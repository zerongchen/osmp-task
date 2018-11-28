package cu.aotain.osmp.task;

import java.util.List;
import java.util.Properties;
import java.util.Timer;
import java.util.TimerTask;

import com.aotain.common.config.ContextUtil;
import cu.aotain.osmp.task.service.impl.CrmsProcessServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.aotain.common.utils.quartz.QuartzTaskLoadUtils;
import com.aotain.common.utils.tools.EnvironmentUtils;
import com.aotain.common.utils.tools.FileUtils;
import com.aotain.common.utils.tools.MonitorStatisticsUtils;
import com.aotain.cu.serviceapi.utils.BaseFeignBuilder;
import com.aotain.cu.serviceapi.utils.ServiceAddressSelector;

import cu.aotain.osmp.task.constant.ProvinceCode;
import cu.aotain.osmp.task.core.DataImortTaskFactory;
import cu.aotain.osmp.task.core.DataImportEngine;
import cu.aotain.osmp.task.core.IImportTask;
import cu.aotain.osmp.task.serviceapi.DemoServiceHystrix;
import cu.aotain.osmp.task.serviceapi.IDemoService;

public class Main {
    static {
        EnvironmentUtils.ConfigBuilder cb = new EnvironmentUtils.ConfigBuilder();
        cb.append(EnvironmentUtils.WORK_PATH, ".");
        cb.append(EnvironmentUtils.LOG4J_PATH, "config/log4j.properties");
        cb.append(EnvironmentUtils.EVN_DIR, "osmp-task");
        EnvironmentUtils.init(cb.build());
        ServiceAddressSelector.init(EnvironmentUtils.loadPropertiesFromEnv("ribbon.properties"));
    }

    private static Logger logger = Logger.getLogger(Main.class);
    private static String PROJECT_MODULE_NAME = "osmstask";

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                new String[]{"classpath:spring-osmp-task.xml"});
        MonitorStatisticsUtils.initModuleNoThread(PROJECT_MODULE_NAME);

        DataImportEngine engine = new DataImportEngine();
        List<IImportTask> tasks =  DataImortTaskFactory.buildTaskByProvinceCode(ProvinceCode.GD);
        for(IImportTask task : tasks){
        	engine.register(task);
        }
        
        loadAndRefreshQuartzJob();
    }

    /**
     * 加载定时任务并每5分钟刷新定时配置
     */
    @SuppressWarnings("unused")
	private static void loadAndRefreshQuartzJob() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
                           @Override
                           public void run() {
                               Properties pro = FileUtils.loadPropertiesFromConfig("config", "quartz.properties");
                               QuartzTaskLoadUtils.loadOrRefresh(pro);
                           }
                       }
                , 10000, 20000);
    }
}
