package cu.aotain.osmp.task.service;

import com.aotain.common.config.ContextUtil;
import com.aotain.common.config.LocalConfig;
import com.aotain.common.config.redis.BaseRedisService;
import com.aotain.common.utils.compress.zip.ZipDecompress;
import com.aotain.common.utils.tools.EnvironmentUtils;
import com.aotain.common.utils.tools.FileUtils;
import com.aotain.cu.serviceapi.dto.UserInformationDTO;
import com.aotain.cu.serviceapi.dto.UserServiceInformationDTO;
import com.aotain.cu.serviceapi.model.BaseModel;
import com.aotain.cu.serviceapi.model.IdcJcdmXzqydm;
import com.aotain.cu.serviceapi.model.UserInformation;
import com.aotain.cu.serviceapi.utils.BaseFeignBuilder;
import com.hankcs.hanlp.dictionary.CustomDictionary;
import cu.aotain.osmp.task.serviceapi.HouseRackServiceApi;
import cu.aotain.osmp.task.serviceapi.UserInfoServiceApi;
import cu.aotain.osmp.task.serviceapi.UserInfoServiceApiHystrix;
import cu.aotain.osmp.task.util.HanLpUtil;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.CharEncoding;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.StringEscapeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import scala.util.parsing.combinator.testing.Str;

import java.io.*;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public abstract class CrmsAndIpcFileHandle<T> {

    private static Logger logger = LoggerFactory.getLogger(CrmsAndIpcFileHandle.class);
    protected UserInfoServiceApi api ;
    protected HouseRackServiceApi houseApi ;

    protected static Map<String, String> paramMap = FileUtils
            .propertiesToMap(FileUtils.loadPropertiesFromConfig(EnvironmentUtils.EVN_DIR,"jcdm.properties", CharEncoding.UTF_8));

    protected static Map<String,Object> areaMap =new HashMap<>();
    @Autowired
    protected ZipDecompress zipDecompress;

    @Autowired
    protected VerificationInfo info;

    /**
     * 解析文件入口最终返回解析后的对象
     * @return
     */
    public T returnHanderFile(List<File> files){
        try {
            setAreaMap();
            Map<String,TreeMap<Long ,String >> content = this.process(files);
            if (content!=null && content.size()>0 && !content.values().isEmpty()){
                return constructUserObj(content);
            }
        }catch (Exception e){
            logger.error("parse file error ",e);
        }
        return null;
    }

    private void setAreaMap(){

        if (api==null){
            api= BaseFeignBuilder.getCacheFeign(UserInfoServiceApi.class, "myclient", new UserInfoServiceApiHystrix(), BaseFeignBuilder.EncodeDecodeType.EDT_JSON_JSON);
        }
        if (areaMap!=null && areaMap.get("areaDic")==null){
            if (api!=null){
                List<String> areaList = api.getAreaDic();
                for (String dic :areaList){
                    CustomDictionary.add(dic);
                }
                areaMap.put("areaDic","1");
            }else {

            }
        }
        if (areaMap!=null && areaMap.get("areaCode")==null){

            List<IdcJcdmXzqydm> areaList = api.getAreaCode(0);
            if (areaList!=null && !areaList.isEmpty()) {
                areaList.forEach(dm->{
                    areaMap.put(dm.getCode(),dm.getAreaCode());
                });
            }
            areaMap.put("areaCode","1");
        }
    }
    /**
     * 核验文件
     * @param content
     * @param verFile
     * @return
     */
    protected abstract boolean validate(Map<Long ,String> content,File verFile);


    /**
     * 解压
     * @return
     */
    public File unZip(File zipFile) {
        try {
            ZipInputStream zis =  new ZipInputStream(new FileInputStream(zipFile));
            ZipEntry entry = null;
            BufferedOutputStream bos = null;
            File target = null;
            while((entry = zis.getNextEntry()) != null && !entry.isDirectory()) {
                target = new File(zipFile.getParent(), entry.getName());
                if (!target.getParentFile().exists()) {
                    target.getParentFile().mkdirs();
                }

                bos = new BufferedOutputStream(new FileOutputStream(target));
                byte[] buffer = new byte[10240];
                int read;
                while((read = zis.read(buffer, 0, buffer.length)) != -1) {
                    bos.write(buffer, 0, read);
                }

                bos.flush();
                bos.close();
            }
            zis.close();
            return target;
        } catch (Exception e) {
            logger.error("", e);
        }
        return null;
    }

    /**
     * ,读取核验文件信息放入缓存
     * @param file
     */
    protected abstract void doVerifiyInfo(File file);


    /**
     * 解析CSV/txt文件
     * @param files
     */
    protected abstract Map<String,TreeMap<Long ,String > > process( List<File> files );


    /**
     * 组装返回对象
     * @param contents
     * @return
     */
    protected abstract T constructUserObj(Map<String,TreeMap<Long,String>> contents);

    /**
     * 结束操作
     */
    protected abstract void end(String fileName);


    /**
     * 分词 获取地市和邮编
     * @param hh
     * @return
     */
    protected void setAreaCodeByAddress( BaseModel model, String hh){

        BaseRedisService<String,String,String> baseRedisService = ContextUtil.getContext().getBean(BaseRedisService.class);

        if (model instanceof UserInformation) {
            UserInformation information = (UserInformation)model;
            HanLpUtil hanLpUtil = HanLpUtil.getInstance();
            List<String> after = hanLpUtil.segArea(hh);

            List<Map<String,String>> result = new ArrayList<>();

            for (String mc:after){
                Map<String,String> code = baseRedisService.getHashs("IDC_JCDM_XZQYDM:"+mc);
                if (code!=null){
                    result.add(code);
                }
            }
            if (result.isEmpty()) return;
            for (Map<String, String> codeMap : result) {
                if ("3".equals(codeMap.get("CODELEVEL"))) {
                    information.setUnitAddressAreaCode(codeMap.get("CODE"));
                    information.setUnitAddressAreaName(codeMap.get("MC"));
                    information.setUnitZipCode(codeMap.get("POSTCODE"));
                }
                if ("1".equals(codeMap.get("CODELEVEL") )) {
                    information.setUnitAddressProvinceCode(codeMap.get("CODE"));
                    information.setUnitAddressProvinceName(codeMap.get("MC"));
                    if (StringUtils.isEmpty(information.getUnitZipCode())) {
                        information.setUnitZipCode(codeMap.get("POSTCODE"));
                    }
                }
                if ("2".equals(codeMap.get("CODELEVEL"))) {
                    information.setUnitAddressCityCode(codeMap.get("CODE"));
                    information.setUnitAddressCityName(codeMap.get("MC"));
                    if (StringUtils.isEmpty(information.getUnitZipCode())) {
                        information.setUnitZipCode(codeMap.get("POSTCODE"));
                    }
                }
            }
            if (!StringUtils.isEmpty(information.getUnitAddressAreaCode())
                    && StringUtils.isEmpty(information.getUnitAddressCityCode())
                    ){
                Map<String,String> areaMap = baseRedisService.getHashs("IDC_JCDM_XZQYDM:"+information.getUnitAddressAreaCode());
                information.setUnitAddressCityCode(areaMap.get("PARENTCODE"));
            }
            if (!StringUtils.isEmpty(information.getUnitAddressCityCode())
                    && StringUtils.isEmpty(information.getUnitAddressProvinceCode())
                    ){
                Map<String,String> areaMap = baseRedisService.getHashs("IDC_JCDM_XZQYDM:"+information.getUnitAddressCityCode());
                information.setUnitAddressProvinceCode(areaMap.get("PARENTCODE"));
            }
        }else if( model instanceof UserServiceInformationDTO){

            Map<String,String> code = baseRedisService.getHashs("IDC_JCDM_XZQYDM:"+hh);
                if ("1".equals(code.get("CODELEVEL"))) {
                    if (StringUtils.isEmpty(model.getAreaCode())){
                        model.setAreaCode(code.get("CODE"));
                    }
                }
                if ("2".equals(code.get("CODELEVEL")) ) {
                    model.setAreaCode(code.get("CODE"));
                }
        }
    }

    /**
     * 根据key去redis获取值
     * @param key
     * @param value
     * @return
     */
    protected String getValueFormRedis(String key,String value){
        BaseRedisService<String,String,String> baseRedisService = ContextUtil.getContext().getBean(BaseRedisService.class);
        String result = baseRedisService.getHash(key+":"+value,"ID");
        return result;
    }
    private static String stringToHexString(String string){
        char[] c=new char[string.length()];
        c = string.toCharArray();
        String hesStr = "";
        for (int i = 0; i < c.length; i++) {
            hesStr = hesStr + Integer.toHexString(c[i]);
        }
        return hesStr;
    }

}
