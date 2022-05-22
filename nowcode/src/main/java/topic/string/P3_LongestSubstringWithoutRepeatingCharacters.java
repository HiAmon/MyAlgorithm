package topic.string;

//给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 10⁴ 
// s 由英文字母、数字、符号和空格组成 
// 
// Related Topics 哈希表 字符串 滑动窗口 👍 7553 👎 0

//✅
public class P3_LongestSubstringWithoutRepeatingCharacters{
    public static void main(String[] args) {
        Solution solution = new P3_LongestSubstringWithoutRepeatingCharacters().new Solution();
//        String str = "pwwkew";
        String str = "abcabcbbdoab";
        System.out.println(solution.lengthOfLongestSubstring(str));
//        char[] chars = str.toCharArray();
//        for (int i = 0; i < chars.length; i++) {
//            System.out.println(chars[i]);
//        }
//        byte[] bytes = str.getBytes();
//        for (int i = 0; i < bytes.length; i++) {
//            System.out.println(bytes[i]);
//        }
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 对于 「找字符串的子串」问题，通常都是滑动窗口【因为子串内部是不能断裂而是连续的，注意区分「子串」和「子序列」！！】
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {

        if (null == s || "".equals(s)){
            return 0;
        }

        Solution solution = new Solution();
        int maxlen = 1;
        int i = 0;
        int j = 1;
        char[] chars = s.toCharArray();
        while (j < chars.length){
            int con = solution.contains(chars, i, j, chars[j]);
            if (con >= 0){
                i = con+1;
            }else {
                j++;
            }
            maxlen = Math.max(maxlen, j-i);
        }
        return maxlen;
    }

    public int contains(char[] chars, int begin, int end, char target){
        for (int i = begin; i < end; i++) {
            if (chars[i] == target){
                return i;
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}