package cu.aotain.osmp.task.service.impl;

import com.alibaba.fastjson.JSON;
import com.aotain.common.utils.tools.FileUtils;
import com.aotain.cu.serviceapi.dto.HouseIPSegmentInforDTO;
import com.aotain.cu.serviceapi.dto.ResultDto;
import com.aotain.cu.serviceapi.dto.UserBandwidthInformationDTO;
import com.aotain.cu.serviceapi.dto.UserInformationDTO;
import com.aotain.cu.serviceapi.model.PageResult;
import com.aotain.cu.serviceapi.utils.BaseFeignBuilder;
import com.google.common.collect.Maps;
import cu.aotain.osmp.task.core.gd.HardFileMonitorJobForGD;
import cu.aotain.osmp.task.factory.IcosSystem;
import cu.aotain.osmp.task.service.IcosSystemFileAnalyze;
import cu.aotain.osmp.task.service.VerificationInfo;
import cu.aotain.osmp.task.serviceapi.UserInfoServiceApi;
import cu.aotain.osmp.task.serviceapi.UserInfoServiceApiHystrix;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 描述:
 * 客户信息列表
 *
 * @author chenym@aotain.com
 * @create 2018-08-24 16:36
 */
@Service
public class IcosSystemCustomerListServiceImpl extends IcosSystemFileAnalyze implements IcosSystem {

    private static final Logger LOG = LoggerFactory.getLogger(IcosSystemCustomerListServiceImpl.class);

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
                if (arr.length == 19) {
                    contextLists.add(remarkLine);
                } else {
                    writeErrorLine(remarkLine);
                    LOG.error(remarkLine);
                }
            }
        }
        contexts = null;
        if (LOG.isDebugEnabled()) {
            LOG.debug(" parse file=" + file.getName() + " finish,list.size()=" + contextLists.size() + ",fileTotalLines=" + count);
        }
        return contextLists;
    }

    @Override
    public void assemblyBean(List<String> list) {
        LOG.info("start customerList assemblyBean list.size()=" + list.size());

        Map<String, String> currentLineMap = Maps.newHashMap();
        Set databaseKeySet = new HashSet();
        Map<String, UserInformationDTO> database_map = Maps.newHashMap();
        Set currentKeySet = new HashSet();
        for (String line : list) {
            String[] arr = line.split(",", line.length());
            if (arr.length == 21) {
                // 单位名称
                String customerName = arr[0];

                if (StringUtils.isEmpty(customerName)) {
                    LOG.error("customerName=" + customerName + ", ERROR line=" + line + ";because customerName is NULL");
                    writeErrorLine(line);
                }

                if (currentLineMap.containsKey(customerName)) {
                    LOG.error("customerName=" + customerName + ", ERROR line=" + line + ";duplicate customerName");
                    writeErrorLine(line);
                }
                currentLineMap.put(customerName, line);
            }
        }
        currentKeySet = currentLineMap.keySet();
        /**
         * 查询所有用户信息
         */
        UserInfoServiceApi userInfoServiceApi = BaseFeignBuilder.getCacheFeign(UserInfoServiceApi.class, "myclient", new UserInfoServiceApiHystrix(), BaseFeignBuilder.EncodeDecodeType.EDT_JSON_JSON);

        UserInformationDTO dto = new UserInformationDTO();
        dto.setIsPaging(0);
        PageResult<UserInformationDTO> databaseRecords = userInfoServiceApi.getAllUser(dto);
        if (databaseRecords != null && databaseRecords.getRows().size() > 0) {
            for (UserInformationDTO m : databaseRecords.getRows()) {
                database_map.put(m.getUnitName(), m);
            }
        }
        databaseKeySet = database_map.keySet();

        // 待插入的用户信息, 文件中存在，数据库中不存在
        List<String> preInsertRecordList = (List) CollectionUtils.subtract(currentKeySet, databaseKeySet);

        // 待修改的用户信息, 文件中存在，数据库中存在
        List<String> preUpdateRecordList = (List) CollectionUtils.intersection(currentKeySet, databaseKeySet);

        // 待删除的用户信息, 文件中不存在，数据库中存在
        List<String> predeleteRecordList = (List) CollectionUtils.subtract(databaseKeySet, currentKeySet);

        /**
         *  新增用户信息
         */
        try {
            if (preInsertRecordList != null && preInsertRecordList.size() > 0) {
                LOG.info("pre add userInfo preInsertRecordList.size()=" + preInsertRecordList.size());
                List<UserInformationDTO> userInformationDTOs = new ArrayList<>();
                UserInformationDTO pre_model = null;
                for (String currentKey : preInsertRecordList) {
                    String iLine = currentLineMap.get(currentKey);
                    pre_model = getUserInfoByCsvLine(iLine);
                    if (pre_model == null) {
                        continue;
                    }
                    userInformationDTOs.add(pre_model);
                }

                List<ResultDto> result = userInfoServiceApi.insertsUser(userInformationDTOs);

                if (LOG.isDebugEnabled()) {
                    LOG.debug(" add userInfo return result=" + JSON.toJSONString(result));
                }

                for (ResultDto resultDto : result) {
                    if (resultDto != null && resultDto.getResultCode() == 1) {
                        for (String key : resultDto.getAjaxValidationResultMap().keySet()) {
                            UserInformationDTO u = userInformationDTOs.get(Integer.valueOf(key));
                            String errorRecord = currentLineMap.get(u.getUnitName());
                            writeErrorLine(errorRecord + "," + JSON.toJSONString(resultDto));
                            LOG.error("add userInfo error,line=" + errorRecord + ";because " + JSON.toJSONString(resultDto));
                        }
                    }
                }

            }
        } catch (Exception e) {
            LOG.error("", e);
        }

        /**
         *  修改用户信息
         */
        try {
            if (preUpdateRecordList != null && preUpdateRecordList.size() > 0) {
                LOG.info("pre update userInfo preUpdateRecordList.size()=" + preUpdateRecordList.size());
                List<UserInformationDTO> userInformationDTOs = new ArrayList<>();
                UserInformationDTO uModel = null;
                for (String uRecord : preUpdateRecordList) {
                    uModel = database_map.get(uRecord);
                    String uLine = currentLineMap.get(uRecord);
                    uModel = getUserInfoByCsvLine(uLine, uModel);
                    if (uModel == null) {
                        continue;
                    }
                    userInformationDTOs.add(uModel);
                }
                List<ResultDto> resultUpdate = userInfoServiceApi.updateUsers(userInformationDTOs);

                if (LOG.isDebugEnabled()) {
                    LOG.debug(" update userInfo return result=" + JSON.toJSONString(resultUpdate));
                }

                for (ResultDto resultDto : resultUpdate) {
                    if (resultDto != null && resultDto.getResultCode() == 1) {
                        for (String key : resultDto.getAjaxValidationResultMap().keySet()) {
                            UserInformationDTO u = userInformationDTOs.get(Integer.valueOf(key));
                            String errorRecord = currentLineMap.get(u.getUnitName());
                            writeErrorLine(errorRecord + "," + JSON.toJSONString(resultDto));
                            LOG.error("update userInfo error,line=" + errorRecord + ";because " + JSON.toJSONString(resultDto));
                        }
                    }
                }
            }
        } catch (Exception e) {
            LOG.error("", e);
        }

        /**
         *  删除用户信息
         */
        try {
            if (predeleteRecordList != null && predeleteRecordList.size() > 0) {
                LOG.info("pre delete userInfo predeleteRecordList.size()=" + predeleteRecordList.size());
                List<UserInformationDTO> userInformationDTOs = new ArrayList<>();
                UserInformationDTO uModel = null;
                for (String dRecord : predeleteRecordList) {
                    uModel = database_map.get(dRecord);
                    userInformationDTOs.add(uModel);
                }
                ResultDto resultDelete = userInfoServiceApi.delete(userInformationDTOs);

                if (LOG.isDebugEnabled()) {
                    LOG.debug(" delete userInfo return result=" + JSON.toJSONString(resultDelete));
                }

                if (resultDelete != null && resultDelete.getResultCode() == 1) {
                    LOG.error("delete userInfo error=" + resultDelete + "; because " + JSON.toJSONString(resultDelete));
                }
            }
        } catch (Exception e) {
            LOG.error("", e);
        }
        LOG.info("finish customerList assemblyBean");

    }

    private UserInformationDTO getUserInfoByCsvLine(String uLine, UserInformationDTO model) {
        if (StringUtils.isEmpty(uLine)) {
            return model;
        }
        String[] arr = uLine.split(",", uLine.length());

        String customerName = arr[0];
        String areaCode = arr[1];
        String cityCode = arr[2];
        String custAddr = arr[3];
        String icpzh = arr[4];
        String icpName = arr[5];
        String icpType = arr[6];

        String icptacter = arr[7];

        // 客户 ICP证号
        String icpphone = arr[8];
        String icpFax = arr[9];
        String icpEmail = arr[10];
        String icpLeadContacter = arr[11];
        String icpLeadCophone = arr[12];
        String icpLeadFax = arr[13];
        String icpLeadEmail = arr[14];
        String icpLicenseNbr = arr[15];
        String icpHeadName = arr[16];
        String icpHeadCertNbr = arr[17];
        String icpLicense = arr[18];
        String eltFileName = arr[19];
        String fileRowsNumber = arr[20];

        /**
         *  TODO 属性都不确定，为保证流程通过，先给默认假值。
         */
        // 客户属性
        String nature = StringUtils.isEmpty(icpphone) ? "2" : "1";
        model.setNature(Integer.valueOf(nature));

        // 客户标识
        String identify = "1";
        model.setIdentify(identify);

        // 单位属性名称
        String unitNature = "1";
        model.setUnitName(unitNature);

        // 单位属性
        model.setUnitNature(Integer.valueOf(1));

        //单位证件类型
        String idType = "2";
        model.setIdType(Integer.valueOf(idType));

        //单位证件号码
        String idNumber = "420821198709136117";
        model.setIdNumber(idNumber);

        String unitAddressProvinceCode = "440000";
        model.setUnitAddressProvinceCode(unitAddressProvinceCode);

        String unitAddressCityCode = "440300";
        model.setUnitAddressCityCode(unitAddressCityCode);

        String unitAddressAreaCode = "440300";
        model.setUnitAddressAreaCode(unitAddressAreaCode);

        String registeTime = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        model.setRegisteTime(registeTime);
        //服务开通时间
        model.setServiceRegTime(registeTime);

        String officerName = "icos";
        model.setOfficerName(officerName);

        String officerIdType = "2";
        model.setOfficerIdType(Integer.valueOf(officerIdType));

        //网络信息安全责任人证件号码
        String officerId = "441522199912022413";
        model.setOfficerId(officerId);

        String officerTelphone = "0755-2456457";
        model.setOfficerTelphone(officerTelphone);

        String officerMobile = "15756324578";
        model.setOfficerMobile(officerMobile);

        String officerEmail = "asda@asda.com";
        model.setOfficerEmail(officerEmail);

        //单位地址
        model.setUnitAddress("icos系统来源数据");

        model.setUnitName(customerName);
        model.setUnitAddress(custAddr);
        model.setAreaCode(cityCode);
        model.setCreateTime(new Date());
        model.setCreateUserId(-1);

        List<String> cityCodes = new ArrayList<>();
        cityCodes.add(cityCode);
        model.setCityCodeList(cityCodes);
        return model;
    }

    private UserInformationDTO getUserInfoByCsvLine(String iLine) {
        if (StringUtils.isEmpty(iLine)) {
            return null;
        }
        UserInformationDTO model = new UserInformationDTO();
        model.setCreateUserId(-1);
        model.setCreateTime(new Date());
        return getUserInfoByCsvLine(iLine, model);
    }

}
