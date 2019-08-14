package leetcode;

import java.util.HashSet;

public class leetcode128 {
    public int longestConsecutive(int[] nums) {
        if(nums==null && nums.length==0) return 0;
        HashSet<Integer> set = new HashSet<Integer>();
        for(int n : nums) {
            set.add(n);
        }
        int longest = 0;
        for(int s : set) {
            if(!set.contains(s-1)) {
                int num = s;
                int count = 1;

                while(set.contains(s+1)) {
                    num +=1;
                    count +=1;
                }
                longest = Math.max(longest, count);
            }
        }
        return longest;
    }
}
