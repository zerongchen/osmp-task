package cu.aotain.osmp.task.mapper;

import com.aotain.common.config.annotation.MyBatisDao;
import cu.aotain.osmp.task.model.IdcHouseCodeLibModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 描述:
 *
 * @author chenym@aotain.com
 * @create 2018-09-05 15:00
 */
@MyBatisDao
public interface IdcHouseCodeLibMapper {

    /**
     * @return
     */
    List<IdcHouseCodeLibModel> getIdcHouseCodeLibModelAll();

    IdcHouseCodeLibModel getIdcHouseCodeLibModelByNodeCode(@Param("houseNodeCode") String houseNodeCode);
}
