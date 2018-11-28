package cu.aotain.osmp.task.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 描述:
 *
 * @author chenym@aotain.com
 * @create 2018-09-05 15:03
 */
@Setter
@Getter
@ToString
public class IdcHouseCodeLibModel {
    /**
     * 主键ID
     */
    private Integer id;
    /**
     * 节点编码，GZ（广州）、SZ（深圳）、DG（东莞）、FS（佛山）、SPTGZ（省平台广州）、SPTSZ（省平台深圳）
     */
    private String houseNodeCode;
    /**
     * 数据中心编码，机房的编码值
     */
    private String dataCenterCode;
    /**
     * 数据中心名称，即机房的名称
     */
    private String dataCenterName;
    /**
     * 机房的专线标识，1-IDC、5-专线，即使专线又是IDC时，值为1,5
     */
    private String identity;
    /**
     * 物理机房的辖管单位编码信息
     */
    private String subordinateUnit;
    /**
     * 物理机房的隶属地市码信息
     */
    private Integer areaCode;


}
