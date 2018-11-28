package cu.aotain.osmp.task.core.common;

import org.apache.log4j.Logger;

import cu.aotain.osmp.task.constant.ImportJobStatus;
import cu.aotain.osmp.task.core.IImportJob;

/**
 * 硬盘文件监听Job（实现对文件的校验、备份等功能）
 * 
 * @author liuz@aotian.com
 * @date 2018年8月28日 下午9:14:50
 */
public abstract class AbsHardFileMonitorJob implements IImportJob {
	private MonitorResult mresult;
	private Logger logger = Logger.getLogger(AbsHardFileMonitorJob.class);
	private ImportJobStatus status = ImportJobStatus.UN_INIT;
	
	@Override
	public void init(Object params) {
		this.mresult = (MonitorResult) params;
		status = ImportJobStatus.INIT; 
	}

	@Override
	public void stop() {
		if(status == ImportJobStatus.UN_INIT || status == ImportJobStatus.INIT){
			logger.warn("job "+this.getClass().getName() + " is not started");
			return;
		}
		if(status == ImportJobStatus.STOP || status == ImportJobStatus.INTERRUPTED) {
			logger.warn("job "+this.getClass().getName() + " was stoped");
			return;
		}
		if(status == ImportJobStatus.INTERRUPTING) {
			logger.warn("job "+this.getClass().getName() + " is interrupting ...");
			return;
		}
		logger.warn("try to interrupt job ... ");
		status = ImportJobStatus.INTERRUPTING;
	}

	@Override
	public void doProcess() {
		status = ImportJobStatus.START;
		dealFiles(this.mresult);
		// 非中断时,改为执行完成
		if(status != ImportJobStatus.INTERRUPTED){
			status = ImportJobStatus.STOP;
		}
	}
	
	/**
	 * 文件处理
	 * @param monitorReusult
	 * @param
	 */
	public abstract void dealFiles(MonitorResult monitorReusult);

}
