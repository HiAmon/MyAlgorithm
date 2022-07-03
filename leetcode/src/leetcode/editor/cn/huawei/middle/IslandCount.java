package leetcode.editor.cn.huawei.middle;


public class IslandCount {
    public static void main(String[] args) {
        char[][] ch = new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '1'}
        };
        IslandCount islandCount = new IslandCount();
        System.out.println(islandCount.numIslands(ch));
    }
    
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j]=='1'){
                    ++count;
                    //把当前点所属连通分支全变成0，这样下次再进来找到的一定是另一个连通分支了
                    dfs(grid,i,j);
                }
            }
        }
        return count;
    }

    public void dfs(char[][] grid, int r, int c){
        if (c < 0 || r < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == '0'){
            return;
        }
        grid[r][c] = '0';
        dfs(grid,r-1,c);
        dfs(grid,r+1,c);
        dfs(grid,r,c-1);
        dfs(grid,r,c+1);
    }
}
