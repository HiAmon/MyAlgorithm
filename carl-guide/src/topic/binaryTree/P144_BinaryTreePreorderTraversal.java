package topic.binaryTree;

//给你二叉树的根节点 root ，返回它节点值的 前序 遍历。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,null,2,3]
//输出：[1,2,3]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1]
//输出：[1]
// 
//
// 示例 4： 
//
// 
//输入：root = [1,2]
//输出：[1,2]
// 
//
// 示例 5： 
//
// 
//输入：root = [1,null,2]
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶：递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 深度优先搜索 二叉树 👍 732 👎 0

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的先序遍历
 */
public class P144_BinaryTreePreorderTraversal{
    public static void main(String[] args) {
        Solution solution = new P144_BinaryTreePreorderTraversal().new Solution();
        TreeNode root = new TreeNode(5);
        TreeNode node = root;
        node.left = new TreeNode(4);
        node.right = new TreeNode(6);
        node = root.left;
        node.left = new TreeNode(1);
        node.right = new TreeNode(2);
        solution.preorderTraversal(root);
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    /**
     * =====先序遍历======
     * @param root
     * @return
     */
    public List<Integer> preOrderTraversal(TreeNode root){
        /** 省略root判空*/

        List<Integer> rs = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode cur = root;

        /**
         * 因为cur的取值来源于栈顶，所以只要栈不为空cur就不会为空，
         * 且后面cur都是加了if判空的，所以也不会在赋值的时候取到空值，
         * 故循环的时候不用判断cur为空了
         */
        while (null != cur || !stack.isEmpty()){

            //只要当前节点不为空就先输出，然后再去找它的孩子
            cur = stack.pop();
            rs.add(cur.val);

            /**
             * 把当前节点输出了之后，再来看孩子
             * 如果有右孩子，右孩子先进栈（因为栈是后进先出，这里要保证左先右后）
             */
            if (null != cur.right){
                stack.push(cur.right);
            }
            if (null != cur.left){
                stack.push(cur.left);
            }
        }
        return rs;
    }



    /**
     * =====中序遍历======
     * @return
     */
    public List<Integer> midOrderTraversal(TreeNode root){
        /** 省略root判空*/

        //只要有左孩子就进栈，没有就从栈顶弹出，弹出的元素再检查有没有右孩子，再检查右孩子有没有左孩子，如果有就当前节点进栈，直到找到当前节点的孩子中最左下的孩子，以此类推
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();

        /**
         * 如果当前节点空了且栈也空了，就可以退出
         *
         * 因为如果栈空了但当前节点不为空，可能存在cur来到根节点，刚遍历完左孩子（也就是根节点的左子树和自己都刚输出完），还没有来到右孩子的情况
         * 反之就继续循环
         */
        while ( !(null == cur && stack.isEmpty()) ){
            if (null != cur){
                /**
                 * 如果当前节点还有左孩子，就把当前节点进栈
                 */
                stack.push(cur);
                cur = cur.left;
            }else if (null == cur){
                /**
                 * 如果当前节点是空的，也就是左孩子空了（因为不为空的时候就让cur = cur.left，所以是延迟一轮的）,说明已经遍历到当前子树的最左下角了
                 * 那就可以把当前节点输出（因为终于把左节点都输出完了）
                 * 然后就轮到右孩子了
                 */
                TreeNode node = stack.pop();
                res.add(node.val);
                cur = node.right;
            }
        }
        return res;
    }


    /**
     * =====后序遍历======
     */
    public List<Integer> postOrderTraversal(TreeNode root){
        List<Integer> rs = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        /**
         * 只要当前节点右孩子，就把当前节点进栈，因为输出是左右中，所以进栈顺序应该是中右左
         *
         */
        stack.push(root);

        while (!stack.isEmpty()){
            if (null != cur.right){
                stack.push(cur.right);
            }
            if (null != cur.left){
                stack.push(cur.left);
            }
            //。。。
        }
        return rs;//todo 见官方代码的奇妙解法
    }

    /**
     * 官方思路
     * 后序遍历--> 左右中，反过来就是中右左
     * 之前前序遍历的输出是中左右，那就把前序遍历的左右顺序颠倒一下，然后把输出数组翻转
     *
     * #cm 这是什么神仙思路啊我靠。。这nm是人能想到的吗？？
     */
    public List<Integer> postOrderTraversal2(TreeNode root){
        /** 省略判空*/

        TreeNode cur;
        List<Integer> rs = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            cur = stack.pop();
            rs.add(cur.val);

            if (null != cur.left){
                stack.push(cur.left);
            }

            if (null != cur.right){
                stack.push(cur.right);
            }
        }
        Collections.reverse(rs);
        return rs;
    }

    /**
     * 参考后序遍历的方法二
     *
     * 那不如把原树做翻转二叉树，然后调用前序遍历，再翻转res[]
     * @param root
     * @return
     */
    public List<Integer> postOrderTraversal3(TreeNode root){
        //todo 先翻转二叉树
        return postOrderTraversal2(root);
    }
    ///===================自己代码⬆⬆⬆⬆=================









    ///===================官方代码⬇⬇⬇⬇=================


    /**
     * ===前序遍历===
     * 父节点进栈 -> 父节点出栈并记录 -> 右孩子进栈 -> 左孩子进栈 -> 指针指向栈顶的节点
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            //进栈到出栈一次 -> 当前节点记录一次
            //然后进栈当前节点的子节点，所以是父左右的遍历顺序，因为父已经出栈并记录结果了，子节点再相继入出栈
            TreeNode node = stack.pop();
            result.add(node.val);
            //cur访问树的节点的顺序，和把当前cur记录到结果数组的顺序是一直的，只要把握后进先出，先序遍历就是中左右，所以当前节点不进栈，孩子的进栈顺序是右左就行
            if (node.right != null){
                stack.push(node.right);
            }
            if (node.left != null){
                stack.push(node.left);
            }
        }
        return result;
    }


    /**
     * ===中序遍历===
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()){    //当前节点遍历到右边叶子了，或者栈空了，就结束，因为只要cur还是父节点或左节点，栈就不可能是空的
            if (cur != null){   //如果cur不是空的，叶子或者有孩子
                stack.push(cur);    //只要你还有左孩子你就进栈
                cur = cur.left;     //cur一路走到左孩子，
            }else {     //cur为空，说明栈顶元素没有左孩子，就可以输出当前节点
                cur = stack.pop();
                result.add(cur.val);
                cur = cur.right;    //此时走到中了，然后就是右，再循环判断右孩子有没有左孩子
            }
        }
        return result;
    }



}
//leetcode submit region end(Prohibit modification and deletion)

}