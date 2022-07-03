package leetcode.editor.cn.huawei.middle;

import java.util.HashSet;
import java.util.Set;

/**
 * @author wuyou
 */
public class LongestDistinctSubString {
    public static void main(String[] args) {
        LongestDistinctSubString longestDistinctSubString = new LongestDistinctSubString();
        int n = longestDistinctSubString.lengthOfLongestSubstring("www");
        System.out.println(n);
    }

    public int lengthOfLongestSubstring(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> set = new HashSet<>();
        //目标子串右边界指针
        int j = -1;
        int ans = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (i != 0) {
                set.remove(s.charAt(i - 1));
            }
            while (j + 1 < s.length() && !set.contains(s.charAt(j + 1))) {
                //新元素就包进来
                set.add(s.charAt(j + 1));
                ++j;
            }
            ans = Math.max(ans, j - i + 1);
        }
        return ans;
    }
}
