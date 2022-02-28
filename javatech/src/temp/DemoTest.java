package temp;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class DemoTest {
//    class Item {
//        Integer isExpiration;
//        Integer productBatchManage;
//
//        public Integer getIsExpiration() {
//            return isExpiration;
//        }
//
//        public void setIsExpiration(Integer isExpiration) {
//            this.isExpiration = isExpiration;
//        }
//
//        public Integer getProductBatchManage() {
//            return productBatchManage;
//        }
//
//        public void setProductBatchManage(Integer productBatchManage) {
//            this.productBatchManage = productBatchManage;
//        }
//    }

    public static void main(String[] args) {
//        Long generateId = IdGenerateUtil.generateId(IdGenerateUtil.GenerateType.INVENTORY_ID);
//        System.out.println(generateId);

//        for (int i = 0; i < 256; i++) {
//            System.out.printf("alter table t_delivery_order_%03d modify column `order_flag` varchar(50) NOT NULL DEFAULT '' COMMENT '出库单标识';\n",i);
//        }

        List<String> itemCodeTypes = new ArrayList<>();
        itemCodeTypes.add("11");
        itemCodeTypes.add("41");
        itemCodeTypes.add("21");
        HashSet<String> itemSet = new HashSet<>(itemCodeTypes);

        List<ReceiptItemVo> receiptItemVos = new ArrayList<>();
        ReceiptItemVo vo1 = new ReceiptItemVo();
        vo1.setItemCode("11");
        ReceiptItemVo vo2 = new ReceiptItemVo();
        vo2.setItemCode("21");
        receiptItemVos.add(vo1);
        receiptItemVos.add(vo2);
        Set<String> newItemSet = receiptItemVos.stream().map(ReceiptItemVo::getItemCode).collect(Collectors.toSet());
        itemSet.addAll(newItemSet);
        System.out.println(itemSet.size());


    }
}
