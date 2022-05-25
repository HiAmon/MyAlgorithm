package topic.dfs;

////给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉
//树并
////返回其根节点。 
////
//// 
////
//// 示例 1: 
////
//// 
////输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
////输出: [3,9,20,null,null,15,7]
//// 
////
//// 示例 2: 
////
//// 
////输入: preorder = [-1], inorder = [-1]
////输出: [-1]
//// 
////
//// 
////
//// 提示: 
////
//// 
//// 1 <= preorder.length <= 3000 
//// inorder.length == preorder.length 
//// -3000 <= preorder[i], inorder[i] <= 3000 
//// preorder 和 inorder 均 无重复 元素 
//// inorder 均出现在 preorder 
//// preorder 保证 为二叉树的前序遍历序列 
//// inorder 保证 为二叉树的中序遍历序列 
//// 
//// Related Topics 树 数组 哈希表 分治 二叉树 👍 1604 👎 0
//

import topic.TreeNode;

import java.util.HashMap;

public class P105_ConstructBinaryTreeFromPreorderAndInorderTraversal{
    public static void main(String[] args) {
        Solution solution = new P105_ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
        int[] preorder = new int[]{3,9,20,15,7};
        int[] inorder = new int[]{9,3,15,20,7};
        TreeNode head = solution.buildTree(preorder, inorder);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        int[] preorder;
        int[] inorder;
        HashMap<Integer,Integer> inMap = new HashMap<>();//inMap作为参照就够了，直接对preOrder遍历，不需要preMap

        public TreeNode buildTree(int[] preorder, int[] inorder) {

            int len = preorder.length;
            for (int i = 0; i < len; i++) {
                inMap.put(inorder[i],i);
            }

            this.preorder = preorder;
            this.inorder = inorder;
            TreeNode root = traverse(0, len - 1, 0, len - 1);
            return root;
        }

        /**
         * 递归 -> 深度优先遍历
         * @param preLeft 当前处理的左区间 preorder中对应下标
         * @param preRight 当前处理的右区间
         * @param inLeft 当前处理的左区间 inorder中中对应下标
         * @param inRight 当前处理的右区间
         *
         * 思路见1052.png
         * @https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/solution/cong-qian-xu-yu-zhong-xu-bian-li-xu-lie-gou-zao-9/
         * @return
         */
        public TreeNode traverse(int preLeft, int preRight, int inLeft, int inRight ){
            //单层递归退出条件，区间为空
            if (inLeft > inRight || preLeft > preRight) {
                return null;
            }

            // val 为前序遍历第一个的值，也即是根节点的值
            int val = preorder[preLeft];
            TreeNode curParent = new TreeNode(val);

            // curIn 为根据根节点的值来找中序遍历的下标
            int curIn = inMap.get(val);

            // 根据 curIn 来递归找左右子树
            curParent.left = traverse(
                    preLeft + 1,
                    preLeft + (curIn - inLeft),
                    inLeft,
                    curIn - 1);

            curParent.right = traverse(
                    preLeft + (curIn - inLeft) + 1,
                    preRight,
                     curIn + 1,
                    inRight);
            return curParent;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}