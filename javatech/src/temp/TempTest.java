package temp;

import com.google.common.base.Joiner;

import java.lang.reflect.Field;
import java.util.*;

public class TempTest {
    public static void main(String[] args) {
//        for (int i = 0; i < 256; i++) {
//            System.out.printf("alter table t_delivery_order_%03d add express_code varchar(50) not null default ' comment '运单号';\n",'i);
//            System.out.printf("alter table t_delivery_order_%03d add order_flag varchar(200) not null default ' comment '订单标记';\n",'i);
//            System.out.printf("alter table t_delivery_order_%03d add schedule_day varchar(10) not null default ' comment '应到货时间';\n",'i);
//            System.out.printf("alter table t_delivery_order_%03d add schedule_end_time varchar(8) not null default ' comment '投递时间范围（结束时间）';\n",'i);
//        }

//        for (int i = 0; i < 256; i++) {
//            System.out.printf("alter table t_delivery_order_%03d modify column `receive_person` varchar(500) NOT NULL DEFAULT ' COMMENT '收货人',\n" +
//                    "modify column `mobile_phone` varchar(500) NOT NULL DEFAULT ' COMMENT '手机号',\n" +
//                    "modify column `phone` varchar(500) NOT NULL DEFAULT ' COMMENT '电话';\n",i);
//        }

//

//        for (int i = 0; i < ao.length; i++) {
//            System.out.println("SELECT * from t_inventory_040 iv LEFT JOIN t_item it on iv.item_code = it.item_code where it.owner_item_code = " + arr[i] + " and iv.location_code = " + trr[i] + " and stock_qty > 0;");
//            System.out.println("update t_inventory_040 set stock_qty = 0, locked_qty = 0  where inventory_id = " + ao[i]);
//        }


//        for (int i = 0; i < 256; i++) {
//            System.out.printf("alter table t_receipt_%03d add column up_on_same_location tinyint(4) not null default '00' comment '同库位上架标识，0-否，1-b2b快速上架，2-原快速上架'," +
//                    "add column related_order_code varchar(50) NOT NULL DEFAULT ' COMMENT '[关联单号]',' add INDEX idx_wr (`warehouse_code`','`related_order_code`);\n",'i);
//        }
//        System.out.printf("alter table t_receipt_flow add column up_inventory_same_location tinyint(4) not null default 0 comment '同库位上架，0-否，1-是';\n");

//        List<String> itemCodeTypes = new ArrayList<>();
//        itemCodeTypes.add("A");
//        itemCodeTypes.add("B");
//        itemCodeTypes.add("C");
//        HashSet<String> itemSet = new HashSet<>(itemCodeTypes);
//        List<ReceiptItemVo> receiptItemVos = new ArrayList<>();
//        ReceiptItemVo o1 = new ReceiptItemVo();
//        ReceiptItemVo o2 = new ReceiptItemVo();
//        ReceiptItemVo o3 = new ReceiptItemVo();
//        ReceiptItemVo o4 = new ReceiptItemVo();
//        ReceiptItemVo o5 = new ReceiptItemVo();
//        o1.setItemCode("D");
//        o2.setItemCode("E");
//        o3.setItemCode("B");
//        o4.setItemCode("B");
//        o5.setItemCode("D");
//        receiptItemVos.add(o1);
//        receiptItemVos.add(o2);
//        receiptItemVos.add(o3);
//        Set<String> newItemSet = receiptItemVos.stream().map(ReceiptItemVo::getItemCode).collect(Collectors.toSet());
//        System.out.println(itemSet.size());
//        System.out.println(newItemSet.size());
//        itemSet.addAll(newItemSet);
//        System.out.println(itemSet.size());

        HashMap<String,Integer> map = new HashMap<>();

        map.put("4064041024469",1);


        String[] list = new String[]{


        };
        String name = "inventoryId,itemCode,barcode,ownerCode,warehouseCode,locationCode,zoneCode,stockQty,lockedQty,frozenQty,intransitQty,availableQty,inventoryType,brokenGrade,batch,manufactureDate,expirationDate,createTime,modifyTime,lastInventoryCountTime,transQty,waitQty,version,knitQty";
        String sqlFields = "inventory_id,item_code,barcode,owner_code,warehouse_code,location_code,zone_code,stock_qty,locked_qty,frozen_qty,intransit_qty,available_qty,inventory_type,broken_grade,batch,manufacture_date,expiration_date,create_time,modify_time,last_inventory_count_time,trans_qty,wait_qty,version,knit_qty,product_batch_manage";
        
        String[] names = name.split(",");
        List<String> datalist = new ArrayList<>();
        List<String> iIds = generateInventoryIds();
        for (int i = 0; i < list.length; i++) {
            //处理一行数据，转换为实体
//            StringBuilder objStr = new StringBuilder();
            String[] members = list[i].split("','");
            //处理一行数据，转换为实体
            generateSql(members,names,iIds.get(i),map);
            datalist.add("(" + Joiner.on(",").join(members) +")");
//            for (int j = 0; j < members.length; j++) {
//                String mid = "";
//                if (isStr(names[j])){
//                    mid = "\"";
//                }
//                String append = "\"" + names[j] + "\":" + mid + members[j] + mid +",";
//                objStr.append(append);
//            }
//            String obj = objStr.substring(0, objStr.lastIndexOf(","));
//            obj = "{" + obj + "}";
//            Gson gson = new Gson();
//            InventoryDO inventoryDO = gson.fromJson(obj, InventoryDO.class);
//            inventoryDO.setProductBatchManage("");
//            System.out.println(gson.toJson(inventoryDO));
        }
        String sql = "insert into t_inventory_009(" + sqlFields +") values " + Joiner.on(",").join(datalist);
        System.out.println(sql);
    }

    public static boolean isStr(String fieldName){
        try {
            Class clazz = InventoryDO.class;
            Field declaredField = clazz.getDeclaredField(fieldName);
            declaredField.setAccessible(true);
            String fieldType = declaredField.getType().getTypeName();
            if ("java.lang.Integer".equals(fieldType) || "java.lang.Long".equals(fieldType)){
                return false;
            }else {
                return true;
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void generateSql(String[] data, String[] fieldName,String id, HashMap<String,Integer> map){
        data[0] = id;
        if (map.containsKey(data[2])){
            data[7] = map.get(data[2]) +"";
            data[11] = data[7];
        }
        for (int i = 1; i < data.length; i++) {
            StringBuilder stringBuilder = new StringBuilder("'");
            if (isStr(fieldName[i])){
                stringBuilder.append(data[i]).append("'");
                data[i] = stringBuilder.toString();
            }
        }
    }

    public static List<String> generateInventoryIds(){
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(IdGenerateUtil.generateId(IdGenerateUtil.GenerateType.INVENTORY_ID) +"");
        }
        return list;
    }

    public void test(){
        String[] ss = new String[]{"1,2","3,4"};
    }

}
