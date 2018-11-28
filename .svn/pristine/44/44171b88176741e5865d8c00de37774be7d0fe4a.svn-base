package cu.aotain.osmp.task.factory;

import com.aotain.common.config.ContextUtil;
import org.springframework.stereotype.Component;

/**
 * 描述:
 * Icos系统工厂方法
 *
 * @author chenym@aotain.com
 * @create 2018-08-24 16:41
 */
@Component
public class IcosSystemFactory extends AbstractOsmpFactory {

    @Override
    public IcosSystem getIcosSystemType(String fileName) {
        if (fileName == null) {
            return null;
        }
        if (fileName.toLowerCase().contains("RackList".toLowerCase())) {
            return (IcosSystem) ContextUtil.getContext().getBean("icosSystemRackListServiceImpl");
        } else if (fileName.toLowerCase().contains("IpList".toLowerCase())) {
            return (IcosSystem) ContextUtil.getContext().getBean("icosSystemIpListServiceImpl");
        } else if (fileName.toLowerCase().contains("PortList".toLowerCase())) {
            return (IcosSystem) ContextUtil.getContext().getBean("icosSystemPortListServiceImpl");
        } else if (fileName.toLowerCase().contains("CustomerList".toLowerCase())) {
            return (IcosSystem) ContextUtil.getContext().getBean("icosSystemCustomerListServiceImpl");
        }else if (fileName.toLowerCase().contains("verification".toLowerCase())) {
            return (IcosSystem) ContextUtil.getContext().getBean("icosSystemVerificationServiceImpl");
        }
        return null;
    }

}
