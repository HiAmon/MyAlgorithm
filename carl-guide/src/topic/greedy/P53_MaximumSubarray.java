package topic.greedy;

//给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。 
//
// 子数组 是数组中的一个连续部分。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
//输出：6
//解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：nums = [5,4,-1,7,8]
//输出：23
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// 
//
// 进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。 
// Related Topics 数组 分治 动态规划 👍 4318 👎 0

public class P53_MaximumSubarray{
    public static void main(String[] args) {
        Solution solution = new P53_MaximumSubarray().new Solution();
//        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int[] nums = {5,4,-1,7,8};
        int res = solution.maxSubArray1(nums);
        int res2 = solution.maxSubArray2(nums);
        System.out.println(res);
        System.out.println(res2);
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxSubArray1(int[] nums) {
        /**
         * 贪心算法：
         * ~~从左往右加，遇到总和是负数，就把左边所有负数和负数以左的部分丢弃~~
         * ~~局部最优：当前和是正数~~
         * ~~全局最优：结果数组内能得到最大的总和~~
         *
         * ⬆ 此方法不可行🙅，比如[100,-99,3],此方法只是求出了正数4，没有求出最大数100
         */

        if (nums.length == 1){
            return nums[0];
        }
        //i和j是左闭右闭
        int i = 0;
        int j = 0;
        int sum = nums[0];
        int max = sum;
        //赋值公式待优化
        while (j < nums.length -1){
            if (sum >= 0){
                //i不动
                j++;
                sum += nums[j];
            }else /* (sum < 0) */{
                j++;
                sum = nums[j];
                i = j;
            }
            j++;
            sum += nums[j];
            if (sum > max){
                max = sum;
            }
        }
        return max;
    }

    /**
     * 官方解法，不需要双指针啦，一个变量就可以啦
     * 更优化更简洁了
     * @param nums
     * @return
     */
    public int maxSubArray2(int[] nums) {
        if (nums.length <= 1){
            return nums[0];
        }
        int max = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            max = Math.max(max,sum);
            if (sum <= 0){
                sum = 0;
            }
        }
        return max;
    }
}

//leetcode submit region end(Prohibit modification and deletion)

}