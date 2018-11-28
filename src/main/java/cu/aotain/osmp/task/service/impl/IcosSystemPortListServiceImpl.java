package cu.aotain.osmp.task.service.impl;

import com.alibaba.fastjson.JSON;
import com.aotain.common.utils.tools.FileUtils;
import com.aotain.cu.serviceapi.dto.ResultDto;
import com.aotain.cu.serviceapi.dto.UserBandwidthInformationDTO;
import com.aotain.cu.serviceapi.model.PageResult;
import com.aotain.cu.serviceapi.utils.BaseFeignBuilder;
import com.google.common.collect.Maps;
import cu.aotain.osmp.task.core.gd.HardFileMonitorJobForGD;
import cu.aotain.osmp.task.factory.IcosSystem;
import cu.aotain.osmp.task.service.IcosSystemFileAnalyze;
import cu.aotain.osmp.task.service.VerificationInfo;
import cu.aotain.osmp.task.serviceapi.UserBandWidthServiceApi;
import cu.aotain.osmp.task.serviceapi.hystrix.UserBandWidthServiceApiHystrix;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 描述:
 * 客户带宽信息列表
 *
 * @author chenym@aotain.com
 * @create 2018-08-24 16:34
 */
@Service
public class IcosSystemPortListServiceImpl extends IcosSystemFileAnalyze implements IcosSystem {

    private static final Logger LOG = LoggerFactory.getLogger(IcosSystemPortListServiceImpl.class);
    private VerificationInfo info;

    @Autowired
    @Required
    public void setInfo(VerificationInfo info) {
        this.info = info;
    }

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
                String[] arr = line.split(",", line.length());
                if (arr.length >= 5) {
                    contextLists.add(remarkLine);
                } else {
                    writeErrorLine(remarkLine + ",error=arr.length()!=5");
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
        LOG.info("start portList assemblyBean list.size()=" + list.size());
        Map<String, String> currentLineMap = Maps.newHashMap();
        Set databaseKeySet = new HashSet();
        Map<String, UserBandwidthInformationDTO> database_map = Maps.newHashMap();
        Set currentKeySet = new HashSet();
        for (String line : list) {
            String[] arr = line.split(",", line.length());
            // CustomerName,AreaCode,CityCode,Banwidth,UseDate,etlfileName,fileRowsNumber
            if (arr.length == 7) {
                // 单位名称
                String customerName = arr[0];
                // 机房编码
                String areaCode = arr[1];
                String houseId = getHouseIdByAreaCode(areaCode);
                String userId = getUserIdByUserName(customerName);
                if (StringUtils.isEmpty(houseId) || StringUtils.isEmpty(userId)) {
                    LOG.warn(" ERROR line=" + line + ",error= userId:" + userId + ",houseId:" + houseId);
                    writeErrorLine(line + ",error=userId:" + userId + ";houseId:" + houseId);
                    continue;
                }
                String put_key = userId+ "_"+houseId ;
                if (currentLineMap.containsKey(put_key)) {
                    String existsLine = currentLineMap.get(put_key);
                    String[] existArr = existsLine.split(",", line.length());
                    String number = existArr[6];
                    LOG.warn(" ERROR line=" + line + ",error=userId:" + userId + ";houseId:" + houseId + " exists in number:" + number);
                    writeErrorLine(line + ",error=userId:" + userId + ";houseId:" + houseId + " exists in number:" + number);
                    continue;
                }
                currentLineMap.put(put_key, line);
            }
        }
        currentKeySet = currentLineMap.keySet();

        /**
         * 查询所有用户带宽信息
         */
        PageResult<UserBandwidthInformationDTO> databaseRecords = null;
        UserBandWidthServiceApi serviceApi = BaseFeignBuilder.getCacheFeign(UserBandWidthServiceApi.class, "myclient", new UserBandWidthServiceApiHystrix(), BaseFeignBuilder.EncodeDecodeType.EDT_JSON_JSON);

        UserBandwidthInformationDTO dto = new UserBandwidthInformationDTO();
        dto.setIsPaging(0);
        databaseRecords = serviceApi.queryBandwidth(dto);
        if (databaseRecords != null && databaseRecords.getRows().size() > 0) {
            for (UserBandwidthInformationDTO m : databaseRecords.getRows()) {
                database_map.put(m.getUserId() + "_" + m.getHouseId(), m);
            }
        }
        databaseKeySet = database_map.keySet();


        // 待插入的机房ip段, 文件中存在，数据库中不存在
        List<String> preInsertRecordList = (List) CollectionUtils.subtract(currentKeySet, databaseKeySet);

        // 待修改的机房ip段, 文件中存在，数据库中存在
        List<String> preUpdateRecordList = (List) CollectionUtils.intersection(currentKeySet, databaseKeySet);

        // 待删除的机房ip段, 文件中不存在，数据库中存在
        List<String> predeleteRecordList = (List) CollectionUtils.subtract(databaseKeySet, currentKeySet);

        /**
         *  新增用户带宽信息
         */
        try {
            if (preInsertRecordList != null && preInsertRecordList.size() > 0) {
                LOG.info("pre add userBandWidth preInsertRecordList.size()=" + preInsertRecordList.size());
                Map<String, List<UserBandwidthInformationDTO>> pre_insertRecordMap = new HashMap<>();
                UserBandwidthInformationDTO pre_model = null;
                for (String currentKey : preInsertRecordList) {
                    String iLine = currentLineMap.get(currentKey);

                    // CustomerName,AreaCode,CityCode,Banwidth,UseDate,etlfileName,fileRowsNumber
                    String[] arr = iLine.split(",", iLine.length());
                    String customerName = arr[0];
                    String areaCode = arr[1];
                    pre_model = getUserBandWidthInfoByCsvLine(iLine);
                    if (pre_model == null) {
                        LOG.warn(iLine + ",error=get houseId is NULL||get userId is NULL");
                        writeErrorLine(iLine + ",error=get houseId is NULL||get userId is NULL");
                        continue;
                    }
                    String insert_key = getUserIdByUserName(customerName) + "_" + getHouseIdByAreaCode(areaCode);

                    if (pre_insertRecordMap.containsKey(insert_key)) {
                        pre_insertRecordMap.get(insert_key).add(pre_model);
                    } else {
                        List<UserBandwidthInformationDTO> iList = new ArrayList<>();
                        iList.add(pre_model);
                        pre_insertRecordMap.put(insert_key, iList);
                    }
                }

                for (Collection n : pre_insertRecordMap.values()) {
                    List<UserBandwidthInformationDTO> lists = (List<UserBandwidthInformationDTO>) n;
                    ResultDto resultDto = serviceApi.insertBandwidth(lists);
                    if (resultDto != null && resultDto.getResultCode() == 1) {
                        for (String key : resultDto.getAjaxValidationResultMap().keySet()) {
                            UserBandwidthInformationDTO u = lists.get(Integer.valueOf(key));
                            String errorRecord = currentLineMap.get(u.getUserId() + "_" + u.getHouseId());
                            writeErrorLine(errorRecord + "," + JSON.toJSONString(resultDto));
                            LOG.error("add into portList error,line=" + errorRecord + ";because " + JSON.toJSONString(resultDto));
                        }
                    }
                }
            }
        } catch (Exception e) {
            LOG.error("", e);
        }

        /**
         *  修改用户带宽信息
         */
        try {
            if (preUpdateRecordList != null && preUpdateRecordList.size() > 0) {
                LOG.info("pre update userBandWidth preUpdateRecordList.size()=" + preUpdateRecordList.size());
                List<UserBandwidthInformationDTO> userBandwidthInformationDTOs = new ArrayList<>();
                UserBandwidthInformationDTO uModel = null;
                for (String uRecord : preUpdateRecordList) {
                    uModel = database_map.get(uRecord);
                    String uLine = currentLineMap.get(uRecord);
                    uModel = getUserBandWidthInfoByCsvLine(uLine, uModel);
                    if (uModel == null) {
                        writeErrorLine(uLine + ",error=get houseId is NULL||get userId is NULL");
                        continue;
                    }
                    userBandwidthInformationDTOs.add(uModel);
                }
                ResultDto resultUpdate = serviceApi.updateBandwidth(userBandwidthInformationDTOs);
                if (resultUpdate != null && resultUpdate.getResultCode() == 1) {
                    for (String key : resultUpdate.getAjaxValidationResultMap().keySet()) {
                        UserBandwidthInformationDTO u = userBandwidthInformationDTOs.get(Integer.valueOf(key));
                        String errorRecord = currentLineMap.get(u.getUserId() + "_" + u.getHouseId());
                        writeErrorLine(errorRecord + "," + JSON.toJSONString(resultUpdate));
                        LOG.error("update portList error,line=" + errorRecord + ";because " + JSON.toJSONString(resultUpdate));
                    }
                }
            }
        } catch (Exception e) {
            LOG.error("", e);
        }

        /**
         *  删除用户带宽信息
         */
        try {
            if (predeleteRecordList != null && predeleteRecordList.size() > 0) {
                LOG.info("pre delete userBandWidth predeleteRecordList.size()=" + predeleteRecordList.size());
                List<UserBandwidthInformationDTO> userBandwidthInformationDTOs = new ArrayList<>();
                UserBandwidthInformationDTO uModel = null;
                for (String uHouseIpSeg : predeleteRecordList) {
                    uModel = database_map.get(uHouseIpSeg);
                    userBandwidthInformationDTOs.add(uModel);
                }
                ResultDto resultDelete = serviceApi.deleteBandwidth(userBandwidthInformationDTOs);
                if (resultDelete != null && resultDelete.getResultCode() == 1) {
                    LOG.error("delete portList error,line=" + resultDelete + ";because " + JSON.toJSONString(resultDelete));
                }
            }
        } catch (Exception e) {
            LOG.error("", e);
        }
        LOG.info("finish portList assemblyBean");
    }

    private UserBandwidthInformationDTO getUserBandWidthInfoByCsvLine(String uLine, UserBandwidthInformationDTO uModel) {
        if (StringUtils.isEmpty(uLine)) {
            return uModel;
        }
        // CustomerName,AreaCode,CityCode,Banwidth,UseDate,etlfileName,fileRowsNumber
        String[] arr = uLine.split(",", uLine.length());

        String customerName = arr[0];
        String areaCode = arr[1];
        String cityCode = arr[2];
        String BandWidth = arr[3];
        String useDate = arr[4];
        String etlFileName = arr[5];
        String fileRowsNumber = arr[6];

        String distributeTime = getDateTimeStringByUseDate(useDate);
        String userId = getUserIdByUserName(customerName);
        String houseId = getHouseIdByAreaCode(areaCode);

        uModel.setDistributeTime(distributeTime);
        uModel.setAreaCode(cityCode);
        if (houseId == null) {
            return null;
        }
        if (userId == null) {
            return null;
        }
        uModel.setHouseId(Long.valueOf(houseId));
        uModel.setBandWidth(Long.valueOf(BandWidth));
        uModel.setUpdateTime(new Date());
        uModel.setUpdateUserId(-1);
        uModel.setEtlFileName(etlFileName);
        uModel.setFileRowsNumber(fileRowsNumber);
        uModel.setUserId(Long.valueOf(userId));

        List<String> userAuthHouseList = new ArrayList();
        userAuthHouseList.add(houseId + "");
        uModel.setUserAuthHouseList(userAuthHouseList);

        List cityCodeLists = new ArrayList();
        cityCodeLists.add(uModel.getAreaCode());
        uModel.setCityCodeList(cityCodeLists);
        return uModel;
    }

    /**
     * 根据csv文件中的一行记录填充实体类
     *
     * @param iLine
     * @return
     */
    private UserBandwidthInformationDTO getUserBandWidthInfoByCsvLine(String iLine) {
        if (StringUtils.isEmpty(iLine)) {
            return null;
        }
        UserBandwidthInformationDTO model = new UserBandwidthInformationDTO();
        model.setCreateUserId(-1);
        model.setCreateTime(new Date());
        model = getUserBandWidthInfoByCsvLine(iLine, model);
        return model;
    }

    private String getDateTimeStringByUseDate(String useDate) {
        String distributeTime;
        try {
            distributeTime = useDate.split(" ")[0];
        } catch (Exception e) {
            distributeTime = null;
        }

        if (distributeTime == null) {
            try {
                Date f = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").parse(useDate);
                distributeTime = new SimpleDateFormat("yyyy-MM-dd").format(f);
            } catch (ParseException e) {
                distributeTime = null;
            }
        }
        return distributeTime;
    }

}
