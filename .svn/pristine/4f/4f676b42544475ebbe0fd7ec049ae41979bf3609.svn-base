package cu.aotain.osmp.task.core;

import java.util.ArrayList;
import java.util.List;

/**
 * 基础数据导入引擎
 * 
 * @author liuz@aotian.com
 * @date 2018年8月28日 上午10:16:58
 */
public class DataImportEngine {
	public List<IImportTask> taskList;

	/**
	 * 向引擎中注册任务
	 * @param task
	 */
	public void register(IImportTask task) {
		if (taskList == null) {
			taskList = new ArrayList<IImportTask>();
		}
		if (!taskList.contains(task)) {
			taskList.add(task);
			task.start();
		}
	}
	
	/**
	 * 删除任务
	 * @param task
	 */
	public void remove(IImportTask task) {
		if(taskList.contains(task)){
			task.stop(); // 停止服务
			taskList.remove(task);
		}
	}
	
	public List<IImportTask> getImportTasks(){
		return taskList;
	}
	
}
