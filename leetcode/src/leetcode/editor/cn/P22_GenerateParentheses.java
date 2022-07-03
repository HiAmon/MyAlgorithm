//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例： 
//
// 输入：n = 3
//输出：[
//       "((()))",
//       "(()())",
//       "(())()",
//       "()(())",
//       "()()()"
//     ]
// 
// Related Topics 字符串 回溯算法 
// 👍 1489 👎 0


package leetcode.editor.cn;

//括号生成

import java.util.*;

public class P22_GenerateParentheses{
	 public static void main(String[] args) {
	 	 Solution solution = new P22_GenerateParentheses().new Solution();
	 }

	/**
	 * 栈：
	 * 进栈：-->□□□□□
	 * 出栈：□□□□□-->
	 * 进栈 -> '('
	 * 出栈 -> ')'
	 *
	 * 用回溯法搭配约束函数和限界函数
	 */
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> generateParenthesis(int n) {
    	List<String> res = new ArrayList<>();
		Map<Integer,Object> map = new HashMap<>();
    	if (n == 1){
    		map.put(1,"()");
		}
    	if (n == 2){
    		res.add("()()");
    		res.add("(())");
    		map.put(2,res);
		}
		Stack<Pair> stack = new Stack<>();
		stack.pop();
		for (int i = 1; i <= n; i++) {

			for (int j = 1; j <= i; j++) {
				//当仅允许栈中小于等于i个元素
				Pair pair = new Pair(1);
				stack.push(pair);
				pair.bePushedIn();
				pair.change();
			}


		}


		return null;
    }
}

class Pair{
	int flag;//1:in, 2:out

	public Pair(int flag) {
		this.flag = flag;
	}

	void change(){
		if (flag == 1){
			flag = 2;
		}else {
			flag = 1;
		}
	}

	void bePushedIn(){
		if (flag == 1){
			System.out.println("(");
		}
	}

	void bePopedOut(){
		if (flag == 2){
			System.out.println(")");
		}
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}
