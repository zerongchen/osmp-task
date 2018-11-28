package cu.aotain.osmp.task.webservice;

/**
 * Demo class
 *
 * @author bang
 * @date 2018/08/27
 */
public interface IpServ extends java.rmi.Remote {
    void main(java.lang.String[] args) throws java.rmi.RemoteException;
    java.lang.String ip_Query(java.lang.String user_name, java.lang.String password, java.lang.String xmlStream) throws java.rmi.RemoteException;
    java.lang.String ip_Insert(java.lang.String user_name, java.lang.String password, java.lang.String xmlStream) throws java.rmi.RemoteException;
    java.lang.String ip_Update(java.lang.String user_name, java.lang.String password, java.lang.String xmlStream) throws java.rmi.RemoteException;
    java.lang.String ip_Delete(java.lang.String user_name, java.lang.String password, java.lang.String xmlStream) throws java.rmi.RemoteException;
    java.lang.String ipBackErrRetQuery(java.lang.String user_name, java.lang.String password, java.lang.String xmlStream) throws java.rmi.RemoteException;
    java.lang.String ipBackErrRetDel(java.lang.String user_name, java.lang.String password, java.lang.String xmlStream) throws java.rmi.RemoteException;
    java.lang.String ipv6_Insert(java.lang.String user_name, java.lang.String password, java.lang.String xmlStream) throws java.rmi.RemoteException;
    java.lang.String ipv6_Delete(java.lang.String user_name, java.lang.String password, java.lang.String xmlStream) throws java.rmi.RemoteException;
    java.lang.String ipv6_Update(java.lang.String user_name, java.lang.String password, java.lang.String xmlStream) throws java.rmi.RemoteException;
    java.lang.String ipv6_Query(java.lang.String user_name, java.lang.String password, java.lang.String xmlStream) throws java.rmi.RemoteException;
}