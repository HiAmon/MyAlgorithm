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
//		 System.out.println(solution.longestPalindrome("bb"));
		 System.out.println(solution.longestPalindrome_centerExpand("abba"));
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
		String s;

		public String longestPalindrome(String s) {
			//dp[i][j]表示子串[i..j]是否是回文串
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


		/**
		 * 中心扩散：#回文中心 #臂长
		 * @param s
		 * @return
		 */
		public String longestPalindrome_centerExpand(String s) {
			this.s = s;
			int len = s.length();
			if (len <= 1){
				return s;
			}
			if (len == 2){
				return s.charAt(0) == s.charAt(1)?s:(s.substring(0,1));
			}
			int begin = 0;
			int end = 0;
//			int maxCenter = 1;//无法应对abba的情况
			for (int i = 1; i < len -1;i++) {
				int len1 = getMaxLengthHere(i - 1, i + 1);
				int len2 = getMaxLengthHere(i, i + 2);
				if (len1 < len2){
					i++;
				}
				int maxLen = Math.max(len1, len2);
				if(maxLen > begin-end){

				}
				begin = i-maxLen/2;
				end = i + maxLen/2 +1;

			}
			return s.substring(begin,end);
		}

		/**
		 * 返回当前元素能扩展的最大范围
		 */
		public int getMaxLengthHere(int l, int r){
			//不能在引用入参上直接修改，因为是用元素下标定位的，会影响母方法的值
			int left = l;
			int right = r;
			while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
				left--;
				right++;
			}
			return right-left+1;
		}
	}
	//leetcode submit region end(Prohibit modification and deletion)

}

class Solution {
	public String longestPalindrome(String s) {
		if (s == null || s.length() < 1) {
			return "";
		}
		int start = 0, end = 0;
		for (int i = 0; i < s.length(); i++) {
			int len1 = expandAroundCenter(s, i, i);
			int len2 = expandAroundCenter(s, i, i + 1);
			int len = Math.max(len1, len2);
			if (len > end - start) {
				start = i - (len - 1) / 2;
				end = i + len / 2;
			}
		}
		return s.substring(start, end + 1);
	}

	public int expandAroundCenter(String s, int left, int right) {
		while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
			--left;
			++right;
		}
		return right - left - 1;
	}
}