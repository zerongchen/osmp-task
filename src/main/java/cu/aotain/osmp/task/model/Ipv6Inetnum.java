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
 *         &lt;element name="UseInfo" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Inetnum" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
 *                   &lt;element name="NodeCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="IpTypeCode" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
 *                   &lt;element name="AllotDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *                   &lt;element name="LastChangedTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *                   &lt;element name="RealUseDate" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
 *                   &lt;element name="Operator" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="20"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="Remarks" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="DeviceName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="DeviceLoopback" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="PortName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="PortDescr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="UseDescr" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
 *                   &lt;element name="UserSubject" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="UserAddress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="ContactInfo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
 *                   &lt;element name="Inetnum" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
 *                   &lt;element name="NodeCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="IpTypeCode" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
 *                   &lt;element name="NextNodeCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="IpTypeCodeNew" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
 *                   &lt;element name="AllotDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *                   &lt;element name="Operator" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="20"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="Remarks" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="LastChangedTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="UseAllotFlag" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
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
 *                   &lt;element name="Wgdz">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="512"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
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
 *                   &lt;element name="Xxdz">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="512"/>
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
 *                   &lt;element name="Dwfl" minOccurs="0">
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
 *                   &lt;element name="Dwxzjb" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer">
 *                         &lt;maxInclusive value="2147483647"/>
 *                         &lt;minInclusive value="0"/>
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
 *                   &lt;element name="Lydwlx" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}long">
 *                         &lt;minInclusive value="0"/>
 *                         &lt;maxInclusive value="1"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
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
 *                   &lt;element name="InetnumID" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
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
        "useInfo",
        "allocatedInfo",
        "useAllotFlag",
        "backInfo",
        "otherInfo"
})
@XmlRootElement(name = "Ipv6Inetnum")
public class Ipv6Inetnum {

    @XmlElement(name = "UseInfo")
    protected Ipv6Inetnum.UseInfo useInfo;
    @XmlElement(name = "AllocatedInfo")
    protected Ipv6Inetnum.AllocatedInfo allocatedInfo;
    @XmlElement(name = "UseAllotFlag", required = true)
    protected Object useAllotFlag;
    @XmlElement(name = "BackInfo")
    protected Ipv6Inetnum.BackInfo backInfo;
    @XmlElement(name = "OtherInfo")
    protected Ipv6Inetnum.OtherInfo otherInfo;

    /**
     * 获取useInfo属性的值。
     *
     * @return
     *     possible object is
     *     {@link Ipv6Inetnum.UseInfo }
     *
     */
    public Ipv6Inetnum.UseInfo getUseInfo() {
        return useInfo;
    }

    /**
     * 设置useInfo属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link Ipv6Inetnum.UseInfo }
     *
     */
    public void setUseInfo(Ipv6Inetnum.UseInfo value) {
        this.useInfo = value;
    }

    /**
     * 获取allocatedInfo属性的值。
     *
     * @return
     *     possible object is
     *     {@link Ipv6Inetnum.AllocatedInfo }
     *
     */
    public Ipv6Inetnum.AllocatedInfo getAllocatedInfo() {
        return allocatedInfo;
    }

    /**
     * 设置allocatedInfo属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link Ipv6Inetnum.AllocatedInfo }
     *
     */
    public void setAllocatedInfo(Ipv6Inetnum.AllocatedInfo value) {
        this.allocatedInfo = value;
    }

    /**
     * 获取useAllotFlag属性的值。
     *
     * @return
     *     possible object is
     *     {@link Object }
     *
     */
    public Object getUseAllotFlag() {
        return useAllotFlag;
    }

    /**
     * 设置useAllotFlag属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link Object }
     *
     */
    public void setUseAllotFlag(Object value) {
        this.useAllotFlag = value;
    }

    /**
     * 获取backInfo属性的值。
     *
     * @return
     *     possible object is
     *     {@link Ipv6Inetnum.BackInfo }
     *
     */
    public Ipv6Inetnum.BackInfo getBackInfo() {
        return backInfo;
    }

    /**
     * 设置backInfo属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link Ipv6Inetnum.BackInfo }
     *
     */
    public void setBackInfo(Ipv6Inetnum.BackInfo value) {
        this.backInfo = value;
    }

    /**
     * 获取otherInfo属性的值。
     *
     * @return
     *     possible object is
     *     {@link Ipv6Inetnum.OtherInfo }
     *
     */
    public Ipv6Inetnum.OtherInfo getOtherInfo() {
        return otherInfo;
    }

    /**
     * 设置otherInfo属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link Ipv6Inetnum.OtherInfo }
     *
     */
    public void setOtherInfo(Ipv6Inetnum.OtherInfo value) {
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
     *         &lt;element name="Inetnum" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
     *         &lt;element name="NodeCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="IpTypeCode" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
     *         &lt;element name="NextNodeCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="IpTypeCodeNew" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
     *         &lt;element name="AllotDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
     *         &lt;element name="Operator" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="20"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="Remarks" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="LastChangedTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
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
            "inetnum",
            "nodeCode",
            "ipTypeCode",
            "nextNodeCode",
            "ipTypeCodeNew",
            "allotDate",
            "operator",
            "remarks",
            "lastChangedTime"
    })
    public static class AllocatedInfo {

        @XmlElement(name = "Inetnum", required = true)
        protected Inetnum inetnum;
        @XmlElement(name = "NodeCode", required = true)
        protected String nodeCode;
        @XmlElement(name = "IpTypeCode", required = true)
        protected Object ipTypeCode;
        @XmlElement(name = "NextNodeCode", required = true)
        protected String nextNodeCode;
        @XmlElement(name = "IpTypeCodeNew", required = true)
        protected Object ipTypeCodeNew;
        @XmlElement(name = "AllotDate")
        @XmlSchemaType(name = "dateTime")
        protected XMLGregorianCalendar allotDate;
        @XmlElement(name = "Operator")
        protected String operator;
        @XmlElement(name = "Remarks")
        protected String remarks;
        @XmlElement(name = "LastChangedTime")
        @XmlSchemaType(name = "dateTime")
        protected XMLGregorianCalendar lastChangedTime;

        /**
         * 获取inetnum属性的值。
         *
         * @return
         *     possible object is
         *     {@link Object }
         *
         */
        public Inetnum getInetnum() {
            return inetnum;
        }

        /**
         * 设置inetnum属性的值。
         *
         * @param value
         *     allowed object is
         *     {@link Object }
         *
         */
        public void setInetnum(Inetnum value) {
            this.inetnum = value;
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
         * 获取ipTypeCode属性的值。
         *
         * @return
         *     possible object is
         *     {@link Object }
         *
         */
        public Object getIpTypeCode() {
            return ipTypeCode;
        }

        /**
         * 设置ipTypeCode属性的值。
         *
         * @param value
         *     allowed object is
         *     {@link Object }
         *
         */
        public void setIpTypeCode(Object value) {
            this.ipTypeCode = value;
        }

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

        /**
         * 获取ipTypeCodeNew属性的值。
         *
         * @return
         *     possible object is
         *     {@link Object }
         *
         */
        public Object getIpTypeCodeNew() {
            return ipTypeCodeNew;
        }

        /**
         * 设置ipTypeCodeNew属性的值。
         *
         * @param value
         *     allowed object is
         *     {@link Object }
         *
         */
        public void setIpTypeCodeNew(Object value) {
            this.ipTypeCodeNew = value;
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
         * 获取operator属性的值。
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getOperator() {
            return operator;
        }

        /**
         * 设置operator属性的值。
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setOperator(String value) {
            this.operator = value;
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
     *         &lt;element name="Wgdz">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="512"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
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
     *         &lt;element name="Xxdz">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="512"/>
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
     *         &lt;element name="Dwfl" minOccurs="0">
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
     *         &lt;element name="Dwxzjb" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer">
     *               &lt;maxInclusive value="2147483647"/>
     *               &lt;minInclusive value="0"/>
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
     *         &lt;element name="Lydwlx" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}long">
     *               &lt;minInclusive value="0"/>
     *               &lt;maxInclusive value="1"/>
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
            "lxrxm",
            "lxrdh",
            "lxrdzyj",
            "shengid",
            "shiid",
            "xianid",
            "wgip",
            "wgdz",
            "wgShengId",
            "wgShiId",
            "wgXianId",
            "xxdz",
            "dwxz",
            "sydwzjlx",
            "sydwzjhm",
            "yyfwlx",
            "syqy",
            "dwfl",
            "jyxkzh",
            "dwxzjb",
            "ifReAllocation",
            "fpdx",
            "lydwlx"
    })
    public static class BackInfo {

        @XmlElement(name = "ArchFlag", required = true)
        protected String archFlag;
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
        @XmlElement(name = "Wgdz", required = true)
        protected String wgdz;
        @XmlElement(name = "WgShengId", required = true)
        protected BigInteger wgShengId;
        @XmlElement(name = "WgShiId", required = true)
        protected BigInteger wgShiId;
        @XmlElement(name = "WgXianId", required = true)
        protected BigInteger wgXianId;
        @XmlElement(name = "Xxdz", required = true)
        protected String xxdz;
        @XmlElement(name = "Dwxz")
        protected int dwxz;
        @XmlElement(name = "Sydwzjlx")
        protected int sydwzjlx;
        @XmlElement(name = "Sydwzjhm", required = true)
        protected String sydwzjhm;
        @XmlElement(name = "Yyfwlx")
        protected int yyfwlx;
        @XmlElement(name = "Syqy")
        protected int syqy;
        @XmlElement(name = "Dwfl")
        protected Integer dwfl;
        @XmlElement(name = "Jyxkzh")
        protected String jyxkzh;
        @XmlElement(name = "Dwxzjb")
        protected Integer dwxzjb;
        @XmlElement(name = "IfReAllocation")
        protected String ifReAllocation;
        @XmlElement(name = "Fpdx")
        protected Integer fpdx;
        @XmlElement(name = "Lydwlx")
        protected Integer lydwlx;

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
         * 获取lydwlx属性的值。
         *
         * @return
         *     possible object is
         *     {@link Integer }
         *
         */
        public Integer getLydwlx() {
            return lydwlx;
        }

        /**
         * 设置lydwlx属性的值。
         *
         * @param value
         *     allowed object is
         *     {@link Integer }
         *
         */
        public void setLydwlx(Integer value) {
            this.lydwlx = value;
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
     *         &lt;element name="InetnumID" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
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
            "ipBackSynFlag",
            "ipBackSynTime",
            "ipBackID",
            "ipBackSynInfo",
            "inetnumID"
    })
    public static class OtherInfo {

        @XmlElement(name = "IPBackSynFlag")
        protected String ipBackSynFlag;
        @XmlElement(name = "IPBackSynTime")
        @XmlSchemaType(name = "dateTime")
        protected XMLGregorianCalendar ipBackSynTime;
        @XmlElement(name = "IPBackID")
        protected BigInteger ipBackID;
        @XmlElement(name = "IPBackSynInfo")
        protected String ipBackSynInfo;
        @XmlElement(name = "InetnumID")
        protected Object inetnumID;

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
     *         &lt;element name="Inetnum" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
     *         &lt;element name="NodeCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="IpTypeCode" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
     *         &lt;element name="AllotDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
     *         &lt;element name="LastChangedTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
     *         &lt;element name="RealUseDate" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
     *         &lt;element name="Operator" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="20"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="Remarks" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="DeviceName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="DeviceLoopback" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="PortName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="PortDescr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="UseDescr" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
     *         &lt;element name="UserSubject" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="UserAddress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="ContactInfo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
            "inetnum",
            "nodeCode",
            "ipTypeCode",
            "allotDate",
            "lastChangedTime",
            "realUseDate",
            "operator",
            "remarks",
            "deviceName",
            "deviceLoopback",
            "portName",
            "portDescr",
            "useDescr",
            "userSubject",
            "userAddress",
            "contactInfo"
    })
    public static class UseInfo {

        @XmlElement(name = "Inetnum", required = true)
        protected Object inetnum;
        @XmlElement(name = "NodeCode", required = true)
        protected String nodeCode;
        @XmlElement(name = "IpTypeCode", required = true)
        protected Object ipTypeCode;
        @XmlElement(name = "AllotDate")
        @XmlSchemaType(name = "dateTime")
        protected XMLGregorianCalendar allotDate;
        @XmlElement(name = "LastChangedTime")
        @XmlSchemaType(name = "dateTime")
        protected XMLGregorianCalendar lastChangedTime;
        @XmlElement(name = "RealUseDate")
        protected Object realUseDate;
        @XmlElement(name = "Operator")
        protected String operator;
        @XmlElement(name = "Remarks")
        protected String remarks;
        @XmlElement(name = "DeviceName")
        protected String deviceName;
        @XmlElement(name = "DeviceLoopback")
        protected String deviceLoopback;
        @XmlElement(name = "PortName")
        protected String portName;
        @XmlElement(name = "PortDescr")
        protected String portDescr;
        @XmlElement(name = "UseDescr")
        protected Object useDescr;
        @XmlElement(name = "UserSubject")
        protected String userSubject;
        @XmlElement(name = "UserAddress")
        protected String userAddress;
        @XmlElement(name = "ContactInfo")
        protected String contactInfo;

        /**
         * 获取inetnum属性的值。
         *
         * @return
         *     possible object is
         *     {@link Object }
         *
         */
        public Object getInetnum() {
            return inetnum;
        }

        /**
         * 设置inetnum属性的值。
         *
         * @param value
         *     allowed object is
         *     {@link Object }
         *
         */
        public void setInetnum(Object value) {
            this.inetnum = value;
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
         * 获取ipTypeCode属性的值。
         *
         * @return
         *     possible object is
         *     {@link Object }
         *
         */
        public Object getIpTypeCode() {
            return ipTypeCode;
        }

        /**
         * 设置ipTypeCode属性的值。
         *
         * @param value
         *     allowed object is
         *     {@link Object }
         *
         */
        public void setIpTypeCode(Object value) {
            this.ipTypeCode = value;
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
         * 获取realUseDate属性的值。
         *
         * @return
         *     possible object is
         *     {@link Object }
         *
         */
        public Object getRealUseDate() {
            return realUseDate;
        }

        /**
         * 设置realUseDate属性的值。
         *
         * @param value
         *     allowed object is
         *     {@link Object }
         *
         */
        public void setRealUseDate(Object value) {
            this.realUseDate = value;
        }

        /**
         * 获取operator属性的值。
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getOperator() {
            return operator;
        }

        /**
         * 设置operator属性的值。
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setOperator(String value) {
            this.operator = value;
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
         * 获取portDescr属性的值。
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getPortDescr() {
            return portDescr;
        }

        /**
         * 设置portDescr属性的值。
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setPortDescr(String value) {
            this.portDescr = value;
        }

        /**
         * 获取useDescr属性的值。
         *
         * @return
         *     possible object is
         *     {@link Object }
         *
         */
        public Object getUseDescr() {
            return useDescr;
        }

        /**
         * 设置useDescr属性的值。
         *
         * @param value
         *     allowed object is
         *     {@link Object }
         *
         */
        public void setUseDescr(Object value) {
            this.useDescr = value;
        }

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

    }

}
