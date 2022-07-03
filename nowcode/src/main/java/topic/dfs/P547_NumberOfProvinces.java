package topic.dfs;

//
// 
// 有 n 个城市，其中一些彼此相连，另一些没有相连。如果城市 a 与城市 b 直接相连，且城市 b 与城市 c 直接相连，那么城市 a 与城市 c 间接相连
//。 
//
// 省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。 
//
// 给你一个 n x n 的矩阵 isConnected ，其中 isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，而 
//isConnected[i][j] = 0 表示二者不直接相连。 
//
// 返回矩阵中 省份 的数量。 
//
// 
//
// 示例 1： 
//
// 
//输入：isConnected = [[1,1,0],[1,1,0],[0,0,1]]
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：isConnected = [[1,0,0],[0,1,0],[0,0,1]]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 200 
// n == isConnected.length 
// n == isConnected[i].length 
// isConnected[i][j] 为 1 或 0 
// isConnected[i][i] == 1 
// isConnected[i][j] == isConnected[j][i] 
// 
// 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 图 👍 793 👎 0

import java.util.*;

public class P547_NumberOfProvinces{
    public static void main(String[] args) {
        Solution solution = new P547_NumberOfProvinces().new Solution();
//        int[][] iscon = new int[][]{{1,1,0},{1,1,0},{0,0,1}};
//        int[][] iscon = new int[][]{{1,1,1},{1,1,1},{1,1,1}};
        int[][] iscon = new int[][]{{1,0,0,1},{0,1,1,0},{0,1,1,1},{1,0,1,1}};
        System.out.println(solution.findCircleNum(iscon));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    /**
     * DFS
     * @param isConnected
     * @return
     */
    int[][] isConnected;
    boolean[] visited;
    public int findCircleNum(int[][] isConnected) {
        int province = 0;
        this.isConnected = isConnected;
        visited = new boolean[isConnected.length];
        for (int i = 0; i < isConnected.length; i++) {
            if (!visited[i]){
                dfs(i);
                province++;//数值处理
            }
        }
        return province;
    }

    /**
     * 深度优先遍历
     * 从一个节点遍历到与他相连的所有节点，直到叶子节点
     * @param i
     */
    public void dfs(int i){
        for (int j = 0; j < isConnected.length; j++) {
            if (isConnected[i][j] == 1 && !visited[j]){
                visited[j] = true;
                dfs(j);//从i传递到j
            }
        }
    }




    @Deprecated
    public int findCircleNum_de(int[][] isConnected) {
        List<Set<Integer>> list = new ArrayList<>();
        
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = i+1; j < isConnected[i].length; j++) {
                if (isConnected[i][j] == 1){
                    if (list.size() > 0){
                        for (Set<Integer> set : list) {
                            if (set.contains(i) || set.contains(j)){
                                set.add(i);
                                set.add(j);
                            }
                        }
                    }
                    Set<Integer> set = new HashSet<>();
                    set.add(i);
                    set.add(j);
                    list.add(set);
                }
            }
        }

        int sum = 0;
        for (Set<Integer> set : list) {
            sum += set.size();

        }
        if (sum == isConnected.length){
            return 1;
        }
        return list.size() + isConnected.length - sum;
    }

    @Deprecated
    void unionSet(List<Set<Integer>> list){
        int maxSize = 0;
        Iterator<Set<Integer>> iterator = list.iterator();
        while (iterator.hasNext()){
            Set<Integer> set = iterator.next();
//            if (set.contains(i) || set.contains(j)){
//                if (set.size() < maxSize){
//                    iterator.remove();
//                    continue;
//                }
//                maxSize = Math.max(maxSize, set.size());
//            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}