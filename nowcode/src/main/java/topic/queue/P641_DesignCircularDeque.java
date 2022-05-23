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
//        MyCircularDeque_GuanFang circularDeque = new MyCircularDeque_GuanFang(8); // 设置容量大小为3
        MyCircularDeque circularDeque = new MyCircularDeque(8); // 设置容量大小为3
        circularDeque.insertLast(1);			        // 返回 true
        circularDeque.insertLast(2);			        // 返回 true
        circularDeque.insertFront(3);			        // 返回 true
        circularDeque.insertFront(4);			        // 已经满了，返回 false
        int rear = circularDeque.getRear();// 返回 2
        boolean full = circularDeque.isFull();// 返回 true
        boolean b = circularDeque.deleteLast();// 返回 true
        circularDeque.insertFront(4);			        // 返回 true
        int front = circularDeque.getFront();


    }

//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 这是【循环】双端队列，加到队尾满了的话是要加到队头的，不是满了就false就可以了的，要注意
     * 【建议在草稿本上画一个圆环形的有裂口的队列，比较形象】
     * 所以设计capacity需要留出一位。且队为满不是head=tail就可以了，而是要：
     * (tail + 1) % capacity == front;
     * 留出一位就是为了保证这个「tail+1」不会溢出到队头变成head=tail，保证区分队空和队满的情况
     *
     * @https://leetcode.cn/problems/design-circular-deque/solution/shu-zu-shi-xian-de-xun-huan-shuang-duan-dui-lie-by/
     * 解答ppt中的入参k=7（而不是8），所以画出的数组长度为8，但始终有一位不存储实际值（这一位并不是固定的某一位）
     *
     * Ps.但是也可以用一个emptyFlag来标识队空和满的状态，这样就不用额外留一个，更好理解，但是前者更方便和巧妙
     */
    static class MyCircularDeque {
    int[] values;
    int head;   //指向队列头部第 1 个有效数据的位置；
    int tail;   //指向队列尾部（即最后 1 个有效数据）的 下一个位置
    int capacity;

    public MyCircularDeque(int k) {
        capacity = k+1;
        values = new int[capacity];
        head = 0;
        tail = 0;
    }

    /**
     * 有点反常识，这里的insertFront并不是插在第一位，而是丢进去掉到队尾😅
     * 如果是这样的话就不应该叫双端队列，而是双端栈了，因为出入队列和出入栈的规律是一样的，插入时直接掉到栈底
     *
     * 为什么是移动head而不是tail？
     * 因为从队头插入会直接掉到队尾，如果head不动的话，[head,tail)区间就会包含中间的零值     *
     * @param value
     * @return
     */
    public boolean insertFront(int value) {
        if (isFull()){
            return false;
        }
        head = (head - 1 + capacity) % capacity;
        values[head] = value;
        return true;
    }
    
    public boolean insertLast(int value) {
        if (isFull()){
            return false;
        }
        values[tail] = value;   //因为tail一只指向队尾有效元素的下一个元素，所以真的有下一个元素过来的时候，直接用它赋值就可以了
        tail = (tail + 1) % capacity;   //计算tail，考虑从队尾循环到队头的情况，tail=7->0
        return true;
    }

    /**
     * 从队头删除，head要右移，但是也要考虑head已经在最右的位置的情况
     * @return
     */
    public boolean deleteFront() {
        if (isEmpty()){
            return false;
        }
        //if head==0,head=capacity-1=7
        head = (head + 1) % capacity;
        return true;
    }

    /**
     * 从队尾删除，右边出去一个，tail要左移一位，
     * @return
     */
    public boolean deleteLast() {
        if (isEmpty()){
            return false;
        }
        tail = (tail - 1 + capacity) % capacity;
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
        return values[tail-1];//todo
//        return values[(tail - 1 + capacity) % capacity];
    }
    
    public boolean isEmpty() {
        if (head == tail){
            return true;
        }
        return false;
    }

    /**
     * 因为是循环队列，满的情况不一定是head=0,tail=capacity-1，
     * 也有可能是head=4,tail=3，即tail从尾巴循环到头部"套圈"追上了head
     * @return
     */
    public boolean isFull() {
        if ((tail + 1) % capacity == head){
            return true;
        }
        return false;
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


    public static class MyCircularDeque_GuanFang {

        // 1、不用设计成动态数组，使用静态数组即可
        // 2、设计 head 和 tail 指针变量
        // 3、head == tail 成立的时候表示队列为空
        // 4、tail + 1 == head

        private int capacity;
        private int[] arr;
        private int front;
        private int rear;

        /**
         * Initialize your data structure here. Set the size of the deque to be k.
         */
        public MyCircularDeque_GuanFang(int k) {
            capacity = k + 1;
            arr = new int[capacity];

            // 头部指向第 1 个存放元素的位置
            // 插入时，先减，再赋值
            // 删除时，索引 +1（注意取模）
            front = 0;
            // 尾部指向下一个插入元素的位置
            // 插入时，先赋值，再加
            // 删除时，索引 -1（注意取模）
            rear = 0;
        }

        /**
         * Adds an item at the front of Deque. Return true if the operation is successful.
         */
        public boolean insertFront(int value) {
            if (isFull()) {
                return false;
            }
            front = (front - 1 + capacity) % capacity;
            arr[front] = value;
            return true;
        }

        /**
         * Adds an item at the rear of Deque. Return true if the operation is successful.
         */
        public boolean insertLast(int value) {
            if (isFull()) {
                return false;
            }
            arr[rear] = value;
            rear = (rear + 1) % capacity;
            return true;
        }

        /**
         * Deletes an item from the front of Deque. Return true if the operation is successful.
         */
        public boolean deleteFront() {
            if (isEmpty()) {
                return false;
            }
            // front 被设计在数组的开头，所以是 +1
            front = (front + 1) % capacity;
            return true;
        }

        /**
         * Deletes an item from the rear of Deque. Return true if the operation is successful.
         */
        public boolean deleteLast() {
            if (isEmpty()) {
                return false;
            }
            // rear 被设计在数组的末尾，所以是 -1
            rear = (rear - 1 + capacity) % capacity;
            return true;
        }

        /**
         * Get the front item from the deque.
         */
        public int getFront() {
            if (isEmpty()) {
                return -1;
            }
            return arr[front];
        }

        /**
         * Get the last item from the deque.
         */
        public int getRear() {
            if (isEmpty()) {
                return -1;
            }
            // 当 rear 为 0 时防止数组越界
            return arr[(rear - 1 + capacity) % capacity];
        }

        /**
         * Checks whether the circular deque is empty or not.
         */
        public boolean isEmpty() {
            return front == rear;
        }

        /**
         * Checks whether the circular deque is full or not.
         */
        public boolean isFull() {
            // 注意：这个设计是非常经典的做法
            return (rear + 1) % capacity == front;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}