package concurrency;

import java.util.concurrent.*;

public class ThreadPoolDemo {
    public static void main(String[] args) {
        BlockingDeque<Runnable> blockingDeque = new LinkedBlockingDeque<>();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1,5,500, TimeUnit.SECONDS,blockingDeque);

        threadPoolExecutor.execute(new PickChaoMi());
        Callable<BabyCat> chao = new ChaoMiBirth();
        Future<BabyCat> future = threadPoolExecutor.submit(chao);
        try {
            BabyCat babyCat = future.get();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    static class PickChaoMi implements Runnable{

        @Override
        public void run() {
            System.out.println("pick 炒米！");
        }
    }

    static class ChaoMiBirth implements Callable{

        @Override
        public Object call() throws Exception {
            return new BabyCat();
        }
    }

    static class BabyCat{
        String name;
    }
}
