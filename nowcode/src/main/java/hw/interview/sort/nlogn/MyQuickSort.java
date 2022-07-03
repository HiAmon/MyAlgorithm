package hw.interview.sort.nlogn;

import hw.interview.sort.MyNode;
import hw.interview.sort.MySortable;

/**
 * 综合性最强的排序算法
 * 法如其名，很快
 * 【重点】：pivot，左右指针
 */
public class MyQuickSort implements MySortable<Integer>{

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{8,9,5,2,1};
        new MyQuickSort().quickSort(arr,0,arr.length-1);
        for (int i = 0; i < arr.length; i++) {
            System.out.printf(arr[i] + " ");
        }
    }

    public void quickSort(Integer[] arr, int pivot, int right){
        if (pivot < right){
            int newPivot = partition(arr, pivot, right);
            quickSort(arr, pivot, newPivot-1);
            quickSort(arr, newPivot+1, right);
        }
    }

    public int partition(Integer[] arr, int low, int high){
        int i = low;
        int j = high + 1;
        int val = arr[low];
        while (true){
            while (arr[++i] < val){
                if (i == high){
                    break;
                }
            }
            while (val < arr[--j]){
                if (j == low){
                    break;
                }
            }
            if (i >= j){
                break;
            }
            arraySwap(i, j , arr);
        }
        arraySwap(low, j, arr);
        return j;
    }

//    public int partition(Integer[] arr, int pivot, int right){
//        int x = arr[right];
//        int i = pivot-1;
//        for (int j = pivot; j < right-1; j++){
//            if (arr[j] < x){
//                i++;
//                arraySwap(i,j,arr);
//            }
//        }
//        arraySwap(i+1,right,arr);
//        return i+1;
//    }


//======================
    @Override
    public void arraySort(Integer[] array) {

    }

    @Override
    public void linkedSort(MyNode head) {

    }
}
