package topic.queue;

//设计实现双端队列。 
//
// 实现 MyCircularDeque 类: 
//
// 
// MyCircularDeque(int k) ：构造函数,双端队列最大为 k 。 
// boolean insertFront()：将一个元素添加到双端队列头部。 如果操作成功返回 true ，否则返回 false 。 
// boolean insertLast() ：将一个元素添加到双端队列尾部。如果操作成功返回 true ，否则返回 false 。 
// boolean deleteFront() ：从双端队列头部删除一个元素。 如果操作成功返回 true ，否则返回 false 。 
// boolean deleteLast() ：从双端队列尾部删除一个元素。如果操作成功返回 true ，否则返回 false 。 
// int getFront() )：从双端队列头部获得一个元素。如果双端队列为空，返回 -1 。 
// int getRear() ：获得双端队列的最后一个元素。 如果双端队列为空，返回 -1 。 
// boolean isEmpty() ：若双端队列为空，则返回 true ，否则返回 false 。 
// boolean isFull() ：若双端队列满了，则返回 true ，否则返回 false 。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入
//["MyCircularDeque", "insertLast", "insertLast", "insertFront", "insertFront", 
//"getRear", "isFull", "deleteLast", "insertFront", "getFront"]
//[[3], [1], [2], [3], [4], [], [], [], [4], []]
//输出
//[null, true, true, true, false, 2, true, true, true, 4]
//
//解释
//MyCircularDeque circularDeque = new MycircularDeque(3); // 设置容量大小为3
//circularDeque.insertLast(1);			        // 返回 true
//circularDeque.insertLast(2);			        // 返回 true
//circularDeque.insertFront(3);			        // 返回 true
//circularDeque.insertFront(4);			        // 已经满了，返回 false
//circularDeque.getRear();  				// 返回 2
//circularDeque.isFull();				        // 返回 true
//circularDeque.deleteLast();			        // 返回 true
//circularDeque.insertFront(4);			        // 返回 true
//circularDeque.getFront();				// 返回 4
//  
//
// 
//
// 提示： 
//
// 
// 1 <= k <= 1000 
// 0 <= value <= 1000 
// insertFront, insertLast, deleteFront, deleteLast, getFront, getRear, isEmpty,
// isFull 调用次数不大于 2000 次 
// 
// Related Topics 设计 队列 数组 链表 👍 118 👎 0

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.DelayQueue;

public class P641_DesignCircularDeque{
    public static void main(String[] args) {
        //Your MyCircularDeque object will be instantiated and called as such:



    }

//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 这是【循环】双端队列，加到队尾满了的话是要加到队头的，不是满了就false就可以了的，要注意
     * 所以设计capacity需要留出一位。且队为满不是head=tail就可以了，而是要：
     * (tail + 1) % capacity == front;
     * 留出一位就是为了保证这个「tail+1」不会溢出到队头变成head=tail，保证区分队空和队满的情况
     *
     * 但是也可以用一个emptyFlag来标识队空和满的状态，这样就不用额外留一个，更好理解，但是前者更方便和巧妙
     */
    static class MyCircularDeque {
    int[] values;
    int head = -1;
    int tail = -1;
    int capacity;

    public MyCircularDeque(int k) {
        capacity = k;
        values = new int[k];
        head = 0;
        tail = 0;
    }
    
    public boolean insertFront(int value) {
        if (isFull() || head == 0){
            return false;
        }
        values[head] = value;
        head++;
        return true;
    }
    
    public boolean insertLast(int value) {
        if (isFull() || tail == capacity-1){
            return false;
        }
        values[tail] = value;
        tail++;
        return true;
    }
    
    public boolean deleteFront() {
        if (head == 0 || isEmpty()){
            return false;
        }
        head--;
        return true;
    }
    
    public boolean deleteLast() {
        if (canNotDelete()){
            return false;
        }
        tail--;
        return true;
    }
    
    public int getFront() {
        if (isEmpty()){
            return -1;
        }
        return values[head];
    }
    
    public int getRear() {
        if (isEmpty()){
            return -1;
        }
        return values[tail];
    }
    
    public boolean isEmpty() {
        if (head == tail){
            return true;
        }
        return false;
    }
    
    public boolean isFull() {
        if (head == 0 && tail == capacity-1){
            return true;
        }
        return false;
    }

    public boolean canNotDelete(){
        if (head == 0 || tail == 0){
            return false;
        }
        return true;
    }
}

//加了注释，用于理解ArrayDeque中同名方法的>>>操作
class ArrayDequeDemo{
    public  void main(String[] args) {
        int initialCapacity = 8;
        // Find the best power of two to hold elements.
        // Tests "<=" because arrays aren't kept full.
        if (9 >= initialCapacity) {
            initialCapacity = 9;//1001
            initialCapacity |= (initialCapacity >>>  1);//100｜1001=1101 11｜1101=1111
            initialCapacity |= (initialCapacity >>>  2);
            initialCapacity |= (initialCapacity >>>  4);
            initialCapacity |= (initialCapacity >>>  8);
            initialCapacity |= (initialCapacity >>> 16);
            initialCapacity++;//1111+1=10000 和二次幂对齐了

            if (initialCapacity < 0)   // Too many elements, must back off
                initialCapacity >>>= 1;// Good luck allocating 2 ^ 30 elements
        }
        System.out.println(initialCapacity);
    }
}

//leetcode submit region end(Prohibit modification and deletion)

}