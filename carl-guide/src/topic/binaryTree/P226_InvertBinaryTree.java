package topic.binaryTree;

//给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [4,2,7,1,3,6,9]
//输出：[4,7,2,9,6,3,1]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：root = [2,1,3]
//输出：[2,3,1]
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
// 树中节点数目范围在 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 1173 👎 0

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Q：翻转二叉树
 * 翻转和遍历的区别和联系
 *
 * 翻转是在指针指向当前节点的时候，把它的左右孩子交换一下，这个只要一个简单的swap方法就可以实现，
 * 而它的重点依然是在遍历过程上，因为首先需要指针把所有节点都过一遍。
 *
 * 所以这道题的几种解法和遍历是一样的，有递归和迭代，
 * 其中迭代又分为DFS和BFS，
 * DFS的遍历顺序和递归很像使用栈
 * BFS就是层序遍历，使用队列
 *
 * @https://programmercarl.com/0226.%E7%BF%BB%E8%BD%AC%E4%BA%8C%E5%8F%89%E6%A0%91.html#%E9%80%92%E5%BD%92%E6%B3%95
 */
public class P226_InvertBinaryTree{
    public static void main(String[] args) {
        Solution solution = new P226_InvertBinaryTree().new Solution();
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);
//        solution.invertTree(root);
        solution.invertTree2(root);
//        solution.invertTree3(root);
        System.out.println("sdsd");
    }

//leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    /**
     * 递归解法
     *
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (null == root){
            return null;
        }
        swapChildren(root);//翻转当前节点的左右孩子节点
        invertTree(root.left);//进入左子树进行翻转
        //当入参节点的左孩子下面全部左右翻转之后
        invertTree(root.right);//再进入右子树进行翻转
        return root;
    }

    public void swapChildren(TreeNode node){
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
    }

    //--------------------------------------------

    /**
     * 迭代解法
     *
     * 深度优先遍历，遍历过程中翻转，依然是用栈，但是因为需要翻转，所以可以利用LIFO特性
     * todo ？这个解法是对的么？有点着急了
     * @param root
     * @return
     */
    public TreeNode invertTree2(TreeNode root){
        Deque<TreeNode> deque = new LinkedList<>();      //pop() 弹出时如果栈为空会抛异常，而poll() 只会返回空
        deque.push(root);
        while (null != root || !deque.isEmpty()){
            if (deque.size() <= 0){
                break;
            }
            TreeNode cur = deque.poll();
            swapChildren(cur);
            if (null != cur.left){
                deque.push(cur.left);
            }
            if (null != cur.right){
                deque.push(cur.right);
            }
        }
        return root;
    }

    /**
     * 迭代解法
     *
     * 广度优先（就是层序遍历）
     * 用队列
     * 做法：每次进队列，都会
     * @param root
     * @return
     */
    public TreeNode invertTree3(TreeNode root){
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);  //offer和push有什么不同呢？todo
        while (!queue.isEmpty()){
            int len = queue.size();
            while (len > 0) {
                TreeNode cur = queue.pop();
                swapChildren(cur);
                //弹出当前节点并做交换处理，然后将孩子进队，内循环的数量就是当前层的节点数量
                if (null != cur.left){
                    queue.push(cur.left);
                }
                if (null != cur.right){
                    queue.push(cur.right);
                }
                len--; //可以优化成 while(len-- > 0)，不过这个无所谓了，也不帮助理解
            }
        }
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}