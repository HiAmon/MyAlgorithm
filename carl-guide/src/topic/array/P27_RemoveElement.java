package topic.array;

//给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。 
//
// 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。 
//
// 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。 
//
// 
//
// 说明: 
//
// 为什么返回数值是整数，但输出的答案是数组呢? 
//
// 请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。 
//
// 你可以想象内部操作如下: 
//
// 
//// nums 是以“引用”方式传递的。也就是说，不对实参作任何拷贝
//int len = removeElement(nums, val);
//
//// 在函数里修改输入数组对于调用者是可见的。
//// 根据你的函数返回的长度, 它会打印出数组中 该长度范围内 的所有元素。
//for (int i = 0; i < len; i++) {
//    print(nums[i]);
//}
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [3,2,2,3], val = 3
//输出：2, nums = [2,2]
//解释：函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。你不需要考虑数组中超出新长度后面的元素。例如，函数返回的新长度为 2 ，而 
//nums = [2,2,3,3] 或 nums = [2,2,0,0]，也会被视作正确答案。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1,2,2,3,0,4,2], val = 2
//输出：5, nums = [0,1,4,0,3]
//解释：函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。注意这五个元素可为任意顺序。你不需要考虑数组中超出新长度后面
//的元素。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 100 
// 0 <= nums[i] <= 50 
// 0 <= val <= 100 
// 
// Related Topics 数组 双指针 👍 1120 👎 0

import com.google.gson.Gson;

public class P27_RemoveElement {
    public static void main(String[] args) {
        Solution solution = new P27_RemoveElement().new Solution();
        int[] nums = {0,1,2,2,3,0,4,2};
        int val = 2;
//        System.out.println("左右指针法个人写法：" + solution.removeElement1(nums,val));
//        System.out.println("快慢指针法个人优化写法：" + solution.removeElement2(nums,val));
        System.out.println("快慢指针法官方标答：" + solution.removeElement3(nums,val));
//        System.out.println("快慢指针法个人原始写法：" + solution.removeElement4(nums,val));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int removeElement1(int[] nums, int val) {
        /**
         * 方法一：左右指针
         * 即i，j指针相向而行，当指针重合或碰过则结束
         * 左右指针在遇到各情况时交换元素
         */
        int i = 0;
        int j = nums.length-1;
        while(i<j){
            if ((nums[i]==val && nums[j]!= val)){
                swap(nums,i++,j--);
            }
            //todone 此处可以优化if条件
//            if (nums[i]!=val && nums[j] == val){
//                i++;
//                j--;
//            }
//            if (nums[i]!=val && nums[j] != val){
//                i++;
//            }
//            if (nums[i]==val && nums[j] == val){
//                j--;
//            }

            //=======
            if (nums[j] == val){
                j--;
            }
            if (nums[i]!=val){
                i++;
            }
        }
        System.out.println(new Gson().toJson(nums));
        return j;
    }

    public int removeElement2(int[] nums, int val) {
        /**
         * 快慢指针法：i，j指针同向而行
         * i指向第一个val值，j指向前方第一个非val值，交换
         */
        int i = 0;
        int j = 1;
        while (j < nums.length-1){
            if (nums[i]!=val){
                i++;
                j=i+1;
                if (j > nums.length-1){
                    System.out.println(new Gson().toJson(nums));
                    return i;
                }
            }
            if (nums[j]==val){
                j++;
            }
            //todo if条件待优化
            if (nums[i]==val && nums[j]!=val){
                swap(nums,i,j);
            }
        }
        System.out.println(new Gson().toJson(nums));
        return i;
    }

    public int removeElement3(int[] nums, int val) {
        /**
         * 官方写法
         *
         * 为什么slow不用被判断？
         * slow不是等于目标值时就要停下吗？
         * ——slow等于目标值时，和fast交换了，所以也可以继续往前走；
         * ——slow不等于目标值时，本来就要往前走；
         * 所以每次循环他都会往前走
         *
         */
        int fast = 0;
        int slow;
        for (slow = 0; fast < nums.length; fast++) {
            if (nums[fast] != val){//当slow,fast都不是目标值时，两人都往前走，直到两人一起遇到目标值；
                // 当遇到第一个目标值的时候，fast就把slow留在原地，自己往前走，
                // 当fast遇到非目标值的时候，fast就把自己这个非目标值赋给slow，然后fast,slow都往前走一步；
                nums[slow] = nums[fast];
                slow++;
                //可简写成：nums[slow++] = nums[fast];
            }
        }
        System.out.println(new Gson().toJson(nums));
        return slow;
    }

    public int removeElement4(int[] nums, int val) {
        /**
         * 快慢指针的原始解答（自己写的，双层循环，效率不高）
         */
        int i = 0;
        int j = 1;
        while (j < nums.length-1){
            while (nums[i]!=val){
                i++;
                j=i++;
            }
            while (nums[j]==val){
                j++;
                if (j > nums.length-1){
                    System.out.println(new Gson().toJson(nums));
                    return i;
                }
            }
            swap(nums,i,j);
        }
        System.out.println(new Gson().toJson(nums));
        return i;
    }

    public void swap(int[] nums, int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

//leetcode submit region end(Prohibit modification and deletion)

}