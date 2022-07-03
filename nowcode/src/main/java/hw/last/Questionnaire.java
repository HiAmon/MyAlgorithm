package hw.last;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 去重+排序
 */
public class Questionnaire {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()){
            int n = in.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = in.nextInt();
            }
            int[] ints = Arrays.stream(nums).distinct().sorted().toArray();
            for (int anInt : ints) {
                System.out.println(anInt);
            }
        }
    }
}
