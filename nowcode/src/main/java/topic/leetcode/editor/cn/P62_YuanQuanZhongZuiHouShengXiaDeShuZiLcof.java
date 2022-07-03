package topic.leetcode.editor.cn;

////0,1,···,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字（删除后从下一个数字开始计数）。求出这个圆圈里剩下的最后一个数
//字。
//// 
////
//// 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。 
////
//// 
////
//// 示例 1： 
////
//// 
////输入: n = 5, m = 3
////输出: 3
//// 
////
//// 示例 2： 
////
//// 
////输入: n = 10, m = 17
////输出: 2
//// 
////
//// 
////
//// 限制： 
////
//// 
//// 1 <= n <= 10^5 
//// 1 <= m <= 10^6 
//// 
//// Related Topics 递归 数学 👍 614 👎 0
//

import topic.ListNode;

public class P62_YuanQuanZhongZuiHouShengXiaDeShuZiLcof{
    public static void main(String[] args) {
        Solution solution = new P62_YuanQuanZhongZuiHouShengXiaDeShuZiLcof().new Solution();
        System.out.println(solution.lastRemaining(5,3));
        System.out.println(solution.lastRemaining_Guanfang(5,3));
        System.out.println(solution.lastRemaining_Math(5,3));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lastRemaining_Math(int n, int m) {//5，3
        int ans = 0;
        // 最后一轮剩下2个人，所以从2开始反推
        for (int i = 2; i <= n; i++) {//2，5
            ans = (ans + m) % i;//
        }
        return ans;
    }

    public int lastRemaining_Guanfang(int n, int m) {
        return traverse(n, m);
    }

    public int traverse(int n, int m) {//序列的起点变了，而序列的长度始终只-1
        if (n == 1) {//特殊情况判断
            return 0;
        }
        int x = traverse(n - 1, m);
        return (m + x) % n;//递推公式
    }

    /**
     * 这种方式会超时
     * @param n
     * @param m
     * @return
     */
    public int lastRemaining(int n, int m) {
        //1. 构造循环链表
        ListNode head = new ListNode(0);
        ListNode cur = head;
        for (int i = 1; i < n; i++) {
            cur.next = new ListNode(i);
            cur = cur.next;
        }
        cur.next = head;

        //2. 模拟题意
        int i = 0;
        int size = n;
        while (size > 1){//初次cur指向head前一个
            if (i == m-1){
                cur.next = cur.next.next;
                size--;
                i = 0;
                continue;
            }
            cur = cur.next;
            i++;
        }
        return cur.val;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}