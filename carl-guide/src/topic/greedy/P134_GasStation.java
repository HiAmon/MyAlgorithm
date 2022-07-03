package topic.greedy;

//在一条环路上有 N 个加油站，其中第 i 个加油站有汽油 gas[i] 升。 
//
// 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。 
//
// 如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1。 
//
// 说明: 
//
// 
// 如果题目有解，该答案即为唯一答案。 
// 输入数组均为非空数组，且长度相同。 
// 输入数组中的元素均为非负数。 
// 
//
// 示例 1: 
//
// 输入: 
//gas  = [1,2,3,4,5]
//cost = [3,4,5,1,2]
//
//输出: 3
//
//解释:
//从 3 号加油站(索引为 3 处)出发，可获得 4 升汽油。此时油箱有 = 0 + 4 = 4 升汽油
//开往 4 号加油站，此时油箱有 4 - 1 + 5 = 8 升汽油
//开往 0 号加油站，此时油箱有 8 - 2 + 1 = 7 升汽油
//开往 1 号加油站，此时油箱有 7 - 3 + 2 = 6 升汽油
//开往 2 号加油站，此时油箱有 6 - 4 + 3 = 5 升汽油
//开往 3 号加油站，你需要消耗 5 升汽油，正好足够你返回到 3 号加油站。
//因此，3 可为起始索引。 
//
// 示例 2: 
//
// 输入: 
//gas  = [2,3,4]
//cost = [3,4,3]
//
//输出: -1
//
//解释:
//你不能从 0 号或 1 号加油站出发，因为没有足够的汽油可以让你行驶到下一个加油站。
//我们从 2 号加油站出发，可以获得 4 升汽油。 此时油箱有 = 0 + 4 = 4 升汽油
//开往 0 号加油站，此时油箱有 4 - 3 + 2 = 3 升汽油
//开往 1 号加油站，此时油箱有 3 - 3 + 3 = 3 升汽油
//你无法返回 2 号加油站，因为返程需要消耗 4 升汽油，但是你的油箱只有 3 升汽油。
//因此，无论怎样，你都不可能绕环路行驶一周。 
// Related Topics 贪心 数组 👍 832 👎 0

import java.util.Arrays;
import java.util.List;

public class P134_GasStation{
    public static void main(String[] args) {
        Solution solution = new P134_GasStation().new Solution();
        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};
//        int i = solution.canCompleteCircuit(gas, cost);
//        int i = solution.canCompleteCircuit2(gas, cost);
        int i = solution.canCompleteCircuit3(gas, cost);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 贪心和暴力解混在一起了，不太行
         * @param gas
         * @param cost
         * @return
         */
        public int canCompleteCircuit(int[] gas, int[] cost) {
            int gasSum = 0;
            int costSum = 0;
            for (int i = 0; i < gas.length; i++) {
                gasSum += gas[i];
                costSum += cost[i];
            }
            if (gasSum < costSum){
                return -1;
            }
            int[] sub = new int[gas.length];
            for (int i = 0; i < gas.length; i++) {
                sub[i] = gas[i] - cost[i];
            }

            int sum = 0;

            //begin：出发点，每个站作为一次出发点
            for (int begin = 0; begin < sub.length-1; begin++) {
                int circle = 0; //控制旋转数，作为循环保证，假如len=5，circle=5，只能走5次，不能多走
                int t = begin; //t作为指针
                while (circle < sub.length -1 ){
                    if (t == sub.length-1){
                        t = 0;//手动制造循环
                    }
                    sum += sub[t];
                    //如果在此之前的差值都是负数，当前是正数，且油量总数大于总消耗量，说明一定能走完，后面的正数一定能和前面的负数抵消
                    if ((sum < 0) && sub[t] > 0){
                        return t;
                    }
                    circle++;
                }
            }
            return -1;
        }

        /**
         * 官方解法一：总结规律
         * 1、sum(gas)-sum(cost) < 0，则直接失败
         * 2、rest[i] = gas[i]-cost[i]，先从零出发，如果rest[i]全程都大于0，说明从0出发不会断油
         * 3、如果过程中rest[i] < 0了，就看后面哪个节点能把这个负数填平，这个节点就是出发点
         * @param gas
         * @param cost
         * @return
         */
        public int canCompleteCircuit2(int[] gas, int[] cost){
            int curSum = 0;
            int min = Integer.MAX_VALUE; // 从起点出发，油箱里的油量最小值
            for (int i = 0; i < gas.length; i++) {
                int rest = gas[i] - cost[i];
                curSum += rest;
                if (curSum < min) {
                    min = curSum;
                }
            }
            if (curSum < 0) return -1;  // 情况1
            if (min >= 0) return 0;     // 情况2
            // 情况3
            for (int i = gas.length - 1; i >= 0; i--) {
                int rest = gas[i] - cost[i];
                min += rest;
                if (min >= 0) {
                    return i;
                }
            }
            return -1;
        }


        /**
         * 官方解法：
         * 正经贪心算法：
         * 局部最优：当前剩余油量累加 <0,说明当前范围内的站都不能作为出发站，出发站一定在后面的站里
         * 全局最优：找到能作为出发站的站
         * @param gas
         * @param cost
         * @return
         */
        public int canCompleteCircuit3(int[] gas, int[] cost){
            if (Arrays.stream(gas).sum() < Arrays.stream(cost).sum()){
                return -1;
            }
            //剩余油量数组
            int sum = 0; //跑完当前路程，当前累计剩余油量，如果已经是负数了，那么从下一个站出发重新开始，
            int begin = 0;
            for (int i = 0; i < gas.length; i++) {
                sum += gas[i] - cost[i];
                if (sum < 0){
                    begin = (i+1) % gas.length; //取模 也可以不取
                    sum = 0; //当前累计剩余油量要归零，因为要从下个站重新开始了
                }
            }
            return begin;
        }

        public int canCompleteCircuit4(int[] gas, int[] cost){
            int curSum = 0;
            int totalSum = 0;
            int index = 0;
            for (int i = 0; i < gas.length; i++) {
                curSum += gas[i] - cost[i];
                totalSum += gas[i] - cost[i];
                if (curSum < 0) {
                    index = (i + 1) % gas.length ;
                    curSum = 0;
                }
            }
            if (totalSum < 0) return -1;
            return index;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}