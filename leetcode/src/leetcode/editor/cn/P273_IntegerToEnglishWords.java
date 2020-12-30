//将非负整数 num 转换为其对应的英文表示。 
//
// 
//
// 示例 1： 
//
// 
//输入：num = 123
//输出："One Hundred Twenty Three"
// 
//
// 示例 2： 
//
// 
//输入：num = 12345
//输出："Twelve Thousand Three Hundred Forty Five"
// 
//
// 示例 3： 
//
// 
//输入：num = 1234567
//输出："One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
// 
//
// 示例 4： 
//
// 
//输入：num = 1234567891
//输出："One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thous
//and Eight Hundred Ninety One"
// 
//
// 
//
// 提示： 
//
// 
// 0 <= num <= 231 - 1 
// 
// Related Topics 数学 字符串 
// 👍 121 👎 0


package leetcode.editor.cn;

//整数转换英文表示

public class P273_IntegerToEnglishWords{
	 public static void main(String[] args) {
	 	 Solution solution = new P273_IntegerToEnglishWords().new Solution();
		 System.out.println(solution.numberToWords(1234567891));
	 }

	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
		int[] arab = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 30, 40, 50, 60, 70, 80, 90, 100, 1000, 1000000, 1000000000};
		String[] words = {"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
				"Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen",
				"Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety",
				"Hundred", "Thousand", "Million", "Billion"};
		/**
		 * class Solution {
		 * public:
		 * 	const int N[31] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 30, 40, 50, 60, 70, 80, 90,
		 * 			100, 1000, 1000000, 1000000000};
		 * 	const string S[31] = {"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
		 * 			"Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen",
		 * 			"Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety",
		 * 			"Hundred", "Thousand", "Million", "Billion"};
		 *     const int K = 90;
		 *     string numberToWords(int num) {
		 *         if (num == 0) return "Zero";
		 *         int i = 30;
		 *         while (i >= 0 && N[i] > num) --i;
		 *         string res;
		 *         if (N[i] <= K) {
		 *             res += S[i];
		 *         } else {
		 *             res += numberToWords(num / N[i]) + " " + S[i];
		 *         }
		 *         if (num % N[i] > 0) res += " " + numberToWords(num % N[i]);
		 *         return res;
		 *     }
		 * };
		 *
		 * 作者：da-li-wang
		 * 链接：https://leetcode-cn.com/problems/english-int-lcci/solution/c-jian-dan-ti-jie-by-da-li-wang-38/
		 * 来源：力扣（LeetCode）
		 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
		 * */
    public String numberToWords(int num) {
    	if (num == 0){
    		return "zero";
		}
    	int i = arab.length -1;//30
    	while (i >= 0 && arab[i] > num ){
    		--i;
		}
    	String res = "";
    	if (arab[i] <= 90){
    		res += words[i];
		}else {
    		res += numberToWords(num/arab[i]) + " " + words[i];
		}
    	if (num % arab[i] > 0){
    		res += " " + numberToWords(num % arab[i]);
		}
		return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
