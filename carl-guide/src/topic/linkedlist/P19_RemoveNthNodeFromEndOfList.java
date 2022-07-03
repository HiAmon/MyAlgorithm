package topic.linkedlist;

//给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], n = 2
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1], n = 1
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1,2], n = 1
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中结点的数目为 sz 
// 1 <= sz <= 30 
// 0 <= Node.val <= 100 
// 1 <= n <= sz 
// 
//
// 
//
// 进阶：你能尝试使用一趟扫描实现吗？ 
// Related Topics 链表 双指针 👍 1792 👎 0

public class P19_RemoveNthNodeFromEndOfList{
    public static void main(String[] args) {
        Solution solution = new P19_RemoveNthNodeFromEndOfList().new Solution();
        ListNode head = new ListNode(1);
        ListNode cur = head;
        for (int i = 2; i <= 10; i++) {
            cur.next = new ListNode(i);
            cur = cur.next;
        }
        ListNode listNode = solution.removeNthFromEnd(head, 10);

        ListNode cu = listNode;
        while (null != cu.next){
            System.out.println(cu.val);
            cu = cu.next;
        }
        System.out.println(cu.val);
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 官方思路：很绝！！！双指针！
     * i、j指针，使之保持为n的间距，然后共同向右平移，直到j抵达末尾，这是i正好处于倒数第n个位置
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //为了防止删除第一个节点出错的情况，设定一个虚拟头节点
        ListNode prehead = new ListNode(-1);
        prehead.next = head;
        ListNode left = prehead;
        ListNode right = prehead;
        for (int i = 0; i < n; i++) {
            right = right.next;
        }
        while (null != right.next){
            right = right.next;
            left = left.next;
        }
        left.next = left.next.next;
        return prehead.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}