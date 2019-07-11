public class DP_MinPath {
    public static void main(String[] args) {
        int[][] arr = new int[][]{{1,3,5,9},{8,1,3,4},{5,0,6,1},{8,8,4,0}};
        int[] re = new int[]{-3,-2,7,-5,1,2,4};
//        System.out.println(arr.length);
//        System.out.println(arr[0].length);
        DP_MinPath dp_minPath = new DP_MinPath();
//        System.out.println(dp_minPath.minPath(arr));
        System.out.println(dp_minPath.FindGreatestSumOfSubArray(re));
    }
    //不压缩，空间复杂度为M*N
    public int minPath(int[][] m) {
        if(m.length==0 || m==null || m[0].length==0 || m[0]==null) return 0;
        int row = m.length;
        int col = m[0].length;
        int[][] dp = new int[row][col];
        dp[0][0] = m[0][0];
        //两条边
        for (int i = 1; i < row; i++) {
            dp[i][0] = dp[i-1][0] + m[i][0];
        }

        for (int j = 1; j < col; j++) {
            dp[0][j] = dp[0][j-1] + m[0][j];
        }

        //中间部分
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1])+m[i][j];
            }
        }
        return dp[row-1][col-1];
    }
    //压缩，空间复杂度为min(m,n)
    public int dp_compress_minPath(int[][] m) {
        if(m.length==0 || m==null || m[0].length==0 || m[0]==null) return 0;
        int less = Math.min(m.length, m[0].length);
        int more = Math.max(m.length, m[0].length);
        Boolean rowmore = less==m.length; //判断行数是否大于列数
        int[] arr = new int[less];
        arr[0] = m[0][0];
        for (int i = 1; i < less; i++) {
            arr[i] = arr[i-1] + (rowmore?m[0][i] : m[i][0]);
        }
        for (int i = 1; i < more; i++) {
            arr[0] = arr[0-1] + (rowmore?m[0][i] : m[i][0]);
            for(int j = 1;j < less;j++) {
                arr[j] = Math.min(arr[j-1], arr[j]) + (rowmore?m[j][i] : m[i][j]);
            }
        }
        return arr[less-1];
    }


    public  int FindGreatestSumOfSubArray(int[] array) {
        int res = array[0]; //记录当前所有子数组的和的最大值
        int max=array[0];   //包含array[i]的连续数组最大值
        for (int i = 1; i < array.length; i++) {
            max=Math.max(max+array[i], array[i]);
            res=Math.max(max, res);
        }
        return res;
    }
}
