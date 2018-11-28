package cu.aotain.osmp.task;

import cu.aotain.osmp.task.webservice.MobileCodeWSSoap12Stub;
import org.junit.Test;

import java.lang.reflect.Method;
import java.net.URL;

/**
 * Demo class
 *
 * @author bang
 * @date 2018/08/27
 */
public class WebServiceTest extends BaseTest{
    @Test
    public void test(){
        String wsdlUrl = "http://ws.webxml.com.cn/WebServices/MobileCodeWS.asmx?WSDL";
        try {
            org.apache.axis.client.Service service = new org.apache.axis.client.Service();

            // 生成的客户端代码中有XxxStub类，可如下方式使用
            MobileCodeWSSoap12Stub stub = new MobileCodeWSSoap12Stub(new URL(wsdlUrl), service);

            // 有些webservice需要登录，登陆后才能进行一些操作，这个需要设置如下两个参数：
            // 超时时间
            stub.setTimeout(1000 * 60 * 20);
            // 次数设置true，登录后才能保持登录状态，否则第二次调用ws方法时仍然会提示未登录。
            stub.setMaintainSession(true);

            Method method = stub.getClass().getMethod("getMobileCodeInfo",String.class,String.class);
            String result = (String)method.invoke(stub,"13554631051","0000");
//            String[] aa = stub.getDatabaseInfo();
//            for (int i=0;i<result.length;i++){
//                System.out.println(result[i]+"==");
//            }
            System.out.println(result+"====");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
