package topic.dp;

//一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。 
//
// 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。 
//
// 问总共有多少条不同的路径？ 
//
// 
//
// 示例 1： 
//
// 
//输入：m = 3, n = 7
//输出：28 
//
// 示例 2： 
//
// 
//输入：m = 3, n = 2
//输出：3
//解释：
//从左上角开始，总共有 3 条路径可以到达右下角。
//1. 向右 -> 向下 -> 向下
//2. 向下 -> 向下 -> 向右
//3. 向下 -> 向右 -> 向下
// 
//
// 示例 3： 
//
// 
//输入：m = 7, n = 3
//输出：28
// 
//
// 示例 4： 
//
// 
//输入：m = 3, n = 3
//输出：6 
//
// 
//
// 提示： 
//
// 
// 1 <= m, n <= 100 
// 题目数据保证答案小于等于 2 * 10⁹ 
// 
// Related Topics 数学 动态规划 组合数学 👍 1427 👎 0

public class P62_UniquePaths{
    public static void main(String[] args) {
        Solution solution = new P62_UniquePaths().new Solution();
        System.out.println(solution.uniquePaths(3,7));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 动态规划五步骤：
     * 1. 确定dp含义:(0,0) -> (i,j)的走法
     * 2. 递推公式
     * 3. 初始化
     * 4. 遍历顺序
     * 5. 输出结果
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        //1
        int[][] dp = new int[m][n];

        //2
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }

        //3
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1]; //根据图画草稿可知
            }
        }
        return dp[m-1][n-1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}