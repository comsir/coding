package shouSIDemo;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
//写回溯算法模板
public class quanPailie {
    // curSize 表示当前的路径 path 里面有多少个元素
    private void generatePermution(int[] nums, boolean[] visited, int curSize, int len, Stack<Integer> path, List<List<Integer>> res) {
        if(curSize == len) {
            //此时path已经保存了nums中所有数字，已经成为了一个排列
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < len; i++) {
            if(!visited[i]) { //状态为false 也就是不存在
                path.push(nums[i]);
                visited[i] = true;
                generatePermution(nums, visited, curSize + 1, len, path, res);
                //回溯的时候一定要记住状态重置
                path.pop();  //从栈中 弹出 就是回溯的方法
                visited[i] = false;
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[len];
        if(len == 0) {
            return res;
        }
        generatePermution(nums, used, 0, len, new Stack<>(), res);
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4};
        quanPailie qpl = new quanPailie();
        List<List<Integer>> res = qpl.permute(nums);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }
}
