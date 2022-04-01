package topic.binaryTree;

//给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：[[3],[9,20],[15,7]]
// 
//
// 示例 2： 
//
// 
//输入：root = [1]
//输出：[[1]]
// 
//
// 示例 3： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 2000] 内 
// -1000 <= Node.val <= 1000 
// 
// Related Topics 树 广度优先搜索 二叉树 👍 1191 👎 0

import java.util.*;

public class P102_BinaryTreeLevelOrderTraversal{
    public static void main(String[] args) {
        Solution solution = new P102_BinaryTreeLevelOrderTraversal().new Solution();
        TreeNode root = new TreeNode();
        solution.levelOrder(root);
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 层序遍历
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> rs = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();

        /**
         * 从根节点开始，当前节点出队时，将其子节点入队
         */
        queue.push(root);
        while (!queue.isEmpty()){
            List<Integer> row = new ArrayList<>();
            int len = queue.size(); //🟢 这一句是亮点！
            while (len-- > 0){
                TreeNode cur = queue.pop();
                row.add(cur.val);
                if (null != cur.left){
                    queue.push(cur.left);
                }
                if (null != cur.right){
                    queue.push(cur.right);
                }
            }
            rs.add(row);
        }
        return rs;
    }

    /**
     * 官方代码
     * @param node
     * @return
     */
    public List<List<Integer>> levelOrder2(TreeNode node) {
        List<List<Integer>> resList = new ArrayList<List<Integer>>();
        if (node == null) return null;
        Queue<TreeNode> que = new LinkedList<TreeNode>();
        que.offer(node);

        while (!que.isEmpty()) {
            List<Integer> itemList = new ArrayList<Integer>();
            int len = que.size();

            while (len > 0) {
                TreeNode tmpNode = que.poll();
                itemList.add(tmpNode.val);

                if (tmpNode.left != null) que.offer(tmpNode.left);
                if (tmpNode.right != null) que.offer(tmpNode.right);
                len--;
            }

            resList.add(itemList);
        }
        return resList;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}