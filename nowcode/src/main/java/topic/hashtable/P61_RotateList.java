package topic.hashtable;

//给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], k = 2
//输出：[4,5,1,2,3]
// 
//
// 示例 2： 
//
// 
//输入：head = [0,1,2], k = 4
//输出：[2,0,1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 500] 内 
// -100 <= Node.val <= 100 
// 0 <= k <= 2 * 10⁹ 
// 
// Related Topics 链表 双指针 👍 773 👎 0

import topic.ListNode;

public class P61_RotateList{
    public static void main(String[] args) {
        Solution solution = new P61_RotateList().new Solution();
//        int[] array = new int[]{1,2,3,4,5};
        int[] array = new int[]{1,2};
        ListNode head = new ListNode(array[0]);
        ListNode cur = head;
        for (int i = 1; i < array.length; i++) {
            cur.next = new ListNode(array[i]);
            cur = cur.next;
        }
        solution.rotateRight(head,1);
//        solution.rotateRight_GuanFang(head,1);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 怎么做？怎么确定
         * @param head
         * @param k
         * @return
         */
        public ListNode rotateRight(ListNode head, int k) {
            //0. 判空
            if (null == head){
                return null;
            }
            if(k == 0){
                return head;
            }
            ListNode tail = head;
            int n = 1;   //从1开始，最后就直接得到节点数目了，而不是下标

            //1. 得到链表的长度和尾节点
            while (null != tail.next){
                tail = tail.next;
                n++;
            }

            //2. 得到k对应节点的指针
            k = k % n;//因为移动n次就会回到原点，所以对n取模，应对k很大浪费移动次数的情况
            ListNode point = head;

            //为什么是n-k-1次？ 因为要分隔开左边n-k个节点 和 右边 k个节点，那么pont从head出发，就要右移n-k-1次才能移动到目标节点【建议画图理解
            for(int i = 0; i < n-k-1; i++){
                point = point.next;
            }

            //3. 从point处断裂，尾连接到头，直接在head上动手
            tail.next = head;
            head = point.next;
            point.next = null;
            return head;  //返回新的头节点
        }


        public ListNode rotateRight_GuanFang(ListNode head, int k) {
            if(head == null|| k == 0)  return head;
            int n = 0;			   //链表的长度
            ListNode tail = null;  //尾节点
            for(ListNode p = head; p != null ; p = p.next){
                tail = p;
                n++;
            }
            k %= n;
            ListNode p = head;
            for(int i = 0; i < n-k-1; i++){
                p = p.next;   //找到链表的第n-k个节点
            }
            tail.next = head;
            head = p.next;
            p.next = null;
            return head;  //返回新的头节点
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}