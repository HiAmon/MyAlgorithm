package topic.array;

//给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。 
//
// 返回这三个数的和。 
//
// 假定每组输入只存在恰好一个解。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,2,1,-4], target = 1
//输出：2
//解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,0,0], target = 1
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 3 <= nums.length <= 1000 
// -1000 <= nums[i] <= 1000 
// -10⁴ <= target <= 10⁴ 
// 
// Related Topics 数组 双指针 排序 👍 1146 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P16_ThreeSumClosest{
    public static void main(String[] args) {
        Solution solution = new P16_ThreeSumClosest().new Solution();
        int[] nums = new int[]{-1,2,1,-4};
        System.out.println(solution.threeSumClosest_guanfang(nums,1));
        System.out.println(solution.threeSumClosest_2(nums,1));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {


    public int threeSumClosest_guanfang(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int best = 10000000;

        // 枚举 a
        for (int i = 0; i < n; ++i) {
            // 保证和上一次枚举的元素不相等
//            if (i > 0 && nums[i] == nums[i - 1]) {
//                continue;
//            }
            // 使用双指针枚举 b 和 c
            int j = i + 1, k = n - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == target) {
                    return target;
                }
                // 根据差值的绝对值来更新答案
                best = Math.abs(sum - target) < Math.abs(best - target)?sum:best;
//
//                if (Math.abs(sum - target) < Math.abs(best - target)) {
//                    best = sum;
//                }


                if (sum > target) {
                    // 如果和大于 target，移动 c 对应的指针
//                    int k0 = k - 1;
//                    // 移动到下一个不相等的元素
//                    while (j < k0 && nums[k0] == nums[k]) {
//                        --k0;
//                    }
//                    k = k0;
                    k--;
                } else {
                    // 如果和小于 target，移动 b 对应的指针
//                    int j0 = j + 1;
//                    // 移动到下一个不相等的元素
//                    while (j0 < k && nums[j0] == nums[j]) {
//                        ++j0;
//                    }
//                    j = j0;
                    j++;
                }
            }
        }
        return best;
    }
    /**
     * 用双指针来代替内双层循环
     * 外循环用来遍历
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest_2(int[] nums, int target) {
        int result = Integer.MAX_VALUE;//!!!这里不能赋值为0，因为0可能是个离target更近的值
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int j = i+1;//j左指针
            int k = nums.length-1;//k右指针
            //左右指针，指针碰撞则结束
            while (j < k){
                int sum = nums[i] + nums[j] + nums[k];

                result = Math.abs(sum-target)<Math.abs(result-target)?sum:result;

                if (sum == target){
                    return sum;
                }
                if (sum > target){
                    //说明右指针大了
                    k--;
                }else {
                    //说明左指针小了
                    j++;
                }
            }
        }
        return result;
    }


    public int threeSumClosest_1(int[] nums, int target) {
        //难点：怎么在10个数里不重复的选三个数？
        int len = nums.length;
        if (len == 3){
            return nums[0] + nums[1] + nums[2];
        }
        List<Integer> res = new ArrayList<>();

        Arrays.sort(nums);
        if (nums[0] + nums[1] + nums[2] > target){
            return nums[0] + nums[1] + nums[2];
        }

        for (int i = 0; i < len; i++) {
            for (int j = i+1; j < len-1; j++) {
                if (nums[i] + nums[j] + nums[j+1] > target){
                    res.add(nums[i] + nums[j] + nums[j+1]);
                    break;
                }
                for (int k = j+1; k < len; k++) {
                    if (nums[i] + nums[j] + nums[k] == target){
                        return nums[i] + nums[j] + nums[k];
                    }
                    res.add(nums[i]+nums[j]+nums[k]);
                }
            }
        }
        res.sort((o1, o2) -> (o1-o2));
        for (int i = 0; i < res.size()-1; i++) {
            if (res.get(i) <= target && res.get(i+1) >= target){
                if ((target - res.get(i)) >= (res.get(i + 1) - target)){
                    return res.get(i+1);
                }else {
                    return res.get(i);
                }
            }
        }
        if (res.get(res.size()-1) < target){
            return res.get(res.size()-1);
        }
        if (res.get(0) > target){
            return res.get(0);
        }
        return Integer.MIN_VALUE;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}