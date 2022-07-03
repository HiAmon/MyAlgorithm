package hw.interview.search;

/**
 * 二分查找
 */
public class MyBinarySearch {

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7,8};
        System.out.println(new MyBinarySearch().search(arr,6));
    }
    public int search(int[] nums, int target){
        if (null == nums){
            return -1;
        }
        int len = nums.length;
        if (len == 0){
            return -1;
        }
        if (len == 1){
            return nums[0]==target?0:-1;
        }


        int low = 0;
        int high = len-1;
        int mid = 0;
        //查找时优先比较mid，故mid左右用开区间[low,mid),(mid,high]
        while (low <= high){   //🟢 因为下面的处理中把mid排除了，所以这里low和high碰撞是有意义的，要用<=而不是<
//            mid = (low+high)/2;  //防溢出！！
            mid = (high-low)/2 + low;
            if (target == nums[mid]){
                return mid;
            }else if (target > nums[mid]){ //在右边
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
