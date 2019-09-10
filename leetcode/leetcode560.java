package leetcode;

import java.util.HashMap;

public class leetcode560 {
    public static int subarraySum(int nums[], int k) {
        int[] sum = new int[nums.length + 1];
        sum[0] = 0;
        int count = 0;
        for (int i = 1; i <=nums.length; i++) {
            sum[i] = sum[i-1] + nums[i-1];
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < sum.length; i++) {
            if(map.containsKey(sum[i]-k)) {
                count+=map.get(sum[i]-k);
            }
            map.put(sum[i], map.getOrDefault(sum[i], 0)+1);
        }
        return count ;
    }
    public int subarraySum2(int[] nums, int k) {
        int count  = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = 0; j < nums.length; j++) {
                sum+=nums[j];
                if(sum==k) {
                    count ++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] res = {28,54,7,-70,22,65,-6};
        int k = 100;
        System.out.println(subarraySum(res, k));
    }
}
