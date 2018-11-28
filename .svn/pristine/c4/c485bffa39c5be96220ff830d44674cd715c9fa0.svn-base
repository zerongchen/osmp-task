package cu.aotain.osmp.task.service.impl;

import cu.aotain.osmp.task.core.gd.HardFileMonitorJobForGD;
import cu.aotain.osmp.task.factory.AbstractOsmpFactory;
import cu.aotain.osmp.task.factory.IcosSystem;
import cu.aotain.osmp.task.service.IcosSystemService;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 描述:
 * Icos系统业务层
 *
 * @author chenym@aotain.com
 * @create 2018-08-24 17:04
 */
@Service
public class IcosSystemServiceImp implements IcosSystemService {

    private static final Logger LOG = LoggerFactory.getLogger(IcosSystemServiceImp.class);

    @Autowired
    @Qualifier("icosSystemFactory")
    private AbstractOsmpFactory AbstractOsmpFactory;

    public void observer(List<File> fileList, HardFileMonitorJobForGD.FileWriter999 writer) {

        if (fileList == null || (fileList != null && fileList.size() == 0)) {
            return;
        }
        try {
            for (File f : fileList) {
                String fileName = FilenameUtils.getBaseName(f.getName());
                IcosSystem icosSystem = AbstractOsmpFactory.getIcosSystemType(fileName);
                icosSystem.execte(f, writer);
            }
        } catch (Exception e) {
            LOG.error(" ", e);
        }
    }

    public void observer(File file, HardFileMonitorJobForGD.FileWriter999 writer) {
        String fileName = FilenameUtils.getBaseName(file.getName());
        IcosSystem icosSystem = AbstractOsmpFactory.getIcosSystemType(fileName);
        icosSystem.execte(file, writer);
    }

    public void observer(File file, List<File> fileLists, HardFileMonitorJobForGD.FileWriter999 writer) {
        this.observer(file, writer);
        this.observer(fileLists, writer);
    }

}
