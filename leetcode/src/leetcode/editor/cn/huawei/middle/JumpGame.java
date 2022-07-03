package leetcode.editor.cn.huawei.middle;

public class JumpGame {
    public static void main(String[] args) {
        int[] nums = new int[]{2,3,1,1,4,1,1,8,3,4,5,1};
        JumpGame jumpGame = new JumpGame();
        int i = jumpGame.canJump(nums);
        System.out.println(i);
    }

    /**
     * 贪心算法，每次选出当下最优解，最后聚集成整体最优解
     * @param nums
     * @return
     */
    public int canJump(int[] nums){
        //maxP表示最优跳跃点
        int maxIndex = 0;
        //表示当前跳跃点的选择区间的右端点
        int end = 0;
        int steps = 0;
        for (int i = 0; i < nums.length-1; i++) {
            //选出当前选择区间内能跳到最远的点的下标
            maxIndex = Math.max(maxIndex, nums[i]+i);
            if (i==end){
                //修改选择区间右端点为跳到最远的点
                end = maxIndex;
                steps++;
            }
        }
        return steps;
    }

    public int canJumpOld(int[] nums) {

        int next = 0;
        int steps = 0;
        for (int i = 0; i < nums.length-1; i++) {
            if (i==next){
                 next = getMax(nums,i);
                 steps++;
            }
        }
        return steps;
    }

    public int getMax(int[] nums, int i){
        int max = nums[i];
        for (int j = i+1; j <= i+nums[i]; j++) {
            max = Math.max(max,nums[j]);
        }
        return max;
    }
}
