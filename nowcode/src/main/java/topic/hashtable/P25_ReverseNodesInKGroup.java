package topic.hashtable;

//给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。 
//
// k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], k = 2
//输出：[2,1,4,3,5]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：head = [1,2,3,4,5], k = 3
//输出：[3,2,1,4,5]
// 
//
// 
//提示：
//
// 
// 链表中的节点数目为 n 
// 1 <= k <= n <= 5000 
// 0 <= Node.val <= 1000 
// 
//
// 
//
// 进阶：你可以设计一个只用 O(1) 额外内存空间的算法解决此问题吗？ 
//
// 
// 
// Related Topics 递归 链表 👍 1640 👎 0

import topic.ListNode;

import java.util.ArrayList;
import java.util.List;

public class P25_ReverseNodesInKGroup{
    public static void main(String[] args) {
        Solution solution = new P25_ReverseNodesInKGroup().new Solution();
        int[] array = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14};
        ListNode head = new ListNode(array[0]);
        ListNode cur = head;
        for (int i = 1; i < array.length; i++) {
            cur.next = new ListNode(array[i]);
            cur = cur.next;
        }
//        solution.reverseKGroup(head,5);
        solution.reverseKGroup_GuanFang(head,5);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 考虑在每k个位置用额外的head,tail节点，串起这一段节点，然后反转，
         * 再吧tail和下一段的head串起来
         *
         * 这方法不太行，还是参考官方题解
         * @param head
         * @param k
         * @return经典
         */
        @Deprecated
        public ListNode reverseKGroup(ListNode head, int k) {
            //0. 判断边界情况，如只有一个节点，或者K大于节点总数量
            if(null == head){
                return null;
            }
            if (null == head.next){
                return head;
            }
            int len = 1;
            ListNode tail = head;
            while (null != tail.next){
                tail = tail.next;
                len++;
            }
            int loop = (len%k == 0)?(len/k):(len/k+1);
            if (loop == 0){
                return head;
            }

            //begin rotating:
            ListNode slow = null; //🟢 记住这一点，初始化的时候慢指针是空的
            ListNode fast = head;
            ListNode[][] segmentHeads = new ListNode[loop][2];
            for (int m = 0; m < loop; m++) {//len=4,k=5

                //找到每个k段的末尾节点
                ListNode fin = head;
                for (int i = 0; i < k-1; i++) {
                    if (null == fin.next){  //最后一段不满k长度的，就取最后一个退出
                        break;
                    }
                    fin = fin.next;
                }
                segmentHeads[m][0] = fast;
                segmentHeads[m][1] = fin;

                int interLoop = (len-m*k)>k ? k : (len-m*k);  //15=5,5,4;k=5,m=2,
                for (int i = 0; i < interLoop; i++) {
                    ListNode temp = fast.next;
                    fast.next = slow;//*反转指针

                    //快慢指针往前移动
                    slow = fast;
                    fast = temp;
                }
                /**
                 * 和直接的反转指针的区别是什么？
                 * 是每k个节点，要保留一次原指针方向
                 */
            }

            for (int i = 0; i < segmentHeads.length-1; i++) {
                segmentHeads[i][0].next = segmentHeads[i+1][1];
            }

            return segmentHeads[0][0];
        }


        public ListNode reverseKGroup_GuanFang(ListNode head, int k) {
            ListNode vHead = new ListNode(0);
            vHead.next = head;

            ListNode pre = vHead;//pre 待翻转段头节点的前一个节点
            ListNode fin = vHead;//fin 待翻转段的末尾

            while (fin.next != null) {
                for (int i = 0; i < k && fin != null; i++) {
                    fin = fin.next;
                }
                if (fin == null) break;

                ListNode start = pre.next;//待翻转段的头节点
                ListNode next = fin.next;//先保存下一段的头的值
                fin.next = null;//把当前段的末尾和下一段断开
                //即把当前k个节点变成孤立段

                pre.next = reverse(start);//对这一段进行翻转，让上个段的结尾指向当前翻转段的头节点

                start.next = next;//start移动到下一段的开始
                pre = start;//pre进入下一个段

                fin = pre;
            }
            return vHead.next;
        }

        /**
         * 封装单段反转方法
         * @param head
         * @return
         */
        private ListNode reverse(ListNode head) {
            ListNode slow = null;
            ListNode fast = head;
            while (fast != null) {
                ListNode temp = fast.next;
                fast.next = slow;
                slow = fast;
                fast = temp;
            }
            return slow;//slow是翻转后这个段的头节点
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}