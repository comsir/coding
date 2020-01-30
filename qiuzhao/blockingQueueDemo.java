import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ShareData {//资源类
    private int number = 0;
    //锁
    private Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();
    public void increment() throws Exception{
        lock.lock(); //进来 同步代码块加锁
        try{
            //1.判断
            while(number != 0) {
                //等待，不能生产
                condition.await();//如果没有被消费 就等待 也就是 加了1后还没减1
            }
            //2.判断好了 干活
            number++;
            System.out.println(Thread.currentThread().getName()+number);
            //3.通知唤醒
            condition.signalAll();
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void decrement() throws Exception{
        lock.lock(); //进来 同步代码块加锁
        try{
            //1.判断
            while(number == 0) {
                //等待，不能生产
                condition.await();//没有加1 就绝不会减1
            }
            //2.判断好了 干活
            number--;
            System.out.println(Thread.currentThread().getName()+number);
            //3.通知唤醒
            condition.signalAll();
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}

public class blockingQueueDemo {
    //题目：一个初始值为0的变量，两个线程对其交替操作，一个加1一个减1
    //操作高并发口诀：
    //1.高内聚低耦合 线程操作(方法)资源类
    //2.判断干活唤醒通知
    //3.严防多线程下的虚假唤醒 (唤醒用while 不用if 如果用if 多线程下如用虚假唤醒)
    public static void main(String[] args) {
        ShareData shareData = new ShareData();
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    shareData.increment();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "aa").start();

        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    shareData.decrement();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "bb").start();
    }
}
