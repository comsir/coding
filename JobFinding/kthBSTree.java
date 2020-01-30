package JobFinding;

import java.util.Stack;

/*
*
* 求二叉搜索树的最小第k个节点
* 思路 二叉搜索树 中序遍历就得到一个从小到大排序 只要返回第k个数就可以
* 用非递归/递归中序遍历
* */
public class kthBSTree {


    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }
    public static void main(String[] args) {

    }
    //非递归
    TreeNode KthNode(TreeNode pRoot, int k)
    {
        //非递归的中序遍历 到第k个
        if(pRoot==null || k<0) return null;
        Stack<TreeNode> stack = new Stack<>();
        while(!stack.isEmpty() || pRoot!=null) {
            if(pRoot!=null) {
                stack.push(pRoot);
                pRoot = pRoot.left;
            } else {
                pRoot = stack.pop();
                k--;
                if(k==0) {
                    return pRoot;
                }
                pRoot = pRoot.right;
            }
        }
        return null;
    }


    int index;
    TreeNode KthNode2(TreeNode root, int k)
    {
        if(root != null){ //中序遍历寻找第k个
            TreeNode node = KthNode(root.left,k);
            if(node != null)
                return node;
            index ++;
            if(index == k)
                return root;
            node = KthNode(root.right,k);
            if(node != null)
                return node;
        }
        return null;
    }
}
