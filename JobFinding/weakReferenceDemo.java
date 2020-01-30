package JobFinding;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
/*
* 虚引用在被GC之后会放到引用队列中
* */
public class weakReferenceDemo {
    public static void main(String[] args) throws InterruptedException {
     Object a = new Object();
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
        WeakReference<Object> weakReference = new WeakReference<>(a, referenceQueue);
        System.out.println(a);
        System.out.println(weakReference.get());
        System.out.println(referenceQueue.poll());

        System.out.println("======================");
        a=null;
        System.gc();
        Thread.sleep(500);

        System.out.println(a);
        System.out.println(weakReference.get());
        System.out.println(referenceQueue.poll());
    }
}
