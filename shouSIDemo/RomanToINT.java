package shouSIDemo;

import java.util.HashMap;
import java.util.Map;

public class RomanToINT {
    public static int romanToInt(String str) {
        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("IX", 9);
        map.put("X", 10);
        map.put("XL", 40);
        map.put("L", 50);
        map.put("XC", 90);
        map.put("C", 100);
        map.put("CD", 400);
        map.put("D", 500);
        map.put("CM", 900);
        map.put("M", 1000);

        int ans = 0;
        for (int i = 0; i < str.length();) {
            if(i+1 < str.length() && map.containsKey(str.substring(i, i+2))) {
                ans += map.get(str.substring(i, i+2));
                i +=2;
            }else {
                ans += map.get(String.valueOf(str.charAt(i)));
                i++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String str = "CM";
        System.out.println(romanToInt(str));
    }
}
