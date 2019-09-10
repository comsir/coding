package shouSIDemo;

import java.util.LinkedList;
import java.util.Queue;
//其实思路就是 queue1主要存取
//queue2只是辅助存取
public class TwoQueueToStack {
    private Queue<Integer> queue1;
    private Queue<Integer> queue2;

    public TwoQueueToStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }
    private void moveItem(){
        while (queue1.size() != 1) {
            queue2.offer(queue1.poll());
        }
    }

    private void swapQueues () {
        Queue<Integer> tmpQueue = queue1;
        queue1 = queue2;
        queue2 = tmpQueue;
    }

    public void push(int value) {
        queue1.offer(value);
    }
    public int top() {
        moveItem();
        int item = queue1.poll();
        //不能改变的
        swapQueues();
        queue1.offer(item);
        return item;
    }
    public void pop() {
        moveItem();
        queue1.poll();
        swapQueues();
    }
    public boolean isEmpty() {
        return queue1.isEmpty();
    }
}
