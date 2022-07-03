package topic.linkedlist;

//给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5]
//输出：[5,4,3,2,1]
// 
//
// 示例 2： 
//
// 
//输入：head = [1,2]
//输出：[2,1]
// 
//
// 示例 3： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目范围是 [0, 5000] 
// -5000 <= Node.val <= 5000 
// 
//
// 
//
// 进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？ 
// 
// 
// Related Topics 递归 链表 👍 2207 👎 0

public class P206_ReverseLinkedList{
    public static void main(String[] args) {
        Solution solution = new P206_ReverseLinkedList().new Solution();
        int[] nums = {1,2,3,4,5,6};
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
            System.out.print(pp.val + " ");
            pp = pp.next;
        }
        System.out.print(pp.val);
        System.out.println("\n-----");
        solution.reverseList(head);
    }

//leetcode submit region begin(Prohibit modification and deletion)


    class Solution {
        public ListNode reverseList(ListNode head) {
            if (null == head || null == head.next){
                return head;
            }
            ListNode pre = head;
            ListNode cur = null;
            ListNode temp;
            /**
             * cur.next = null;不需要，会影响后面遍历结果（非必须删除正向指针）
             * ⬇ 官方解答优化
             */
            while (null != pre){
                temp = pre.next;
                pre.next = cur;
                cur = pre;
                pre = temp;
            }

            /**⬇链表数据可视化*/
            head = cur;
            try {
                System.out.print(cur.val + " ");
                while (cur != null){
                    cur = cur.next;
                    System.out.print(cur.val + " ");
                }
            }catch (NullPointerException e){
                System.out.println();
            }
            /**⬆ ---end*/
            return head;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}