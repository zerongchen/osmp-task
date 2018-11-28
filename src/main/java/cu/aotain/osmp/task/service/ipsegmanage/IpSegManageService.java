package cu.aotain.osmp.task.service.ipsegmanage;

import com.aotain.cu.serviceapi.dto.HouseIPSegmentInforDTO;
import com.aotain.cu.serviceapi.dto.ResultDto;

import java.util.List;
import java.util.Map;

/**
 * ip地址管理系统接口
 *
 * @author bang
 * @date 2018/08/28
 */
public interface IpSegManageService {
    /**
     * 从ip地址管理系统获取所有的ip地址段信息
     * @return
     */
    List<HouseIPSegmentInforDTO> getDataFromISMS();

    /**
     * 从数据库获取ip地址段信息
     * @return
     */
    List<HouseIPSegmentInforDTO> getDataFromDb();

    /**
     * 对比两边数据进行新增修改删除操作
     * @return
     */
    Map<String,List<HouseIPSegmentInforDTO>> combineData();

    /**
     * 同步记录
     * @return
     */
    Map<String,ResultDto> synchDb();
}
