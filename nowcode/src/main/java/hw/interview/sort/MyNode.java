package hw.interview.sort;

/**
 * 自定义链表节点
 */
public class MyNode {

    public int val;
    public MyNode next;

    public MyNode() {}

    public MyNode(int val) {
        this.val = val;
    }

    public MyNode(int val, MyNode next) {
        this.val = val; this.next = next;
    }
}
