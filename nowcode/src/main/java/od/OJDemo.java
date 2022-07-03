package od;

import java.util.LinkedList;
import java.util.Scanner;

public class OJDemo {

    class Node{
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        if (m <= 1 || m >= 100){
            System.out.println("ERROR!");
        }
        OJDemo demo = new OJDemo();
        demo.getLast(m);
    }

    public void getLast(int m){
        Node head = new Node(1);
        Node end = new Node(100);
        end.next = head;
        for (int i = 2; i <= 99; i++) {
            Node node = new Node(i);
            node.next = head.next;
            head.next = node;
            if (i == 99){
                node.next = end;
            }
        }

        Node cur = head;
        Node pre = end;
        int flag = 0;
        int sum = 100;
        while (sum >= m){
            if (flag == m-1){
                //剔除当前节点
                pre.next = cur.next;
                cur = cur.next;
                sum--;
            }else {
                //继续轮询
                cur = cur.next;
                pre = pre.next;
                flag++;
            }
        }
        while (cur.next!=cur){
            System.out.print(cur.data+",");
            cur = cur.next;
        }

    }
}
