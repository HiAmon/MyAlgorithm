package topic.dfs;

//给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。 
//
// 有效 二叉搜索树定义如下： 
//
// 
// 节点的左子树只包含 小于 当前节点的数。 
// 节点的右子树只包含 大于 当前节点的数。 
// 所有左子树和右子树自身必须也是二叉搜索树。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [2,1,3]
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：root = [5,1,4,null,null,3,6]
//输出：false
//解释：根节点的值是 5 ，但是右子节点的值是 4 。
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目范围在[1, 10⁴] 内 
// -2³¹ <= Node.val <= 2³¹ - 1 
// 
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 1595 👎 0

import topic.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;


public class P98_ValidateBinarySearchTree{
    public static void main(String[] args) {
        Solution solution = new P98_ValidateBinarySearchTree().new Solution();
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(6);

//        root.left.left = new TreeNode(6);
//        root.left.right = new TreeNode(3);

        root.right.left = new TreeNode(3);
        root.right.left.right = new TreeNode(4);
        root.right.left.right.right = new TreeNode(7);
        System.out.println(solution.isValidBST(root));
    }

//leetcode submit region begin(Prohibit modification and deletion)



class Solution {
    public boolean isValidBST(TreeNode root) {
        return traverse(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }


    boolean traverse(TreeNode cur, long down, long up){
        if (null == cur){
            return true;
        }
        if (!(cur.val > down && cur.val < up)){
            return false;
        }
        if (null == cur.right && null == cur.left){
            return true;//如果满足且是叶子节点
        }
        return traverse(cur.left, down, cur.val)&& traverse(cur.right, cur.val, up);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}