import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
* 模拟十个用户到五个窗口办理业务
* */
public class myThreadPoolDemo {
    public static void main(String[] args) {
//        ExecutorService threadPool = Executors.newFixedThreadPool(5);//固定线程数的线程池 值为5
//        ExecutorService threadPool = Executors.newSingleThreadExecutor();
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
