package stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MyStream {
    /**
     * java8 stream api新特性
     */
    public static void main(String[] args) {
        List<Love> loves = new ArrayList<>();
        /**
         * 当前泛型list转此类型的某几个字段组成的类的泛型的list
         * 比如把love中的you字段单独作为一个list，并且要去重
         */
        List<String> yous = loves.stream().map(Love::getYou).distinct().collect(Collectors.toList());

        /**
         * 把原类型中的某两个字段抽出来作为key类型和value类型，并且对key去重
         */
        final Map<Integer, String> youMap = loves.stream().collect(Collectors.toMap(Love::getYouCode, Love::getYou, (l1, l2) -> l1));
    }

    class Love {
        String you;
        String me;
        Integer youCode;
        Integer meCode;

        public Integer getYouCode() {
            return youCode;
        }

        public void setYouCode(Integer youCode) {
            this.youCode = youCode;
        }

        public Integer getMeCode() {
            return meCode;
        }

        public void setMeCode(Integer meCode) {
            this.meCode = meCode;
        }

        public String getYou() {
            return you;
        }

        public void setYou(String you) {
            this.you = you;
        }

        public String getMe() {
            return me;
        }

        public void setMe(String me) {
            this.me = me;
        }
    }
}
