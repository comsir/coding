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
    /*
    *输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
    * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
    * */
    public static void helper(TreeNode root,int target,ArrayList<Integer> cur,ArrayList<ArrayList<Integer>> res){
        if (root==null) return;  //这个是跳出来的操作，然后用cur.remove往上一层跳
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
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(9);

        TreeNode node4 = new TreeNode(2);
        TreeNode node5 = new TreeNode(5);


        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;


        ArrayList<ArrayList<Integer>> a = FindPath(node1, 10);
        System.out.println(a.size());

        ArrayList<Integer> b = a.get(1);
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
