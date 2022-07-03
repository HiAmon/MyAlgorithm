package topic.array;

//给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否
//则返回 -1。 
//
// 
//示例 1: 
//
// 输入: nums = [-1,0,3,5,9,12], target = 9
//输出: 4
//解释: 9 出现在 nums 中并且下标为 4
// 
//
// 示例 2: 
//
// 输入: nums = [-1,0,3,5,9,12], target = 2
//输出: -1
//解释: 2 不存在 nums 中因此返回 -1
// 
//
// 
//
// 提示： 
//
// 
// 你可以假设 nums 中的所有元素是不重复的。 
// n 将在 [1, 10000]之间。 
// nums 的每个元素都将在 [-9999, 9999]之间。 
// 
// Related Topics 数组 二分查找 👍 531 👎 0

public class P704_BinarySearch {
    public static void main(String[] args) {
        Solution solution = new P704_BinarySearch().new Solution();
        int[] nums = {-1,0,3,5,9,12};
        int target = 12;
        int search = solution.search(nums, target);
        System.out.println(search);
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int search(int[] nums, int target) {
        /**
         * 左闭右闭写法，此时while循环是low<=high，而不是low<high，左右指针相等是有意义的，
         * 因为截半的时候没有保留mid本身，所有保留下来的区间是全部有意义的
         *
         * 参考：https://gitee.com/programmercarl/leetcode-master/blob/master/problems/0704.%E4%BA%8C%E5%88%86%E6%9F%A5%E6%89%BE.md#%E4%BA%8C%E5%88%86%E6%B3%95%E7%AC%AC%E4%B8%80%E7%A7%8D%E5%86%99%E6%B3%95
         */
        int low = 0;
        int high = nums.length - 1; //细心一点！！
        if (target < nums[0] || target > nums[nums.length-1]){
            return -1;
        }
        /**
         * n:数组的元素个数
         * n-1:数组末尾元素下标
         *
         * 则mid指针地址：
         * mid=Math.ceil( (n-1)/2 );    //ceil:向上取整
         * 或者
         * mid = Math.floor(n/2);   //floor:向下取整
         *
         * 循环第一次时，mid = (low+high)/2
         * 因为low取得是0，所以实际上用的是第一种——向上取整
         *
         * #cm 纸牌实验中，最简单的找中间指针位置的方法：如果是奇数张牌，取中间那个；如果是偶数张牌，去掉末尾牌取中间那个，然后取后面一张；
         */
        while (low <= high){
            int mid = low+(high-low) >> 1;//防溢出
            if (target == nums[mid]){
                return mid;
            }else if (target < nums[mid]){
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}