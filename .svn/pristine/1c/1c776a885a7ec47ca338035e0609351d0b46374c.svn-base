package cu.aotain.osmp.task.service.impl;

import com.alibaba.fastjson.JSON;
import com.aotain.cu.serviceapi.dto.*;
import com.aotain.cu.serviceapi.model.IdcJcdmXzqydm;
import com.aotain.cu.serviceapi.model.PageResult;
import com.aotain.cu.serviceapi.utils.BaseFeignBuilder;
import com.csvreader.CsvReader;
import com.google.common.collect.Maps;
import cu.aotain.osmp.task.core.gd.HardFileMonitorJobForGD;
import cu.aotain.osmp.task.service.CrmsAndIpcFileHandle;
import cu.aotain.osmp.task.service.CrmsProcessService;
import cu.aotain.osmp.task.service.UserInfo;
import cu.aotain.osmp.task.serviceapi.HouseRackServiceApi;
import cu.aotain.osmp.task.serviceapi.UserInfoServiceApi;
import cu.aotain.osmp.task.serviceapi.UserInfoServiceApiHystrix;
import cu.aotain.osmp.task.serviceapi.hystrix.HouseRackServiceApiHystrix;
import cu.aotain.osmp.task.util.FileTools;
import org.apache.commons.lang.CharEncoding;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.*;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class CrmsProcessServiceImpl extends CrmsAndIpcFileHandle<UserInfo> implements CrmsProcessService {

    private static Logger logger = LoggerFactory.getLogger(CrmsProcessServiceImpl.class);

    private HardFileMonitorJobForGD.FileWriter999 wirter;
    private Map<String, Boolean> booleanMap;

    @Override
    public Map<String, TreeMap<Long, String>> process(List<File> dataFile) {
        if (dataFile == null || dataFile.isEmpty()) return null;
        InputStream input;
        Map<String, TreeMap<Long, String>> contentMap = new HashMap<String, TreeMap<Long, String>>();
        for (File zipFile : dataFile) {
            try {

                TreeMap<Long, String> sigleContent = new TreeMap<>();
                File daFile = null;
                if ((daFile = unZip(zipFile)) == null) {
                    wirter.closeWriter(zipFile.getName(), "34");
                    break;
                }
                input = new BufferedInputStream(new FileInputStream(daFile));
                InputStreamReader read = new InputStreamReader(input, CharEncoding.UTF_8);
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTXT = null;
                Long num = 1l;
                while ((lineTXT = bufferedReader.readLine()) != null) {
                    sigleContent.put(num++, lineTXT.toString());
                }
                input.close();
                read.close();
                bufferedReader.close();
                if (validate(sigleContent, zipFile)) {
                    contentMap.put(zipFile.getName(), sigleContent);
                } else {
                    wirter.closeWriter(zipFile.getName(), "32");
                }
            } catch (FileNotFoundException e) {
                logger.error("", e);
            } catch (UnsupportedEncodingException e) {
                logger.error("parse file error [" + zipFile.getName() + "]", e);
            } catch (IOException e) {
                logger.error("read txt file error [" + zipFile.getName() + "]", e);
            }
        }
        return contentMap;
    }

    @Override
    protected boolean validate(Map<Long, String> content, File verFile) {
        if (info.getVerificationMap().get("CRMS").get(verFile.getName()) != null) {
            if (content.size() == (int) info.getVerificationMap().get("CRMS").get(verFile.getName())) {
                return true;
            }
            return false;
        }
        return false;
    }

    @Override
    protected void doVerifiyInfo(File file) {
        try {
            // 创建CSV读对象
            CsvReader csvReader = FileTools.createCsvReader(file);
            // 读表头
            csvReader.readHeaders();
            HashMap<String, Object> map = new HashMap<String, Object>();
            while (csvReader.readRecord()) {
                map.put(csvReader.get(0), Integer.parseInt(csvReader.get(1)));
            }
            info.getVerificationMap().put("CRMS", map);
            csvReader.close();
        } catch (Exception e) {
            logger.error("error get data from " + file.getName(), e);
        }

    }

    @Override
    protected UserInfo constructUserObj(Map<String, TreeMap<Long, String>> contents) {

        Map<String, TreeMap<Long, UserInformationDTO>> users = new HashMap<String, TreeMap<Long, UserInformationDTO>>();
        Map<String, TreeMap<Long, UserBandwidthInformationDTO>> userBinds = new HashMap<String, TreeMap<Long, UserBandwidthInformationDTO>>();

        if (api == null) {
            api = BaseFeignBuilder.getCacheFeign(UserInfoServiceApi.class, "myclient", new UserInfoServiceApiHystrix(), BaseFeignBuilder.EncodeDecodeType.EDT_JSON_JSON);
        }
        if (houseApi == null) {
            houseApi = BaseFeignBuilder.getCacheFeign(HouseRackServiceApi.class, "myclient", new HouseRackServiceApiHystrix(), BaseFeignBuilder.EncodeDecodeType.EDT_JSON_JSON);
        }
        HouseInformationDTO pDto = new HouseInformationDTO();
        pDto.setIsPaging(0);
        PageResult<HouseInformationDTO> lists = houseApi.listHouseInfo(pDto);
        /**
         * 机房主体
         */
        Map<String, HouseInformationDTO> houseMap = new HashMap<String, HouseInformationDTO>();
        if (lists != null && lists.getRows().size() > 0) {
            lists.getRows().forEach(dto -> {
                houseMap.put(dto.getHouseName(), dto);
            });
        }

        contents.forEach((k, v) -> {
            List<IdcJcdmXzqydm> areaList = api.getAreaCode(Integer.parseInt(k.substring(4, 7)));
            String code = "";
            if (areaList != null && !areaList.isEmpty()) {
                code = areaList.get(0).getAreaCode();
            }
            String areaCode = code;
            TreeMap<Long, UserInformationDTO> userDatas = new TreeMap<Long, UserInformationDTO>();
            TreeMap<Long, UserBandwidthInformationDTO> userBindDatas = new TreeMap<Long, UserBandwidthInformationDTO>();
            v.forEach((rowNum, rowVaue) -> {
                try {
                    String[] cont = rowVaue.split("\\|");
                    UserInformationDTO information = new UserInformationDTO();
                    UserBandwidthInformationDTO userBand = new UserBandwidthInformationDTO();
                    //处理逻辑
                    information.setNature(2);
                    information.setIdentify("5");
                    information.setUserAuthIdentityList(Arrays.asList("5"));
                    information.setUnitName(cont[1]);
                    information.setUserCode(cont[2]);
                    information.setUnitNature(Integer.parseInt(cont[6]));
                    information.setIdType(Integer.parseInt(paramMap.getOrDefault("jcdm.zjlx.crms." + cont[7], "999")));
                    information.setIdNumber(cont[8]);
                    information.setUnitAddress(cont[9]);
                    information.setRegisteTime(cont[10]);
                    information.setServiceRegTime(cont[11]);
                    information.setOfficerName(cont[12]);
                    information.setOfficerIdType(Integer.parseInt(paramMap.getOrDefault("jcdm.zjlx.crms." + cont[13], "999")));
                    information.setOfficerId(cont[14]);
                    information.setOfficerTelphone(cont[15]);
                    information.setOfficerMobile(cont[16]);
                    information.setOfficerEmail(cont[17]);
                    information.setAreaCode(areaCode);
                    information.setCityCodeList(Arrays.asList(areaCode));
                    information.setCreateUserId(-2);
                    information.setUpdateUserId(-2);
                    information.setAuthFilter(true);
                    setAreaCodeByAddress(information, information.getUnitAddress());
                    userDatas.put(rowNum, information);

                    userBand.setIdType(information.getIdType());
                    userBand.setIdNumber(information.getIdNumber());
                    userBand.setUnitName(information.getUnitName());
                    userBand.setHouseName(cont[18]);
                    if (houseMap.get(userBand.getHouseName()) != null) {
                        userBand.setHouseId(Long.valueOf(houseMap.get(userBand.getHouseName()).getHouseId()));
                        userBand.setUserAuthHouseList(Arrays.asList(String.valueOf(userBand.getHouseId())));
                        userBand.setDistributeTime(cont[19]);
                        userBand.setBandWidth(Long.parseLong(cont[20]));
                        userBand.setAreaCode(areaCode);
                        userBand.setCityCodeList(Arrays.asList(areaCode));
                        userBand.setCreateUserId(-2);
                        userBand.setUpdateUserId(-2);
                        userBand.setAuthFilter(true);
                        userBindDatas.put(rowNum, userBand);
                    } else {
                        constructUserHHErrorFile(k, (long) rowNum, "机房不存在");
                    }
                } catch (Exception e) {
                    logger.error("parse txt param error", e);
                    constructUserErrorFile(k, (long) rowNum, "参数解析有误");
                }
            });
            users.put(k, userDatas);
            userBinds.put(k, userBindDatas);
        });
        UserInfo info = new UserInfo();
        info.setUsers(users);
        info.setUserBinds(userBinds);
        return info;
    }

    @Override
    protected void end(String fileName) {
        if (booleanMap != null && booleanMap.get(fileName) != null && booleanMap.get(fileName)) {
            wirter.closeWriter(fileName, "1");
            booleanMap.remove(fileName);
        } else {
            wirter.closeWriter(fileName, "0");
        }
    }

    private Map<Integer, UserInformationDTO> insertUsers(String fileName, TreeMap<Long, UserInformationDTO> map) {
        if (map != null && !map.isEmpty()) {
            try {
                List<UserInformationDTO> dtoList = new ArrayList<>();
                Long row = 0l;
                Map<Long, Long> rowMap = new HashMap<>();
                for (Long key : map.keySet()) {
                    dtoList.add(map.get(key));
                    rowMap.put(row++, key);
                }
                if (!dtoList.isEmpty()) {
                    Map<Integer, UserInformationDTO> returnMap = new HashMap<>();
                    List<ResultDto> resultDtos = api.insertsUser(dtoList);
                    if (resultDtos != null && !resultDtos.isEmpty()) {
                        for (int i = 0; i < resultDtos.size(); i++) {
                            if (resultDtos.get(i).getResultCode() != ResultDto.ResultCodeEnum.SUCCESS.getCode()) {
                                constructUserErrorFile(fileName, rowMap.get((long) i), resultDtos.get(i).getResultMsg());
                            } else {
                                UserInformationDTO dto = dtoList.get(i);
                                dto.setUserId(Long.valueOf(resultDtos.get(i).getPid()));
                                returnMap.put(dto.hashCode(), dto);
                            }
                        }
                    }
                    return returnMap;
                }
            } catch (Exception e) {
                logger.error("insert user error", e);
                wirter.closeWriter(fileName, "1");
            }

        }
        return Maps.newHashMap();
    }

    private void updateUsers(String fileName, TreeMap<Long, UserInformationDTO> map) {
        if (map != null && !map.isEmpty()) {
            try {
                List<UserInformationDTO> dtoList = new ArrayList<>();
                Long row = 0l;
                Map<Long, Long> rowMap = new HashMap<>();
                for (Long key : map.keySet()) {
                    dtoList.add(map.get(key));
                    rowMap.put(row++, key);
                }
                if (!dtoList.isEmpty()) {
                    List<ResultDto> resultDtos = api.updateUsers(dtoList);
                    if (resultDtos != null && !resultDtos.isEmpty()) {
                        for (int i = 0; i < resultDtos.size(); i++) {
                            if (resultDtos.get(i).getResultCode() != ResultDto.ResultCodeEnum.SUCCESS.getCode()) {
                                constructUserErrorFile(fileName, (long) rowMap.get(i), resultDtos.get(i).getResultMsg());
                            }
                        }
                    }
                }
            } catch (Exception e) {
                logger.error("update user error", e);
                wirter.closeWriter(fileName, "1");
            }
        }
    }

    private void deleteUsers(List<UserInformationDTO> dtos) {
        try {
            if (dtos.isEmpty()) return;
            api.deleteUsers(dtos);
        } catch (Exception e) {
            logger.error("delete user error", e);
        }

    }

    private void addUserBinds(String fileName, TreeMap<Long, UserBandwidthInformationDTO> map) {
        if (map == null || map.isEmpty() || map.values() == null || map.values().isEmpty()) return;
        try {
            List<UserBandwidthInformationDTO> dtoList = new ArrayList<>();
            Long row = 0l;
            Map<Long, Long> rowMap = new HashMap<>();
            for (Long key : map.keySet()) {
                dtoList.add(map.get(key));
                rowMap.put(row++, key);
            }
            if (dtoList.isEmpty()) return;
            ResultDto resultDto = api.insertsUserBinds(dtoList);
            if (resultDto.getResultCode() != ResultDto.ResultCodeEnum.SUCCESS.getCode()) {
                Map<String, AjaxValidationResult> resultMap = resultDto.getAjaxValidationResultMap();
                resultMap.forEach((k, v) -> {
                    Map<String, Object[]> error = v.getErrorsArgsMap();
                    if (error != null && !error.isEmpty()) {
                        constructUserHHErrorFile(fileName, rowMap.get(Long.valueOf(k)), JSON.toJSONString(error.values()));
                    }
                });
            }
        } catch (Exception e) {
            logger.error("insert user HH error", e);
            wirter.closeWriter(fileName, "1");
        }
    }

    private void updateUserBinds(String fileName, TreeMap<Long, UserBandwidthInformationDTO> map) {
        if (map == null || map.isEmpty() || map.values() == null || map.values().isEmpty()) return;
        try {

            List<UserBandwidthInformationDTO> dtoList = new ArrayList<>();
            Long row = 0l;
            Map<Long, Long> rowMap = new HashMap<>();
            for (Long key : map.keySet()) {
                dtoList.add(map.get(key));
                rowMap.put(row++, key);
            }
            if (dtoList.isEmpty()) return;
            ResultDto resultDto = api.updateUserBinds(dtoList);
            if (resultDto.getResultCode() != ResultDto.ResultCodeEnum.SUCCESS.getCode()) {
                Map<String, AjaxValidationResult> resultMap = resultDto.getAjaxValidationResultMap();
                resultMap.forEach((k, v) -> {
                    Map<String, Object[]> error = v.getErrorsArgsMap();
                    if (error != null && !error.isEmpty()) {
                        constructUserHHErrorFile(fileName, rowMap.get(Long.valueOf(k)), JSON.toJSONString(error.values()));
                    }
                });
            }
        } catch (Exception e) {
            logger.error("update user HH error", e);
            wirter.closeWriter(fileName, "1");
        }

    }

    private void deleteUserBinds(List<UserBandwidthInformationDTO> dtos) {
        try {
            if (dtos == null && dtos.isEmpty()) return;
            List<Long> ids = new ArrayList<>();
            for (UserBandwidthInformationDTO dto : dtos) {
                ids.add(dto.getHhId());
            }
            api.deleteUsersBinds(ids);
        } catch (Exception e) {
            logger.error("delete user bandwidth error ", e);
        }

    }

    /**
     * 构建用户主体异常文件
     *
     * @param fileName
     * @param rowNum
     * @param msg
     */
    private void constructUserErrorFile(String fileName, Long rowNum, String msg) {
        if (booleanMap == null) {
            booleanMap = new ConcurrentHashMap<>();
        }
        booleanMap.put(fileName, true);
        wirter.append(fileName, "第" + rowNum + "行 " + msg + "\n");

    }

    /**
     * 构建用户带宽异常文件
     *
     * @param fileName
     * @param rowNum
     * @param msg
     */
    private void constructUserHHErrorFile(String fileName, Long rowNum, String msg) {
        if (booleanMap == null) {
            booleanMap = new ConcurrentHashMap<>();
        }
        booleanMap.put(fileName, true);
        wirter.append(fileName, "第" + rowNum + "行 " + msg + "\n");

    }

    @Override
    @Transactional
    public void execute(File validateFile, List<File> dataFile, HardFileMonitorJobForGD.FileWriter999 wirter) {
        this.wirter = wirter;
        this.doVerifiyInfo(validateFile);
        UserInfo userInfo = returnHanderFile(dataFile);
        //get current data
        if (userInfo != null) {
            api = BaseFeignBuilder.getCacheFeign(UserInfoServiceApi.class, "myclient", new UserInfoServiceApiHystrix(), BaseFeignBuilder.EncodeDecodeType.EDT_JSON_JSON);
            UserInformationDTO userparam = new UserInformationDTO();
            userparam.setIsPaging(0);
            PageResult<UserInformationDTO> userPageResult = api.getAllUser(userparam);

            UserBandwidthInformationDTO bindparam = new UserBandwidthInformationDTO();
            bindparam.setIsPaging(0);
            PageResult<UserBandwidthInformationDTO> userBindPageResult = api.getAllUserBind(bindparam);


            /**
             * 用户主体
             */
            //以用户的hashCode,对象 构成 Map
            Map<Integer, UserInformationDTO> userTableDtoMap = new HashMap<Integer, UserInformationDTO>();
            if (userPageResult != null && userPageResult.getRows().size() > 0) {
                userPageResult.getRows().forEach(dto -> {
                    userTableDtoMap.put(dto.hashCode(), dto);
                });
            }
            //数据库为空
            if (!userTableDtoMap.isEmpty()) {
                List<UserInformationDTO> deleteUserList = new ArrayList<>();
                List<UserInformationDTO> commonList = new ArrayList<>();
                List<UserInformationDTO> currentExit = new ArrayList<>();
                currentExit.addAll(userTableDtoMap.values());
                if (userInfo.getUsers() != null && !userInfo.getUsers().isEmpty()) {
                    userInfo.getUsers().forEach((fileName, fileValue) -> {
                        TreeMap<Long, UserInformationDTO> addUserMap = new TreeMap<Long, UserInformationDTO>();
                        TreeMap<Long, UserInformationDTO> modifyUserMap = new TreeMap<Long, UserInformationDTO>();
                        loop1:
                        fileValue.forEach((rowNum, rowValue) -> {
                            UserInformationDTO userInformationDTO;
                            if ((userInformationDTO = userTableDtoMap.get(rowValue.hashCode())) != null) {
                                //rowValue对象在数据库中存在,则更新
                                rowValue.setUserId(userInformationDTO.getUserId());
                                modifyUserMap.put(rowNum, rowValue);
                                commonList.add(userInformationDTO);
                            } else {
                                addUserMap.put(rowNum, rowValue);
                            }
                        });
                        //入库(主体)
                        userTableDtoMap.putAll(insertUsers(fileName, addUserMap));
                        updateUsers(fileName, modifyUserMap);
                    });
                    //待删除的
                    deleteUserList.addAll(currentExit);
                    deleteUserList.removeAll(commonList);
                    deleteUsers(deleteUserList);
                } else {
                    //文件数据为空,直接略过
                }
            } else {
                //直接新增
                userInfo.getUsers().forEach((fileName, fileValue) ->
                {
                    userTableDtoMap.putAll(insertUsers(fileName, fileValue));
                    end(fileName);
                });
            }

            /**
             * 带宽操作
             */

            //以用户的hashCode,对象 构成 Map
            Map<Integer, UserBandwidthInformationDTO> userBindMap = new HashMap<Integer, UserBandwidthInformationDTO>();
            if (userBindPageResult != null && userBindPageResult.getRows().size() > 0) {
                userBindPageResult.getRows().forEach(dto -> {
                    userBindMap.put(Objects.hash(new Object[]{dto.getUserId(), dto.getHouseId()}), dto);
                });
            }

            List<UserBandwidthInformationDTO> commonUserBind = new ArrayList<>();
            List<UserBandwidthInformationDTO> deleteUserBindList = new ArrayList<>();
            if (userBindMap != null && userBindMap.size() > 0) {
                if (userInfo.getUserBinds() != null && !userInfo.getUserBinds().isEmpty()) {
                    userInfo.getUserBinds().forEach((fileName, fileValue) -> {
                        TreeMap<Long, UserBandwidthInformationDTO> addUseBindrMap = new TreeMap<>();
                        TreeMap<Long, UserBandwidthInformationDTO> modifyUserBindMap = new TreeMap<>();

                        fileValue.forEach((rowNum, rowValue) -> {
                            UserInformationDTO dto;
                            if ((dto = userTableDtoMap.get(rowValue.UserHashCode())) != null) {
                                rowValue.setUserId(dto.getUserId());
                                UserBandwidthInformationDTO bindDto;
                                if ((bindDto = userBindMap.get(Objects.hash(new Object[]{rowValue.getUserId(), rowValue.getHouseId()}))) != null) {
                                    rowValue.setHhId(bindDto.getHhId());
                                    modifyUserBindMap.put(rowNum, rowValue);
                                    commonUserBind.add(bindDto);
                                } else {
                                    addUseBindrMap.put(rowNum, rowValue);
                                }
                            } else {
                                constructUserHHErrorFile(fileName, rowNum, "找不到用户主体");
                            }
                        });
                        //入库(带宽)
                        addUserBinds(fileName, addUseBindrMap);
                        updateUserBinds(fileName, modifyUserBindMap);
                        end(fileName);
                    });
                    //待删除的
                    deleteUserBindList.addAll(userBindMap.values());
                    deleteUserBindList.removeAll(commonUserBind);
                    deleteUserBinds(deleteUserBindList);
                } else {
//                    deleteUserBindList.addAll(userBindTableDatas);
                }
            } else {
                userInfo.getUserBinds().forEach((fileName, fileValue) -> {
                    TreeMap<Long, UserBandwidthInformationDTO> addUseBindrMap = new TreeMap<>();
                    fileValue.forEach((rowNum, rowValue) -> {
                        UserInformationDTO dto;
                        if ((dto = userTableDtoMap.get(rowValue.UserHashCode())) != null) {
                            rowValue.setUserId(dto.getUserId());
                            addUseBindrMap.put(rowNum, rowValue);
                        } else {
                            constructUserHHErrorFile(fileName, rowNum, "找不到用户主体");
                        }

                    });
                    addUserBinds(fileName, fileValue);
                    end(fileName);
                });
            }
        }
    }


}
