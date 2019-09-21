package leetcode;
//整数拆分
public class leetcode343 {
    int[] memory;
    public static void main(String[] args) {

    }
    private int IntegerBreak(int n) {
        if(n<=2) return 1;
        if(n==3) return 2;
        if(n==4) return 4;
        int res = 1;
        while (n>=4) {
            res = res * 3;
            n -=3;
        }
        res = res * n;
        return res;
    }
    private int IntegerBreak2(int n) {
        if(n==2) return 1;
        int res = -1;
        for (int i = 1; i <= n - 1; i++) {
            res = Math.max(res, Math.max(i*(n - i), i*IntegerBreak2(n - i)));
        }
        return res;
    }

    private int IntegerBreak3(int n) {
        memory = new int[n + 1];
        return IntegerBreak3helper(n);
    }
    private int IntegerBreak3helper(int n) {
        if(n==2) return 1;
        //记忆化的核心
        if(memory[n]!=0) {
            //menory初始化为0，如果它不为0，说明已经计算过，直接返回
            return memory[n];
        }
        int res = -1;
        for (int i = 1; i < n-1 ; i++) {
            res = Math.max(res, Math.max(i*(n - i), i*IntegerBreak3helper(n - i)));
        }
        memory[n] = res;
        return res;
    }

    //记忆搜索是自顶向下 递归进行  ------->动态规划是自底向上 递推进行
    private int IntegerBreak4(int n) {
        memory[2] = 1;
        for (int i = 3; i <=n; i++) {
            for (int j = 1; j <=i-1 ; j++) {
                memory[i] = Math.max(memory[i], Math.max(j*memory[i-j], j*(i-j)));
            }
        }
        return memory[n];
    }
}
