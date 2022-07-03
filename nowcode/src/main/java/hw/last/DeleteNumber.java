package hw.last;

import java.util.LinkedList;

/**
 * 华为2016研发工程师编程题：
 *
 * 有一个数组a[N]顺序存放0~N-1，要求每隔两个数删掉一个数，到末尾时循环至开头继续进行，
 * 求最后一个被删掉的数的原始下标位置。以8个数(N=7)为例:
 * ｛0，1，2，3，4，5，6，7｝，0->1->2(删除)->3->4->5(删除)->6->7->0(删除),
 * 如此循环直到最后一个数被删除。
 */
public class DeleteNumber {

    public static void main(String[] args) {
        LinkedList<Node> linkedList = new LinkedList<>();
        while (linkedList.size() > 3) {

        }
    }

    class Node{
        Node next;
        int index;

        public Node(Node next, int index) {
            this.next = this;
            this.index = index;
        }

        public Node getNext() {
            return next;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }
    }
}
