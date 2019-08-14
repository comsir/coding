package leetcode;

public class leetcode11 {
    public static void main(String[] args) {
        int[] arr = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(arr));
    }
    public static int maxArea(int[] height) {
        if(height.length==0 && height==null) return 0;
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i+1; j < height.length; j++) {
                int area = (j-i)*(Math.min(height[i], height[j]));
                max = Math.max(max, area);
            }
        }
        return max;
    }
    public int maxArea2(int[] height) {
        if(height.length==0 && height==null) return 0;
        int i=0;
        int j=height.length-1;
        int max = 0;
        while(i<j) {
            max = Math.max(max, (j-i)*(Math.min(height[i], height[j])));
            if(height[i]<height[j]) {
                i++;
            }else {
                j--;
            }
        }
        return max;
    }
}
