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

    public static void main(String[] args) {
        int res = 1534236469;
        int reverse = reverse(res);
        System.out.println(reverse);
    }
}
