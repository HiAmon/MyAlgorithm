package topic.linkedlist;

//设计链表的实现。您可以选择使用单链表或双链表。单链表中的节点应该具有两个属性：val 和 next。val 是当前节点的值，next 是指向下一个节点的指针
///引用。如果要使用双向链表，则还需要一个属性 prev 以指示链表中的上一个节点。假设链表中的所有节点都是 0-index 的。 
//
// 在链表类中实现这些功能： 
//
// get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。
// addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。 
// addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。 
// addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val 的节点。如果 index 等于链表的长度，则该节点将附加
//到链表的末尾。如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。 
// deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。 
//
// 示例：
//
// MyLinkedList linkedList = new MyLinkedList();
//linkedList.addAtHead(1);
//linkedList.addAtTail(3);
//linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
//linkedList.get(1);            //返回2
//linkedList.deleteAtIndex(1);  //现在链表是1-> 3
//linkedList.get(1);            //返回3
// 
// 提示：
//
// 所有val值都在 [1, 1000] 之内。
// 操作次数将在 [1, 1000] 之内。 
// 请不要使用内置的 LinkedList 库。 
// 
// Related Topics 设计 链表 👍 343 👎 0

import java.util.List;

public class P707_DesignLinkedList{
    public static void main(String[] args) {
        Solution solution = new P707_DesignLinkedList().new Solution();
        solution.showLinkedList();
    }

//leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public void showLinkedList(){
//            int[] nums = new int[]{1,2,6,3,4,5,6};
//            MyLinkedList linkedList = new MyLinkedList(nums);
//            System.out.println("get: " + linkedList.get(6));
            MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(1);
        linkedList.addAtTail(3);
        linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
//            System.out.println("get: " + linkedList.get(1));            //返回2
        linkedList.deleteAtIndex(1);  //现在链表是1-> 3
            System.out.println("get again: " + linkedList.get(1));            //返回3
            linkedList.interater();
        }
    }

    class LinkNode {
        int val;
        LinkNode next;

        public LinkNode(int val) {
            this.val = val;
        }

        public LinkNode() {
        }
    }


    class MyLinkedList {
        LinkNode head;
        int length;
        /**
         * 构造方法-头插法
         * @param nums
         */
        public MyLinkedList(int[] nums) {
            head = new LinkNode(nums[0]);
            length = nums.length;
            LinkNode pre = head;

            for (int i = 1; i < nums.length; i++) {
                LinkNode cur = new LinkNode(nums[i]);
                pre.next = cur;
                pre = cur;
            }
            LinkNode pp = head;
            while (null != pp.next){
                System.out.print(pp.val + " ");
                pp = pp.next;
            }
            System.out.print(pp.val + "\n");
        }

        public MyLinkedList() {
            head = new LinkNode();
            length = 0;
        }

        public int get(int index) {
            if (index < 0 || index >= length){
                return -1;
            }
            int t = 0;
            LinkNode p = head;
            while (t < index){
                p = p.next;
                t++;
            }
            return p.val;
        }

        /**
         * 官方思路：// 通过判断 index < (size - 1) / 2 来决定是从头结点还是尾节点遍历，提高效率
         * @return
         */
        public int standardGet(){
            //...
            return 0;
        }

        public void addAtHead(int val) {
            LinkNode node = new LinkNode(val);
            if (length == 0){
                head = node;
                length++;
                return;
            }
            node.next = head;
            head = node;
            length++;
        }

        /**
         * 官方解答
         */
        public void standardAddAtHead(int val){
            addAtIndex(0,val);
        }

        public void addAtTail(int val) {
            LinkNode node = new LinkNode(val);
            if (length == 0){
                head = node;
                length++;
                return;
            }
            LinkNode p = head;
            while (null != p.next){
                p = p.next;
            }
            p.next = node;
            length++;
        }

        /**
         * 官方解答，直接调用，更简洁
         */
        public void standardAddAtTail(int val){
            addAtIndex(length, val);
        }

        //在第index个节点前面插入val节点
        public void addAtIndex(int index, int val) {
            /**
             * 官方思路，入参判断
             * ⬇ ---begin
             */
            if (index >= length){
                return;
            }
            if (index < 0){
                index = 0;
            }
            /**
             * ⬆ ---end
             */


            //用虚拟头节点法
            LinkNode vhead = new LinkNode(-1);
            vhead.next = head;
            LinkNode pre = vhead;
            int t = 0;
            while (t < index){
                pre = pre.next;
                t++;
            }
            LinkNode node = new LinkNode(val);
            node.next = pre.next;
            pre.next = node;
            head = vhead.next;
            length++;
        }

        public void deleteAtIndex(int index) {
            int t = 0;
            LinkNode vhead = new LinkNode(-1);
            vhead.next = head;
            LinkNode pre = vhead;
            while (t < index){
                pre = pre.next;
                t++;
            }
            pre.next = pre.next.next;
            length--;
        }

        public void interater(){
            LinkNode p = head;
            System.out.print(p.val + " ");
            while (null != p.next) {
                p = p.next;
                System.out.print(p.val + " ");
            }
            System.out.println("\nlength: " + length);
        }
    }

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
//leetcode submit region end(Prohibit modification and deletion)

    //todo 双链表 ->tbc


}