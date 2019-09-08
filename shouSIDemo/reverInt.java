package shouSIDemo;

//反转整数
public class reverInt {
    public static int reverse(int x) {
        boolean state = false;
        if(x<0) {
            x = Math.abs(x);
            state = true;
        }
        String strx = String.valueOf(x);
        StringBuilder sb = new StringBuilder();
        int res;
        for (int i = strx.length() - 1; i > -1; i--) {
            sb.append(strx.charAt(i));
        }
        try{
             res = Integer.parseInt(sb.toString());
        }catch (Exception e) {
            return 0;
        }
        if(state == true) {
            return -res;
        }else {
            return res;
        }
    }

    public static int reverse2(int x) {
        int rev = 0;
        while (x!=0) {
            int pop = x%10;
            x = x/10;
            //两种溢出的情况
            if(rev > Integer.MAX_VALUE/10 || (rev ==Integer.MAX_VALUE/10 && pop > 7)) return 0;
            if(rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE/10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }

    public static void main(String[] args) {
        int res = 1534236469;
        int reverse = reverse(res);
        System.out.println(reverse);
    }
}
