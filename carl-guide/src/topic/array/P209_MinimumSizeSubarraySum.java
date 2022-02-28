package topic.array;

//给定一个含有 n 个正整数的数组和一个正整数 target 。
//
// 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长
//度。如果不存在符合条件的子数组，返回 0 。
//
//
//
// 示例 1：
//
//
//输入：target = 7, nums = [2,3,1,2,4,3]
//输出：2
//解释：子数组 [4,3] 是该条件下的长度最小的子数组。
//
//
// 示例 2：
//
//
//输入：target = 4, nums = [1,4,4]
//输出：1
//
//
// 示例 3：
//
//
//输入：target = 11, nums = [1,1,1,1,1,1,1,1]
//输出：0
//
//
//
//
// 提示：
//
//
// 1 <= target <= 10⁹
// 1 <= nums.length <= 10⁵
// 1 <= nums[i] <= 10⁵
//
//
//
//
// 进阶：
//
//
// 如果你已经实现 O(n) 时间复杂度的解法, 请尝试设计一个 O(n log(n)) 时间复杂度的解法。
//
// Related Topics 数组 二分查找 前缀和 滑动窗口 👍 883 👎 0

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

public class P209_MinimumSizeSubarraySum{
    public static void main(String[] args) {
        Solution solution = new P209_MinimumSizeSubarraySum().new Solution();
        int[] nums = {1,4,4};
        System.out.println(solution.minSubArrayLen2(4,nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minSubArrayLen(int target, int[] nums) {
            //看到"连续子数组"这几个字，基本上就和滑动窗口有关了

            //用双指针框住一个滑动窗口

            int i = 0;
            int j = 0;
            int sum = 0;
            while (j < nums.length - 1) {
                for (int p = i; p <= j; p++) {
                    sum += nums[p];
                }
                if (sum >= target) {
                    return j - i + 1;
                }

            }

            return -1;
        }

        /**
         * 官方解法：滑动窗口
         * 思路：
         * 1.窗口内条件
         * 2.当窗口内未达到条件时窗口扩张
         * 3.当窗口内超过条件时窗口右移
         *
         * @param target
         * @param nums
         * @return
         */
        public int minSubArrayLen2(int target, int[] nums) {
            int i = 0;
            int j = 0;
            int sum = nums[0];
            int len = nums.length+1;
            while (j < nums.length) {
                if (sum < target){
                    if (j== nums.length-1){
                        break;
                    }
                    sum += nums[++j];
                }else {
                    len = Math.min(j-i+1,len);
                    sum -= nums[i++];
                }
            }
            return len> nums.length?-1:len;
        }

    //leetcode submit region end(Prohibit modification and deletion)
    }
}