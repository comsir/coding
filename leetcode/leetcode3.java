package leetcode;

import java.util.HashSet;

public class leetcode3 {
    public static void main(String[] args) {
        String s = "pwwkew";
        System.out.println(lengthOfLongestSubstring_dp(s));
    }
    public static int lengthOfLongestSubstring(String s) {
        if(s==null) return 0;
        if(s.equals(" ") || s.length()==1) return 1;
        HashSet<Character> set = new HashSet<>();
        char[] chs = s.toCharArray();
        int i=0;
        int j=0;
        int count = 0;
        int max = 0;
        while (i<chs.length && j<chs.length) {
            if(!set.contains(chs[j])) {
                set.add(chs[j++]);
                count = j-i;
                max = Math.max(max, count);
            }else{
                set.remove(chs[i++]);
            }
        }
        return max;
    }

    //dp
    public static int lengthOfLongestSubstring_dp(String s) {
        int l = 0;
        int [] dp = new int[s.length()+1];
        for(int i=0;i<s.length();i++){
            if(s.substring(l,i).indexOf(s.charAt(i))!=-1)
                l = s.indexOf(s.charAt(i), l)+1;
            dp[i+1] = Math.max(dp[i], i-l+1);
        }
        return dp[s.length()];
    }
}
