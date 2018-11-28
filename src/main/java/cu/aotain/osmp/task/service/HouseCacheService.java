package cu.aotain.osmp.task.service;

import com.aotain.common.utils.tools.EnvironmentUtils;
import com.aotain.cu.serviceapi.dto.HouseInformationDTO;
import com.aotain.cu.serviceapi.model.PageResult;
import com.aotain.cu.serviceapi.utils.BaseFeignBuilder;
import com.aotain.cu.serviceapi.utils.ServiceAddressSelector;
import cu.aotain.osmp.task.serviceapi.HouseRackServiceApi;
import cu.aotain.osmp.task.serviceapi.hystrix.HouseRackServiceApiHystrix;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * 描述:
 *
 * @author chenym@aotain.com
 * @create 2018-08-28 14:17
 */
@Service
public class HouseCacheService implements BeanNameAware {

    @Cacheable("houseinfos")
    public HouseInformationDTO getHouseInfo(String houseIdstr) {

        return getHouseInfoFromDb(houseIdstr);
    }

    @Autowired
    private CacheManager cacheManager;

    @PostConstruct
    public void initHouseCenterCodeCache() {
        HouseRackServiceApi idemo = BaseFeignBuilder.getCacheFeign(HouseRackServiceApi.class, "myclient", new HouseRackServiceApiHystrix(), BaseFeignBuilder.EncodeDecodeType.EDT_JSON_JSON);
        HouseInformationDTO dto = new HouseInformationDTO();
        dto.setIsPaging(0);
        PageResult<HouseInformationDTO> lists = idemo.listHouseInfo(dto);
        if (lists != null && lists.getRows().size() > 0) {
            Cache houseNodeCache = cacheManager.getCache("houseinfos");
            for (HouseInformationDTO model : lists.getRows()) {
                houseNodeCache.put(model.getHouseIdStr(), model);
            }
        }
    }

    public HouseInformationDTO getHouseInfoFromDb(String houseIdstr) {
        HouseRackServiceApi idemo = BaseFeignBuilder.getCacheFeign(HouseRackServiceApi.class, "myclient", new HouseRackServiceApiHystrix(), BaseFeignBuilder.EncodeDecodeType.EDT_JSON_JSON);
        HouseInformationDTO dto = new HouseInformationDTO();
        dto.setIsPaging(0);

        PageResult<HouseInformationDTO> lists = idemo.listHouseInfo(dto);
        if (lists != null && lists.getRows().size() > 0) {
            for (HouseInformationDTO model : lists.getRows()) {
                if (model.getHouseIdStr().equals(houseIdstr)) {
                    return model;
                }
            }
        }
        return null;
    }

    @Override
    public void setBeanName(String s) {
        EnvironmentUtils.ConfigBuilder cb = new EnvironmentUtils.ConfigBuilder();
        cb.append(EnvironmentUtils.WORK_PATH, ".");
        cb.append(EnvironmentUtils.LOG4J_PATH, "config/log4j.properties");
        cb.append(EnvironmentUtils.EVN_DIR, "osmp-task");
        EnvironmentUtils.init(cb.build());
        ServiceAddressSelector.init(EnvironmentUtils.loadPropertiesFromEnv("ribbon.properties"));
    }

}
