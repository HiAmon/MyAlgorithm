package topic.linkedlist;

////给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
//// 
////
//// 示例 1： 
////
//// 
////输入：head = [1,2,6,3,4,5,6], val = 6
////输出：[1,2,3,4,5]
//// 
////
//// 示例 2： 
////
//// 
////输入：head = [], val = 1
////输出：[]
//// 
////
//// 示例 3： 
////
//// 
////输入：head = [7,7,7,7], val = 7
////输出：[]
//// 
////
//// 
////
//// 提示： 
////
//// 
//// 列表中的节点数目在范围 [0, 10⁴] 内 
//// 1 <= Node.val <= 50 
//// 0 <= val <= 50 
//// 
//// Related Topics 递归 链表 👍 778 👎 0
//

import java.util.Collections;
import topic.linkedlist.ListNode;
public class P203_RemoveLinkedListElements{
    public static void main(String[] args) {
        Solution solution = new P203_RemoveLinkedListElements().new Solution();
        int[] nums = {1,2,6,3,4,5,6};
        ListNode head = new ListNode(nums[0]);
        ListNode pre = head;
        //头插法

        for (int i = 1; i < nums.length; i++) {
            ListNode cur = new ListNode(nums[i]);
            pre.next = cur;
            pre = cur;
        }
        ListNode pp = head;
        while (null != pp.next){
            System.out.println(pp.val);
            pp = pp.next;
        }
        System.out.println(pp.val);

        System.out.println("-----------");

        ListNode newhead = solution.removeElements(head, 6);
        ListNode qq = newhead;
        while (null != qq.next){
            System.out.println(qq.val);
            qq = qq.next;
        }
        System.out.println(qq.val);
    }

//leetcode submit region begin(Prohibit modification and deletion)


class Solution {
    /**
     * 官方思路，新建一个虚拟头节点，这样就能统一处理头节点和非头节点了
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {

        ListNode vhead = new ListNode(-1,head);     //虚拟头节点
        ListNode pre = vhead;
        ListNode curr = head;

        while(curr != null){
            if (curr.val == val){
                pre.next = curr.next;
            }else {
                pre = curr;
            }
            curr = curr.next;
        }
        return vhead.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}