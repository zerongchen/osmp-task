package cu.aotain.osmp.task.service.ipsegmanage;

import com.aotain.cu.serviceapi.model.HouseIPSegmentInformation;
import cu.aotain.osmp.task.model.Inetnum;
import cu.aotain.osmp.task.model.ReqQuery;
import cu.aotain.osmp.task.model.RespQuery;

import java.util.List;

/**
 * ip地址段同步服务类
 *
 * @author bang
 * @date 2018/08/28
 */
public interface IpSegService {

    /**
     * 获取所有的查询结果
     * @return
     */
    List<Inetnum> getWebServiceCallBackData();

    /**
     * 根据单个查询条件确定结果
     * @param reqQuery
     * @return
     */
    List<RespQuery> getResultData(ReqQuery reqQuery);

    /**
     * 根据所有查询条件确定结果
     * @param reqQuery
     * @return
     */
    List<Inetnum> getResultData(List<ReqQuery> reqQuery);

    /**
     * ipv4查询的结果集
     * @return
     */
    List<HouseIPSegmentInformation> ipQueryResult();
}
