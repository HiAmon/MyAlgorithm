package topic.greedy;

//给定一个区间的集合 intervals ，其中 intervals[i] = [starti, endi] 。返回 需要移除区间的最小数量，使剩余区间互不重
//叠 。 
//
// 
//
// 示例 1: 
//
// 
//输入: intervals = [[1,2],[2,3],[3,4],[1,3]]
//输出: 1
//解释: 移除 [1,3] 后，剩下的区间没有重叠。
// 
//
// 示例 2: 
//
// 
//输入: intervals = [ [1,2], [1,2], [1,2] ]
//输出: 2
//解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
// 
//
// 示例 3: 
//
// 
//输入: intervals = [ [1,2], [2,3] ]
//输出: 0
//解释: 你不需要移除任何区间，因为它们已经是无重叠的了。
// 
//
// 
//
// 提示: 
//
// 
// 1 <= intervals.length <= 10⁵ 
// intervals[i].length == 2 
// -5 * 10⁴ <= starti < endi <= 5 * 10⁴ 
// 
// Related Topics 贪心 数组 动态规划 排序 👍 599 👎 0

public class P435_NonOverlappingIntervals{
    public static void main(String[] args) {
        Solution solution = new P435_NonOverlappingIntervals().new Solution();
        
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 贪心策略
         * 先按照 区间左端从左到右顺序，区间长度从短到长顺序
         * 一个指针指向当前覆盖范围的右端，如果下一个区间的右侧在这个指针左边（也就是重复了），就把这个区间干掉（res++）
         *
         *
         * todo 应该是懒得写了，以后有兴趣可以写一下
         * @param intervals
         * @return
         */
        public int eraseOverlapIntervals(int[][] intervals) {
            return 0;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}