package hw.last;

import java.util.Scanner;

public class Main{
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        String input = "";
        while(in.hasNextLine()){
            input = in.nextLine();
            if (null == input || "".equals(input)){
                break;
            }
            System.out.println(new StringBuilder(input).reverse());
        }
        in.close();
    }
}