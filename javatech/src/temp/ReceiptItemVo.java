package temp;

import java.io.Serializable;

public class ReceiptItemVo implements Serializable {

    /**
     [收货明细ID]
     */
    private Long receiptDetailId;

    /**
     [货品编码]
     */
    private String itemCode;

    /**
     [货品条码]
     */
    private String barcode;

    /**
     [本次收货量]
     */
    private Integer receiveQty;

    /**
     [残次等级]
     */
    private String brokenGrade;

    /**
     [库存类型]
     */
    private String inventoryType;

    /**
     [残次等级]
     */
    private String brokenGradeName;

    /**
     [库存类型]
     */
    private String inventoryTypeName;

    public String getBrokenGradeName() {
        return brokenGradeName;
    }

    public void setBrokenGradeName(String brokenGradeName) {
        this.brokenGradeName = brokenGradeName;
    }

    public String getInventoryTypeName() {
        return inventoryTypeName;
    }

    public void setInventoryTypeName(String inventoryTypeName) {
        this.inventoryTypeName = inventoryTypeName;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public Integer getReceiveQty() {
        return receiveQty;
    }

    public void setReceiveQty(Integer receiveQty) {
        this.receiveQty = receiveQty;
    }

    public String getBrokenGrade() {
        return brokenGrade;
    }

    public void setBrokenGrade(String brokenGrade) {
        this.brokenGrade = brokenGrade;
    }

    public String getInventoryType() {
        return inventoryType;
    }

    public void setInventoryType(String inventoryType) {
        this.inventoryType = inventoryType;
    }

    public Long getReceiptDetailId() {
        return receiptDetailId;
    }

    public void setReceiptDetailId(Long receiptDetailId) {
        this.receiptDetailId = receiptDetailId;
    }
}

