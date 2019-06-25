package song.tree.com;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class k_treePath2 {

    public static ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
        ArrayList<Integer> cur=new ArrayList<>();

        helper(root,target,cur,res);
        Collections.sort(res, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                if (o1.size()<o2.size()){
                    return 1;
                }else return -1;
            }
        });
        return res;
    }
    public static void helper(TreeNode root,int target,ArrayList<Integer> cur,ArrayList<ArrayList<Integer>> res){
        if (root==null) return;
        int value=root.val;
        cur.add(value);

        if (target==value&&root.left==null&&root.right==null){
            res.add(new ArrayList<>(cur));
        }else {
            helper(root.left,target-value,cur,res);
            helper(root.right,target-value,cur,res);
        }

        cur.remove(cur.size()-1);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);

        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(4);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;

        ArrayList<ArrayList<Integer>> a = FindPath(node1, 8);
        System.out.println(a.size());

        ArrayList<Integer> b = a.get(0);
        for (Integer integer : b) {
            System.out.println(integer);
        }

    }
   static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }
}
