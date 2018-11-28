package cu.aotain.osmp.task.service.impl;

import com.aotain.common.utils.tools.FileUtils;
import cu.aotain.osmp.task.core.gd.HardFileMonitorJobForGD;
import cu.aotain.osmp.task.factory.IcosSystem;
import cu.aotain.osmp.task.service.IcosSystemFileAnalyze;
import cu.aotain.osmp.task.service.VerificationInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 描述:
 *
 * @author chenym@aotain.com
 * @create 2018-08-25 9:46
 */
@Service
public class IcosSystemVerificationServiceImpl extends IcosSystemFileAnalyze implements IcosSystem {

    private static final Logger LOG = LoggerFactory.getLogger(IcosSystemVerificationServiceImpl.class);

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
    public boolean unZip(File file) {
        return true;
    }

    @Override
    public void postProcess(File file) {

        List<String> contexts = FileUtils.readFileByLine(file);
        if (LOG.isDebugEnabled()) {
            LOG.debug("[" + file.getName() + "] content:" + contexts);
        }
        try {
            for (String line : contexts) {
                String[] arr = line.split(",");
                if (arr != null && arr.length == 2) {
                    info.getIcosVerificationMap().put(arr[0].toLowerCase(), arr[1]);
                }
            }
            if (LOG.isDebugEnabled()) {
                LOG.debug("[info.getIcosVerificationMap()" + info.getIcosVerificationMap());
            }
        } catch (Exception e) {
            LOG.error("", e);
        }

    }

    @Override
    public List<String> resolveAndValid(File file) {
        return null;
    }

    @Override
    public void assemblyBean(List<String> list) {

    }

}
