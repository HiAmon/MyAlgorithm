package topic.greedy;

//给定一个二叉树，我们在树的节点上安装摄像头。 
//
// 节点上的每个摄影头都可以监视其父对象、自身及其直接子对象。 
//
// 计算监控树的所有节点所需的最小摄像头数量。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：[0,0,null,0,0]
//输出：1
//解释：如图所示，一台摄像头足以监控所有节点。
// 
//
// 示例 2： 
//
// 
//
// 输入：[0,0,null,0,null,0,null,null,0]
//输出：2
//解释：需要至少两个摄像头来监视树的所有节点。 上图显示了摄像头放置的有效位置之一。
// 
//
// 
//提示： 
//
// 
// 给定树的节点数的范围是 [1, 1000]。 
// 每个节点的值都是 0。 
// 
// Related Topics 树 深度优先搜索 动态规划 二叉树 👍 361 👎 0

public class P968_BinaryTreeCameras{
    public static void main(String[] args) {
        Solution solution = new P968_BinaryTreeCameras().new Solution();
//        TreeNode root = new TreeNode(0);
//        solution.minCameraCover(root);
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    //Definition for a binary tree node.
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * 贪心策略：
     * 模拟题目要求分析规律可以发现：从叶子节点往上倒推一层，就是第一批摄像头，因为摄像头可以覆盖上下两层，所以放在"中间层"最划算
     *
     * 从叶子节点倒推
     *
     * 官方思路：
     * 节点的三种状态：
     * 0：无覆盖
     * 1：覆盖
     * 2：摄像头
     * ---> 直到没有节点处于0状态
     */
    class Solution {
        public int minCameraCover(TreeNode root) {
            if (null == root){
                return -1;
            }

            int res = 0;
            if (traversal(root) == 0){
                res++;
            }
            return res;
        }

        public int traversal(TreeNode node){
            //遇到叶子节点
            if (null == node){
                return -1;
            }

            int left = traversal(node.left);
            int right = traversal(node.right);

            if (left == 0 || right == 0){
                return 2;
            }

            if (left == 2 || right == 2){
                return 1;
            }

            return 0;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}