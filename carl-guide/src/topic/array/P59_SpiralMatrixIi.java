package topic.array;

//给你一个正整数 n ，生成一个包含 1 到 n² 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：[[1,2,3],[8,9,4],[7,6,5]]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 
// Related Topics 数组 矩阵 模拟 👍 571 👎 0

import com.google.gson.Gson;

public class P59_SpiralMatrixIi{
    public static void main(String[] args) {
        Solution solution = new P59_SpiralMatrixIi().new Solution();
        System.out.println(new Gson().toJson(solution.generateMatrix2(4)));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] spiral = new int[n][n];

        int number = 1;
        /**
         * 保持统一原则，左闭右开/左开右闭
         *
         * 找规律：环形的层数是Math.ceil(n/2)
         *
         */
        //*****(if n=4)*******
        //方向信号，true：横向；false：纵向
        int row = 0;
        int col = 0;
        int arm = n-1;
        double loop = Math.ceil(n / 2);
        for (int k = 0; k < loop; k++) {
            for (int round = 1; round <= 4; round++) {
                int i;
                for (i = 0; i < arm; i++) {
                    if (round == 1){
                        row = i+1;
                        //列加，行不变
                        //00,01,02,03 ==> 0
                        spiral[row][i] = number++;
                    }else if (round == 2){
                        //行加，列不变
                        //04,14,24,34 ==> 4
                        spiral[i][col] = number++;
                    }else if (round == 3){
                        //列减，行不变
                        //44,43,42,41 ==> 4
                        spiral[row][i] = number++;
                    }else {
                        //行减，列不变
                        //40,30,20,10 ==> 0
                        spiral[i][col] = number++;
                    }
                }
                col = i+1;
                row = i+1;
            }
            arm = arm - 2;
        }

        return spiral;
    }

    /**
     * 官方解法：分成4个for
     * 原创代码⬇
     */
    public int[][] generateMatrix2(int n) {
        int[][] spiral = new int[n][n];
        int number = 1;
        int row;
        int col;
        int arm = n-1;
        double ceil = Math.ceil(n / 2.0);//n=6 ->3
        int m = new Double(ceil).intValue();

        /**
         * 优化点：loop的数量做成n/2，奇数圈的最中间单独处理即可，所以无需向上取整
         * int m = n/2;
         * 但后续都需要同步调整，可以下次试试
         */


        for (int loop = 0; loop < m; loop++) {//0,1,2
            if (arm == 0){
                spiral[n/2][n/2] = number;
                break;
            }
            for (int i = loop; i < loop + arm; i++) {
                //列加，行不变
                //00,01,02,03 ==>
                row = loop;
                spiral[row][i] = number++;
            }

            for (int i = loop; i < loop + arm; i++) {
                //行加，列不变
                //04,14,24,34 ==>
                col = n-1-loop;
                spiral[i][col] = number++;
            }

            for (int i = n-1-loop; i > n-1-loop - arm; i--) {
                //列减，行不变
                //44,43,42,41 ==>
                row = n-1-loop;
                spiral[row][i] = number++;
            }

            for (int i = n-1-loop; i > n-1-loop - arm; i--) {
                //行减，列不变
                //40,30,20,10 ==>
                col = loop;
                spiral[i][col] = number++;
            }
            arm = arm - 2;
        }
        return spiral;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}