package cu.aotain.osmp.task.quartz;

import com.aotain.common.utils.quartz.AbsQuartzJob;
import com.aotain.common.utils.quartz.IQuartzJob;

public class DemoJob2 extends AbsQuartzJob {

	@Override
	public void run(IQuartzJob jobInfo) {
		System.out.println("This is a test job2:"+jobInfo);


	}

}
