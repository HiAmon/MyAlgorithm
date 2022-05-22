package topic.array;

//给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。 
//
// 你应当 保留 两个分区中每个节点的初始相对位置。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,4,3,2,5,2], x = 3
//输出：[1,2,2,4,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [2,1], x = 2
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 200] 内 
// -100 <= Node.val <= 100 
// -200 <= x <= 200 
// 
// Related Topics 链表 双指针 👍 560 👎 0

import topic.ListNode;

public class P86_PartitionList{
    public static void main(String[] args) {
        Solution solution = new P86_PartitionList().new Solution();
        ListNode head = new ListNode(1);
        ListNode cur = head;
        int[] ints = new int[]{1,4,3,2,5,2};
        for (int i = 1; i < ints.length; i++) {
            ListNode listNode = new ListNode(ints[i]);
            cur.next = listNode;
            cur = cur.next;
        }

        solution.partition(head,3);
    }

//leetcode submit region begin(Prohibit modification and deletion)


class Solution {
    /**
     * 这是单向链表，只支持从头往后遍历，无法从尾往前遍历
     *
     * 从左往右遍历，遇到比x小的节点，链接到minHead后面，然后把minHead末尾链接到head
     * 遇到比x大的节点，链接到maxHead后面，
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {
        ListNode minHead = new ListNode(-99);
        ListNode minTail = minHead;
        ListNode maxHead = new ListNode(99);
        ListNode maxTail = maxHead;

        //head = [1,4,3,2,5,2], x = 3
        /**
         * 思路：
         * 新建一个maxHead\minHead节点，把遍历到的当前节点接到头节点后面，不需要另外声明指针了，head作为指针就可以
         */
        while (head != null){
            if (head.val < x){
                minTail.next = head;
                minTail = minTail.next;
            }else {
                maxTail.next = head;
                maxTail = maxTail.next;
            }
            head = head.next;
        }
        maxTail.next = null;
        minTail.next = maxHead.next;
        return minHead.next;
    }









    @Deprecated
    public ListNode partition_old(ListNode head, int x) {
        ListNode cur = head;
        ListNode minHead = new ListNode(-99);
//        minHead.next = head;
        ListNode minTail = minHead;
        ListNode maxHead = new ListNode(+99);
        ListNode maxTail = head;

        while (null != cur.next){
            if (cur.val < x){
                minTail.next = cur;
                minTail = minTail.next;
            }else {
                maxTail.next = cur;
                maxTail = maxTail.next;
            }
            cur = cur.next;
        }
        return minHead.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}