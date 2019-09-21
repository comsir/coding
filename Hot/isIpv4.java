package Hot;

public class isIpv4 {
    public static void main(String[] args){
        String[] ipArr = new String[]{"abc", "123456789012345678", ".1.2.3", "1.2.3.4.", "1.2.3", "1.2.3.4.5", "1.02.003.014", "1a.2.3.4", "1.2a.3.4", "1.2.3a.4", "1.2.3.4a",
                "0.1.2.3", "-1.1.2.3", "1.-1.2.3", "1.2.-1.3", "1.2.3.-1", "256.1.2.3", "1.256.2.3", "1.2.256.3", "1.2.3.256", "1234.123.123.123", "123.1234.123.123",
                "123.123.1234.123", "123.123.123.1234", "123.123.123.123", "0.0.0.0", "1.0.0.0", "255.255.255.255", "11.22.33.44", ""};
        for (int i = 0; i < ipArr.length; i++) {
            boolean isIpLegal = isIpv4Helper(ipArr[i]);
            if(isIpLegal) {
                System.out.println(ipArr[i] + " 合法");
            } else {
                System.out.println(ipArr[i] + " 非法!!!");
            }
        }

    }
    private static boolean isIpv4Helper(String str) {
        //1.判空
        if(str == null) return false;
        //2.检查长度
        if(str.length()<7 || str.length()>15) return false;
        //3.判断是否以 '.'开头或者结尾
        if(str.charAt(0)=='.' || str.charAt(str.length() - 1) == '.') return false;
        String[] strs = str.split("\\.");
        if(strs.length != 4) return false;
        //5.对每个切割出来的字符串进行单独判断
        for (String s:strs) {
            //5.1如果每一段 不是一个字符 且 以 0 开头 则是非法的
            if(s.length()!=1 && s.charAt(0)=='0') return false;
            for (int i = 0; i < s.length(); i++) {
                if(s.charAt(i)<'0' || s.charAt(i)>'9') return false;
            }
            int temp = Integer.parseInt(s);
        }
        for (int i = 0; i < strs.length; i++) {
            int tmp = Integer.parseInt(strs[i]);
            if(i==0) {
                if(tmp<1 || tmp>255) return false;
            }else {
                if(tmp<0 || tmp>255) return false;
            }
        }
        return true;
    }
}
