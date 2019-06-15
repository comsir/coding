
class HoldLockDemo implements Runnable{
    private String lockA;
    private String lockB;

    public HoldLockDemo(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @Override
    public void run() {
        synchronized (lockA) {
            System.out.println(Thread.currentThread().getName()+"\t 自己持有"+lockA+"\t尝试持有"+lockB);
            synchronized (lockB) {
                System.out.println(Thread.currentThread().getName()+"\t 自己持有"+lockB+"\t尝试持有"+lockA);
            }
        }
    }
}
/*
*死锁是指两个或两个以上的进程在执行过程中，
* 因争夺资源而造成的一种互相等待的现象
* 若无外力干涉那它都将无法推进下去
* */
public class DeadLockDemo {
    public static void main(String[] args) {
        String lockA = "lockA";
        String lockB = "lockB";

        new Thread(new HoldLockDemo(lockA, lockB),"aaa").start();
        new Thread(new HoldLockDemo(lockB, lockA),"bbb").start();

    }
}
