package temp;


import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Logger;

public class FizzBuzzDemo  {

    public static void main(String[] args) {
        for (int i = 100; i > 0; i--) {
            if ((i % 15) == 0){
                System.out.println("fizzbuzz");
            }else if ((i % 5) == 0){
                System.out.println("buzz");
            }else if ((i % 3) == 0){
                System.out.println("fizz");
            }else {
                System.out.println(i);
            }
        }

        new FizzBuzzDemo().jj();
    }

    public static void ii() throws SQLException {
        Long i = 4478302758038432590L;
        if (i < 0){
            throw new ArithmeticException("omg!");
        }else {
            throw new SQLException();
        }
    }

    public void jj(){
        try(Scanner in = new Scanner(System.in)) {
            while (isNotBlank(in.nextLine())){
                System.out.println("continue");
            }
            System.out.println("ending..");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void kk(){
        try (Scanner scanner = new Scanner(new File("test.txt"))) {
            while (scanner.hasNext()) {
                System.out.println(scanner.nextLine());
            }


        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        }
    }

    public boolean isNotBlank(String input){
        if (null == input || input.length() <= 0){
            return false;
        }
        if (input.matches("^\\s")){
            return false;
        }
        return true;
    }
}
