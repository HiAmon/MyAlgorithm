package temp;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

public class NewnewTest {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("SF000SO111","24321321312");
        map.put("SF000SO112","48980324803");
        map.put("SF000SO113","87589427893");
        map.put("SF000SO114","87589427893");
        System.out.println(new Gson().toJson(map.values()));
    }
}
