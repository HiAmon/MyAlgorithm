package topic.hashtable;

//实现一个 MyCalendar 类来存放你的日程安排。如果要添加的日程安排不会造成 重复预订 ，则可以存储这个新的日程安排。 
//
// 当两个日程安排有一些时间上的交叉时（例如两个日程安排都在同一时间内），就会产生 重复预订 。 
//
// 日程可以用一对整数 start 和 end 表示，这里的时间是半开区间，即 [start, end), 实数 x 的范围为， start <= x < 
//end 。 
//
// 实现 MyCalendar 类： 
//
// 
// MyCalendar() 初始化日历对象。 
// boolean book(int start, int end) 如果可以将日程安排成功添加到日历中而不会导致重复预订，返回 true 。否则，返回 
//false 并且不要将该日程安排添加到日历中。 
// 
//
// 
//
// 示例： 
//
// 
//输入：
//["MyCalendar", "book", "book", "book"]
//[[], [10, 20], [15, 25], [20, 30]]
//输出：
//[null, true, false, true]
//
//解释：
//MyCalendar myCalendar = new MyCalendar();
//myCalendar.book(10, 20); // return True
//myCalendar.book(15, 25); // return False ，这个日程安排不能添加到日历中，因为时间 15 已经被另一个日程安排预订了
//。
//myCalendar.book(20, 30); // return True ，这个日程安排可以添加到日历中，因为第一个日程安排预订的每个时间都小于 20
// ，且不包含时间 20 。 
//
// 
//
// 提示： 
//
// 
// 0 <= start < end <= 10⁹ 
// 每个测试用例，调用 book 方法的次数最多不超过 1000 次。 
// 
// Related Topics 设计 线段树 有序集合 👍 123 👎 0

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class P729_MyCalendarI{
    public static void main(String[] args) {
        MyCalendar myCalendar = new MyCalendar();
        boolean book = myCalendar.book(10, 20);// return True
        boolean book1 = myCalendar.book(15, 25);// return False ，这个日程安排不能添加到日历中，因为时间 15 已经被另一个日程安排预订了。
        boolean book2 = myCalendar.book(20, 30);// return True ，这个日程安排可以添加到日历中，因为第一个日程安排预订的每个时间都小于 20 ，且不包含时间 20 。
        System.out.println(myCalendar);
    }

//leetcode submit region begin(Prohibit modification and deletion)
static class MyCalendar {

    List<Pair> pairList;

    public MyCalendar() {
        pairList = new ArrayList<>();
    }

    public class Pair{
        private int min;
        private int max;

        public int getMin() {
            return min;
        }

        public int getMax() {
            return max;
        }


        public Pair(int min, int max) {
            this.min = min;
            this.max = max;
        }
    }
    
    public boolean book(int start, int end) {
        if (pairList.size() == 0){
            pairList.add(new Pair(start,end));
            return true;
        }
        //添加元素可以在foreach中添加(不然会报ConcurrentException)，
        //删除元素需要使用iterator来删除（不然会报checkForComodification）
        for (Pair pair : pairList) {
            if (pair.getMin() < end && start < pair.getMax()) {
                return false;
            }
        }
        pairList.add(new Pair(start,end));  //乌龙！！！这是单次预定，添加操作当然放在循环外面！！！
        return true;
    }
    /**
     * List<int[]> calendar;
     *
     *     MyCalendar() {
     *         calendar = new ArrayList();
     *     }
     *
     *     public boolean book(int start, int end) {
     *         for (int[] iv: calendar) {
     *             if (iv[0] < end && start < iv[1]) return false;
     *         }
     *         calendar.add(new int[]{start, end});
     *         return true;
     *     }
     */
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
//leetcode submit region end(Prohibit modification and deletion)

}