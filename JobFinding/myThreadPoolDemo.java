package JobFinding;

import java.util.concurrent.*;


public class myThreadPoolDemo {
    public static void main(String[] args) {
        //自定义线程池
        //其实就是new一个ThreadPoolExecutor 然后自定义7个参数
        //根据参数maximunPoolSize=5和参数队列大小=3
        // 如果使用的是默认的拒绝策略 所以请求超过8就会报异常
        //java.util.concurrent.RejectedExecutionException: Task java.util.concurrent.FutureTask@7699a589 rejected from java.util.
        ExecutorService threadPool = new ThreadPoolExecutor(2,
                5,
                2L,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<Runnable>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());

        try{
            for (int i = 0; i < 10; i++) {
                threadPool.submit(()->{
                    System.out.println(Thread.currentThread().getName()+"\t 办理业务");
                });
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            threadPool.shutdown();
        }

    }
//jdk提供的线程池
/*
 * 模拟十个用户到五个窗口办理业务
 * */
    private static void JDKThreadPool() {
//      ExecutorService threadPool = Executors.newFixedThreadPool(5);//固定线程数的线程池 值为5
//      ExecutorService threadPool = Executors.newSingleThreadExecutor();
        ExecutorService threadPool = Executors.newCachedThreadPool();
        try{
            for (int i = 0; i < 10; i++) {
                threadPool.submit(()->{
                    System.out.println(Thread.currentThread().getName()+"\t 办理业务");
                });
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            threadPool.shutdown();
        }
    }
}
