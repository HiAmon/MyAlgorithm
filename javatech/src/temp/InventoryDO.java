package temp;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;


@Data
public class InventoryDO implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 主键ID*/
    private Long inventoryId;

    /** 货品编码*/
    private String itemCode;

    /** 货品条码*/
    private String barcode;

    /** 货主*/
    private String ownerCode;

    /** 仓库*/
    private String warehouseCode;

    /** 货位*/
    private String locationCode;

    /** 区域*/
    private String zoneCode;

    /** 在库数量*/
    private Integer stockQty;

    /** 占用数量*/
    private Integer lockedQty;

    /** 冻结数量*/
    private Integer frozenQty;

    /** 移入数量*/
    private Integer intransitQty;

    /** 可用数量*/
    private Integer availableQty;

    /** 库存类型*/
    private String inventoryType;

    /** 残次品等级*/
    private String brokenGrade;

    /** 批次*/
    private String batch;

    /** 生产日期*/
    private String manufactureDate;

    /** 失效日期*/
    private String expirationDate;

    /** 创建时间*/
    private Date createTime;

    /** 修改时间*/
    private Date modifyTime;

    /** 最后库存变动时间*/
    private Date lastInventoryCountTime;

    /** 在途库存*/
    private Integer transQty;

    /** 待上架库存*/
    private Integer waitQty;

    /** 版本号*/
    private Integer version;

    /** 锁定数量*/
    private Integer knitQty;

    /** 生产批次管理编码*/
    private String productBatchManage;

}
