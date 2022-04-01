package topic.binaryTree;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class TraversalDemo {
    public static void main(String[] args) {
        TraversalDemo demo = new TraversalDemo();
        demo.callResolve();
    }

    /**
     * 前序遍历
     * 先输出当前节点，再遍历左子树（假如有的话），然后遍历右子树
     *
     * 【直接输出结果的写法】比较简单
     */
    /**
     * 0. 确定递归函数的入参和返回值，这里只需要当前节点，所以是节点做入参，因为直接打印了不需要保存结果，所以返回void就好
     */
    void traversalByPreOrder(TreeNode root){
        /**
         * 1. 终止条件
         *
         * 当前节点为空时，不存在孩子，也就无法继续往下递归，故返回
         */
        if (null == root){
            return;
        }

        /**
         * 2. 单层递归的处理逻辑
         *
         * 这里就是输出
         */
        System.out.println(root.val);

        /**
         * 3. 递归的递推逻辑
         *
         * 因为是中左右的遍历顺序，所以中间输出完了就先到左孩子
         */
        traversalByPreOrder(root.left);     //递归左孩子，每次递归都输出当前节点，直到左下角
        traversalByPreOrder(root.right);
    }


    /**
     * 同样是前序遍历
     *
     * 【输出到list的写法】
     * 因为在遍历方法里定义list会导致递归数量的list对象被创建，所以要分成两个方法
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
        Integer[] array = {1,2,null,3,4,5,null,null,6}; //一颗倒V形的二叉树
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
     *
     * //这是一个未完成的方法把？ todo
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
