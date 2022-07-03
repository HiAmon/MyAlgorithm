package hw.last;

import java.util.*;

/**
 * 华为2016研发工程师编程题 --> 参考答案
 */
class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
    }
}

public class DeleteNumberSolution2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //方法三：构建循环链表模拟
        while (scanner.hasNext()) {
            int n = scanner.nextInt();

            //构建0到n-1的循环链表
            Node head = new Node(0);
            Node tail = head;
            for (int i = 1; i < n; i++) {
                Node cur = new Node(i);
                tail.next = cur;
                tail = cur;
            }
            tail.next = head;

            //指针跨越模拟节点删除
            Node pre = null;
            Node cur = head;
            Node post = null;
            int flag = 1;
            while (cur.next != cur) {
                if (flag != 3) {
                    pre = cur;
                    cur = cur.next;
                    flag++;
                } else {
                    post = cur.next;
                    cur = post;
                    //跳跃
                    pre.next = cur;
                    flag = 1;
                }
            }
            System.out.println(cur.data);
        }
        scanner.close();
    }
}
