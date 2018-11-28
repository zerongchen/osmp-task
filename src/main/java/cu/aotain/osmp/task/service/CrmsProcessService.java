package cu.aotain.osmp.task.service;

import cu.aotain.osmp.task.core.gd.HardFileMonitorJobForGD;

import java.io.File;
import java.util.List;

public interface CrmsProcessService {

    public void execute( File validateFile, List<File> dataFile ,HardFileMonitorJobForGD.FileWriter999 wirter);

}
