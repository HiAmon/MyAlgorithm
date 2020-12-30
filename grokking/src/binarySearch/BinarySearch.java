package binarySearch;

public class BinarySearch {

    public static Integer binarySearch(int[] nums, int target){
        int low = 0;
        int high = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (target < nums[low + high]){
                high = (low + high)/2;
            }else if (target > nums[low + high]){
                low = (low + high)/2;
            }else {
                return high;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] a = new int[65536];
        for (int i = 0; i < 65536; i++) {
            a[i] = i+1;
        }
        int target = 389;
        long before = System.currentTimeMillis();
        System.out.println(binarySearch(a,target));
        System.out.println(System.currentTimeMillis() - before);

    }
}
