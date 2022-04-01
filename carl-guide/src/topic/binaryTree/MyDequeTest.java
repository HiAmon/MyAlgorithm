package topic.binaryTree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class MyDequeTest {
    public static void main(String[] args) {
        /**
         * 想试一下new同一个对象用不同的类名来接，实际创建的对象大小有区别吗。。
         * 也算是多态的一种把
         */


        long begin = Runtime.getRuntime().freeMemory();
        Queue<TreeNode> queue = new LinkedList<>();
        for (int i = 0; i < 1000; i++) {
            queue.add(new TreeNode(1));
        }
        long end = Runtime.getRuntime().freeMemory();
        System.out.println((begin-end)/1024.00 + "kb");

        //-------
        long begin1 = Runtime.getRuntime().freeMemory();
        Deque<TreeNode> queue1 = new LinkedList<>();
        for (int i = 0; i < 1000; i++) {
            queue1.add(new TreeNode(1));
        }
        long end1 = Runtime.getRuntime().freeMemory();
        System.out.println((begin1-end1)/1024.00 + "kb");

    }
}
