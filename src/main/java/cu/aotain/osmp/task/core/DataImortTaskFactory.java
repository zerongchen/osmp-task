package cu.aotain.osmp.task.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.aotain.common.utils.tools.EnvironmentUtils;
import com.aotain.common.utils.tools.FileUtils;

import cu.aotain.osmp.task.constant.ProvinceCode;
import cu.aotain.osmp.task.core.common.HardFileImportTask;

/**
 * 导出任务构造工厂
 * 
 * @author liuz@aotian.com
 * @date 2018年8月28日 上午11:11:23
 */
public class DataImortTaskFactory {
	
	/**
	 * 根据省份名称构造
	 * @param provinceCode 省份简码
	 * 
	 * @return
	 */
	public static List<IImportTask> buildTaskByProvinceCode(ProvinceCode provinceCode) {
		List<IImportTask>  list = new ArrayList<IImportTask>();
		if(ProvinceCode.GD.equals(provinceCode)) {
			// 1. 创建硬盘文件监控
			IImportTask task = new HardFileImportTask();
			Map<String, String> params = FileUtils
					.propertiesToMap(EnvironmentUtils.loadPropertiesFromEnv("engine.properties"));
			//		.propertiesToMap(FileUtils.loadPropertiesFromConfig("config", "engine.properties"));
			// 改成读取环境变量下的配置文件
			task.init(params);
			list.add(task);
			// TODO: 创建webservice服务调用者
		}
		return list;
	}
}
