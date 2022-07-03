package topic.dfs;

//二维矩阵 grid 由 0 （土地）和 1 （水）组成。岛是由最大的4个方向连通的 0 组成的群，封闭岛是一个 完全 由1包围（左、上、右、下）的岛。 
//
// 请返回 封闭岛屿 的数目。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：grid = [[1,1,1,1,1,1,1,0],[1,0,0,0,0,1,1,0],[1,0,1,0,1,1,1,0],[1,0,0,0,0,1,
//0,1],[1,1,1,1,1,1,1,0]]
//输出：2
//解释：
//灰色区域的岛屿是封闭岛屿，因为这座岛屿完全被水域包围（即被 1 区域包围）。 
//
// 示例 2： 
//
// 
//
// 
//输入：grid = [[0,0,1,0,0],[0,1,0,1,0],[0,1,1,1,0]]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：grid = [[1,1,1,1,1,1,1],
//             [1,0,0,0,0,0,1],
//             [1,0,1,1,1,0,1],
//             [1,0,1,0,1,0,1],
//             [1,0,1,1,1,0,1],
//             [1,0,0,0,0,0,1],
//             [1,1,1,1,1,1,1]]
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 1 <= grid.length, grid[0].length <= 100 
// 0 <= grid[i][j] <=1 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 138 👎 0

public class P1254_NumberOfClosedIslands{
    public static void main(String[] args) {
        Solution solution = new P1254_NumberOfClosedIslands().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    int[][] grid;
    int rows;//x
    int cols;//y
    int[] dx = {-1,0,1,0};//x-1/x+2，即上下移动
    int[] dy = {0,1,0,-1};//y+1/y-1，即左右移动

    public int closedIsland(int[][] grid) {
        int islands = 0;
        this.grid = grid;
        rows = grid.length;
        cols = grid[0].length;
        for (int i = 1; i < grid.length-1; i++) {   //1~len-1,外围一圈不算
            for (int j = 1; j < grid[i].length-1; j++) {
                //如果内圈的0没有和外围圈形成连通，就是岛，在岛中再计算孤岛数目
                if (grid[i][j] == 0){
                    boolean res = dfs(i, j);
                    if (res){
                        islands++;
                    }
                }
            }
        }
        return islands;
    }

    /**
     *
     * @param x,y 定位一个格子
     * @return 当前节点是否属于岛
     */
    public boolean dfs(int x, int y){
        //判断这个格子是否是边界
        if (x == 0 || y == 0 || x == rows -1 || y == cols -1){
            return false;
        }
        if (grid[x][y] == 0){ //在递归中可能会遇到0的格子
            return false;
        }

        boolean result = true; //??
        grid[x][y] = 1;

        for (int i = 0; i < 4; i++) {
            int x1 = x + dx[i];
            int y1 = y + dy[i];

            if (x1 < 0 || x1 >= rows || y1 < 0 || y1 >= cols || grid[x1][y1] == 1){
                continue;
            }

            result = result & dfs(x1,y1); //【???】
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}