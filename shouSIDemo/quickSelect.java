package shouSIDemo;

//从数组中找出第 k 小的元素：
public class quickSelect {
    public static int quickselect(int[] nums, int k) {
        int i = 0;
        int j = nums.length - 1;

        while (i<=j) {
            int partitionIdx = partition(nums, i, j);
            if((k-1)==partitionIdx) {
                return nums[partitionIdx];
            } else if ((k - 1) < partitionIdx) {
                j = partitionIdx - 1;
            }else {
                i = partitionIdx + 1;
            }
        }
        return 0;
    }

    private static int partition(int[] nums, int start, int end) {
        if(start == end) {
            return start;
        }
        int pivot = nums[start];

        while (start < end) {
            //从右边找到最小的
            while (start<end && nums[end] >=pivot) {
                end--;
            }

            nums[start] = nums[end];
            //从左边找到最大的
            while (start<end && nums[start] <= pivot) {
                start++;
            }
            nums[end] = nums[start];
        }
        nums[start] = pivot;
        return start;
    }

    public static void main(String[] args) {
        int[] arr = {23,46,0,8,11,18};
        int res = quickselect(arr, 1);
        System.out.println(res);
    }
}
