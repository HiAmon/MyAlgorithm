package hw.interview.sort.nn;

import hw.interview.sort.MyNode;
import hw.interview.sort.MySortable;

/**
 * 冒泡排序
 *
 * 两两交换，每一趟把第n大的元素送到第n右的位置，一共n-1趟
 */
public class MyBubbleSort implements MySortable<Integer> {
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{5,4,3,2,1};
        new MyBubbleSort().arraySort(arr);
        new MyBubbleSort().arraySort_optimized(arr);
    }

    @Override
    public void arraySort(Integer[] array) {
        int len = array.length;

        /**
         *
         * len=5，k∊[0,4-n)       ▼这就是右指针的右边界
         * 当n=0，k∊[0,4)，k+1∊[1,4]
         * 当n=1，k∊[0,3)，k+1∊[1,3]
         * 当n=2，k∊[0,2)，k+1∊[1,2]
         * 当n=3，k∊[0,1)，k+1∊[1,1]
         */
        for (int n = 0; n < len-1; n++) {   //n表示趟次，第0～n-1趟
            for (int k = 0; k < len-1 - n;k++){
                if (array[k] > array[k+1]){
                    arraySwap(k,k+1,array);
                }
            }
        }

    }

    /**
     * [对最好情况进行优化]：对于没有发生交换的排序，说明已经有序，直接退出
     * [最好情况是]：当数组本来就有序，只需要一趟就能发现并退出
     * @param array
     */
    public void arraySort_optimized(Integer[] array) {
        int len = array.length;

        for (int n = 0; n < len-1; n++) {
            boolean hasSwap = false;
            for (int p = 0; p < len-1-n; p++) {
                if (array[p] > array[p+1]){
                    arraySwap(p,p+1,array);
                    hasSwap = true;
                }
            }
            if (!hasSwap){
                break;
            }
        }

    }

    @Override
    public void linkedSort(MyNode head) {

    }
}
