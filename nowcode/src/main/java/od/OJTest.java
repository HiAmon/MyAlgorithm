package od;

import java.math.BigInteger;
import java.util.Scanner;

public class OJTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String num = in.nextLine();
        BigInteger bigInteger = new BigInteger(num,10);
        BigInteger two = new BigInteger("2",10);
        BigInteger i = new BigInteger("2",10);
        while (i.compareTo(bigInteger.divide(two))<0){
            BigInteger[] arr = bigInteger.divideAndRemainder(i);
            if (arr[1].equals(BigInteger.ZERO) && arr[0].isProbablePrime(1)){
                System.out.println(i+" "+arr[0]);
                return;
            }
            i = i.nextProbablePrime();
        }
        System.out.println("-1 -1");
    }

}
