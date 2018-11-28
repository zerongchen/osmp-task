package cu.aotain.osmp.task.service;


import com.aotain.common.utils.compress.zip.ZipDecompress;
import com.aotain.common.utils.tools.FileUtils;
import com.aotain.cu.serviceapi.dto.HouseInformationDTO;
import cu.aotain.osmp.task.core.gd.HardFileMonitorJobForGD;
import cu.aotain.osmp.task.model.IdcHouseCodeLibModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * 描述: 模板抽象
 *
 * @author chenym@aotain.com
 * @create 2018-08-20 16:34
 */
public abstract class IcosSystemFileAnalyze {

    private static final Logger LOG = LoggerFactory.getLogger(IcosSystemFileAnalyze.class);

    @Autowired
    private ZipDecompress zipDecompress;

    @Autowired
    private VerificationInfo info;

    @Autowired
    protected HouseCacheService houseCacheService;

    @Autowired
    protected UserNameUserIdCacheService userNameUserIdCacheService;

    protected HardFileMonitorJobForGD.FileWriter999 writer;
    @Autowired
    private HouseNodeCodeCache houseNodeCodeCache;
    private String fileName;

    private boolean isError = false;

    public void process(File file) {

        fileName = file.getName();

        LOG.info("process file=" + file.getAbsolutePath());

        File dataFile = null;
        if (fileName.contains("verification")) {
            dataFile = file;
        } else {
            if (this.unZip(file)) {
                LOG.info("unzip file=" + file + ",success!");
            } else {
                LOG.error("unzip file=" + file + ",failure!");
                return;
            }
            dataFile = new File(file.getAbsolutePath().replaceAll("zip", "csv"));
            if (!dataFile.exists()) {
                LOG.error("datafile of " + file.getAbsolutePath() + ",is not exists!");
                return;
            }
        }

        this.postProcess(dataFile);
        try {
            if (this.verification(dataFile)) {
                List<String> contxts = resolveAndValid(dataFile);
                this.assemblyBean(contxts);
            }
        } catch (Exception e) {
            LOG.error("", e);
        } finally {
            close999File();
        }

    }

    /**
     * 解压缩
     */
    public boolean unZip(File file) {
        try {
            if (file.exists()) {
                zipDecompress.process(file, new File(file.getParent()));
                if (new File(file.getAbsolutePath().replaceAll("zip", "csv")).exists()) {
                    return true;
                }
            } else {
                LOG.error("zip file=" + file.getAbsolutePath() + ",not exists!");
            }
        } catch (Exception e) {
            LOG.error("", e);
        }
        return false;
    }

    /**
     *
     */
    public abstract void postProcess(File file);

    /**
     * 数据文件校验
     */
    public Boolean verification(File file) {
        if (file == null || file.getName().contains("verification")) {
            return false;
        }
        try {
            List<String> contexts = FileUtils.readFileByLine(file);
            int fileRecordsNumber = contexts.size();
            String fileName = file.getName();
            Map<String, String> icos_map = info.getIcosVerificationMap();
            if (icos_map.containsKey(fileName.toLowerCase())) {
                String length = icos_map.get(fileName.toLowerCase());
                if (LOG.isDebugEnabled()) {
                    LOG.debug("[" + file.getAbsolutePath() + "], file->fileRecords=" + fileRecordsNumber + ",verification->fileRecords=" + length);
                }
                if (length.equals(contexts.size() + "")) {
                    return true;
                } else {
                    LOG.warn(fileName.toLowerCase() + " file->fileRecords=" + fileRecordsNumber + ",verification->fileRecords=" + length + ", not match!");
                }
            } else {
                LOG.error("verification not found {" + fileName + "}");
            }
        } catch (Exception e) {
            LOG.error("", e);
            return false;
        }
        return false;
    }

    /**
     * 解析并校验文件记录
     */
    public abstract List<String> resolveAndValid(File file);

    /**
     * 装配bean
     */
    public abstract void assemblyBean(List<String> list);

    /**
     * 写错误记录
     *
     * @param line
     */
    public void writeErrorLine(String line) {
        isError = true;
        writer.append(fileName, line + "\n");
    }


    public String getHouseIdByAreaCode(String areaCode) {
        //机房编码
        IdcHouseCodeLibModel mo = houseNodeCodeCache.getIdcHouseCodeLibModel(areaCode);
        if (mo == null) {
            LOG.warn("house_node_code:" + areaCode + ",get IdcHouseCodeLib is NULL");
            return null;
        }
        //机房信息
        HouseInformationDTO n = houseCacheService.getHouseInfo(mo.getDataCenterCode());

        if (n == null || n.getHouseId() == 0) {
            LOG.warn("data_center_code:" + mo.getDataCenterCode() + ",get houseid from database is null");
            return null;
        }
        return n.getHouseId() + "";

    }

    public String getUserIdByUserName(String customerName) {
        return userNameUserIdCacheService.getUserIdByUserName(customerName);
    }


    public void close999File() {
        if (isError) {
            writer.closeWriter(fileName, "100");
        }
    }
}
