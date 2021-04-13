//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 注意空字符串可被认为是有效字符串。 
//
// 示例 1: 
//
// 输入: "()"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "()[]{}"
//输出: true
// 
//
// 示例 3: 
//
// 输入: "(]"
//输出: false
// 
//
// 示例 4: 
//
// 输入: "([)]"
//输出: false
// 
//
// 示例 5: 
//
// 输入: "{[]}"
//输出: true 
// Related Topics 栈 字符串 
// 👍 2054 👎 0


package leetcode.editor.cn;

//有效的括号

import java.util.Stack;

public class P20_ValidParentheses{
	 public static void main(String[] args) {
	 	 Solution solution = new P20_ValidParentheses().new Solution();
		 System.out.println(solution.isValid("[]{}"));
	 }

	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
		public boolean isValid(String s) {
			if (s.length() % 2 != 0 || s.length() < 1) {
				return false;
			}
			Stack stack = new Stack();
			stack.push(s.charAt(0));
			for (int i = 1; i < s.length(); i++) {
				if (!stack.empty()){
					//栈非空，先判断栈顶元素，满足条件则pop，不满足就push
					//学到了peek()和pop()的区别，都是取栈顶，但peek是不移出栈顶元素的
					if (isMatch((char)stack.peek(),s.charAt(i))){
						stack.pop();
						continue;
					}
				}
				//如果栈空，直接push
				stack.push(s.charAt(i));
			}
			if (!stack.empty()){
				return false;
			}
			return true;
		}

		@Deprecated
		public boolean isValidOld(String s) {
			// 2021/4/11 基数控制不可行，需要控制顺序
			int trueNum = 0;
			int big = 0;
			int mid = 0;
			int small = 0;
			for (int i = 0; i < s.length(); i++) {
				switch (s.charAt(i)) {
					case '{':
						big++;
						break;
					case '}':
						big--;
						break;
					case '[':
						mid++;
						break;
					case ']':
						mid--;
						break;
					case '(':
						small++;
						break;
					case ')':
						small--;
						break;
				}
				if (big < 0 || mid < 0 || small < 0) {
					System.out.println("反序了");
					return false;
				}
				/****************/
				int[] array = new int[3];
				array[0] = big;
				array[1] = mid;
				array[2] = small;
				if ((getTrueNum(array) - trueNum == -1) && !isMatch(s.charAt(i - 1), s.charAt(i))) {
					System.out.println("有一个单括号夹在正常括号中间了 " + trueNum + "-->" + getTrueNum(array));
					System.out.println(s.charAt(i - 1) + "***" + s.charAt(i));
					return false;
				} else {
					trueNum = getTrueNum(array);
				}
				/****************/
			}
			if (!(big == 0 && small == 0 && mid == 0)) {
				System.out.println("走到最后没有全部闭合");
				return false;
			}
			return true;
		}

		public int getTrueNum(int[] array) {
			int num = 0;
			for (int i = 0; i < array.length; i++) {
				if (array[i] > 0) {
					num++;
				}
			}
			return num;
		}

		public boolean isMatch(char i, char j) {
			if (i == '(' && j == ')') {
				return true;
			}
			if (i == '[' && j == ']') {
				return true;
			}
			if (i == '{' && j == '}') {
				return true;
			}
			return false;
		}
	}

//leetcode submit region end(Prohibit modification and deletion)

}
