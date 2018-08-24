package demo;

import java.util.concurrent.*;

public class ThreadPoolTest {
    public static void main(String[] args) {
        //ThreadPoolTest.newCachedThreadPool();
        //ThreadPoolTest.newFixedThreadPool();
        ThreadPoolTest.selfDefineThreadPool();
    }

    /**
     * 创建缓存线程池
     * 缓存线程池，初始线程数为0，无上限
     */
    public static void newCachedThreadPool(){
        MyRunnable myRunnable = new MyRunnable();
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < 10; i++) {
            executorService.submit(myRunnable);
        }

        executorService.shutdown();
    }

    /**
     * 创建固定线程数的线程池
     * 在构造函数中定义线程的数目
     */
    public static void newFixedThreadPool(){
        MyRunnable myRunnable = new MyRunnable();
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            executorService.submit(myRunnable);
        }
        executorService.shutdown();
    }

    /**
     * 单线程线程池
     */
    public static void newSingleThreadPool(){
        MyRunnable myRunnable = new MyRunnable();
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5; i++) {
            executorService.submit(myRunnable);
        }
        executorService.shutdown();
    }

    /**
     * 周期线程池
     */
    public static void newSchduleThreadPool(){
        MyRunnable myRunnable = new MyRunnable();
        ExecutorService executorService = Executors.newScheduledThreadPool(5);
        for (int i = 0; i < 10; i++) {
            executorService.submit(myRunnable);
        }
        executorService.shutdown();
    }

    public static void selfDefineThreadPool(){
        BlockingQueue<Runnable> blockingQueue = new ArrayBlockingQueue<>(1);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5,10,1L,TimeUnit.SECONDS,blockingQueue);
        for (int i = 0; i < 200; i++) {
            Future<String> future = threadPoolExecutor.submit(new MyCallable<String>());
            try {
                System.out.println(future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            //threadPoolExecutor.submit(new MyCallable<String>());
        }
        threadPoolExecutor.shutdown();
    }

    static class MyRunnable implements Runnable{

        @Override
        public void run() {
            System.out.println("当前线程：" + Thread.currentThread().getName());
        }
    }

    static class MyCallable<String> implements Callable<String> {

        @Override
        public String call() throws Exception {
            //System.out.println("当前线程为： " + Thread.currentThread().getName());
            return (String) Thread.currentThread().getName();
        }
    }
}
