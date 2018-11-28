package cu.aotain.osmp.task;

import com.aotain.common.utils.tools.EnvironmentUtils;
import com.aotain.cu.serviceapi.dto.HouseIPSegmentInforDTO;
import com.aotain.cu.serviceapi.dto.ResultDto;
import com.aotain.cu.serviceapi.dto.UserInformationDTO;
import com.aotain.cu.serviceapi.model.PageResult;
import com.aotain.cu.serviceapi.utils.BaseFeignBuilder;
import com.aotain.cu.serviceapi.utils.ServiceAddressSelector;
import cu.aotain.osmp.task.mapper.IdcHouseCodeLibMapper;
import cu.aotain.osmp.task.model.IdcHouseCodeLibModel;
import cu.aotain.osmp.task.service.HouseCacheService;
import cu.aotain.osmp.task.service.HouseNodeCodeCache;
import cu.aotain.osmp.task.service.IcosSystemService;
import cu.aotain.osmp.task.serviceapi.HouseIpSegServiceApiHystrix;
import cu.aotain.osmp.task.serviceapi.IHouseIpSegServiceApi;
import cu.aotain.osmp.task.serviceapi.UserInfoServiceApi;
import cu.aotain.osmp.task.serviceapi.UserInfoServiceApiHystrix;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 描述:
 *
 * @author chenym@aotain.com
 * @create 2018-08-30 14:15
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-osmp-task.xml"})
public class TestUserInfo {

    @Autowired
    private IcosSystemService icosSystemService;

    @Autowired
    private IdcHouseCodeLibMapper idcHouseCodeLibMapper;

    @Autowired
    private HouseNodeCodeCache houseNodeCodeCache ;

    @Autowired
    private CacheManager cacheManager;

    /**
     * 查询用户信息
     */
    @Test
    public void testQueryUserInfo() {

        UserInfoServiceApi userInfoServiceApi = BaseFeignBuilder.getCacheFeign(UserInfoServiceApi.class, "myclient", new UserInfoServiceApiHystrix(), BaseFeignBuilder.EncodeDecodeType.EDT_JSON_JSON);

        UserInformationDTO dto = new UserInformationDTO();
        dto.setIsPaging(0);
        PageResult<UserInformationDTO> lists = userInfoServiceApi.getAllUser(dto);
        System.out.println(lists);
    }

    /**
     * 查询用户信息
     */
    @Test
    public void testdeleteUserInfo() {

        UserInfoServiceApi userInfoServiceApi = BaseFeignBuilder.getCacheFeign(UserInfoServiceApi.class, "myclient", new UserInfoServiceApiHystrix(), BaseFeignBuilder.EncodeDecodeType.EDT_JSON_JSON);
        List<UserInformationDTO> list = new ArrayList<>();
        UserInformationDTO dto1 = new UserInformationDTO();
        dto1.setUserId(30335L);
        list.add(dto1);

        ResultDto lists = userInfoServiceApi.delete(list);
        System.out.println(lists);
    }


    /**
     * 查询机房节点编码表
     */
    @Test
    public void testQueryHouseCodeLib() {
        List<IdcHouseCodeLibModel> list = idcHouseCodeLibMapper.getIdcHouseCodeLibModelAll();
        System.out.println(list);
    }

    /**
     * 查询缓存,清空缓存
     */
    @Test
    public void testCacheManager() {
        System.out.println(cacheManager);
        IdcHouseCodeLibModel m1 = houseNodeCodeCache.getIdcHouseCodeLibModel("aaa");
        IdcHouseCodeLibModel m2 = houseNodeCodeCache.getIdcHouseCodeLibModel("bbb");
        IdcHouseCodeLibModel m3 = houseNodeCodeCache.getIdcHouseCodeLibModel("bbb");
        houseNodeCodeCache.removeIdcHouseCodeLibModel("bbb");
        System.out.println(cacheManager);
    }

}
