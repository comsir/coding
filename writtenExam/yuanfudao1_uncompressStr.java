package writtenExam;

/*
* 题目大意：解压字符串
* 比如：
* A11B----AAAAAAAAAAAB
* (AA)2A---AAAAA
* ((A2B)2)2G--AABAABAABAABG
* (SDSFD)2AA---SDSFDSDSFDAA
* A2BC4D2---AABCCCCDD
* 输入：第一行输入正整数C,表示下面有C组数据
* 之后C行 每一行一个字符串
*
* */

import java.util.Scanner;

public class yuanfudao1_uncompressStr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int c = Integer.parseInt(sc.nextLine());
        while(c>0) {
            c--;
            String inStr = sc.nextLine();
            String res="";
            int i = 0;
            for (; i < inStr.length();) {
                //1.如果遍历到的是 （ 或者字母
                if(inStr.charAt(i)=='(' || (inStr.charAt(i)>='A' && inStr.charAt(i)<='Z')) {
                    res = res + inStr.charAt(i++);
                } else if(inStr.charAt(i)==')'){
                    //2.如果遇到 ）
                    String tmpStr="";
                    while (res.charAt(res.length()-1)!='(') {
                        tmpStr = res.charAt(res.length()-1) + tmpStr;
                        res = res.substring(0, res.length()-1);//去掉最后一个字符
                    }
                    //直到遇到 （
                    res = res.substring(0, res.length()-1);//去掉最后一个字符
                    i++;
                    String numStr = "";
                    //获取到括号内容后 处理括号外的数字
                    while(inStr.charAt(i)=='0')i++;
                    while(inStr.charAt(i)>='0'&& inStr.charAt(i)<='9') {
                        numStr = numStr + inStr.charAt(i++);
                    }
                    int num = Integer.parseInt(numStr);
                    String NTmpStr = "";
                    while (num>0) {  //根据数字翻倍
                        NTmpStr = NTmpStr + tmpStr;
                        num--;
                    }
                    res = res + NTmpStr;
                }else {
                    //遇到字母后面的数字
                    String tmpStr = res.charAt(res.length()-1) + "";
                    res = res.substring(0, res.length()-1);
                    String numStr = "";
                    //获取到括号内容后 处理括号外的数字
                    while(inStr.charAt(i)=='0')i++;
                    while(i<inStr.length() && inStr.charAt(i)>='0'&& inStr.charAt(i)<='9') {
                        numStr = numStr + inStr.charAt(i++);
                    }
                    int num = Integer.parseInt(numStr);
                    String NTmpStr = "";
                    while (num>0) {  //根据数字翻倍
                        NTmpStr = NTmpStr + tmpStr;
                        num--;
                    }
                    res = res + NTmpStr;
                }
            }
            System.out.println(res);
        }
    }
}
