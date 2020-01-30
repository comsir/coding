package JobFinding;

public class jumpN {
    public static void main(String[] args) {

    }
    //左移1位就是乘以一个2，在1基础上左移number-1位就是1乘以2^(number-1)
    public int JumpFloorII(int target) {
        int a=1; return a<<(target-1);
    }
//传统递归
    public int JumpFloorII1(int target) {
        if(target<=0) return 0;
        if(target==1) return 1;
        if(target==2) return 2;
        return 2*JumpFloorII(target-1);
    }
}
