package topic.binaryTree;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class TraversalDemo {
    public static void main(String[] args) {
        TraversalDemo demo = new TraversalDemo();
        demo.callResolve();
    }


    private class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode() {
        }
    }

    /**
     * 前序遍历
     * 先输出当前节点，再遍历左子树（假如有的话），然后遍历右子树
     *
     * 直接输出结果
     */
    void traversalByPreOrder(TreeNode root){
        if (null == root){
            return;
        }
        System.out.println(root.val);
        traversalByPreOrder(root.left);
        traversalByPreOrder(root.right);
    }


    /**
     * 同样是前序遍历
     *
     * 输出到list的写法，因为在遍历方法里定义list会导致递归数量的list对象被创建，所以要分成两个方法
     */
    void traverseByPreOrderToList(TreeNode root){
        List<Integer> res = new ArrayList<>();
        traverse(root,res);
        System.out.println(new Gson().toJson(res));
    }

    void traverse(TreeNode node, List<Integer> list){
        if (null == node){
            return;
        }
        list.add(node.val);
        traverse(node.left,list);
        traverse(node.right,list);
    }

    public void callResolve(){
        Integer[] array = {1,2,null,3,4,5,null,null,6};
//        Integer[] array = {1,2,null};
        TreeNode root = resolveArrayToTree(array);
//        traverseByPreOrderToList(root);
        traversalByPreOrder(root);
    }

    /**
     * 反向解析数组到二叉树
     * （前提：该数组是默认将目标对象补全为完全二叉树后得到的 ）
     *
     * 用广度优先遍历的方式解析⬇
     */
    public TreeNode resolveArrayToTree(Integer[] array){
        TreeNode root = new TreeNode();
        root.val = array[0];
        TreeNode cur = root;    //cur指针
        /**
         * cur指针的移动
         * 当遇到null，或者两个孩子都赋值，才移动cur到下一个
         */

        for (Integer i = 1; i < array.length; i++) {
            if (null != array[i]){
                TreeNode node = new TreeNode();
                node.val = array[i];
                if (i%2 == 0){
                    cur.right = node;
                    if (null != cur.left){

                    }
                    cur = cur.left;
                }else {
                    cur.left = node;
                }
            }else {
                //遇到null时，cur移动到左孩子
                if (null == cur.right && null != cur.left){
                    cur = cur.left;
                }else if (null != cur.right){
                    cur = cur.right;
                }
            }
        }
        return root;
    }

}
