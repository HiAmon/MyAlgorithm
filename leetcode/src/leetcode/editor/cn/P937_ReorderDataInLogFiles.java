//你有一个日志数组 logs。每条日志都是以空格分隔的字串。 
//
// 对于每条日志，其第一个字为字母与数字混合的 标识符 ，除标识符之外的所有字为这一条日志的 内容 。 
//
// 
// 除标识符之外，所有字均由小写字母组成的，称为 字母日志 
// 除标识符之外，所有字均由数字组成的，称为 数字日志 
// 
//
// 题目所用数据保证每个日志在其标识符后面至少有一个字。 
//
// 请按下述规则将日志重新排序： 
//
// 
// 所有 字母日志 都排在 数字日志 之前。 
// 字母日志 在内容不同时，忽略标识符后，按内容字母顺序排序；在内容相同时，按标识符排序； 
// 数字日志 应该按原来的顺序排列。 
// 
//
// 返回日志的最终顺序。 
//
// 
//
// 示例 ： 
//
// 输入：["a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"]
//输出：["g1 act car","a8 act zoo","ab1 off key dog","a1 9 2 3 1","zo4 4 7"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= logs.length <= 100 
// 3 <= logs[i].length <= 100 
// logs[i] 保证有一个标识符，并且标识符后面有一个字。 
// 
// Related Topics 字符串 
// 👍 54 👎 0


package leetcode.editor.cn;

//重新排列日志文件

import com.google.gson.Gson;

import java.util.Arrays;
import java.util.Comparator;

public class P937_ReorderDataInLogFiles{
	 public static void main(String[] args) {
	 	 Solution solution = new P937_ReorderDataInLogFiles().new Solution();
	 	 String[] logs = {"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};
//		 String[] strings = logs[2].split(" ", 2);
		 String[] strings = solution.reorderLogFiles(logs);
		 System.out.println(new Gson().toJson(strings));
	 }

	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String[] reorderLogFiles(String[] logs) {
		Arrays.sort(logs, (log1,log2) ->{
			//limit=n时，表示会将str分割为n段，如果limit值大于str中分割符数量+1，则还是按照分割符数量+1来分割
			String[] los1 = log1.split(" ", 2);
			String[] los2 = log2.split(" ", 2);
			//判断字符是否为数字
			boolean isDigit1 = Character.isDigit(los1[1].charAt(0));
			boolean isDigit2 = Character.isDigit(los2[1].charAt(0));
			//如果都不是数字，则比较正文的字典序
			if (!isDigit1 && !isDigit2){
				int compare = los1[1].compareTo(los2[1]);
				if (compare!=0){
					return compare;
				}
				//正文相同则比较标识
				return los1[0].compareTo(los2[0]);
			}
			//新来的str是否是数字，如果是则为0，不是则为1（则当前的一定是数字）
			int x = isDigit2 ? 0 : 1;
			//当前的str是否是数字，如果是，就按照新来的状态返回，如果不是，新来的就排到后面
			return isDigit1 ? x : -1;
		});
		return logs;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
