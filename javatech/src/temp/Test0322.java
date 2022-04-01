package temp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test0322 {
    public static void main(String[] args) {
        System.out.println(findNum(169L));
    }

    static int findNum(Long ix){
        if (ix == 1){
            return 2;
        }
        Long high = 2L;
        int num = 2;
        Map<Integer,Long> list = new HashMap();
        while (high < ix){
            high += ++num;
        }
        return num;
    }
}
