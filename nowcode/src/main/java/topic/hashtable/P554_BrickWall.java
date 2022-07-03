package topic.hashtable;

//你的面前有一堵矩形的、由 n 行砖块组成的砖墙。这些砖块高度相同（也就是一个单位高）但是宽度不同。每一行砖块的宽度之和相等。 
//
// 你现在要画一条 自顶向下 的、穿过 最少 砖块的垂线。如果你画的线只是从砖块的边缘经过，就不算穿过这块砖。你不能沿着墙的两个垂直边缘之一画线，这样显然是没
//有穿过一块砖的。 
//
// 给你一个二维数组 wall ，该数组包含这堵墙的相关信息。其中，wall[i] 是一个代表从左至右每块砖的宽度的数组。你需要找出怎样画才能使这条线 穿过的
//砖块数量最少 ，并且返回 穿过的砖块数量 。 
//
// 
//
// 示例 1： 
//
// 
//输入：wall = [[1,2,2,1],[3,1,2],[1,3,2],[2,4],[3,1,2],[1,3,1,1]]
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：wall = [[1],[1],[1]]
//输出：3
// 
// 
//
// 提示： 
//
// 
// n == wall.length 
// 1 <= n <= 10⁴ 
// 1 <= wall[i].length <= 10⁴ 
// 1 <= sum(wall[i].length) <= 2 * 10⁴ 
// 对于每一行 i ，sum(wall[i]) 是相同的 
// 1 <= wall[i][j] <= 2³¹ - 1 
// 
// Related Topics 数组 哈希表 👍 283 👎 0

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P554_BrickWall{
    public static void main(String[] args) {
        Solution solution = new P554_BrickWall().new Solution();
        int[][] arr = new int[][]{{1,2,2,1},{3,1,2},{1,3,2},{2,4},{3,1,2},{1,3,1,1}};
        List<List<Integer>> wall = new ArrayList<>();
        for (int[] ints : arr) {
            List<Integer> row = new ArrayList<>();
            for (int anInt : ints) {
                row.add(anInt);
            }
            wall.add(row);
        }
        solution.leastBricks(wall);
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 哈希表思路很简单，对每个行数组找出缝隙的位置，
     * 统计每行所有缝隙的出现次数，缝隙最多的自然就是穿过砖数最少的
     * @param wall
     * @return
     */
    public int leastBricks(List<List<Integer>> wall) {
//        int sumWidth = 0;
//        for (Integer integer : wall.get(0)) {
//            sumWidth += integer;
//        }
        int rowLen = wall.size();
        HashMap<Integer,Integer> map = new HashMap<>();
        for (List<Integer> row : wall) {
            int cur = 0;
            int size = row.size();
            for (int i = 0; i < size-1; i++) {//除去最后一块砖
                cur += row.get(i);
                map.put(cur,map.getOrDefault(cur,0)+1);
            }
        }
        int max = 0;
        int maxKey = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (max < entry.getValue()){
                max = entry.getValue();
                maxKey = entry.getKey();
            }
        }
        //看清楚题目要求什么啊！！！！题目要看500遍！！！
        return rowLen-max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}