//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2018.08.28 时间 09:23:21 AM CST
//


package cu.aotain.osmp.task.model;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


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
 *         &lt;element name="BasicInfo">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="StartIp" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="EndIp" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="NodeCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="Status" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="IPVersion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="PrivateFlag" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;length value="1"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="AllocatedInfo" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="NextNodeCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="IPInfo" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="UserSubject" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="UserAddress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="UseFlag">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;length value="1"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="Syfs">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;length value="1"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="Fprq">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;minLength value="10"/>
 *                         &lt;maxLength value="10"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="UserTypeId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="NetTypeId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="NetDescr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="AccessType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="AccessSpeed" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer">
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="Remarks" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="ContactInfo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="DeviceLoopback" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="DeviceName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="PortName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="UseDescr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="CustIpSource" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="ASNum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="SLA" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="BackInfo" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="ArchFlag">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;length value="1"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="Dwmc" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="256"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="Xxdz" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="512"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="Dwhyfl" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer">
 *                         &lt;maxInclusive value="2147483647"/>
 *                         &lt;minInclusive value="0"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="Lxrxm" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="64"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="Lxrdh" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="64"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="Lxrdzyj" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="256"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="Shengid">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer">
 *                         &lt;maxInclusive value="2147483647"/>
 *                         &lt;minInclusive value="0"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="Shiid">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer">
 *                         &lt;minInclusive value="0"/>
 *                         &lt;maxInclusive value="2147483647"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="Xianid">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer">
 *                         &lt;maxInclusive value="2147483647"/>
 *                         &lt;minInclusive value="0"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="Wgip" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="WgShengId">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer">
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="WgShiId">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer">
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="WgXianId">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer">
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="Wgdz">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="512"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="Dwfl" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer">
 *                         &lt;maxInclusive value="2147483647"/>
 *                         &lt;minInclusive value="0"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="Dwxz">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer">
 *                         &lt;minInclusive value="0"/>
 *                         &lt;maxInclusive value="2147483647"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="Dwxzjb" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer">
 *                         &lt;maxInclusive value="2147483647"/>
 *                         &lt;minInclusive value="0"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="Jyxkzh" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="128"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="IfReAllocation" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;length value="1"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="Fpdx" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer">
 *                         &lt;maxInclusive value="2147483647"/>
 *                         &lt;minInclusive value="0"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="Ly_dwlx" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}long">
 *                         &lt;minInclusive value="0"/>
 *                         &lt;maxInclusive value="1"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="Sydwzjlx">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="Sydwzjhm">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="Yyfwlx">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="Syqy">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="ApnicInfo" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="APnetname" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="APdescr" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="APcountry" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="APadmin_c" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="APtech_c" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="APrev_srv" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="APstatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="APnotify" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="APmnt_by" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="APmnt_irt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="APmnt_lower" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="APmnt_routes" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="APchanged" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="APsource" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="OtherInfo" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="NetCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="IPPoolNodeCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="ApnicSentEmailFlag" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;length value="1"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="ApnicSentTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *                   &lt;element name="IPBackSynFlag" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;length value="1"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="IPBackSynTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *                   &lt;element name="IPBackID" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *                   &lt;element name="IPBackSynInfo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="AllotDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *                   &lt;element name="LastChangedTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *                   &lt;element name="IpSynSys" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="InetnumID" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
 *                   &lt;element name="Oper" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="20"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
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
        "basicInfo",
        "allocatedInfo",
        "ipInfo",
        "backInfo",
        "apnicInfo",
        "otherInfo"
})
@XmlRootElement(name = "Inetnum")
public class Inetnum {

    @XmlElement(name = "BasicInfo", required = true)
    protected Inetnum.BasicInfo basicInfo;
    @XmlElement(name = "AllocatedInfo")
    protected Inetnum.AllocatedInfo allocatedInfo;
    @XmlElement(name = "IPInfo")
    protected Inetnum.IPInfo ipInfo;
    @XmlElement(name = "BackInfo")
    protected Inetnum.BackInfo backInfo;
    @XmlElement(name = "ApnicInfo")
    protected Inetnum.ApnicInfo apnicInfo;
    @XmlElement(name = "OtherInfo")
    protected Inetnum.OtherInfo otherInfo;

    /**
     * 获取basicInfo属性的值。
     *
     * @return
     *     possible object is
     *     {@link Inetnum.BasicInfo }
     *
     */
    public Inetnum.BasicInfo getBasicInfo() {
        return basicInfo;
    }

    /**
     * 设置basicInfo属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link Inetnum.BasicInfo }
     *
     */
    public void setBasicInfo(Inetnum.BasicInfo value) {
        this.basicInfo = value;
    }

    /**
     * 获取allocatedInfo属性的值。
     *
     * @return
     *     possible object is
     *     {@link Inetnum.AllocatedInfo }
     *
     */
    public Inetnum.AllocatedInfo getAllocatedInfo() {
        return allocatedInfo;
    }

    /**
     * 设置allocatedInfo属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link Inetnum.AllocatedInfo }
     *
     */
    public void setAllocatedInfo(Inetnum.AllocatedInfo value) {
        this.allocatedInfo = value;
    }

    /**
     * 获取ipInfo属性的值。
     *
     * @return
     *     possible object is
     *     {@link Inetnum.IPInfo }
     *
     */
    public Inetnum.IPInfo getIPInfo() {
        return ipInfo;
    }

    /**
     * 设置ipInfo属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link Inetnum.IPInfo }
     *
     */
    public void setIPInfo(Inetnum.IPInfo value) {
        this.ipInfo = value;
    }

    /**
     * 获取backInfo属性的值。
     *
     * @return
     *     possible object is
     *     {@link Inetnum.BackInfo }
     *
     */
    public Inetnum.BackInfo getBackInfo() {
        return backInfo;
    }

    /**
     * 设置backInfo属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link Inetnum.BackInfo }
     *
     */
    public void setBackInfo(Inetnum.BackInfo value) {
        this.backInfo = value;
    }

    /**
     * 获取apnicInfo属性的值。
     *
     * @return
     *     possible object is
     *     {@link Inetnum.ApnicInfo }
     *
     */
    public Inetnum.ApnicInfo getApnicInfo() {
        return apnicInfo;
    }

    /**
     * 设置apnicInfo属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link Inetnum.ApnicInfo }
     *
     */
    public void setApnicInfo(Inetnum.ApnicInfo value) {
        this.apnicInfo = value;
    }

    /**
     * 获取otherInfo属性的值。
     *
     * @return
     *     possible object is
     *     {@link Inetnum.OtherInfo }
     *
     */
    public Inetnum.OtherInfo getOtherInfo() {
        return otherInfo;
    }

    /**
     * 设置otherInfo属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link Inetnum.OtherInfo }
     *
     */
    public void setOtherInfo(Inetnum.OtherInfo value) {
        this.otherInfo = value;
    }


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
     *         &lt;element name="NextNodeCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
            "nextNodeCode"
    })
    public static class AllocatedInfo {

        @XmlElement(name = "NextNodeCode", required = true)
        protected String nextNodeCode;

        /**
         * 获取nextNodeCode属性的值。
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getNextNodeCode() {
            return nextNodeCode;
        }

        /**
         * 设置nextNodeCode属性的值。
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setNextNodeCode(String value) {
            this.nextNodeCode = value;
        }

    }


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
     *         &lt;element name="APnetname" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="APdescr" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="APcountry" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="APadmin_c" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="APtech_c" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="APrev_srv" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="APstatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="APnotify" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="APmnt_by" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="APmnt_irt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="APmnt_lower" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="APmnt_routes" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="APchanged" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="APsource" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
            "aPnetname",
            "aPdescr",
            "aPcountry",
            "aPadminC",
            "aPtechC",
            "aPrevSrv",
            "aPstatus",
            "aPnotify",
            "aPmntBy",
            "aPmntIrt",
            "aPmntLower",
            "aPmntRoutes",
            "aPchanged",
            "aPsource"
    })
    public static class ApnicInfo {

        @XmlElement(name = "APnetname", required = true)
        protected String aPnetname;
        @XmlElement(name = "APdescr", required = true)
        protected String aPdescr;
        @XmlElement(name = "APcountry")
        protected String aPcountry;
        @XmlElement(name = "APadmin_c")
        protected String aPadminC;
        @XmlElement(name = "APtech_c")
        protected String aPtechC;
        @XmlElement(name = "APrev_srv")
        protected String aPrevSrv;
        @XmlElement(name = "APstatus")
        protected String aPstatus;
        @XmlElement(name = "APnotify")
        protected String aPnotify;
        @XmlElement(name = "APmnt_by")
        protected String aPmntBy;
        @XmlElement(name = "APmnt_irt")
        protected String aPmntIrt;
        @XmlElement(name = "APmnt_lower")
        protected String aPmntLower;
        @XmlElement(name = "APmnt_routes")
        protected String aPmntRoutes;
        @XmlElement(name = "APchanged")
        protected String aPchanged;
        @XmlElement(name = "APsource")
        protected String aPsource;

        /**
         * 获取aPnetname属性的值。
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getAPnetname() {
            return aPnetname;
        }

        /**
         * 设置aPnetname属性的值。
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setAPnetname(String value) {
            this.aPnetname = value;
        }

        /**
         * 获取aPdescr属性的值。
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getAPdescr() {
            return aPdescr;
        }

        /**
         * 设置aPdescr属性的值。
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setAPdescr(String value) {
            this.aPdescr = value;
        }

        /**
         * 获取aPcountry属性的值。
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getAPcountry() {
            return aPcountry;
        }

        /**
         * 设置aPcountry属性的值。
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setAPcountry(String value) {
            this.aPcountry = value;
        }

        /**
         * 获取aPadminC属性的值。
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getAPadminC() {
            return aPadminC;
        }

        /**
         * 设置aPadminC属性的值。
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setAPadminC(String value) {
            this.aPadminC = value;
        }

        /**
         * 获取aPtechC属性的值。
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getAPtechC() {
            return aPtechC;
        }

        /**
         * 设置aPtechC属性的值。
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setAPtechC(String value) {
            this.aPtechC = value;
        }

        /**
         * 获取aPrevSrv属性的值。
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getAPrevSrv() {
            return aPrevSrv;
        }

        /**
         * 设置aPrevSrv属性的值。
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setAPrevSrv(String value) {
            this.aPrevSrv = value;
        }

        /**
         * 获取aPstatus属性的值。
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getAPstatus() {
            return aPstatus;
        }

        /**
         * 设置aPstatus属性的值。
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setAPstatus(String value) {
            this.aPstatus = value;
        }

        /**
         * 获取aPnotify属性的值。
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getAPnotify() {
            return aPnotify;
        }

        /**
         * 设置aPnotify属性的值。
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setAPnotify(String value) {
            this.aPnotify = value;
        }

        /**
         * 获取aPmntBy属性的值。
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getAPmntBy() {
            return aPmntBy;
        }

        /**
         * 设置aPmntBy属性的值。
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setAPmntBy(String value) {
            this.aPmntBy = value;
        }

        /**
         * 获取aPmntIrt属性的值。
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getAPmntIrt() {
            return aPmntIrt;
        }

        /**
         * 设置aPmntIrt属性的值。
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setAPmntIrt(String value) {
            this.aPmntIrt = value;
        }

        /**
         * 获取aPmntLower属性的值。
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getAPmntLower() {
            return aPmntLower;
        }

        /**
         * 设置aPmntLower属性的值。
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setAPmntLower(String value) {
            this.aPmntLower = value;
        }

        /**
         * 获取aPmntRoutes属性的值。
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getAPmntRoutes() {
            return aPmntRoutes;
        }

        /**
         * 设置aPmntRoutes属性的值。
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setAPmntRoutes(String value) {
            this.aPmntRoutes = value;
        }

        /**
         * 获取aPchanged属性的值。
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getAPchanged() {
            return aPchanged;
        }

        /**
         * 设置aPchanged属性的值。
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setAPchanged(String value) {
            this.aPchanged = value;
        }

        /**
         * 获取aPsource属性的值。
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getAPsource() {
            return aPsource;
        }

        /**
         * 设置aPsource属性的值。
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setAPsource(String value) {
            this.aPsource = value;
        }

    }


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
     *         &lt;element name="ArchFlag">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;length value="1"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="Dwmc" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="256"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="Xxdz" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="512"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="Dwhyfl" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer">
     *               &lt;maxInclusive value="2147483647"/>
     *               &lt;minInclusive value="0"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="Lxrxm" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="64"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="Lxrdh" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="64"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="Lxrdzyj" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="256"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="Shengid">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer">
     *               &lt;maxInclusive value="2147483647"/>
     *               &lt;minInclusive value="0"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="Shiid">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer">
     *               &lt;minInclusive value="0"/>
     *               &lt;maxInclusive value="2147483647"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="Xianid">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer">
     *               &lt;maxInclusive value="2147483647"/>
     *               &lt;minInclusive value="0"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="Wgip" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="WgShengId">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer">
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="WgShiId">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer">
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="WgXianId">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer">
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="Wgdz">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="512"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="Dwfl" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer">
     *               &lt;maxInclusive value="2147483647"/>
     *               &lt;minInclusive value="0"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="Dwxz">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer">
     *               &lt;minInclusive value="0"/>
     *               &lt;maxInclusive value="2147483647"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="Dwxzjb" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer">
     *               &lt;maxInclusive value="2147483647"/>
     *               &lt;minInclusive value="0"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="Jyxkzh" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="128"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="IfReAllocation" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;length value="1"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="Fpdx" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer">
     *               &lt;maxInclusive value="2147483647"/>
     *               &lt;minInclusive value="0"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="Ly_dwlx" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}long">
     *               &lt;minInclusive value="0"/>
     *               &lt;maxInclusive value="1"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="Sydwzjlx">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="Sydwzjhm">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="Yyfwlx">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="Syqy">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
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
            "archFlag",
            "dwmc",
            "xxdz",
            "dwhyfl",
            "lxrxm",
            "lxrdh",
            "lxrdzyj",
            "shengid",
            "shiid",
            "xianid",
            "wgip",
            "wgShengId",
            "wgShiId",
            "wgXianId",
            "wgdz",
            "dwfl",
            "dwxz",
            "dwxzjb",
            "jyxkzh",
            "ifReAllocation",
            "fpdx",
            "lyDwlx",
            "sydwzjlx",
            "sydwzjhm",
            "yyfwlx",
            "syqy"
    })
    public static class BackInfo {

        @XmlElement(name = "ArchFlag", required = true)
        protected String archFlag;
        @XmlElement(name = "Dwmc")
        protected String dwmc;
        @XmlElement(name = "Xxdz")
        protected String xxdz;
        @XmlElement(name = "Dwhyfl")
        protected Integer dwhyfl;
        @XmlElement(name = "Lxrxm")
        protected String lxrxm;
        @XmlElement(name = "Lxrdh")
        protected String lxrdh;
        @XmlElement(name = "Lxrdzyj")
        protected String lxrdzyj;
        @XmlElement(name = "Shengid")
        protected int shengid;
        @XmlElement(name = "Shiid")
        protected int shiid;
        @XmlElement(name = "Xianid")
        protected int xianid;
        @XmlElement(name = "Wgip", required = true)
        protected String wgip;
        @XmlElement(name = "WgShengId", required = true)
        protected BigInteger wgShengId;
        @XmlElement(name = "WgShiId", required = true)
        protected BigInteger wgShiId;
        @XmlElement(name = "WgXianId", required = true)
        protected BigInteger wgXianId;
        @XmlElement(name = "Wgdz", required = true)
        protected String wgdz;
        @XmlElement(name = "Dwfl")
        protected Integer dwfl;
        @XmlElement(name = "Dwxz")
        protected int dwxz;
        @XmlElement(name = "Dwxzjb")
        protected Integer dwxzjb;
        @XmlElement(name = "Jyxkzh")
        protected String jyxkzh;
        @XmlElement(name = "IfReAllocation")
        protected String ifReAllocation;
        @XmlElement(name = "Fpdx")
        protected Integer fpdx;
        @XmlElement(name = "Ly_dwlx")
        protected Integer lyDwlx;
        @XmlElement(name = "Sydwzjlx")
        protected int sydwzjlx;
        @XmlElement(name = "Sydwzjhm", required = true)
        protected String sydwzjhm;
        @XmlElement(name = "Yyfwlx")
        protected int yyfwlx;
        @XmlElement(name = "Syqy")
        protected int syqy;

        /**
         * 获取archFlag属性的值。
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getArchFlag() {
            return archFlag;
        }

        /**
         * 设置archFlag属性的值。
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setArchFlag(String value) {
            this.archFlag = value;
        }

        /**
         * 获取dwmc属性的值。
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getDwmc() {
            return dwmc;
        }

        /**
         * 设置dwmc属性的值。
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setDwmc(String value) {
            this.dwmc = value;
        }

        /**
         * 获取xxdz属性的值。
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getXxdz() {
            return xxdz;
        }

        /**
         * 设置xxdz属性的值。
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setXxdz(String value) {
            this.xxdz = value;
        }

        /**
         * 获取dwhyfl属性的值。
         *
         * @return
         *     possible object is
         *     {@link Integer }
         *
         */
        public Integer getDwhyfl() {
            return dwhyfl;
        }

        /**
         * 设置dwhyfl属性的值。
         *
         * @param value
         *     allowed object is
         *     {@link Integer }
         *
         */
        public void setDwhyfl(Integer value) {
            this.dwhyfl = value;
        }

        /**
         * 获取lxrxm属性的值。
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getLxrxm() {
            return lxrxm;
        }

        /**
         * 设置lxrxm属性的值。
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setLxrxm(String value) {
            this.lxrxm = value;
        }

        /**
         * 获取lxrdh属性的值。
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getLxrdh() {
            return lxrdh;
        }

        /**
         * 设置lxrdh属性的值。
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setLxrdh(String value) {
            this.lxrdh = value;
        }

        /**
         * 获取lxrdzyj属性的值。
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getLxrdzyj() {
            return lxrdzyj;
        }

        /**
         * 设置lxrdzyj属性的值。
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setLxrdzyj(String value) {
            this.lxrdzyj = value;
        }

        /**
         * 获取shengid属性的值。
         *
         */
        public int getShengid() {
            return shengid;
        }

        /**
         * 设置shengid属性的值。
         *
         */
        public void setShengid(int value) {
            this.shengid = value;
        }

        /**
         * 获取shiid属性的值。
         *
         */
        public int getShiid() {
            return shiid;
        }

        /**
         * 设置shiid属性的值。
         *
         */
        public void setShiid(int value) {
            this.shiid = value;
        }

        /**
         * 获取xianid属性的值。
         *
         */
        public int getXianid() {
            return xianid;
        }

        /**
         * 设置xianid属性的值。
         *
         */
        public void setXianid(int value) {
            this.xianid = value;
        }

        /**
         * 获取wgip属性的值。
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getWgip() {
            return wgip;
        }

        /**
         * 设置wgip属性的值。
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setWgip(String value) {
            this.wgip = value;
        }

        /**
         * 获取wgShengId属性的值。
         *
         * @return
         *     possible object is
         *     {@link BigInteger }
         *
         */
        public BigInteger getWgShengId() {
            return wgShengId;
        }

        /**
         * 设置wgShengId属性的值。
         *
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *
         */
        public void setWgShengId(BigInteger value) {
            this.wgShengId = value;
        }

        /**
         * 获取wgShiId属性的值。
         *
         * @return
         *     possible object is
         *     {@link BigInteger }
         *
         */
        public BigInteger getWgShiId() {
            return wgShiId;
        }

        /**
         * 设置wgShiId属性的值。
         *
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *
         */
        public void setWgShiId(BigInteger value) {
            this.wgShiId = value;
        }

        /**
         * 获取wgXianId属性的值。
         *
         * @return
         *     possible object is
         *     {@link BigInteger }
         *
         */
        public BigInteger getWgXianId() {
            return wgXianId;
        }

        /**
         * 设置wgXianId属性的值。
         *
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *
         */
        public void setWgXianId(BigInteger value) {
            this.wgXianId = value;
        }

        /**
         * 获取wgdz属性的值。
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getWgdz() {
            return wgdz;
        }

        /**
         * 设置wgdz属性的值。
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setWgdz(String value) {
            this.wgdz = value;
        }

        /**
         * 获取dwfl属性的值。
         *
         * @return
         *     possible object is
         *     {@link Integer }
         *
         */
        public Integer getDwfl() {
            return dwfl;
        }

        /**
         * 设置dwfl属性的值。
         *
         * @param value
         *     allowed object is
         *     {@link Integer }
         *
         */
        public void setDwfl(Integer value) {
            this.dwfl = value;
        }

        /**
         * 获取dwxz属性的值。
         *
         */
        public int getDwxz() {
            return dwxz;
        }

        /**
         * 设置dwxz属性的值。
         *
         */
        public void setDwxz(int value) {
            this.dwxz = value;
        }

        /**
         * 获取dwxzjb属性的值。
         *
         * @return
         *     possible object is
         *     {@link Integer }
         *
         */
        public Integer getDwxzjb() {
            return dwxzjb;
        }

        /**
         * 设置dwxzjb属性的值。
         *
         * @param value
         *     allowed object is
         *     {@link Integer }
         *
         */
        public void setDwxzjb(Integer value) {
            this.dwxzjb = value;
        }

        /**
         * 获取jyxkzh属性的值。
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getJyxkzh() {
            return jyxkzh;
        }

        /**
         * 设置jyxkzh属性的值。
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setJyxkzh(String value) {
            this.jyxkzh = value;
        }

        /**
         * 获取ifReAllocation属性的值。
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getIfReAllocation() {
            return ifReAllocation;
        }

        /**
         * 设置ifReAllocation属性的值。
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setIfReAllocation(String value) {
            this.ifReAllocation = value;
        }

        /**
         * 获取fpdx属性的值。
         *
         * @return
         *     possible object is
         *     {@link Integer }
         *
         */
        public Integer getFpdx() {
            return fpdx;
        }

        /**
         * 设置fpdx属性的值。
         *
         * @param value
         *     allowed object is
         *     {@link Integer }
         *
         */
        public void setFpdx(Integer value) {
            this.fpdx = value;
        }

        /**
         * 获取lyDwlx属性的值。
         *
         * @return
         *     possible object is
         *     {@link Integer }
         *
         */
        public Integer getLyDwlx() {
            return lyDwlx;
        }

        /**
         * 设置lyDwlx属性的值。
         *
         * @param value
         *     allowed object is
         *     {@link Integer }
         *
         */
        public void setLyDwlx(Integer value) {
            this.lyDwlx = value;
        }

        /**
         * 获取sydwzjlx属性的值。
         *
         */
        public int getSydwzjlx() {
            return sydwzjlx;
        }

        /**
         * 设置sydwzjlx属性的值。
         *
         */
        public void setSydwzjlx(int value) {
            this.sydwzjlx = value;
        }

        /**
         * 获取sydwzjhm属性的值。
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getSydwzjhm() {
            return sydwzjhm;
        }

        /**
         * 设置sydwzjhm属性的值。
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setSydwzjhm(String value) {
            this.sydwzjhm = value;
        }

        /**
         * 获取yyfwlx属性的值。
         *
         */
        public int getYyfwlx() {
            return yyfwlx;
        }

        /**
         * 设置yyfwlx属性的值。
         *
         */
        public void setYyfwlx(int value) {
            this.yyfwlx = value;
        }

        /**
         * 获取syqy属性的值。
         *
         */
        public int getSyqy() {
            return syqy;
        }

        /**
         * 设置syqy属性的值。
         *
         */
        public void setSyqy(int value) {
            this.syqy = value;
        }

    }


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
     *         &lt;element name="NodeCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="Status" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="IPVersion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="PrivateFlag" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;length value="1"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
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
            "nodeCode",
            "status",
            "ipVersion",
            "privateFlag"
    })
    public static class BasicInfo {

        @XmlElement(name = "StartIp", required = true)
        protected String startIp;
        @XmlElement(name = "EndIp", required = true)
        protected String endIp;
        @XmlElement(name = "NodeCode", required = true)
        protected String nodeCode;
        @XmlElement(name = "Status", required = true)
        protected String status;
        @XmlElement(name = "IPVersion")
        protected String ipVersion;
        @XmlElement(name = "PrivateFlag")
        protected String privateFlag;

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
         * 获取nodeCode属性的值。
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getNodeCode() {
            return nodeCode;
        }

        /**
         * 设置nodeCode属性的值。
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setNodeCode(String value) {
            this.nodeCode = value;
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
         * 获取ipVersion属性的值。
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getIPVersion() {
            return ipVersion;
        }

        /**
         * 设置ipVersion属性的值。
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setIPVersion(String value) {
            this.ipVersion = value;
        }

        /**
         * 获取privateFlag属性的值。
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getPrivateFlag() {
            return privateFlag;
        }

        /**
         * 设置privateFlag属性的值。
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setPrivateFlag(String value) {
            this.privateFlag = value;
        }

    }


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
     *         &lt;element name="UserSubject" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="UserAddress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="UseFlag">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;length value="1"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="Syfs">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;length value="1"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="Fprq">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;minLength value="10"/>
     *               &lt;maxLength value="10"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="UserTypeId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="NetTypeId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="NetDescr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="AccessType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="AccessSpeed" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer">
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="Remarks" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="ContactInfo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="DeviceLoopback" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="DeviceName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="PortName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="UseDescr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="CustIpSource" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="ASNum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="SLA" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
            "userSubject",
            "userAddress",
            "useFlag",
            "syfs",
            "fprq",
            "userTypeId",
            "netTypeId",
            "netDescr",
            "accessType",
            "accessSpeed",
            "remarks",
            "contactInfo",
            "deviceLoopback",
            "deviceName",
            "portName",
            "useDescr",
            "custIpSource",
            "asNum",
            "sla"
    })
    public static class IPInfo {

        @XmlElement(name = "UserSubject")
        protected String userSubject;
        @XmlElement(name = "UserAddress")
        protected String userAddress;
        @XmlElement(name = "UseFlag", required = true)
        protected String useFlag;
        @XmlElement(name = "Syfs", required = true)
        protected String syfs;
        @XmlElement(name = "Fprq", required = true)
        protected String fprq;
        @XmlElement(name = "UserTypeId")
        protected String userTypeId;
        @XmlElement(name = "NetTypeId")
        protected String netTypeId;
        @XmlElement(name = "NetDescr")
        protected String netDescr;
        @XmlElement(name = "AccessType")
        protected String accessType;
        @XmlElement(name = "AccessSpeed")
        protected BigInteger accessSpeed;
        @XmlElement(name = "Remarks")
        protected String remarks;
        @XmlElement(name = "ContactInfo")
        protected String contactInfo;
        @XmlElement(name = "DeviceLoopback")
        protected String deviceLoopback;
        @XmlElement(name = "DeviceName")
        protected String deviceName;
        @XmlElement(name = "PortName")
        protected String portName;
        @XmlElement(name = "UseDescr")
        protected String useDescr;
        @XmlElement(name = "CustIpSource")
        protected String custIpSource;
        @XmlElement(name = "ASNum")
        protected String asNum;
        @XmlElement(name = "SLA")
        protected String sla;

        /**
         * 获取userSubject属性的值。
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getUserSubject() {
            return userSubject;
        }

        /**
         * 设置userSubject属性的值。
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setUserSubject(String value) {
            this.userSubject = value;
        }

        /**
         * 获取userAddress属性的值。
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getUserAddress() {
            return userAddress;
        }

        /**
         * 设置userAddress属性的值。
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setUserAddress(String value) {
            this.userAddress = value;
        }

        /**
         * 获取useFlag属性的值。
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getUseFlag() {
            return useFlag;
        }

        /**
         * 设置useFlag属性的值。
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setUseFlag(String value) {
            this.useFlag = value;
        }

        /**
         * 获取syfs属性的值。
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getSyfs() {
            return syfs;
        }

        /**
         * 设置syfs属性的值。
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setSyfs(String value) {
            this.syfs = value;
        }

        /**
         * 获取fprq属性的值。
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getFprq() {
            return fprq;
        }

        /**
         * 设置fprq属性的值。
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setFprq(String value) {
            this.fprq = value;
        }

        /**
         * 获取userTypeId属性的值。
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getUserTypeId() {
            return userTypeId;
        }

        /**
         * 设置userTypeId属性的值。
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setUserTypeId(String value) {
            this.userTypeId = value;
        }

        /**
         * 获取netTypeId属性的值。
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getNetTypeId() {
            return netTypeId;
        }

        /**
         * 设置netTypeId属性的值。
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setNetTypeId(String value) {
            this.netTypeId = value;
        }

        /**
         * 获取netDescr属性的值。
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getNetDescr() {
            return netDescr;
        }

        /**
         * 设置netDescr属性的值。
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setNetDescr(String value) {
            this.netDescr = value;
        }

        /**
         * 获取accessType属性的值。
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getAccessType() {
            return accessType;
        }

        /**
         * 设置accessType属性的值。
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setAccessType(String value) {
            this.accessType = value;
        }

        /**
         * 获取accessSpeed属性的值。
         *
         * @return
         *     possible object is
         *     {@link BigInteger }
         *
         */
        public BigInteger getAccessSpeed() {
            return accessSpeed;
        }

        /**
         * 设置accessSpeed属性的值。
         *
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *
         */
        public void setAccessSpeed(BigInteger value) {
            this.accessSpeed = value;
        }

        /**
         * 获取remarks属性的值。
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getRemarks() {
            return remarks;
        }

        /**
         * 设置remarks属性的值。
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setRemarks(String value) {
            this.remarks = value;
        }

        /**
         * 获取contactInfo属性的值。
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getContactInfo() {
            return contactInfo;
        }

        /**
         * 设置contactInfo属性的值。
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setContactInfo(String value) {
            this.contactInfo = value;
        }

        /**
         * 获取deviceLoopback属性的值。
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getDeviceLoopback() {
            return deviceLoopback;
        }

        /**
         * 设置deviceLoopback属性的值。
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setDeviceLoopback(String value) {
            this.deviceLoopback = value;
        }

        /**
         * 获取deviceName属性的值。
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getDeviceName() {
            return deviceName;
        }

        /**
         * 设置deviceName属性的值。
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setDeviceName(String value) {
            this.deviceName = value;
        }

        /**
         * 获取portName属性的值。
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getPortName() {
            return portName;
        }

        /**
         * 设置portName属性的值。
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setPortName(String value) {
            this.portName = value;
        }

        /**
         * 获取useDescr属性的值。
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getUseDescr() {
            return useDescr;
        }

        /**
         * 设置useDescr属性的值。
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setUseDescr(String value) {
            this.useDescr = value;
        }

        /**
         * 获取custIpSource属性的值。
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getCustIpSource() {
            return custIpSource;
        }

        /**
         * 设置custIpSource属性的值。
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setCustIpSource(String value) {
            this.custIpSource = value;
        }

        /**
         * 获取asNum属性的值。
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getASNum() {
            return asNum;
        }

        /**
         * 设置asNum属性的值。
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setASNum(String value) {
            this.asNum = value;
        }

        /**
         * 获取sla属性的值。
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getSLA() {
            return sla;
        }

        /**
         * 设置sla属性的值。
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setSLA(String value) {
            this.sla = value;
        }

    }


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
     *         &lt;element name="NetCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="IPPoolNodeCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="ApnicSentEmailFlag" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;length value="1"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="ApnicSentTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
     *         &lt;element name="IPBackSynFlag" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;length value="1"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="IPBackSynTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
     *         &lt;element name="IPBackID" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
     *         &lt;element name="IPBackSynInfo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="AllotDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
     *         &lt;element name="LastChangedTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
     *         &lt;element name="IpSynSys" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="InetnumID" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
     *         &lt;element name="Oper" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="20"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
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
            "netCode",
            "ipPoolNodeCode",
            "apnicSentEmailFlag",
            "apnicSentTime",
            "ipBackSynFlag",
            "ipBackSynTime",
            "ipBackID",
            "ipBackSynInfo",
            "allotDate",
            "lastChangedTime",
            "ipSynSys",
            "inetnumID",
            "oper"
    })
    public static class OtherInfo {

        @XmlElement(name = "NetCode")
        protected String netCode;
        @XmlElement(name = "IPPoolNodeCode")
        protected String ipPoolNodeCode;
        @XmlElement(name = "ApnicSentEmailFlag")
        protected String apnicSentEmailFlag;
        @XmlElement(name = "ApnicSentTime")
        @XmlSchemaType(name = "dateTime")
        protected XMLGregorianCalendar apnicSentTime;
        @XmlElement(name = "IPBackSynFlag")
        protected String ipBackSynFlag;
        @XmlElement(name = "IPBackSynTime")
        @XmlSchemaType(name = "dateTime")
        protected XMLGregorianCalendar ipBackSynTime;
        @XmlElement(name = "IPBackID")
        protected BigInteger ipBackID;
        @XmlElement(name = "IPBackSynInfo")
        protected String ipBackSynInfo;
        @XmlElement(name = "AllotDate")
        @XmlSchemaType(name = "dateTime")
        protected XMLGregorianCalendar allotDate;
        @XmlElement(name = "LastChangedTime")
        @XmlSchemaType(name = "dateTime")
        protected XMLGregorianCalendar lastChangedTime;
        @XmlElement(name = "IpSynSys")
        protected String ipSynSys;
        @XmlElement(name = "InetnumID")
        protected Object inetnumID;
        @XmlElement(name = "Oper")
        protected String oper;

        /**
         * 获取netCode属性的值。
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getNetCode() {
            return netCode;
        }

        /**
         * 设置netCode属性的值。
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setNetCode(String value) {
            this.netCode = value;
        }

        /**
         * 获取ipPoolNodeCode属性的值。
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getIPPoolNodeCode() {
            return ipPoolNodeCode;
        }

        /**
         * 设置ipPoolNodeCode属性的值。
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setIPPoolNodeCode(String value) {
            this.ipPoolNodeCode = value;
        }

        /**
         * 获取apnicSentEmailFlag属性的值。
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getApnicSentEmailFlag() {
            return apnicSentEmailFlag;
        }

        /**
         * 设置apnicSentEmailFlag属性的值。
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setApnicSentEmailFlag(String value) {
            this.apnicSentEmailFlag = value;
        }

        /**
         * 获取apnicSentTime属性的值。
         *
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *
         */
        public XMLGregorianCalendar getApnicSentTime() {
            return apnicSentTime;
        }

        /**
         * 设置apnicSentTime属性的值。
         *
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *
         */
        public void setApnicSentTime(XMLGregorianCalendar value) {
            this.apnicSentTime = value;
        }

        /**
         * 获取ipBackSynFlag属性的值。
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getIPBackSynFlag() {
            return ipBackSynFlag;
        }

        /**
         * 设置ipBackSynFlag属性的值。
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setIPBackSynFlag(String value) {
            this.ipBackSynFlag = value;
        }

        /**
         * 获取ipBackSynTime属性的值。
         *
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *
         */
        public XMLGregorianCalendar getIPBackSynTime() {
            return ipBackSynTime;
        }

        /**
         * 设置ipBackSynTime属性的值。
         *
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *
         */
        public void setIPBackSynTime(XMLGregorianCalendar value) {
            this.ipBackSynTime = value;
        }

        /**
         * 获取ipBackID属性的值。
         *
         * @return
         *     possible object is
         *     {@link BigInteger }
         *
         */
        public BigInteger getIPBackID() {
            return ipBackID;
        }

        /**
         * 设置ipBackID属性的值。
         *
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *
         */
        public void setIPBackID(BigInteger value) {
            this.ipBackID = value;
        }

        /**
         * 获取ipBackSynInfo属性的值。
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getIPBackSynInfo() {
            return ipBackSynInfo;
        }

        /**
         * 设置ipBackSynInfo属性的值。
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setIPBackSynInfo(String value) {
            this.ipBackSynInfo = value;
        }

        /**
         * 获取allotDate属性的值。
         *
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *
         */
        public XMLGregorianCalendar getAllotDate() {
            return allotDate;
        }

        /**
         * 设置allotDate属性的值。
         *
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *
         */
        public void setAllotDate(XMLGregorianCalendar value) {
            this.allotDate = value;
        }

        /**
         * 获取lastChangedTime属性的值。
         *
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *
         */
        public XMLGregorianCalendar getLastChangedTime() {
            return lastChangedTime;
        }

        /**
         * 设置lastChangedTime属性的值。
         *
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *
         */
        public void setLastChangedTime(XMLGregorianCalendar value) {
            this.lastChangedTime = value;
        }

        /**
         * 获取ipSynSys属性的值。
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getIpSynSys() {
            return ipSynSys;
        }

        /**
         * 设置ipSynSys属性的值。
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setIpSynSys(String value) {
            this.ipSynSys = value;
        }

        /**
         * 获取inetnumID属性的值。
         *
         * @return
         *     possible object is
         *     {@link Object }
         *
         */
        public Object getInetnumID() {
            return inetnumID;
        }

        /**
         * 设置inetnumID属性的值。
         *
         * @param value
         *     allowed object is
         *     {@link Object }
         *
         */
        public void setInetnumID(Object value) {
            this.inetnumID = value;
        }

        /**
         * 获取oper属性的值。
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getOper() {
            return oper;
        }

        /**
         * 设置oper属性的值。
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setOper(String value) {
            this.oper = value;
        }

    }

}
