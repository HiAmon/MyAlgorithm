package string;


/**
 * 给定一个字符串，找出其中不含有重复字符的 最长子串 的长度。
 */
public class LengthOfLongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        //外循环遍历chars[]，pos[]存放当前不重复字符串，max存放当前找到的子串的最大长度
        char[] chars = s.toCharArray();
        char[] pos = new char[s.length()];
//        StringBuilder sb = new StringBuilder();
        StringBuffer sb = new StringBuffer();
        int max = 0;
        int n = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i < 1){
                pos[max] = s.charAt(i);
                continue;
            }
            for (int j = 0; j < pos[n]; j++) {
                if (chars[i] == pos[j]){

                }

            }
        }

        return max + 1;
    }

    public static void main(String[] args) {
        lengthOfLongestSubstring("ababab");
    }
}

