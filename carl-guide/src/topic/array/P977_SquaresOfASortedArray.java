package topic.array;

//给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。 
//
// 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-4,-1,0,3,10]
//输出：[0,1,9,16,100]
//解释：平方后，数组变为 [16,1,0,9,100]
//排序后，数组变为 [0,1,9,16,100] 
//
// 示例 2： 
//
// 
//输入：nums = [-7,-3,2,3,11]
//输出：[4,9,9,49,121]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁴ 
// -10⁴ <= nums[i] <= 10⁴ 
// nums 已按 非递减顺序 排序 
// 
//
// 
//
// 进阶： 
//
// 
// 请你设计时间复杂度为 O(n) 的算法解决本问题 
// 
// Related Topics 数组 双指针 排序 👍 373 👎 0

import com.google.gson.Gson;

public class P977_SquaresOfASortedArray {
    public static void main(String[] args) {
        Solution solution = new P977_SquaresOfASortedArray().new Solution();
        int[] nums = {-4,-1,0,0,3,10};
        solution.sortedSquares2(nums);
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] sortedSquares(int[] nums) {
        int len = nums.length;
        //非严格递增的数组
        //如果都是同号（或有0）就不用比了
        if (nums[0] >= 0 || nums[len-1]<=0){
            return nums;
        }

        //思路，看有没有0做分界线，可能有0个或多个0，
        //可以保证一定是有0有正的，（可能有负数，也可能只有00123这样
        //p指向第一个正数
        int p = 0;
        int q = 0;
        while (nums[p] <= 0){
            if (nums[p] == 0){
                q++;
            }
            p++;
        }

        int zl = p-q;
        int zr = p;

        int[] sqrt = new int[nums.length];
        //说明正数的臂长长,或左右一样长
        //则用短的臂去插入长的
        if (zl <= len-zr){
            int j = len-1;
            for (int i = 0; i < zl; i++) {
                if ((Math.abs(nums[i]) < Math.abs(nums[j])) && (Math.abs(nums[i]) > Math.abs(nums[j-1]))){
                    //插入，但数组不能插入只能平移。。也没法交换
                    //那只能用插入排序了，新建一个等长数组，

                }

            }

        }else {
            for (int j = len-1; j < (len - zr); j++) {

            }
        }

        System.out.println(p + "," + q);
        System.out.println(zl + "," + zr);
        return nums;
    }

    /**
     * 官方解法，双指针法-左右指针
     * @param nums
     * @return
     */
    public int[] sortedSquares2(int[] nums) {
        int len = nums.length;
        int[] sqrt = new int[len];
        int i = 0;
        int j = len -1;
        //新数组的指针
        int q = len-1;
        while (i < j){
            sqrt[q--] = nums[(Math.abs(nums[i])>Math.abs(nums[j]))?i++:j--];
        }
        //System.out.println(new Gson().toJson(sqrt));
        return nums;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}