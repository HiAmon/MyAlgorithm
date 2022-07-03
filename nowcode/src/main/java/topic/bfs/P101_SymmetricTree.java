package topic.bfs;

//给你一个二叉树的根节点 root ， 检查它是否轴对称。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,2,2,3,4,4,3]
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：root = [1,2,2,null,3,null,3]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [1, 1000] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶：你可以运用递归和迭代两种方法解决这个问题吗？ 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 1929 👎 0

import topic.TreeNode;

import java.util.*;

public class P101_SymmetricTree{
    public static void main(String[] args) {
        Solution solution = new P101_SymmetricTree().new Solution();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(2);
//        solution.isSymmetric_DFS(root);
        System.out.println(solution.isSymmetric_BFS(root));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    /**
     * BFS+双指针
     * @param root
     * @return
     */
    public boolean isSymmetric_BFS(TreeNode root){
        if (null == root.left ^ null == root.right){
            return false;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);

        boolean res = true;
        while (!queue.isEmpty()){
            TreeNode u = queue.poll();
            TreeNode v = queue.poll();

            if (u.val != v.val){
                return false;
            }
            if (null == u.left ^ null == v.right){
                return false;
            }
            if (null == u.right ^ null == v.left){
                return false;
            }
            if (null != u.left && null != v.right){
                queue.add(u.left);
                queue.add(v.right);
            }
            if (null != v.left && null != u.right){
                queue.add(v.left);
                queue.add(u.right);
            }
        }

        return res;
    }

    //=================DFS===================//
    List<Integer> leftTree = new ArrayList<>();
    List<Integer> rightTree = new ArrayList<>();

    /* 对于[1,2,2,2,null,2]的情况无法通过 */
    public boolean isSymmetric_DFS(TreeNode root) {
        if (null == root.left && null == root.right){//左右都空
            return true;
        }
        if (Boolean.logicalXor(null == root.left , null == root.right)){ //异或
            return false;
        }
        //对根节点的左孩子，左中右，
        //对根节点的右孩子，右中左，
        //如果相等，就是对称树
        dfsLeft(root.left);
        dfsRight(root.right);
        return leftTree.equals(rightTree);
    }

    public void dfsLeft(TreeNode cur){
        if(null == cur){
            leftTree.add(null);
            return;
        }
        dfsLeft(cur.left);
        leftTree.add(cur.val);
        dfsLeft(cur.right);
    }

    public void dfsRight(TreeNode cur){
        if(null == cur){
            rightTree.add(null);
            return;
        }
        dfsRight(cur.right);
        rightTree.add(cur.val);
        dfsRight(cur.left);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}