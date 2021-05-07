//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。 
// 示例 1:
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 示例 2:
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 示例 3:
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 示例 4:
//输入: s = ""
//输出: 0
// 提示：
// 0 <= s.length <= 5 * 104
// s 由英文字母、数字、符号和空格组成 
// Related Topics 哈希表 双指针 字符串 Sliding Window
// 👍 4733 👎 0


package leetcode.editor.cn;

//无重复字符的最长子串

import java.util.HashSet;
import java.util.Set;

public class P3_LongestSubstringWithoutRepeatingCharacters{
	 public static void main(String[] args) {
	 	 Solution solution = new P3_LongestSubstringWithoutRepeatingCharacters().new Solution();
		 System.out.println(solution.lengthOfLongestSubstring("abcabcbb"));
	 }

	/**
	 * 滑动窗口 + 哈希表
	 *
	 */

	class Solution {
	    public int lengthOfLongestSubstring(String s) {
	        // 哈希集合，记录每个字符是否出现过
	        Set<Character> occ = new HashSet<Character>();
	        int n = s.length();
	        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
	        int rk = -1, ans = 0;
	        for (int i = 0; i < n; ++i) {
	            if (i != 0) {
	                // 左指针向右移动一格，移除一个字符
	                occ.remove(s.charAt(i - 1));
	            }
	            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
	                // 不断地移动右指针
	                occ.add(s.charAt(rk + 1));
	                ++rk;
	            }
	            // 第 i 到 rk 个字符是一个极长的无重复字符子串
	            ans = Math.max(ans, rk - i + 1);
	        }
	        return ans;
	    }
	}

	//leetcode submit region begin(Prohibit modification and deletion)
//	class Solution {
//		public int lengthOfLongestSubstring(String s) {
//			int rk = -1;//rk可以表示当前i指向的起始字符所能扩展的最长不重复子串的右边界字符，即子串的左端和右端指针
//			int ans = 0;//结果
//			Set<Character> hashSet = new HashSet<>();
//			for (int i = 0; i < s.length(); i++) {
//				if (i != 0){
//					hashSet.remove(s.charAt(i-1));
//				}
//				//表示rk未出界   && 当前哈希表中没有rk右边这个字符，说明是不重复的，可以把这下一个字符加入到不重复串中
//				while ((rk + 1 < s.length()) && hashSet.contains(s.charAt(rk + 1))){
//					hashSet.add(s.charAt(rk + 1));
//					++rk;
//				}
//				ans = Math.max(ans, rk-i+1);
//			}
//			return ans;
//		}
//	}
	//leetcode submit region end(Prohibit modification and deletion)

}
