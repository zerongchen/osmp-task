package cu.aotain.osmp.task.core.common;

import java.util.List;

import cu.aotain.osmp.task.constant.ProvinceCode;
import cu.aotain.osmp.task.core.gd.HardFileMonitorJobForGD;

/**
 * 硬盘监听Job工厂类
 * 
 * @author liuz@aotian.com
 * @date 2018年8月28日 下午9:17:54
 */
public class HardFileMonitorJobFactory {
	
	public static AbsHardFileMonitorJob createJob(MonitorResult monitorResult){
		// TODO:
		List<String> dirs = monitorResult.getDirList();
//		String systemDirName = dirs.get(0);
		String provinceCode = dirs.get(1);
//		String dataType = dirs.get(2); 			// 1-基础数据
//		String reportDate = dirs.get(3);	 	// 上报日期
		if(provinceCode.equals(ProvinceCode.GD.getCode())){
			return new HardFileMonitorJobForGD();
		}
		return null;
	}
}
