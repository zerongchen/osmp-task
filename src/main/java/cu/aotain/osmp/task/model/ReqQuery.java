//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2018.08.28 时间 09:23:21 AM CST
//


package cu.aotain.osmp.task.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>anonymous complex type的 Java 类。
 *
 * <p>以下模式片段指定包含在此类中的预期内容。
 *
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="StartIp" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="EndIp" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Status" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="RetFilter" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "startIp",
        "endIp",
        "status",
        "retFilter"
})
@XmlRootElement(name = "ReqQuery")
public class ReqQuery {

    @XmlElement(name = "StartIp", required = true)
    protected String startIp;
    @XmlElement(name = "EndIp", required = true)
    protected String endIp;
    @XmlElement(name = "Status", required = true)
    protected String status;
    @XmlElement(name = "RetFilter", required = true)
    protected String retFilter;

    /**
     * 获取startIp属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getStartIp() {
        return startIp;
    }

    /**
     * 设置startIp属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setStartIp(String value) {
        this.startIp = value;
    }

    /**
     * 获取endIp属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getEndIp() {
        return endIp;
    }

    /**
     * 设置endIp属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setEndIp(String value) {
        this.endIp = value;
    }

    /**
     * 获取status属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置status属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setStatus(String value) {
        this.status = value;
    }

    /**
     * 获取retFilter属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getRetFilter() {
        return retFilter;
    }

    /**
     * 设置retFilter属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setRetFilter(String value) {
        this.retFilter = value;
    }

}
