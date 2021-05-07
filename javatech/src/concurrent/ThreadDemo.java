package concurrent;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;

public class ThreadDemo {

    public static void main(String[] args) {
        String test = null;
        switch (test){
            case "dd":
                System.out.println("dd");
                break;
            case "null":
                System.out.println("null");
                break;
            default:
                System.out.println("default");
        }
    }

    @Test
    public void test(){
        ArrayBlockingQueue<Runnable> objects = new ArrayBlockingQueue<>(10);
//        ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 10, 600, TimeUnit.SECONDS,objects);
//        executor.execute(()->{
//            System.out.printf("");
//        });
    }

    @Test
    public void test2(){
        List<Integer> integers = Arrays.asList(1, 2, 3, 4);
        //add/remove/clear --> java.lang.UnsupportedOperationException
        integers.add(5);
        //方法内部用 throw 来抛出异常！
        throw new UnsupportedOperationException("此适配器方法不支持增删改操作！");
    }

    /**
     * 方法签名上用的 throws 来抛出异常
     */
    private int getInt(Integer i) throws Exception{
        return i++;
    }

    @Test
    public void tst(){
        Scanner in = new Scanner(System.in);
        int[] arr = new int[10];
        int i = 0;
        while (!"0".equals(in.next())){
            arr[i] = Integer.parseInt(in.next());
        }
        System.out.println(arr);
    }


}
