package cu.aotain.osmp.task.mapper;

import com.aotain.common.config.annotation.MyBatisDao;
import cu.aotain.osmp.task.model.ReqQuery;

import java.util.List;

/**
 * Demo class
 *
 * @author bang
 * @date 2018/08/29
 */
@MyBatisDao
public interface IdcIsmsIpLibMapper {
    /**
     *
     * @return
     */
    List<ReqQuery> findIpv4QueryCondition();
}
