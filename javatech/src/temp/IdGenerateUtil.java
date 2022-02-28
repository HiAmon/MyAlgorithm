package temp;
//
//import com.sharksharding.util.sequence.SequenceIDManger;
//import com.yunji.best.resource.MysqlResource;
//import com.yunji.oms.common.entity.DateUtils;
//import org.apache.commons.lang.time.DateFormatUtils;
//import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 单号生成工具
 */
public class IdGenerateUtil {
//
//    @Resource(name = "mysqlResource")
//    private MysqlResource basicDataSource;

    //默认机房Id
    private static final int IDC_NUM = 100;

    //-------------------业务类型校验
    static {
        List<Integer> typeList = new ArrayList<>();
        for (GenerateType item : GenerateType.values()) {
            if (typeList.contains(item.type)) {
                throw new ExceptionInInitializerError("出现重复的type" + item.type);
            }
            typeList.add(item.type);
        }
    }

    //---------------------业务枚举
    public enum GenerateType {

        OWNER_CODE("CS", 4, 11, 1L),

        WAREHOUSE_CODE("WH", 4, 12, 1L),

        ITEM("GS", 7, 13, 1000L),

        ITEM_BRAND("BD", 4, 14, 1L),

        ITEM_CATEGORY_1("CS", 5, 15, 1L),

        ITEM_CATEGORY_2("CS", 2, 16, 1L),

        ITEM_CATEGORY_3("CS", 2, 17, 1L),

        OUT_PROCESS("OT", 4, 18, 1000L),

        INVENTORY_SNAPSHOT_ID(null, Long.valueOf(Long.MAX_VALUE).toString().length(), 19, 1000L),

        ENTRY_ORDER_ID(null, Long.valueOf(Long.MAX_VALUE).toString().length(), 20, 1000L),

        ENTRY_ORDER_DETAIL_ID(null, Long.valueOf(Long.MAX_VALUE).toString().length(), 21, 1000L),

        RECEIPT_NO("SH", 5, 22, 1L),

        RECEIPT_ID("", Long.valueOf(Long.MAX_VALUE).toString().length(), 23, 1000L),

        RECEIPT_DETAIL_ID("", Long.valueOf(Long.MAX_VALUE).toString().length(), 24, 1000L),

        RECEIPT_DETAIL_REF_ORDER_CODE("CK", Long.valueOf(Long.MAX_VALUE).toString().length(), 25, 300L),



        ENTRY_ORDER_NO( "", 5  , 26 ,1L  ),

        LOG(null, 19, 27, 1L),

        INVENTORY_ID(null, Long.valueOf(Long.MAX_VALUE).toString().length(), 28, 1000L),

        CONTAINER_CODE(null, 8, 29, 1L),

        INVENTORY_CHANGE_LOG_ID(null, Long.valueOf(Long.MAX_VALUE).toString().length(), 30, 1000L),

        TASK_DETAIL_ID(null, null, 31, 1L),

        TASK_SOURCE_ID(null, null, 32, 1L),

        PACK_HEADER_ID(null, null, 33, 1L),

        PACK_DETAIL_ID(null, null, 34, 1L),

        DELIVERY_ORDER_ID(null, Long.valueOf(Long.MAX_VALUE).toString().length(), 35, 1L),

        DELIVERY_ORDER_DETAIL_ID(null, Long.valueOf(Long.MAX_VALUE).toString().length(), 36, 1L),

        DELIVERY_BOX_ID(null, Long.valueOf(Long.MAX_VALUE).toString().length(), 37, 1000L),

        DELIVERY_BOX_DETAIL_ID(null, Long.valueOf(Long.MAX_VALUE).toString().length(), 38, 1000L),

        DELIVERY_BOX("FH", 6, 39, 1000L),

        WAVE("BC", 6, 40, 1L),

        TASK("RW", 6, 41, 1L),

        TASK_HEADER_ID(null, null, 42, 1L),

        INVENTORY_DIFF_NO("PDCY", 5, 43, 1L),

        /**
         * 盘点回传流水号
         */
        INVENTORY_COUNT_CALLBACK_NO("PDHC", 5, 44, 200L),
        /**
         * 取消单回库 操作单号
         */
        INVENTORY_RETURN_CODE("HK", 5, 45, 1L),

        /**
         * 移库计划单号
         */
        MOVE_NO("MP", 5, 46, 1L),

        /**
         * 盘点计划单号
         */
        INVENTORY_PLAN_NO("PDJH",5,47,1L),

        /**
         * 领用出库单号
         */
        USE_ORDER_NO("LYCK",5,48,1L),
        /**
         * 领用出库单ID
         */
        USE_ORDER_ID(null, Long.valueOf(Long.MAX_VALUE).toString().length(), 49, 1000L),
        /**
         * 领用出库单明细ID
         */
        USE_ORDER_DETAIL_ID(null, Long.valueOf(Long.MAX_VALUE).toString().length(), 50, 1000L),
        /**
         * 领用出库单和库存关系表ID
         */
        USE_ORDER_INVENTORY_ID(null, Long.valueOf(Long.MAX_VALUE).toString().length(), 51, 1000L),

        /**
         * 盘点差异批次
         */
        INVENTORY_DIFF_BATCH("PDCY", 4, 52, 10L),

        /**
         * 下架单号
         */
        DOWN_SHELF_ORDER_NO("XJ",5,53,1L),
        /**
         * 客退批次号
         */
        TRANSFER_NUMBER("", 4, 54, 1000L),
        /**
         * 客退库存批次号流水
         */
        CUSTOMER_INVENTORY_BATCH("",4,55,1L),

        /**
         * 客退上架批次
         */
        CUSTOMER_BACK_PUTAWAY_BATCH("", 6, 56, 1000L),

        /**
         * 随机盘点单号
         */
        INVENTORY_OPERATE_NO("SJPD", 5, 57, 1L),

        /**
         * 随机盘点单号
         */
        BOXCODE_ID(null, Long.valueOf(Long.MAX_VALUE).toString().length(), 58, 1000L)
        ;

        /**
         * 前缀
         */
        private String prefix;

        /**
         * 长度
         */
        private Integer length;

        /**
         * 类型
         */
        private Integer type;

        /**
         * 内存预占数量
         */
        private Long memNum;


        static SnowflakeIdWorker snowflakeIdWorker;

        static {
            try {
                snowflakeIdWorker = new SnowflakeIdWorker(
                        Math.abs(InetAddress.getLocalHost().getHostAddress().hashCode()) % 31,
                        Math.abs(InetAddress.getLocalHost().getHostName().hashCode() % 31));
            } catch (UnknownHostException e) {
                throw new RuntimeException(e);
            }
        }


        GenerateType(String prefix, Integer length, Integer type, Long memNum) {
            this.prefix = prefix;
            this.length = length;
            this.type = type;
            this.memNum = memNum;

        }

        public String getPrefix() {
            return prefix;
        }

        public Integer getLength() {
            return length;
        }
    }

//    @PostConstruct
//    public void init() {
//        SequenceIDManger.init(basicDataSource.getUsername(), basicDataSource.getPassword(), basicDataSource.getUrl(), "com.mysql.jdbc.Driver");
//    }


    public String sharkGenerateId( Date time,GenerateType generateType ){
        if(generateType == null||generateType.type ==null){
            throw new RuntimeException("type not null!");
        }
        int type = generateType.type.intValue();
        if(type == GenerateType.WAVE.type.intValue()|| type == GenerateType.ENTRY_ORDER_NO.type.intValue()){

        }
        return null;
    }

//    /**
//     * 根据日期生成编号，每天编号从1开始
//     *
//     * @param generateType
//     * @return
//     */
//    public String generateCodeByDate(GenerateType generateType) {
//        String sequanceId = SequenceIDManger.getSequenceId(IDC_NUM, generateType.type, generateType.memNum) + "";
//        String date = DateUtils.formatDate("yyyyMMdd", new Date());
//        if (generateType.length == null) {
//            return generateType.prefix + date + sequanceId;
//        }
//        int length = generateType.length-sequanceId.length();
//        if( length > 0 ){
//            StringBuilder builder = new StringBuilder( );
//            while( builder.length() < length ){
//                builder.append( "0" );
//            }
//            sequanceId = builder.append( sequanceId ).toString();
//        }
//        return generateType.prefix + date + sequanceId.substring( sequanceId.length() - generateType.length );
//    }


//    /**
//     * 生成自增长编号
//     *
//     * @param generateType
//     * @return
//     */
//    public String generateCode(GenerateType generateType) {
//        String sequanceId = SequenceIDManger.getSequenceId(IDC_NUM, generateType.type, generateType.memNum) + "";
//        if (generateType.length == null) {
//            return generateType.prefix + sequanceId;
//        }
//        int length = generateType.length-sequanceId.length();
//        if( length > 0 ){
//            StringBuilder builder = new StringBuilder( );
//            while( builder.length() < length ){
//                builder.append( "0" );
//            }
//            sequanceId = builder.append( sequanceId ).toString();
//        }
//        return generateType.prefix + sequanceId.substring(sequanceId.length() - generateType.length);
//    }

    /**
     * 生成ID
     *
     * @param generateType
     * @return
     */
    public static Long generateId(GenerateType generateType) {
        return generateType.snowflakeIdWorker.nextId();
    }

//    /**
//     * 【容器号 】：生成 收货容器号
//     */
//    public String generateContainerCode(String warehouseCode) {
//        String sequanceId = SequenceIDManger.getSequenceId(IDC_NUM, GenerateType.CONTAINER_CODE.type, GenerateType.CONTAINER_CODE.memNum) + "";
//
//        return warehouseCode + sequanceId.substring(sequanceId.length() - GenerateType.CONTAINER_CODE.length);
//    }
//
//    /**
//     * 【品牌编码】：BD+0001
//     */
//    public String generateItemBrandCode() {
//        String seqId = SequenceIDManger.getSequenceId(IDC_NUM, GenerateType.ITEM_BRAND.type, GenerateType.ITEM_BRAND.memNum) + "";
//        seqId = seqId.substring(seqId.length() - GenerateType.ITEM_BRAND.length);
//        return GenerateType.ITEM_BRAND.prefix + seqId;
//    }
//
//    /**
//     * 【货品编码】：GS+20180607（日期）+0001（序号）
//     */
//    public String generateItemCode() {
//        String seqId = SequenceIDManger.getSequenceId(IDC_NUM, GenerateType.ITEM.type, GenerateType.ITEM.memNum) + "";
//        seqId = seqId.substring(seqId.length() - GenerateType.ITEM.length);
//        return GenerateType.ITEM.prefix + DateFormatUtils.format(new Date(), "yyyyMMdd") + seqId;
//    }
//
//    /**
//     * 【发货箱号】：FH + 20180607（日期）+ 000001（六位流水号）
//     */
//    public String generateDeliveryBoxCode() {
//        String seqId = SequenceIDManger.getSequenceId(IDC_NUM, GenerateType.DELIVERY_BOX.type, GenerateType.DELIVERY_BOX.memNum) + "";
//        seqId = seqId.substring(seqId.length() - GenerateType.DELIVERY_BOX.length);
//        return GenerateType.DELIVERY_BOX.prefix + DateFormatUtils.format(new Date(), "yyyyMMdd") + seqId;
//    }
//
//    /**
//     * 【波次号】：仓库编码 + BC + 20180607（日期）+ 000001（六位流水号）
//     */
//    public String generateWaveCode(String warehouseCode) {
//        String seqId = SequenceIDManger.getSequenceId(IDC_NUM, GenerateType.WAVE.type, GenerateType.WAVE.memNum) + "";
//        seqId = seqId.substring(seqId.length() - GenerateType.WAVE.length);
//        return warehouseCode + GenerateType.WAVE.prefix + seqId;
//    }
//
//    /**
//     * 【流程版本号】：OT+20180607（日期）+0001（序号）
//     */
//    public String generateOutProcessCode() {
//        String seqId = SequenceIDManger.getSequenceId(IDC_NUM, GenerateType.OUT_PROCESS.type, GenerateType.OUT_PROCESS.memNum) + "";
//        seqId = seqId.substring(seqId.length() - GenerateType.OUT_PROCESS.length);
//        return GenerateType.OUT_PROCESS.prefix + DateFormatUtils.format(new Date(), "yyyyMMdd") + seqId;
//    }
//
//    /**
//     * 【分类编码】：CS+001, 新增为一级分类，如果选择其他分类，分类编码在原分类编码基础上加01，比如CS00101
//     */
//    public String generateItemCategoryCode(GenerateType generateType, String parentCode) {
//        String seqId = SequenceIDManger.getSequenceId(IDC_NUM, generateType.type, generateType.memNum) + "";
//        seqId = seqId.substring(seqId.length() - generateType.length);
//        return generateType.prefix + parentCode + seqId;
//    }
//
//    /**
//     * 带日期的
//     */
//    public String generateCodeWithDate(GenerateType generateType) {
//        String seqId = SequenceIDManger.getSequenceId(IDC_NUM, generateType.type, generateType.memNum) + "";
//        seqId = seqId.substring(seqId.length() - generateType.length);
//        return generateType.prefix + DateFormatUtils.format(new Date(), "yyyyMMdd") + seqId;
//    }
}

