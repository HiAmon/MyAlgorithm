package hw.interview.sort.nlogn;


/**
 * 归并排序
 * 使用分治法的思想
 * 使用递归来实现，两两排序然后合并 2->4->8->16。。
 */
public class MyMergeSort {

    public void arraySort(int[] arr, int low, int high) {
        if (low >= high){
            return;
        }
        int mid = (high-low)/2 + low;
        arraySort(arr, low, mid);
        arraySort(arr, mid+1, high);
        merge(arr, low, mid, high);
    }

    public void merge(int[] arr, int low, int mid, int high){
        int i = low;
        int j = mid + 1;
        int[] aux = new int[arr.length];
        for (int k = 0; k < high; k++) {
            aux[k] = arr[k];
        }

        for (int k = low; k < high; k++) {
            if (i > mid){
                arr[k] = aux[j++];
            }else if (j > high){
                arr[k] = aux[i++];
            }else if (aux[j] < aux[i]){
                arr[k] = aux[j++];
            }else {
                arr[k] = aux[i++];
            }
        }
    }
}
