//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2018.08.28 时间 09:23:21 AM CST
//


package cu.aotain.osmp.task.model;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
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
 *         &lt;element name="RetResult">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="RetCode" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *                   &lt;element name="RetMsg" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element ref="{}Inetnum" maxOccurs="2000" minOccurs="0"/>
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
        "retResult",
        "inetnum"
})
@XmlRootElement(name = "RespQuery")
public class RespQuery {

    @XmlElement(name = "RetResult", required = true)
    protected RespQuery.RetResult retResult;
    @XmlElement(name = "Inetnum")
    protected List<Inetnum> inetnum;

    /**
     * 获取retResult属性的值。
     *
     * @return
     *     possible object is
     *     {@link RespQuery.RetResult }
     *
     */
    public RespQuery.RetResult getRetResult() {
        return retResult;
    }

    /**
     * 设置retResult属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link RespQuery.RetResult }
     *
     */
    public void setRetResult(RespQuery.RetResult value) {
        this.retResult = value;
    }

    /**
     * Gets the value of the inetnum property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the inetnum property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInetnum().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Inetnum }
     *
     *
     */
    public List<Inetnum> getInetnum() {
        if (inetnum == null) {
            inetnum = new ArrayList<Inetnum>();
        }
        return this.inetnum;
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
     *         &lt;element name="RetCode" type="{http://www.w3.org/2001/XMLSchema}integer"/>
     *         &lt;element name="RetMsg" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
            "retCode",
            "retMsg"
    })
    public static class RetResult {

        @XmlElement(name = "RetCode", required = true)
        protected BigInteger retCode;
        @XmlElement(name = "RetMsg")
        protected String retMsg;

        /**
         * 获取retCode属性的值。
         *
         * @return
         *     possible object is
         *     {@link BigInteger }
         *
         */
        public BigInteger getRetCode() {
            return retCode;
        }

        /**
         * 设置retCode属性的值。
         *
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *
         */
        public void setRetCode(BigInteger value) {
            this.retCode = value;
        }

        /**
         * 获取retMsg属性的值。
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getRetMsg() {
            return retMsg;
        }

        /**
         * 设置retMsg属性的值。
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setRetMsg(String value) {
            this.retMsg = value;
        }

    }

}
