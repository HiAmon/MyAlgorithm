package collection;

import com.google.gson.Gson;

import java.util.*;
import java.util.function.BiConsumer;

public class MapDemo {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        list.add("2");
        list.add("3");
        list.add("1");
        list.add("4");
        /**
         * remove 2:
         * Exception in thread "main" java.util.ConcurrentModificationException
         * 	at java.util.ArrayList$Itr.checkForComodification(ArrayList.java:911)
         * 	at java.util.ArrayList$Itr.next(ArrayList.java:861)
         * 	at collection.MapDemo.main(MapDemo.java:17)
         */
        for(String str : list){
            if (str.equals("1")){
                list.remove(str);
            }
        }
        //为什么remove倒数第二个就没问题？？？
        /******************************************************/


//        String[] strings = new String[0];
//        String[] strings1 = list.toArray(strings);
        System.out.println(new Gson().toJson(list));
//
//        list.addAll(list2);
        /******************************************************/
//        String[] strArray = new String[3];
//        strArray[0] = "432";
//        strArray[1] = "542";
//        strArray[2] = "565";
//        Arrays.asList(strArray).add("4332");
//        Arrays.asList(strArray).remove("432");
//        Arrays.asList(strArray).clear();
        /******************************************************/

        Map<Integer,String> map = new HashMap<>(128);
        map.entrySet();
        map.forEach(new BiConsumer<Integer, String>() {
            @Override
            public void accept(Integer i, String s) {
                if (i==1){
                    map.remove(i);
                }
            }
        });

    }

}

