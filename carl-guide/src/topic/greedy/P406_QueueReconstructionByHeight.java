package topic.greedy;

//假设有打乱顺序的一群人站成一个队列，数组 people 表示队列中一些人的属性（不一定按顺序）。每个 people[i] = [hi, ki] 表示第 i 
//个人的身高为 hi ，前面 正好 有 ki 个身高大于或等于 hi 的人。 
//
// 请你重新构造并返回输入数组 people 所表示的队列。返回的队列应该格式化为数组 queue ，其中 queue[j] = [hj, kj] 是队列中第
// j 个人的属性（queue[0] 是排在队列前面的人）。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入：people = [[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]
//输出：[[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]]
//解释：
//编号为 0 的人身高为 5 ，没有身高更高或者相同的人排在他前面。
//编号为 1 的人身高为 7 ，没有身高更高或者相同的人排在他前面。
//编号为 2 的人身高为 5 ，有 2 个身高更高或者相同的人排在他前面，即编号为 0 和 1 的人。
//编号为 3 的人身高为 6 ，有 1 个身高更高或者相同的人排在他前面，即编号为 1 的人。
//编号为 4 的人身高为 4 ，有 4 个身高更高或者相同的人排在他前面，即编号为 0、1、2、3 的人。
//编号为 5 的人身高为 7 ，有 1 个身高更高或者相同的人排在他前面，即编号为 1 的人。
//因此 [[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]] 是重新构造后的队列。
// 
//
// 示例 2： 
//
// 
//输入：people = [[6,0],[5,0],[4,0],[3,2],[2,2],[1,4]]
//输出：[[4,0],[5,0],[2,2],[3,2],[1,4],[6,0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= people.length <= 2000 
// 0 <= hi <= 10⁶ 
// 0 <= ki < people.length 
// 题目数据确保队列可以被重建 
// 
// Related Topics 贪心 数组 排序 👍 1126 👎 0

import com.google.gson.Gson;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class P406_QueueReconstructionByHeight{
    public static void main(String[] args) {
        Solution solution = new P406_QueueReconstructionByHeight().new Solution();
        int[][] people = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}}; //7行2列
        int[][] queue = solution.reconstructQueue(people);
        System.out.println(new Gson().toJson(queue));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 官方思路：
     * ▲ 有两个维度，h和k，身高和相对位置。 --> 一定要试算 来确定一个维度作为排序标准（本题选中h作为预排标准）
     *
     * 贪心策略：
     * 子问题：当前元素放到正确的相对位置上 （局部有序/拓扑有序）
     * 策略：根据h预排序待插元素，再根据k顺序进行插入排序
     * 最优解/可行解：
     * 组装：
     *
     * ======================
     * 插入的过程：⬇⬇⬇
     *
     * 插入[7,0]：[[7,0]]
     * 插入[7,1]：[[7,0],[7,1]]
     * 插入[6,1]：[[7,0],[6,1],[7,1]]
     * 插入[5,0]：[[5,0],[7,0],[6,1],[7,1]]
     * 插入[5,2]：[[5,0],[7,0],[5,2],[6,1],[7,1]]
     * 插入[4,4]：[[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]]
     *
     * @param people
     * @return
     */
    public int[][] reconstructQueue(int[][] people) {

        Arrays.sort(people, (o1, o2) -> {
            //不要忘了相等的情况,   people[i] = [hi, ki]
            return (o1[0]== o2[0]) ? (o1[1]-o2[1]) : (o2[0]-o1[0]);
        });

        LinkedList<int[]> list = new LinkedList<>();
        for (int[] p : people) {
            list.add(p[1],p);//[7,0],[7,1][6,1][5,0]
        }
        return list.toArray(new int[people.length][]); //!!! 这种写法 #mark！
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}