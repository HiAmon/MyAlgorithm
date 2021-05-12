package hw;

import java.util.Scanner;

/**
 * 酸奶写的。。。
 */
public class A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()){
            int n = in.nextInt();
            int[] data = new int[n];
            for (int i = 0; i < data.length; i++) {
                data[i] = 1;
            }
            int k = 0;
            while(true) {
                int count = 0;
                int index = -1;
                for (int i = 0; i < data.length; i++) {
                    if(data[i] == 1) {
                        index = i;
                        count++;
                    }
                }
                if(count == 1) {
                    System.out.println(index);
                    return;
                }
                boolean del = false;

                while(!del) {
                    int hit = 0;
                    for (;;k++) {
                        if(k == data.length) {
                            k = 0;
                        }
                        if(data[k] == 1 && ++hit==3) {
                            data[k] = 0;
                            del = true;
                            break;
                        }
                    }
                }
            }

        }

    }

}
