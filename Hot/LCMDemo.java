package Hot;

import java.util.HashSet;
import java.util.Stack;

public class LCMDemo {
    public static void main(String[] args) {
        int[] arr = {12,23,5,32,3,4,6,1,8,2};
        int a = 3;
        System.out.println(findKthLargest(arr, a));
    }

    //给定一个无序数据，求第k个最大元素，要求复杂度O(n)
    public static int findKthLargest(int[] arr, int a) {
        if(arr==null || arr.length==0) {
            return -1;
        }
        return quickSelect(arr, 0, arr.length-1, a);
    }

    public static int quickSelect(int[] arr, int start, int end, int k) {
        if(start==end) return arr[start];
        int left = start;
        int right = end;
        int tmp = arr[(start+end)/2];
        while (left<right) {
            while (left <= right && arr[left] > tmp) {
                left++;
            }
            while (left <= right && arr[right] < tmp) {
                right--;
            }
            if(left<=right) {
                int s = arr[left];
                arr[left] = arr[right];
                arr[right] = s;
                left++;
                right--;
            }
        }
        if(start + k -1<=right) {
            return quickSelect(arr, start, right, k);
        }
        if(start + k -1>=left) {
            return quickSelect(arr, left, end, k-(left-start));
        }
        return arr[right + 1];
    }
}
