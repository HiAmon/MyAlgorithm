package topic.linkedlist;

//给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。
//你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
// 示例 1：
//输入：head = [1,2,3,4]
//输出：[2,1,4,3]
//
// 示例 2： 
//输入：head = []
//输出：[]
//
// 示例 3： 
//输入：head = [1]
//输出：[1]
//
// 提示： 
// 链表中节点的数目在范围 [0, 100] 内
// 0 <= Node.val <= 100 
// 
// Related Topics 递归 链表 👍 1203 👎 0

import java.lang.reflect.Method;

public class P24_SwapNodesInPairs{
    public static void main(String[] args) {
        Solution solution = new P24_SwapNodesInPairs().new Solution();
        try {
            Object linkedlist = Class.forName("topic.linkedlist.ListNode").newInstance();
            Method constructor = linkedlist.getClass().getDeclaredMethod("ListNode");
            constructor.invoke(linkedlist);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public ListNode swapPairs(ListNode head) {
        // TODO: 2022/1/17



        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}