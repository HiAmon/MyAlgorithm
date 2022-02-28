package hw;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 牛客输入输出练习
 * integer取值范围：负21亿多到正21亿多，2的31次方，十位的十进制
 * long的取值范围：负922亿亿到正922亿亿，2的63次方，19位的十进制
 */
public class OJTest {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        while (in.hasNextInt()){
//            int a  = in.nextInt();
//            int b  = in.nextInt();
//            System.out.println(a+b);
//        }
//        in.close();
//    }

//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        for (int i = 0; i < n; i++) {
//            int a = in.nextInt();
//            int b = in.nextInt();
//            System.out.println(a + b);
//        }
//        in.close();
//    }

//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        while (in.hasNextInt() ){
//            int a = in.nextInt();
//            int b = in.nextInt();
//            if (a == 0 && b == 0){
//                break;
//            }
//            System.out.println(a+b);
//        }
//    }

//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        while (in.hasNextInt()){
//            int n = in.nextInt();
//            if (n == 0){
//                break;
//            }
//            int sum = 0;
//            for (int i = 0; i < n; i++) {
//                sum += in.nextInt();
//            }
//            System.out.println(sum);
//        }
//    }

//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//
//        while (in.hasNextLine()){
//            String line = in.nextLine();
//            if ("".equals(line)){
//                break;
//            }
//            String[] s = line.split(" ");
//            Integer sum = Arrays.stream(s).map(Integer::parseInt).reduce((o1, o2) -> (o1 + o2)).get();
//            System.out.println(sum);
//        }
//    }

//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = Integer.parseInt(in.nextLine());
//        String s = in.nextLine();
//        String[] arr = s.split(" ");
//        String collect = Arrays.stream(arr).sorted(String::compareTo).collect(Collectors.joining(" "));
//        System.out.println(collect);
//    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()){
            String s = in.nextLine();
            if ("".equals(s)){
                break;
            }
            String[] arr = s.split(" ");
            String collect = Arrays.stream(arr).sorted(String::compareTo).collect(Collectors.joining(" "));
            System.out.println(collect);
        }
    }

//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        while (in.hasNextLine()){
//            String s = in.nextLine();
//            if ("".equals(s)){
//                break;
//            }
//            String[] arr = s.split(",");
//            String collect = Arrays.stream(arr).sorted().collect(Collectors.joining(","));
//            System.out.println(collect);
//        }
//    }

//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        while (in.hasNextLong()){
//            long a = in.nextLong();
//            long b = in.nextLong();
//            System.out.println(a+b);
//        }
//    }


//    /**
//     * 无限流  是啥
//     * @param args
//     */
//    public static void main(String[] args) {
//        Stream<Integer> stream4 = Stream.iterate(0,(x) -> x+2);
//        Stream<Double> random = Stream.generate(() -> Math.random());
//        while (random.iterator().hasNext()){
//            System.out.println(random.iterator().next());
//        }
//    }

}
