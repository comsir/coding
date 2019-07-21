import java.util.ArrayDeque;
import java.util.ArrayList;

public class slidWindow {
    public static void main(String[] args) {

    }

    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(num==null || size==0) return list;
        int length = num.length - size + 1; //共有几个滑动窗口
        int i = 0;
        while(length>0) {
            int j = i;
            int max = 0;
            int curr = size;
            while(curr>0) {
                max = Math.max(max, num[j++]);
                curr--;
            }
            list.add(max);
            i++;
            length--;
        }
        return list;

    }

    /**
     用一个双端队列，队列第一个位置保存当前窗口的最大值，当窗口滑动一次
     1.判断当前最大值是否过期
     2.新增加的值从队尾开始比较，把所有比他小的值丢掉
     */
    public ArrayList<Integer> maxInWindows2(int [] num, int size)
    {
        ArrayList<Integer> res = new ArrayList<>();
        if(size == 0) return res;
        int begin;
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for(int i = 0; i < num.length; i++){
            begin = i - size + 1;
            if(q.isEmpty())
                q.add(i);
            else if(begin > q.peekFirst())
                q.pollFirst();

            while((!q.isEmpty()) && num[q.peekLast()] <= num[i])
                q.pollLast();
            q.add(i);
            if(begin >= 0)
                res.add(num[q.peekFirst()]);
        }
        return res;
    }
}
