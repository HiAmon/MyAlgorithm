package topic.dp;

//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。 
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？ 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 2
//输出：2
//解释：有两种方法可以爬到楼顶。
//1. 1 阶 + 1 阶
//2. 2 阶 
//
// 示例 2： 
//
// 
//输入：n = 3
//输出：3
//解释：有三种方法可以爬到楼顶。
//1. 1 阶 + 1 阶 + 1 阶
//2. 1 阶 + 2 阶
//3. 2 阶 + 1 阶
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 45 
// 
// Related Topics 记忆化搜索 数学 动态规划 👍 2443 👎 0

/**
 * 【最典型-入门级动态规划案例】！！！
 *  可以试试更简单的斐波那契，总结方法论
 */
public class P70_ClimbingStairs{
    public static void main(String[] args) {
        Solution solution = new P70_ClimbingStairs().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 动态规划方法论：
     * 1、dp数组的定义，下标和值的含义；
     * 2、【递推公式】!!!
     * 3、初始化值，如dp[0]、dp[1]、dp[0][0]等；
     * 4、【确定遍历顺序】!!!
     * Ps. 草稿上推导一下dp预期值和日志打印值的对比，debug过程寻找问题；
     * 5、选择并输出题目要求的结果
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
//        if (n == 1){
//            return 1;//1
//        }
//        if (n == 2){
//            return 2;// 1+1 / 2
//        }
//        if (n == 3){
//            return 3;
//            /**
//             * 从2，跨1上来 -->继承了2阶的2种走法 ==> 2
//             * 从1，跨2/1+1上来 -->继承了1阶的1种走法 ==> 1
//             * 2+1=3
//             */
//        }
//
//        if (n == 4){
//            return 5;
//            /**
//             * 从2，跨2上来，==>2【因为如果从2走1+1的话也会走到3。就和3阶的走法是重复的，所以只会从2阶直接跨2步来跳过3阶】
//             * 从3，跨1上来 继承了3阶的3种走法 ==>3
//             * 2+3=5
//             */
//        }

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        dp[4] = 5;
        //得到递推公式：dp[n] = dp[n-1]+dp[n-2];
        for (int i = 5; i < n; i++) {
            dp[n] = dp[n-1] + dp[n-2];
        }

        return dp[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}