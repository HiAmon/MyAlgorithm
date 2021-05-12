package hw;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * 十六进制转成十进制
 */
public class Hex2Dec {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //十六进制转十进制
        long l = Long.parseLong(in.next(), 16);
        System.out.println(l);
        in.close();
    }
}
