package JobFinding;

import java.util.Stack;

/*
* leetcode 100. Same Tree:Given two binary trees, write a function to check if they are the same or not.

Two binary trees are considered the same if they are structurally identical and the nodes have the same value.
*
* */
public class isSameTree_iteration {

    public static void main(String[] args) {

    }


    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null) {
            return true;
        }
        if((p!=null && q==null) || (p==null && q!=null)) {
            return false;
        }
        Stack<TreeNode> stackp = new Stack<TreeNode>();
        Stack<TreeNode> stackq = new Stack<TreeNode>();

        stackp.add(p);
        stackq.add(q);
        while(!stackp.isEmpty() && !stackq.isEmpty()) {
            TreeNode tmpp = stackp.pop();
            TreeNode tmpq = stackq.pop();
            if(tmpp.val!=tmpq.val) {
                return false;
            }

            if(tmpp.left !=null && tmpq.left!=null) {
                stackp.push(tmpp.left);
                stackq.push(tmpq.left);
            }else if(tmpp.left==null && tmpq.left==null) {

            }else {
                return false;
            }

            if(tmpp.right !=null && tmpq.right!=null) {
                stackp.push(tmpp.right);
                stackq.push(tmpq.right);
            }else if(tmpp.right==null && tmpq.right==null) {

            }else {
                return false;
            }
        }
        if(!stackp.isEmpty() || !stackq.isEmpty()) {
            return false;
        }
        return true;

    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
