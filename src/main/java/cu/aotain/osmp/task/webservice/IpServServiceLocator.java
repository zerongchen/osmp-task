package cu.aotain.osmp.task.webservice;

/**
 * Demo class
 *
 * @author bang
 * @date 2018/08/27
 */
public class IpServServiceLocator extends org.apache.axis.client.Service implements IpServService {

    public IpServServiceLocator() {
    }


    public IpServServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public IpServServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for IpServ
    private java.lang.String IpServ_address = "http://132.33.16.200:8090/services/IpServ";

    @Override
    public java.lang.String getIpServAddress() {
        return IpServ_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String IpServWSDDServiceName = "IpServ";

    public java.lang.String getIpServWSDDServiceName() {
        return IpServWSDDServiceName;
    }

    public void setIpServWSDDServiceName(java.lang.String name) {
        IpServWSDDServiceName = name;
    }

    @Override
    public IpServ getIpServ() throws javax.xml.rpc.ServiceException {
        java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(IpServ_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getIpServ(endpoint);
    }

    @Override
    public IpServ getIpServ(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            IpServSoapBindingStub _stub = new IpServSoapBindingStub(portAddress, this);
            _stub.setPortName(getIpServWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setIpServEndpointAddress(java.lang.String address) {
        IpServ_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    @Override
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (IpServ.class.isAssignableFrom(serviceEndpointInterface)) {
                IpServSoapBindingStub _stub = new IpServSoapBindingStub(new java.net.URL(IpServ_address), this);
                _stub.setPortName(getIpServWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    @Override
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("IpServ".equals(inputPortName)) {
            return getIpServ();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    @Override
    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://172.41.73.18:8090/services/IpServ", "IpServService");
    }

    private java.util.HashSet ports = null;

    @Override
    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://172.41.73.18:8090/services/IpServ", "IpServ"));
        }
        return ports.iterator();
    }

    /**
     * Set the endpoint address for the specified port name.
     */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {

        if ("IpServ".equals(portName)) {
            setIpServEndpointAddress(address);
        }
        else
        { // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
     * Set the endpoint address for the specified port name.
     */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
