package cu.aotain.osmp.task.service;

import cu.aotain.osmp.task.core.gd.HardFileMonitorJobForGD;

import java.io.File;
import java.util.List;

/**
 * 描述:
 * Icos系统业务层
 *
 * @author chenym@aotain.com
 * @create 2018-08-24 17:04
 */
public interface IcosSystemService {

    public void observer(List<File> file, HardFileMonitorJobForGD.FileWriter999 writer);

    public void observer(File file, HardFileMonitorJobForGD.FileWriter999 writer);

    public void observer(File file, List<File> fileLists, HardFileMonitorJobForGD.FileWriter999 writer);

}
