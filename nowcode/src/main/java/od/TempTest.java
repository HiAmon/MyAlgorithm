package od;

import java.math.BigInteger;

public class TempTest {
    public static void main(String[] args) {
        BigInteger bigInteger = new BigInteger("15",10);
        BigInteger integer = new BigInteger("2",10);
        BigInteger divide = bigInteger.divideAndRemainder(integer)[0];
        BigInteger divide2 = bigInteger.divideAndRemainder(integer)[1];
        System.out.println(divide);
        System.out.println(divide2);
    }
}
