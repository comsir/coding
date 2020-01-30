package JobFinding;

import java.util.Arrays;
import java.util.Stack;

/*
* 平均并行度为 nlog(n)
* 最坏是 n^2 有序的时候
* 所以用快排是越乱越好
*
* 递归实现
* */
public class quickSort {
    public int[] sortQuick(int[] in, int left, int right) {
        //选定数组的第一个元素为key
        int key = in[left];
        int start = left;
        int end = right;
        while (start<end) {
            //从右向左遍历，找到小于key的值，放入下标为start
            while (start<end && key<in[end]) {
                end--;
            }
            in[start] = in[end];

            //从左向右遍历 找到大于key的值，放入下标end中
            while (start<end && key>in[start]) {
                start++;
            }
            in[end] = in[start];
        }
        //此时start==end 这就是轴的位置，把key放入这个位置，轴的左边小于key,右遍大于key
        in[start] = key;
        sortQuick(in, left, start-1);
        sortQuick(in, end+1, right);
        return in;
    }
    /*
    * 非递归实现快排
    * 一般递归的转化成非递归都这么玩：
    * 将变动的放入stack中，弹出父，判断是否有子，加入子 ，
    * 结束条件都是（！stack.isEmpty()）
    *
    * */
    public int[] nonRec_sortQuick(int[] in, int start, int end) {
        Stack<Integer> stack = new Stack<>();
        int index = start;
        int left = start;
        int right = end;
        if(start<end) {
            stack.push(end);
            stack.push(start);
            while(!stack.isEmpty()) {
                left = stack.pop();
                right = stack.pop();
                index = partition(in, left, right);
                if(left<index-1) {
                    stack.push(index-1);
                    stack.push(left);
                }
                if(right>index+1) {
                    stack.push(right);
                    stack.push(index+1);
                }
            }
        }

        return in;
    }
    private static int partition(int[] in, int start, int end) {
        int key = in[start];
        while (start<end) {
            while(start<end && key>in[end]) {
                end--;
            }
            in[start] = in[end];

            while(start<end && key<in[start]) {
                start++;
            }
            in[end] = in[start];
        }
        in[start] = key;
        return start;
    }

}
