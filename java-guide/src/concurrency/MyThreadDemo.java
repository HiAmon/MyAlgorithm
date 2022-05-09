package concurrency;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

public class MyThreadDemo {

    public static final int DELAY = 10;
    public static final int STEPS = 3;
    public static final double MAX_AMOUNT = 10000;

    public static void main(String[] args) {
        Bank bank = new Bank(4,100000);

        Runnable task1 = () -> {
            try {
                for (int i = 0; i < STEPS; i++) {
                    double amount = MAX_AMOUNT*Math.random();
                    bank.transfer(0,1,amount);
                    Thread.sleep((int)(DELAY*Math.random()));
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        };


        Runnable task2 = () -> {
            try {
                for (int i = 0; i < STEPS; i++) {
                    double amount = MAX_AMOUNT*Math.random();
                    bank.transfer(2,3,amount);
                    Thread.sleep((int)(DELAY*Math.random()));
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        };

        /**
         * Callable和Runnable的区别，可以返回值，可以抛异常，但是不能传入Thread构造器，只能用线程池来调用
         */
        Callable<MySynchronizeDemo> callable = new Callable<MySynchronizeDemo>() {
            @Override
            public MySynchronizeDemo call() throws Exception {
                return null;
            }
        };

        new Thread(task1).start();
        new Thread(task2).start();
        ExecutorService service = Executors.newCachedThreadPool();
        Executors.newFixedThreadPool(5, Executors.defaultThreadFactory());
//        Executors.newScheduledThreadPool();
        Future<MySynchronizeDemo> future = service.submit(callable);
        service.execute(task1);

        Thread thread = new ThreadFactoryBuilder().build().newThread(task1);
        thread.start();

    }
}
/**
 * 输出结果：
 * thread0 run begin...
 * thread2 run begin...
 * thread5 run begin...
 * thread3 run begin...
 * thread4 run begin...
 * thread6 run begin...
 * thread1 run begin...
 * thread7 run begin...
 * thread8 run begin...
 * thread9 run begin...
 * thread0 run end...
 * thread3 run end...
 * thread4 run end...
 * thread6 run end...
 * thread7 run end...
 * thread2 run end...
 * thread1 run end...
 * thread8 run end...
 * thread5 run end...
 * thread9 run end...
 *
 * 结论：线程之间是CPU周期抢占式执行，
 */