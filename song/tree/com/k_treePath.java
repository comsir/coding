package song.tree.com;

import java.util.ArrayList;
import java.util.Stack;

public class k_treePath {

    private ArrayList<ArrayList<Integer>> listAll = new ArrayList<ArrayList<Integer>>();
    private ArrayList<Integer> list = new ArrayList<Integer>();

    public static void main(String[] args) {

    }
//    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
//
//        if(root == null) return listAll;
//        list.add(root.val);
////        target -= root.val;
//        target = target - root.val;
//        if(target == 0 && root.left == null && root.right == null)
//            listAll.add(new ArrayList<Integer>(list));
//        FindPath(root.left, target);
//        FindPath(root.right, target);
//        //移除最后一个元素 深度遍历后 退回
//        list.remove(list.size()-1);
//        return listAll;
//        }
//    }

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        ArrayList<ArrayList<Integer>> paths=new ArrayList<ArrayList<Integer>>();
        if(root==null)return paths;
        find(paths,new ArrayList<Integer>(),root,target);
        return paths;
    }
    public void find(ArrayList<ArrayList<Integer>> paths,ArrayList<Integer> path,TreeNode root,int target){
        path.add(root.val);
        //左节点有右节点都为空 也就是 只有一个节点 等于target 就加入list
        //到了叶子节点还不满足 就回退
        if(root.left==null && root.right==null){
            if(target==root.val){
                paths.add(path);
            }
            return;
        }
//new一个path2,让它和path相等，然后分别负责left和right分支的递归，这里必须分开，不然左右分支的递归结果会相互影响
        ArrayList<Integer> path2=new ArrayList<>();
        path2.addAll(path);
        if(root.left!=null)find(paths,path,root.left,target-root.val);
        if(root.right!=null)find(paths,path2,root.right,target-root.val);
    }



    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

}


