package cu.aotain.osmp.task.service.impl;

import com.alibaba.fastjson.JSON;
import com.aotain.common.utils.tools.FileUtils;
import com.aotain.cu.serviceapi.dto.HouseFrameInformationDTO;
import com.aotain.cu.serviceapi.dto.ResultDto;
import com.aotain.cu.serviceapi.model.HouseUserFrameInformation;
import com.aotain.cu.serviceapi.model.PageResult;
import com.aotain.cu.serviceapi.utils.BaseFeignBuilder;
import com.google.common.collect.Maps;
import cu.aotain.osmp.task.core.gd.HardFileMonitorJobForGD;
import cu.aotain.osmp.task.factory.IcosSystem;
import cu.aotain.osmp.task.service.HouseCacheService;
import cu.aotain.osmp.task.service.IcosSystemFileAnalyze;
import cu.aotain.osmp.task.service.VerificationInfo;
import cu.aotain.osmp.task.serviceapi.HouseRackServiceApi;
import cu.aotain.osmp.task.serviceapi.hystrix.HouseRackServiceApiHystrix;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.*;

/**
 * 描述:
 * 机房机架信息列表
 *
 * @author chenym@aotain.com
 * @create 2018-08-24 16:34
 */
@Service
public class IcosSystemRackListServiceImpl extends IcosSystemFileAnalyze implements IcosSystem {

    private static final Logger LOG = LoggerFactory.getLogger(IcosSystemRackListServiceImpl.class);

    private VerificationInfo info;

    @Autowired
    @Required
    public void setInfo(VerificationInfo info) {
        this.info = info;
    }

    @Autowired
    private HouseCacheService houseCacheService;

    @Override
    public void execte(File file, HardFileMonitorJobForGD.FileWriter999 writer) {
        super.writer = writer;
        this.process(file);
    }

    @Override
    public void postProcess(File file) {

    }

    @Override
    public List<String> resolveAndValid(File file) {
        if (file == null) {
            return null;
        }
        LOG.info("start resolveAndValid file=" + file.getName());
        List<String> contexts = FileUtils.readFileByLine(file);
        List<String> contextLists = new ArrayList<>();
        Integer count = 0;
        if (contexts.size() > 0) {
            for (int i = 0; i < contexts.size(); i++) {
                String line = contexts.get(i);
                count++;
                // 表头skip掉。
                if (i == 0) {
                    continue;
                }
                String remarkLine = line + "," + file.getName() + "," + count;
                String[] arr = line.split(",");
                // Name,AreaCode,CityCode,CustomerName
                if (arr.length == 4) {
                    contextLists.add(remarkLine);
                } else {
                    writeErrorLine(remarkLine);
                    LOG.error(remarkLine + ",error=arr.length()!=4");
                }
            }
        }
        contexts = null;
        if (LOG.isDebugEnabled()) {
            LOG.debug(" parse file=" + file.getName() + " finish,numbers=" + contextLists.size() + ",fileTotalLines=" + count);
        }
        return contextLists;
    }

    @Override
    public void assemblyBean(List<String> list) {
        LOG.info("start rackList assemblyBean list.size()=" + list.size());
        Map<String, String> frameNameLine = Maps.newHashMap();
        Set databaseFrameNameSet = new HashSet();
        Map<String, HouseFrameInformationDTO> database_map = Maps.newHashMap();

        for (String line : list) {
            // Name,AreaCode,CityCode,CustomerName,etlFileName,fileRowsNumber
            String[] arr = line.split(",");
            if (arr.length == 6) {
                //机架名称
                String name = arr[0];

                if (frameNameLine.containsKey(name)) {
                    String existsLine = frameNameLine.get(name);
                    String[] existArr = existsLine.split(",", line.length());
                    String number = existArr[5];
                    LOG.warn(" ERROR line=" + line + ",error=Name:" + name + " exists in number:" + number);
                    writeErrorLine(line + ",error=Name:" + name + " exists in number:" + number);
                    continue;
                }
                frameNameLine.put(name, line);
            }
        }
        Set currentFrameNameSet = frameNameLine.keySet();
        //获取所有的机架信息
        HouseRackServiceApi rackServiceImpl = BaseFeignBuilder.getCacheFeign(HouseRackServiceApi.class, "myclient", new HouseRackServiceApiHystrix(), BaseFeignBuilder.EncodeDecodeType.EDT_JSON_JSON);
        HouseFrameInformationDTO dto = new HouseFrameInformationDTO();
        dto.setIsPaging(0);
        PageResult<HouseFrameInformationDTO> databaseRecords = rackServiceImpl.queryRack(dto);
        for (HouseFrameInformationDTO m : databaseRecords.getRows()) {
            database_map.put(m.getFrameName(), m);
        }
        databaseFrameNameSet = database_map.keySet();
        // 待插入的机房名称, 文件中存在，数据库中不存在
        List<String> preInsertFrameName = (List) CollectionUtils.subtract(currentFrameNameSet, databaseFrameNameSet);

        // 待修改的机房名称, 文件中存在，数据库中存在
        List<String> preUpdateFrameName = (List) CollectionUtils.intersection(currentFrameNameSet, databaseFrameNameSet);

        // 待删除的机房名称, 文件中不存在，数据库中存在
        List<String> predeleteFrameName = (List) CollectionUtils.subtract(databaseFrameNameSet, currentFrameNameSet);

        /**
         * 新增机房机架信息
         */
        try {
            if (preInsertFrameName != null && preInsertFrameName.size() > 0) {
                LOG.info("pre add HouseFrame preInsertFrameName.size()=" + preInsertFrameName.size());
                Map<String, List<HouseFrameInformationDTO>> map = new HashMap<>();
                HouseFrameInformationDTO m = null;
                for (String iStr : preInsertFrameName) {
                    String iLine = frameNameLine.get(iStr);
                    String[] arr = iLine.split(",", iLine.length());
                    //机房编码
                    String areaCode = arr[1];
                    m = getHouseFrameInformationDTOByLine(iLine);
                    if (m == null) {
                        writeErrorLine(iLine + ",error = houseId is NULL");
                        continue;
                    }
                    if (map.containsKey(areaCode)) {
                        map.get(areaCode).add(m);
                    } else {
                        List<HouseFrameInformationDTO> HouseFrameInformationDTOs = new ArrayList<>();
                        HouseFrameInformationDTOs.add(m);
                        map.put(areaCode, HouseFrameInformationDTOs);
                    }
                }
                for (Collection n : map.values()) {
                    List<HouseFrameInformationDTO> lists = (List<HouseFrameInformationDTO>) n;
                    ResultDto result = rackServiceImpl.insertRack(lists);
                    if (result != null && result.getResultCode() == 1) {
                        for (String key : result.getAjaxValidationResultMap().keySet()) {
                            HouseFrameInformationDTO u = lists.get(Integer.valueOf(key));
                            String errorRecord = frameNameLine.get(u.getFrameName());
                            writeErrorLine(errorRecord + ",error=" + JSON.toJSONString(result.getAjaxValidationResultMap().get(key)));
                            LOG.warn("add into houseFrame error,line=" + errorRecord + ";error= " + JSON.toJSONString(result));
                        }
                    }
                }
            }
        } catch (Exception e) {
            LOG.error("", e);
        }

        /**
         * 修改机房机架信息
         */
        try {
            if (preUpdateFrameName != null && preUpdateFrameName.size() > 0) {
                LOG.info("pre update HouseFrame preUpdateFrameName.size()=" + preUpdateFrameName.size());
                List<HouseFrameInformationDTO> updateHouseFrameInformationDTOs = new ArrayList<>();
                HouseFrameInformationDTO uModel = null;
                for (String uStr : preUpdateFrameName) {
                    uModel = database_map.get(uStr);
                    String iLine = frameNameLine.get(uStr);
                    getHouseFrameInformationDTOByLine(iLine, uModel);
                    updateHouseFrameInformationDTOs.add(uModel);
                }
                ResultDto resultUpdate = rackServiceImpl.updateRack(updateHouseFrameInformationDTOs);
                if (resultUpdate != null && resultUpdate.getResultCode() == 1) {
                    for (String key : resultUpdate.getAjaxValidationResultMap().keySet()) {
                        HouseFrameInformationDTO u = updateHouseFrameInformationDTOs.get(Integer.valueOf(key));
                        String errorRecord = frameNameLine.get(u.getFrameName());
                        writeErrorLine(errorRecord + "," + JSON.toJSONString(resultUpdate));
                        LOG.warn("update houseFrame error,line=" + errorRecord + ";error= " + JSON.toJSONString(resultUpdate));
                    }
                }
            }
        } catch (Exception e) {
            LOG.error("", e);
        }

        /**
         * 删除机房机架信息
         */
        try {
            if (predeleteFrameName != null && predeleteFrameName.size() > 0) {
                LOG.info("pre delete HouseFrame predeleteFrameName.size()=" + predeleteFrameName.size());
                List<HouseFrameInformationDTO> deleteHouseFrameInformationDTOs = new ArrayList<>();
                HouseFrameInformationDTO m = null;
                for (String uStr : predeleteFrameName) {
                    m = database_map.get(uStr);
                    deleteHouseFrameInformationDTOs.add(m);
                }
                ResultDto resultDelete = rackServiceImpl.deleteRack(deleteHouseFrameInformationDTOs);
                if (resultDelete != null && resultDelete.getResultCode() == 1) {
                    LOG.warn("delete houseFrame error,line=" + resultDelete + ";error= " + JSON.toJSONString(resultDelete));
                }
            }
        } catch (Exception e) {
            LOG.error("", e);
        }

        LOG.info("finish rackList assemblyBean");
    }

    private HouseFrameInformationDTO getHouseFrameInformationDTOByLine(String iLine) {
        if (StringUtils.isEmpty(iLine)) {
            return null;
        }
        HouseFrameInformationDTO model = new HouseFrameInformationDTO();
        model.setCreateTime(new Date());
        model.setUseType(2);
        model.setOccupancy(1);
        model.setCreateUserId(-1);
        model = getHouseFrameInformationDTOByLine(iLine, model);
        return model;
    }

    private HouseFrameInformationDTO getHouseFrameInformationDTOByLine(String iLine, HouseFrameInformationDTO uModel) {

        String[] arr = iLine.split(",", iLine.length());
        //机架名称
        String frameName = arr[0];
        //机房编码
        String areaCode = arr[1];
        //地区编码
        String cityCode = arr[2];
        //客户编码
        String customerName = arr[3];

        String houseId = getHouseIdByAreaCode(areaCode);
        if (houseId == null) {
            return null;
        }
        //机架信息
        uModel.setHouseId(houseId == null ? 0L : Long.valueOf(houseId));
        uModel.setAreaCode(cityCode);
        List cityCodeLists = new ArrayList();
        cityCodeLists.add(uModel.getAreaCode());
        uModel.setCityCodeList(cityCodeLists);
        uModel.setUpdateUserId(-1);
        uModel.setUpdateTime(new Date());
        uModel.setFrameName(frameName);

        /**
         * 机房用户信息
         */
        List<HouseUserFrameInformation> HouseUserFrameInformations = new ArrayList<>();
        HouseUserFrameInformation houseUser = new HouseUserFrameInformation();
        houseUser.setUserName(customerName);
        houseUser.setHouseId(houseId == null ? 0L : Long.valueOf(houseId));
        HouseUserFrameInformations.add(houseUser);
        uModel.setUserFrameList(HouseUserFrameInformations);
        return uModel;
    }

}
