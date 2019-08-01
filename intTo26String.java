/*
* 题目描述：输入任意十进制数字 将其转换为字母表示
* 如：26-->Z
* 27-->AA
*
* */

import java.util.ArrayList;

public class intTo26String {
    public static void main(String[] args) {
//        int rem = 25%26;
        int curry = 702%26;
//        System.out.println(demo(2));
        System.out.println(convertToTitle2(27));
    }

    public static String convertToTitle(int n) {
        String s = "";
        int k  = n;
        while(n > 26){
            k = n  % 26;
            n = n / 26;
            if(k==0){//没有表示0的字母，故若余数为0，需置为26， 商退一位
                k = 26;
                n = n - 1;
            }
            char c = (char)('A' + k-1 );
            s = c+s;
        }
        char c = (char)('A' +  n -1);
        s = c+s;
        return s;
    }

    public static String convertToTitle1(int n) {
        String strs = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String res = "";
        int curr = n;
        while(n>26) {
            curr = n%26;
            n = n/26;
            if(curr==0) {
                curr = 26;
                n = n - 1;
            }
            res =strs.charAt(curr - 1) + res;
        }
        res =strs.charAt(n - 1) + res;
        return res;
    }

    public static String convertToTitle2(int n) {
        String s = "";
        while(n > 0) {
            n--;
            s = (char)(n % 26 + 'A') + s; //字符串与数字的转换，字符串与string的转换
            n = n / 26;
        }
        return s;
    }

}
