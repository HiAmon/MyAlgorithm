package topic.dfs;

//给你二叉树的根节点 root 和一个表示目标和的整数 targetSum 。判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和
// targetSum 。如果存在，返回 true ；否则，返回 false 。 
//
// 叶子节点 是指没有子节点的节点。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
//输出：true
//解释：等于目标和的根节点到叶节点路径如上图所示。
// 
//
// 示例 2： 
//
// 
//输入：root = [1,2,3], targetSum = 5
//输出：false
//解释：树中存在两条根节点到叶子节点的路径：
//(1 --> 2): 和为 3
//(1 --> 3): 和为 4
//不存在 sum = 5 的根节点到叶子节点的路径。 
//
// 示例 3： 
//
// 
//输入：root = [], targetSum = 0
//输出：false
//解释：由于树是空的，所以不存在根节点到叶子节点的路径。
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目在范围 [0, 5000] 内 
// -1000 <= Node.val <= 1000 
// -1000 <= targetSum <= 1000 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 892 👎 0

import topic.TreeNode;

public class P112_PathSum{
    public static void main(String[] args) {
        Solution solution = new P112_PathSum().new Solution();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);
        solution.hasPathSum_MoFang(root,22);
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 什么情况下递归方法需要单独拎出来？
     * 递归就是自己调用自己，逻辑不变而数据变了，
     */
    public boolean hasPathSum_MoFang(TreeNode root, int targetSum) {
        if (null == root){
            return false;
        }
        return traverse(root, targetSum);
    }

    //因为不是遍历整棵树，需要一些指标来确定什么时候停下来，不能光根据null来判断，所以需要返回值
    public boolean traverse(TreeNode root, int targetSum){
        //1. 终止条件
        if (null == root.left && null == root.right && targetSum == 0){
            return true;//到叶子，且满足，true
        }
        if (null == root.left && null == root.right && targetSum != 0){
            return false;//到叶子节点，但不满足，false
        }

        //2. 单层逻辑，进入内层递归之前需要做什么处理，这里是做减法；
        //但这里也有退出的可能，因为如果遇到解，就可以直接终止了，不需要再进入内层了
        if (null != root.left){//在这里判空所以就不用再头上判空了
            //因为targetSum - cur.left.val这里是传参，并没有做赋值操作，所以就不需要减了再加，（但是也可以那样做，如right⬇️
            if (traverse(root.left, targetSum - root.left.val)){
                return true;
            }
        }
        if (null != root.right){
            targetSum -= root.right.val;
            if (traverse(root.right, targetSum)){
                return true;
            }
            targetSum += root.right.val;//这里就是回溯撤销减法⬆️
        }
        return false;
    }

    /**
     * 标准答案，还是很迷糊，那就先记下来吧 todo
     * @param root
     * @param targetSum
     * @return
     */
    public boolean hasPathSumCarl(TreeNode root, int targetSum) {
        if (root == null) return false;
        if (null == root.left && null == root.right && targetSum == root.val) {
            return true;
        }
        return hasPathSumCarl(root.left, targetSum - root.val) || hasPathSumCarl(root.right, targetSum - root.val);
    }

    }
//leetcode submit region end(Prohibit modification and deletion)



}