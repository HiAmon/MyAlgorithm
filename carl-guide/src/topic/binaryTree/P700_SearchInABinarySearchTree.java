package topic.binaryTree;

//给定二叉搜索树（BST）的根节点 root 和一个整数值 val。 
//
// 你需要在 BST 中找到节点值等于 val 的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 null 。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入：root = [4,2,7,1,3], val = 2
//输出：[2,1,3]
// 
//
// Example 2: 
//
// 
//输入：root = [4,2,7,1,3], val = 5
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 数中节点数在 [1, 5000] 范围内 
// 1 <= Node.val <= 10⁷ 
// root 是二叉搜索树 
// 1 <= val <= 10⁷ 
// 
// Related Topics 树 二叉搜索树 二叉树 👍 245 👎 0

public class P700_SearchInABinarySearchTree{
    public static void main(String[] args) {
        Solution solution = new P700_SearchInABinarySearchTree().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    /**
     * 递归解法
     *
     * 和遍历的递归解法差不多，区别只是多了一个比较的步骤，而且这是一个有序的BST(binary search tree)
     * @param root
     * @param val
     * @return
     */
    //0. 出入参
    public TreeNode searchBST(TreeNode root, int val) {
        //1. 判空
        if (null == root){
            return null;
        }
        //2. 单层逻辑 and 返回条件
        if (val == root.val){
            return root;
        }
        // ⬆ 这两个if 可以合并成 ==> if(null == root || val == root.val){ return root;} 如下优化写法

        //3. 递推逻辑
        /*searchBST(root.left, val);// ❌ 不能两边都搜哦，只要搜一边
        searchBST(root.right, val);*/

        if (null != searchBST(root.left,val)){
            return root.left;
        }else {
            searchBST(root.right,val); //如果左边搜不到再搜右边
        }

        return null;
    }


    /**
     * 优化写法
     * 利用BST的特性，节点值有序递增
     * @param root
     * @param val
     * @return
     */
    public TreeNode searchBST2(TreeNode root, int val) {
        //返回条件
        if(null == root || val == root.val){
            return root;
        }

        //递推逻辑
        if (val < root.val){
            searchBST2(root.left,val);
        }else {
            searchBST2(root.right,val);
        }

        //如果都没找到，没返回root，那就返回null
        return null;
    }

    //----------------------------------------

    /**
     * 迭代写法
     *
     * #tips: 要善于使用BST的有序特性哦～
     *
     * Cm. 因为可以通过比大小的方式确定指针走的方向，所以就不存在回溯的问题了，也就不需要栈和队列来辅助遍历了
     *
     * @param root
     * @param val
     * @return
     */
    public TreeNode searchBST3(TreeNode root, int val) {
        TreeNode cur = root;

        while (cur != null){
            if (val == cur.val){
                return cur;
            }

            if (val < cur.val){
                cur = cur.left;
            }else {
                cur = cur.right;
            }
        }
        return null;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}