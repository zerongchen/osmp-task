package cu.aotain.osmp.task;

import com.aotain.common.utils.tools.EnvironmentUtils;
import com.aotain.cu.serviceapi.dto.*;
import com.aotain.cu.serviceapi.model.HouseUserFrameInformation;
import com.aotain.cu.serviceapi.model.PageResult;
import com.aotain.cu.serviceapi.utils.BaseFeignBuilder;
import com.aotain.cu.serviceapi.utils.ServiceAddressSelector;
import cu.aotain.osmp.task.service.HouseCacheService;
import cu.aotain.osmp.task.service.IcosSystemService;
import cu.aotain.osmp.task.serviceapi.*;
import cu.aotain.osmp.task.serviceapi.hystrix.HouseRackServiceApiHystrix;
import cu.aotain.osmp.task.serviceapi.hystrix.UserInfoServiceHystrix;
import org.apache.commons.io.FilenameUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 描述:
 *
 * @author chenym@aotain.com
 * @create 2018-08-25 9:06
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-osmp-task.xml"})
public class TestIcosSystem {

    @Before
    public void before() {
        EnvironmentUtils.ConfigBuilder cb = new EnvironmentUtils.ConfigBuilder();
        cb.append(EnvironmentUtils.WORK_PATH, ".");
        cb.append(EnvironmentUtils.LOG4J_PATH, "config/log4j.properties");
        cb.append(EnvironmentUtils.EVN_DIR, "osmp-task");
        EnvironmentUtils.init(cb.build());
        ServiceAddressSelector.init(EnvironmentUtils.loadPropertiesFromEnv("ribbon.properties"));
    }

    @Autowired
    private IcosSystemService icosSystemService;

    @Autowired
    private HouseCacheService houseCacheService;

    @Test
    public void test12() {

        houseCacheService.getHouseInfo("dongguan_001");
        houseCacheService.getHouseInfo("dongguan_001");
        houseCacheService.getHouseInfo("dongguan_001");

    }

    @Test
    public void test1() {

        File dir = new File("D:\\project\\CU\\export_20180821");
        List<File> dataFileLists = new ArrayList<>();
        File verFile = null;

        for (File file : dir.listFiles(new FileNameFilter())) {
            String fileName = FilenameUtils.getBaseName(file.getName());
            if (fileName.contains("verification")) {
                verFile = file;
            } else {
                dataFileLists.add(file);
            }
        }
        icosSystemService.observer(verFile, dataFileLists,null);

    }


    static class FileNameFilter implements FileFilter {
        @Override
        public boolean accept(File pathname) {
            if (FilenameUtils.isExtension(pathname.getName(), "ok")) {
                return true;
            }
            return false;
        }
    }

    @Test
    public void test2() {
        IDemoService idemo = BaseFeignBuilder.getCacheFeign(IDemoService.class, "myclient", new DemoServiceHystrix(), BaseFeignBuilder.EncodeDecodeType.EDT_JSON_JSON);
        System.out.println("XXXXXXXXXXX：" + idemo.sayHello(new cu.aotain.osmp.task.serviceapi.IDemoService.UserBean("liuz-刘照")));
        System.out.println("XXXXXXXXXXX：" + idemo.sayHello1(new cu.aotain.osmp.task.serviceapi.IDemoService.UserBean("liuz-大的说法")));
    }


    @Test
    public void test3() {
        EnvironmentUtils.ConfigBuilder cb = new EnvironmentUtils.ConfigBuilder();
        cb.append(EnvironmentUtils.WORK_PATH, ".");
        cb.append(EnvironmentUtils.LOG4J_PATH, "config/log4j.properties");
        cb.append(EnvironmentUtils.EVN_DIR, "osmp-task");
        EnvironmentUtils.init(cb.build());
        ServiceAddressSelector.init(EnvironmentUtils.loadPropertiesFromEnv("ribbon.properties"));

        IDemoService idemo = BaseFeignBuilder.getCacheFeign(IDemoService.class, "myclient", new DemoServiceHystrix(), BaseFeignBuilder.EncodeDecodeType.EDT_JSON_JSON);
        System.out.println("XXXXXXXXXXX：" + idemo.sayHello(new cu.aotain.osmp.task.serviceapi.IDemoService.UserBean("liuz-刘照")));
        System.out.println("XXXXXXXXXXX：" + idemo.sayHello1(new cu.aotain.osmp.task.serviceapi.IDemoService.UserBean("liuz-大的说法")));
    }

    @Test
    public void testListUserInfo() {
        EnvironmentUtils.ConfigBuilder cb = new EnvironmentUtils.ConfigBuilder();
        cb.append(EnvironmentUtils.WORK_PATH, ".");
        cb.append(EnvironmentUtils.LOG4J_PATH, "config/log4j.properties");
        cb.append(EnvironmentUtils.EVN_DIR, "osmp-task");
        EnvironmentUtils.init(cb.build());
        ServiceAddressSelector.init(EnvironmentUtils.loadPropertiesFromEnv("ribbon.properties"));

        UserInfoService idemo = BaseFeignBuilder.getCacheFeign(UserInfoService.class, "myclient", new UserInfoServiceHystrix(), BaseFeignBuilder.EncodeDecodeType.EDT_JSON_JSON);
        System.out.println("-----------------------------------------");
        UserInformationDTO dto = new UserInformationDTO();
        dto.setIsPaging(0);

        dto.setProviderName("12345");
        PageResult<UserInformationDTO> l = idemo.listUserInfo(dto);
        System.out.println(l.getRows().size());
        System.out.println("-----------------------------------------");
    }

    @Test
    public void testUpdateUserInfo() {
        EnvironmentUtils.ConfigBuilder cb = new EnvironmentUtils.ConfigBuilder();
        cb.append(EnvironmentUtils.WORK_PATH, ".");
        cb.append(EnvironmentUtils.LOG4J_PATH, "config/log4j.properties");
        cb.append(EnvironmentUtils.EVN_DIR, "osmp-task");
        EnvironmentUtils.init(cb.build());
        ServiceAddressSelector.init(EnvironmentUtils.loadPropertiesFromEnv("ribbon.properties"));

        UserInfoService idemo = BaseFeignBuilder.getCacheFeign(UserInfoService.class, "myclient", new UserInfoServiceHystrix(), BaseFeignBuilder.EncodeDecodeType.EDT_JSON_JSON);
        System.out.println("-----------------------------------------");
        UserInformationDTO dto = new UserInformationDTO();
        dto.setIsPaging(0);

        dto.setProviderName("12345");
        ResultDto l = idemo.changeUserNature(dto);
        System.out.println(l.toString());
        System.out.println("-----------------------------------------");
    }

    /**
     * 查询所有机架信息
     */
    @Test
    public void testQueryRack() {
        EnvironmentUtils.ConfigBuilder cb = new EnvironmentUtils.ConfigBuilder();
        cb.append(EnvironmentUtils.WORK_PATH, ".");
        cb.append(EnvironmentUtils.LOG4J_PATH, "config/log4j.properties");
        cb.append(EnvironmentUtils.EVN_DIR, "osmp-task");
        EnvironmentUtils.init(cb.build());
        ServiceAddressSelector.init(EnvironmentUtils.loadPropertiesFromEnv("ribbon.properties"));

        HouseRackServiceApi idemo = BaseFeignBuilder.getCacheFeign(HouseRackServiceApi.class, "myclient", new HouseRackServiceApiHystrix(), BaseFeignBuilder.EncodeDecodeType.EDT_JSON_JSON);
        System.out.println("-----------------------------------------");
        HouseFrameInformationDTO dto = new HouseFrameInformationDTO();
        dto.setIsPaging(0);

        Set databaseFrameNameSet = new HashSet();
        PageResult<HouseFrameInformationDTO> databaseRecords = idemo.queryRack(dto);
        for (HouseFrameInformationDTO m : databaseRecords.getRows()) {
            databaseFrameNameSet.add(m.getFrameName());
        }
        System.out.println(databaseFrameNameSet);
    }

    /**
     * 查询所有机房信息
     */
    @Test
    public void testListHouseInfo() {
        EnvironmentUtils.ConfigBuilder cb = new EnvironmentUtils.ConfigBuilder();
        cb.append(EnvironmentUtils.WORK_PATH, ".");
        cb.append(EnvironmentUtils.LOG4J_PATH, "config/log4j.properties");
        cb.append(EnvironmentUtils.EVN_DIR, "osmp-task");
        EnvironmentUtils.init(cb.build());
        ServiceAddressSelector.init(EnvironmentUtils.loadPropertiesFromEnv("ribbon.properties"));

        HouseRackServiceApi idemo = BaseFeignBuilder.getCacheFeign(HouseRackServiceApi.class, "myclient", new HouseRackServiceApiHystrix(), BaseFeignBuilder.EncodeDecodeType.EDT_JSON_JSON);
        System.out.println("-----------------------------------------");
        HouseInformationDTO dto = new HouseInformationDTO();
        dto.setIsPaging(0);

        PageResult<HouseInformationDTO> lists = idemo.listHouseInfo(dto);
        System.out.println(lists.getRows());
    }

    /**
     * 新增机房信息
     */
    @Test
    public void testInsertHouseFrame() {
        EnvironmentUtils.ConfigBuilder cb = new EnvironmentUtils.ConfigBuilder();
        cb.append(EnvironmentUtils.WORK_PATH, ".");
        cb.append(EnvironmentUtils.LOG4J_PATH, "config/log4j.properties");
        cb.append(EnvironmentUtils.EVN_DIR, "osmp-task");
        EnvironmentUtils.init(cb.build());
        ServiceAddressSelector.init(EnvironmentUtils.loadPropertiesFromEnv("ribbon.properties"));

        HouseRackServiceApi idemo = BaseFeignBuilder.getCacheFeign(HouseRackServiceApi.class, "myclient", new HouseRackServiceApiHystrix(), BaseFeignBuilder.EncodeDecodeType.EDT_JSON_JSON);
        System.out.println("-----------------------------------------");

        List<HouseFrameInformationDTO> list = new ArrayList<>();
        HouseFrameInformationDTO dto = new HouseFrameInformationDTO();
        dto.setHouseId(4307L);
        dto.setFrameName("bbb");
        dto.setFrameNo("bbb");
        dto.setAreaCode("442000");

        List cityCodeLists = new ArrayList();
        cityCodeLists.add(dto.getAreaCode());
        dto.setCityCodeList(cityCodeLists);
        dto.setOccupancy(1);
        dto.setUseType(1);
        dto.setCreateUserId(0);

        List<HouseUserFrameInformation> HouseUserFrameInformations = new ArrayList<>();
        HouseUserFrameInformation houseUser = new HouseUserFrameInformation();
        houseUser.setUserName("深圳市高新科技");
        houseUser.setHouseId(4307L);
        HouseUserFrameInformations.add(houseUser);

        dto.setUserFrameList(HouseUserFrameInformations);
        list.add(dto);

        ResultDto lists = idemo.insertRack(list);
        System.out.println(lists);
    }

    /**
     * 修改机房信息
     */
    @Test
    public void testupdateRack() {

        HouseRackServiceApi idemo = BaseFeignBuilder.getCacheFeign(HouseRackServiceApi.class, "myclient", new HouseRackServiceApiHystrix(), BaseFeignBuilder.EncodeDecodeType.EDT_JSON_JSON);
        System.out.println("-----------------------------------------");

        List<HouseFrameInformationDTO> list = new ArrayList<>();
        HouseFrameInformationDTO dto = new HouseFrameInformationDTO();
        dto.setFrameId(484958L);
        dto.setHouseId(4311L);
        dto.setFrameName("德胜IDC八楼机房-11-09999");
        dto.setFrameNo("德胜IDC八楼机房-11-09999");
        dto.setAreaCode("442000");
        List cityCodeLists = new ArrayList();
        cityCodeLists.add(dto.getAreaCode());
        dto.setCityCodeList(cityCodeLists);
        dto.setOccupancy(1);
        dto.setUseType(1);
        dto.setUpdateUserId(-1);

        List<HouseUserFrameInformation> HouseUserFrameInformations = new ArrayList<>();
        HouseUserFrameInformation houseUser = new HouseUserFrameInformation();
        houseUser.setUserName("深圳市高新科技");
        houseUser.setHouseId(4311L);
        HouseUserFrameInformations.add(houseUser);

        dto.setUserFrameList(HouseUserFrameInformations);
        list.add(dto);

        ResultDto lists = idemo.updateRack(list);
        System.out.println(lists);
    }

    /**
     * 修改机房信息
     */
    @Test
    public void testdeleteRack() {

        HouseRackServiceApi idemo = BaseFeignBuilder.getCacheFeign(HouseRackServiceApi.class, "myclient", new HouseRackServiceApiHystrix(), BaseFeignBuilder.EncodeDecodeType.EDT_JSON_JSON);
        System.out.println("-----------------------------------------");

        List<HouseFrameInformationDTO> list = new ArrayList<>();
        HouseFrameInformationDTO dto = new HouseFrameInformationDTO();
       dto.setFrameId(506641L);
        /*       dto.setHouseId(4311L);*/
        dto.setFrameName("东区407机房-03-01");
        dto.setFrameNo("东区407机房-03-01");
/*        dto.setAreaCode("442000");
        List cityCodeLists = new ArrayList();
        cityCodeLists.add(dto.getAreaCode());
        dto.setCityCodeList(cityCodeLists);
        dto.setOccupancy(1);
        dto.setUseType(1);
        dto.setUpdateUserId(-1);*/

        List<HouseUserFrameInformation> HouseUserFrameInformations = new ArrayList<>();
        HouseUserFrameInformation houseUser = new HouseUserFrameInformation();
        houseUser.setUserName("深圳市高新科技");
        houseUser.setHouseId(4311L);
        HouseUserFrameInformations.add(houseUser);

        dto.setUserFrameList(HouseUserFrameInformations);
        list.add(dto);

        ResultDto lists = idemo.deleteRack(list);
        System.out.println(lists);
    }


    /**
     * 查询机房ip段信息
     */
    @Test
    public void testqueryIpSeg() {

        IHouseIpSegServiceApi idemo = BaseFeignBuilder.getCacheFeign(IHouseIpSegServiceApi.class, "myclient", new HouseIpSegServiceApiHystrix(), BaseFeignBuilder.EncodeDecodeType.EDT_JSON_JSON);
        System.out.println("-----------------------------------------");

        HouseIPSegmentInforDTO dto = new HouseIPSegmentInforDTO();
        dto.setIsPaging(0);
        PageResult<HouseIPSegmentInforDTO> lists = idemo.queryIpSeg(dto);
        System.out.println(lists);
    }

    /**
     * 查询机房ip段信息
     */
    @Test
    public void testqueryUserInfo() {

        UserInfoServiceApi serviceApi = BaseFeignBuilder.getCacheFeign(UserInfoServiceApi.class, "myclient", new UserInfoServiceApiHystrix(), BaseFeignBuilder.EncodeDecodeType.EDT_JSON_JSON);
        System.out.println("-----------------------------------------");

        UserInformationDTO dto = new UserInformationDTO();
        dto.setIsPaging(0);
        PageResult<UserInformationDTO> lists = serviceApi.getAllUser(dto);
        System.out.println(lists);
    }
}
