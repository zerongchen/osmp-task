package cu.aotain.osmp.task.service.ipsegmanage;

import com.aotain.cu.serviceapi.model.HouseIPSegmentInformation;
import cu.aotain.osmp.task.model.Ipv6Inetnum;
import cu.aotain.osmp.task.model.Ipv6ReqQuery;
import cu.aotain.osmp.task.model.Ipv6RespQuery;

import java.util.List;

/**
 * ipv6地址段同步服务类
 *
 * @author bang
 * @date 2018/08/28
 */
public interface Ipv6SegService {
    /**
     * 获取所有的查询结果
     * @return
     */
    List<Ipv6Inetnum> getWebServiceCallBackData();

    /**
     * 根据单个查询条件确定结果
     * @param ipv6ReqQuery
     * @return
     */
    List<Ipv6RespQuery> getResultData(Ipv6ReqQuery ipv6ReqQuery);

    /**
     * 根据所有查询条件确定结果
     * @param ipv6ReqQueryList
     * @return
     */
    List<Ipv6Inetnum> getResultData(List<Ipv6ReqQuery> ipv6ReqQueryList);

    /**
     * ipv6查询的结果集
     * @return
     */
    List<HouseIPSegmentInformation> ipv6QueryResult();
}
