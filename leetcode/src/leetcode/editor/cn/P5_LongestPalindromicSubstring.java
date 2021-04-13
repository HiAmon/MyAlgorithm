//给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。 
//
// 示例 1： 
//
// 输入: "babad"
//输出: "bab"
//注意: "aba" 也是一个有效答案。
// 
//
// 示例 2： 
//
// 输入: "cbbd"
//输出: "bb"
// 
// Related Topics 字符串 动态规划 
// 👍 3024 👎 0


package leetcode.editor.cn;

//最长回文子串

public class P5_LongestPalindromicSubstring{
	 public static void main(String[] args) {
	 	 Solution solution = new P5_LongestPalindromicSubstring().new Solution();
		 System.out.println(solution.longestPalindrome("bb"));
	 }

	/**
	 * 动态规划
	 * 经分析可知，回文子串是满足最优子结构和重叠子问题性质的
	 * 当子串长度为1时，显然是满足回文性质的，于是可以作为基准条件
	 * 当长度为2时，通过判断两个字符是否相等也可以判断
	 * 将前两者的计算结果都保存下来，当长度大于2时，通过比较两端的字符是否相等，再查询掐头去尾后的子串的结果（已经被保存过了）是否回文，从而逐次扩张
	 */
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestPalindrome(String s) {
    	boolean[][] dp = new boolean[s.length()][s.length()];
    	int maxlen = 0;
    	String res = "";
    	//这里len是小于字符串长度，不用-1
		for (int len = 0; len < s.length(); len++) {
			for (int i = 0; i < s.length() - len; i++) {
				int j = i + len;
				if (len == 0){
					dp[i][j] = true;
				}else if (len == 1){
					//这里是给dp赋值，不要把判断条件加到if里面，是记录t/f，不是把false的跳过
					dp[i][j] = s.charAt(i) == s.charAt(j);
				}else {
					dp[i][j] = (s.charAt(i) == s.charAt(j)) && dp[i+1][j-1];
				}
				//每次将更优结果保存到结果字符串中
				if (dp[i][j] && (len + 1 > res.length())){
					//substring方法名没有驼峰!!  不是subString!
					res = s.substring(i , j + 1);
				}
			}
		}
		return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
