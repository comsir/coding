package leetcode;

public class leetcode162 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,1};
        System.out.println(findPeakElement(arr));


    }
    //1,2,3,1
    public static int findPeakElement(int[] nums) {
//        return MaxIndex(nums, 0, nums.length-1);
        return MaxIndex_iterator(nums, 0, nums.length-1);
    }
    public static int MaxIndex(int[] nums, int start, int end) {
        if(start == end) return start;
        int mid = (end + start)/2;
        if(nums[mid]>nums[mid+1]) {
            //下坡 峰值在左边
            return MaxIndex(nums, start, mid);
        } else {
            //上坡 峰值在有右边
            return MaxIndex(nums, mid + 1, end);
        }

    }
    public static int MaxIndex_iterator(int[] nums, int start, int end) {
        while(start != end) {
            int mid = (start + end)/2;
            if(nums[mid]> nums[mid + 1]) {
                end = mid;
            }else {
                start = mid + 1;
            }
        }
        return start;
    }

}
