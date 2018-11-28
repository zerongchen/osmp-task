package cu.aotain.osmp.task.webservice;

/**
 * Demo class
 *
 * @author bang
 * @date 2018/08/27
 */
public interface IpServService extends javax.xml.rpc.Service {
    java.lang.String getIpServAddress();

    IpServ getIpServ() throws javax.xml.rpc.ServiceException;

    IpServ getIpServ(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}