import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class subString {

    public static void main(String[] args) {
        String s = " ";
        subString subString = new subString();
        System.out.println(subString.lengthOfLongestSubstring(s));

    }
    public int lengthOfLongestSubstring(String s) {
        //1.怎么遍历string
        //2.用hashmap判断是否于以前的有重复
        //3.有重复 放弃以前的 从这个开始
        //4.一个max值 时刻更新

        if(s.length()==0 || s.isEmpty() ) return 1;
        if(s.equals(" ")) return 1;
        int max = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int length = s.length();
        int count = 0;
        for (int i = 0; i < length; i++) {
            if(!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), 0);
                count++;
            }else {
                max = Math.max(max, count);
                map.clear();
                map.put(s.charAt(i), 0);
                count=1;
            }
        }
        return max;
    }

    public int demo(String s) {
        if (s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max=0;
        for(int i=0,j=0;i<s.length();++i) {
            if(map.containsKey(s.charAt(i))) {
                j = Math.max(j, map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i-j+1);
        }
        return max;
    }

    //用队列 最好理解 50% 99%
    public int demo2(String s) {
        Queue<Character> queue = new LinkedList<>();
        int res = 0;
        for (char c : s.toCharArray()) {
            while (queue.contains(c)) {
                queue.poll();
            }
            queue.offer(c);
            res = Math.max(res, queue.size());
        }
        return res;
    }
}
