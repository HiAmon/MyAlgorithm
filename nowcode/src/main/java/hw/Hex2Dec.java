package hw;

import java.util.Scanner;

/**
 * 十六进制转成十进制
 */
public class Hex2Dec {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()){
            //十六进制转十进制
            String i = in.nextLine();
            if ("".equals(i)){
                break;
            }
            i = i.split("0x")[1];
            long l = Long.parseLong(i, 16);
            System.out.println(l);
        }
    }
}
