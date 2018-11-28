package cu.aotain.osmp.task.core;

/**
 * 导入任务接口定义
 * 
 * @author liuz@aotian.com
 * @date 2018年8月28日 上午10:25:49
 */
public interface IImportJob {
	/**
	 * 初始化任务
	 * @param parms
	 */
	public void init(Object params);
	
	/**
	 * 启动任务
	 */
	public void doProcess();

	/**
	 * 停止任务
	 */
	public void stop();
	
}
