package JobFinding;
//生产者消费者模式
//volatile/cas/atomicInteger/blockQueue/线程交互/原子性

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

//资源类
class myresource {
    //标记位
    private volatile boolean FLAG = true;//默认开启生产和消费 同时进行 生产一个消费一个
    //原子变量
    private AtomicInteger atomicInteger = new AtomicInteger();
    BlockingQueue<String> blockingQueue = null;
    //构造注入
    //一般都传接口
    public myresource(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
        System.out.println(blockingQueue.getClass().getName());
    }
    //操作
    public void myProd() throws Exception {
        String data = null;
        Boolean retValue;
        //判断
        while (FLAG) {
            data = atomicInteger.incrementAndGet()+"";
            retValue = blockingQueue.offer(data, 2L, TimeUnit.SECONDS);
            if(retValue) {
                System.out.println(Thread.currentThread().getName()+"\t 插入队列"+data+"成功");
            }else {
                System.out.println(Thread.currentThread().getName()+"\t 插入队列"+data+"失败");
            }
            //一秒生产一个
            TimeUnit.SECONDS.sleep(1);
        }
        System.out.println(Thread.currentThread().getName()+"\t 停止 ，表示FLAG=false 不再生产");
    }
    public void myComsumer()throws Exception {
        String result = null;
        while(FLAG) {
            result = blockingQueue.poll(2L, TimeUnit.SECONDS);
            if(result ==null || result.equalsIgnoreCase("")) {
                FLAG = false;
                System.out.println(Thread.currentThread().getName()+"\t 超过两秒没有取到消息，退出");
                System.out.println();
                System.out.println();
                return;
            }
            System.out.println(Thread.currentThread().getName()+"\t 删除队列"+result+"成功");
        }
    }
    public void myStop()throws Exception {
        FLAG = false;
    }
}
public class LockSummaryDemo {
    public static void main(String[] args) {
        myresource myresource = new myresource(new ArrayBlockingQueue(10));
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"\t 生产线程启动");
            try {
                myresource.myProd();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"prcducer").start();

        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"\t 消费线程启动");
            try {
                myresource.myComsumer();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"consumer").start();
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("5秒中后线程暂停");
        try {
            myresource.myStop();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
