package topic.array;

//当 k 个日程安排有一些时间上的交叉时（例如 k 个日程安排都在同一时间内），就会产生 k 次预订。 
//
// 给你一些日程安排 [start, end) ，请你在每个日程安排添加后，返回一个整数 k ，表示所有先前日程安排会产生的最大 k 次预订。 
//
// 实现一个 MyCalendarThree 类来存放你的日程安排，你可以一直添加新的日程安排。 
//
// 
// MyCalendarThree() 初始化对象。 
// int book(int start, int end) 返回一个整数 k ，表示日历中存在的 k 次预订的最大值。 
// 
//
// 
//
// 示例： 
//
// 
//输入：
//["MyCalendarThree", "book", "book", "book", "book", "book", "book"]
//[[], [10, 20], [50, 60], [10, 40], [5, 15], [5, 10], [25, 55]]
//输出：
//[null, 1, 1, 2, 3, 3, 3]
//
//解释：
//MyCalendarThree myCalendarThree = new MyCalendarThree();
//myCalendarThree.book(10, 20); // 返回 1 ，第一个日程安排可以预订并且不存在相交，所以最大 k 次预订是 1 次预订。
//myCalendarThree.book(50, 60); // 返回 1 ，第二个日程安排可以预订并且不存在相交，所以最大 k 次预订是 1 次预订。
//myCalendarThree.book(10, 40); // 返回 2 ，第三个日程安排 [10, 40) 与第一个日程安排相交，所以最大 k 次预订是
// 2 次预订。
//myCalendarThree.book(5, 15); // 返回 3 ，剩下的日程安排的最大 k 次预订是 3 次预订。
//myCalendarThree.book(5, 10); // 返回 3
//myCalendarThree.book(25, 55); // 返回 3
// 
//
// 
//
// 提示： 
//
// 
// 0 <= start < end <= 10⁹ 
// 每个测试用例，调用 book 函数最多不超过 400次 
// 
// Related Topics 设计  有序集合 👍 85 👎 0

import java.util.SortedMap;
import java.util.TreeMap;

public class P732_MyCalendarIii{
    public static void main(String[] args) {
//        Solution solution = new P732_MyCalendarIii().new Solution();
        MyCalendarThree myCalendarThree = new MyCalendarThree();
        myCalendarThree.book(10, 20); // 返回 1 ，第一个日程安排可以预订并且不存在相交，所以最大 k 次预订是 1 次预订。
        myCalendarThree.book(50, 60); // 返回 1 ，第二个日程安排可以预订并且不存在相交，所以最大 k 次预订是 1 次预订。
        myCalendarThree.book(10, 40); // 返回 2 ，第三个日程安排 [10, 40) 与第一个日程安排相交，所以最大 k 次预订是 2 次预订。
        myCalendarThree.book(5, 15); // 返回 3 ，剩下的日程安排的最大 k 次预订是 3 次预订。
        myCalendarThree.book(5, 10); // 返回 3
        myCalendarThree.book(25, 55); // 返回 3

        myCalendarThree.book(40, 60); // 返回 3
        System.out.println(myCalendarThree.book(45, 55)); // 返回 3

    }

//leetcode submit region begin(Prohibit modification and deletion)
    //复习一下线段树和单调栈

    /**
     * 当我们预定一个新的日程安排 [start, end)，则执行 delta[start]++ 和 delta[end]--。
     * 其中 delta 是按照 key 值从小到大排序的结构，我们用 active 来记录当前正在进行的日程安排数，
     * 当 active>=3 时，说明产生了三重预定。
     *
     * Cm. 不一定要用TreeMap吧？只是需要「有序map」吧，只是Java中的默认的SortedMap的实现类刚好只有TreeMap
     */
   static class MyCalendarThree {
        TreeMap<Integer, Integer> delta;
        public MyCalendarThree() {
            delta = new TreeMap();
        }

        public int book(int start, int end) {
            delta.put(start, delta.getOrDefault(start, 0) + 1);
            delta.put(end, delta.getOrDefault(end, 0) - 1);
            //[10, 20], [50, 60], [10, 40], [5, 15], [5, 10], [25, 55]

            int active = 0;
            int k = 0;
            for (int d: delta.values()) {
                active += d;
                if (active > k) k = active;
            }
            return k;
        }
    }

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(start,end);
 */
//leetcode submit region end(Prohibit modification and deletion)

}