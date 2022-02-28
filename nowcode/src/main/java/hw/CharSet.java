package hw;

import java.util.Scanner;
import java.util.TreeSet;
import java.util.stream.Stream;

/**
 * 华为2016研发工程师编程题:
 * 2. 输入一个字符串，求出该字符串包含的字符集合
 */
public class CharSet {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()){
            String input = in.nextLine();
            if ("".equals(input)){
                break;
            }
            String[] s = new String[input.toCharArray().length];
            for (int i = 0; i < input.toCharArray().length; i++) {
                s[i] = String.valueOf(input.toCharArray()[i]);
            }
            Stream.of(s).distinct().forEach(e-> System.out.printf(e));
            System.out.println();
        }
    }

}
