package JobFinding;/*
* 题目要求：
* 多线程之间顺序打印 A->B->C
* y要求如下：
* A线程打印5次，B线程打印10次，C线程打印15次
* 紧接着
* 来10轮
* */

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//资源类
class resource {
    //标志
    private int number = 0;
    //锁
    private Lock lock = new ReentrantLock();
    //条件
    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();
    private Condition c3 = lock.newCondition();
    //操作
    public void print5() {
       lock.lock();
       try {
           //1.判断
           while (number !=0) {
               c1.await();
           }
           //干活
           for (int i = 0; i < 5; i++) {
               System.out.println(Thread.currentThread().getName() + "\t"+i);
           }
           //通知唤醒
           number = 1;
           c2.signalAll();
       }catch (Exception e) {
           e.printStackTrace();
       }finally {
           lock.unlock();
       }
    }

    public void print10() {
        lock.lock();
        try {
            //1.判断
            while (number !=1) {
                c2.await();
            }
            //干活
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + "\t"+i);
            }
            //通知唤醒
            number = 2;
            c3.signalAll();
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void print15() {
        lock.lock();
        try {
            //1.判断
            while (number !=2) {
                c3.await();
            }
            //干活
            for (int i = 0; i < 15; i++) {
                System.out.println(Thread.currentThread().getName() + "\t"+i);
            }
            //通知唤醒
            number = 0;
            c1.signalAll();
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }


}
public class LocksDemo {
    public static void main(String[] args) {
        resource resource = new resource();
        new Thread(()->{
            for (int i = 0; i < 3; i++) {
                resource.print5();
            }
        }, "aa").start();

        new Thread(()->{
            for (int i = 0; i < 3; i++) {
                resource.print10();
            }
        }, "bb").start();

        new Thread(()->{
            for (int i = 0; i < 3; i++) {
                resource.print15();
            }
        }, "cc").start();
    }
}
