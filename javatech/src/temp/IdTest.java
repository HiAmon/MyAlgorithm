package temp;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class IdTest {
    public static void main(String[] args) {
//        for (int i = 0; i < 5; i++) {
//            System.out.println(IdGenerateUtil.generateId(IdGenerateUtil.GenerateType.INVENTORY_ID) +"");
//        }

//        StringBuilder ab = new StringBuilder();
//        String[] splits = info.split("\n");
//        for (String person : splits) {
//            String[] oneinfos = person.split("-");
//            ab.append(oneinfos[2]).append("\n");
//        }
//        System.out.println(ab);
        Random random = new Random();
        for (int i = 0; i < 50; i++) {
            System.out.printf("SELECT modify_time from t_logistics_trace_%d where deliver_company = '顺丰快递' UNION \n",random.nextInt(1000));
        }

    }
}
