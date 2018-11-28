package cu.aotain.osmp.task.service;

import cu.aotain.osmp.task.mapper.IdcHouseCodeLibMapper;
import cu.aotain.osmp.task.model.IdcHouseCodeLibModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * 描述:
 *
 * @author chenym@aotain.com
 * @create 2018-09-05 16:35
 */
@Service
public class HouseNodeCodeCache {
    @Autowired
    private IdcHouseCodeLibMapper idcHouseCodeLibMapper;
    @Autowired
    private CacheManager cacheManager;

    @PostConstruct
    public void initHouseCodeLibCache() {
        List<IdcHouseCodeLibModel> list = idcHouseCodeLibMapper.getIdcHouseCodeLibModelAll();
        if (list != null && list.size() > 0) {
            Cache houseNodeCache = cacheManager.getCache("houseNodeCache");
            for (IdcHouseCodeLibModel m : list) {
                String houseNodeCode = m.getHouseNodeCode();
                houseNodeCache.put(houseNodeCode, m);
            }
        }
    }

    @Cacheable(value = "houseNodeCache")
    public IdcHouseCodeLibModel getIdcHouseCodeLibModel(String houseNodeCode) {
        return getIdcHouseCodeLibModelFromDb(houseNodeCode);
    }

    private IdcHouseCodeLibModel getIdcHouseCodeLibModelFromDb(String houseNodeCode) {
        return idcHouseCodeLibMapper.getIdcHouseCodeLibModelByNodeCode(houseNodeCode);
    }

    @CacheEvict("houseNodeCache")
    public void removeIdcHouseCodeLibModel(String houseNodeCode) {
    }
}
