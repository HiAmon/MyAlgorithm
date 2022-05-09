package concurrency;

import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicDemo {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " :" + atomicInteger.incrementAndGet());
            }
        }).start();

        new Thread(()->
            System.out.println(Thread.currentThread().getName() + " :" + atomicInteger.get())
        ).start();

        new Thread(()->
                System.out.println(Thread.currentThread().getName() + " :" + atomicInteger.get())
        ).start();

        new Thread(() ->
                System.out.println(Thread.currentThread().getName() + " :" + atomicInteger.incrementAndGet())
        ).start();

        Executors.newFixedThreadPool(10);

    }
}
