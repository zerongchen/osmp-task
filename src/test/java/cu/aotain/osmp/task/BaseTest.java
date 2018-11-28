package cu.aotain.osmp.task;

import cu.aotain.osmp.task.service.impl.CrmsProcessServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Demo class
 *
 * @author bang
 * @date 2018/08/27
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-osmp-task.xml"})
public class BaseTest {
    private ApplicationContext applicationContext;

    @Autowired
    private CrmsProcessServiceImpl crmsProcessService;

    @PostConstruct
    public void init(){
        applicationContext = new ClassPathXmlApplicationContext("classpath:spring-osmp-task.xml");
    }

    @PreDestroy
    public void destroy(){
        AbstractApplicationContext ctx = (AbstractApplicationContext)applicationContext;
        ctx.close();
    }

    @Test
    public void test(){
        System.out.println(applicationContext+"=======");
    }

    @Test
    public void testCrms(){
        System.out.println(applicationContext+"=======");
    }
}
