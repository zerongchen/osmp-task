package cu.aotain.osmp.task.service.ipsegmanage.impl;

import cu.aotain.osmp.task.service.ipsegmanage.IWebServiceQuery;
import cu.aotain.osmp.task.webservice.IpServSoapBindingStub;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;
import java.net.URL;

/**
 * Demo class
 *
 * @author bang
 * @date 2018/08/27
 */
@Service
public class WebServiceQueryImpl implements IWebServiceQuery {

    private static final Logger logger = LoggerFactory.getLogger(WebServiceQueryImpl.class);

    private static final String WSDL_ADDRESS = "http://132.33.16.200:8090/services/IpServ?wsdl";
    private static final String USER_NAME = "guangdongjiekou";
    private static final String PASS_WORD = "Gguangdongjiekou!@#";

    private static final String IPV4_METHOD_NAME = "ip_Query";
    private static final String IPV6_METHOD_NAME = "ipv6_Query";

    @Override
    public String ipv4Query(String xmlStream) {
        return callWebService(IPV4_METHOD_NAME,xmlStream);
    }

    @Override
    public String ipv6Query(String xmlStream) {
        return callWebService(IPV6_METHOD_NAME,xmlStream);
    }

    /**
     * 调用webservice方法
     * @param methodName
     * @return
     */
    private static String callWebService(String methodName,String xmlStream){
        System.out.println("=========start calling webservice ========");
        String wsdlUrl = WSDL_ADDRESS;
        try {
            org.apache.axis.client.Service service = new org.apache.axis.client.Service();

            // 生成的客户端代码中有XxxStub类，可如下方式使用
            IpServSoapBindingStub stub = new IpServSoapBindingStub(new URL(wsdlUrl), service);

            // 有些webservice需要登录，登陆后才能进行一些操作，这个需要设置如下两个参数：
            // 超时时间
            stub.setTimeout(1000 * 60 * 20);
            // 次数设置true，登录后才能保持登录状态，否则第二次调用ws方法时仍然会提示未登录。
            stub.setMaintainSession(true);
            Method method = stub.getClass().getMethod(methodName,String.class,String.class,String.class);
            String result = (String)method.invoke(stub,USER_NAME,PASS_WORD,xmlStream);
            System.out.println(result+"webservice test...");
            System.out.println("=========end calling webservice ========");
            return result;
        } catch (Exception e) {
            logger.error("call webservice has been failed",e);
            return "";
        }
    }

    public static void main(String[] args) {
        System.out.println(callWebService(IPV4_METHOD_NAME,""));
    }
}
