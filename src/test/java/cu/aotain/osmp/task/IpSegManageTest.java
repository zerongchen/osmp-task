package cu.aotain.osmp.task;

import com.aotain.common.utils.tools.EnvironmentUtils;
import com.aotain.cu.serviceapi.dto.ResultDto;
import com.aotain.cu.serviceapi.utils.ServiceAddressSelector;
import cu.aotain.osmp.task.mapper.IdcIsmsIpLibMapper;
import cu.aotain.osmp.task.model.ReqQuery;
import cu.aotain.osmp.task.service.ipsegmanage.IpSegManageService;
import cu.aotain.osmp.task.service.ipsegmanage.IpSegService;
import cu.aotain.osmp.task.util.MyFileUtils;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * Demo class
 *
 * @author bang
 * @date 2018/08/29
 */
public class IpSegManageTest extends BaseTest{

    @Autowired
    private IpSegManageService ipSegManageService;

    @Autowired
    private IdcIsmsIpLibMapper idcIsmsIpLibMapper;

    @Before
    public void before(){
        EnvironmentUtils.ConfigBuilder cb = new EnvironmentUtils.ConfigBuilder();
        cb.append(EnvironmentUtils.WORK_PATH, ".");
        cb.append(EnvironmentUtils.LOG4J_PATH, "config/log4j.properties");
        cb.append(EnvironmentUtils.EVN_DIR, "osmp-task");
        EnvironmentUtils.init(cb.build());
        ServiceAddressSelector.init(EnvironmentUtils.loadPropertiesFromEnv("ribbon.properties"));
    }

    @Test
    public void test(){
//        ResultDto resultDto = ipSegManageService.synchDb();
//        System.out.println(resultDto);
        Map<String,ResultDto> resultDto = ipSegManageService.synchDb();
        MyFileUtils.writeErrorFile(null,"error",resultDto);
    }

    @Test
    public void testMapper(){
        List<ReqQuery> reqQueryList = idcIsmsIpLibMapper.findIpv4QueryCondition();
        System.out.println(reqQueryList.size()+"======");
    }
}
