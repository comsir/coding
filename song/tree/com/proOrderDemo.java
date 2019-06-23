package song.tree.com;

import sun.reflect.generics.tree.Tree;

import java.util.Stack;

public class proOrderDemo {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);

        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);

//        TreeNode node = new TreeNode(1);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;

//        TwoStackDemo(node1);
//        OneStackDemo(node1);
        morrisIn(node1);
    }
/*
* 一个栈弹出按照 根 右 左
* */
    public static void TwoStackDemo(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(root);
        while (!s1.isEmpty()) {
            root = s1.pop();
            s2.push(root);
            if (root.left != null) {
                s1.push(root.left);
            }
            if (root.right != null) {
                s1.push(root.right);
            }
        }
        while (!s2.isEmpty()) {
            System.out.print(s2.pop().value + " ");
        }
    }
/*
* h 表示 最新弹出的值
* c 表示 stack 最顶端的值
* */
    public static void OneStackDemo(TreeNode root) {
        if (root == null) {
            return ;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode c = null;

        while (!stack.isEmpty()) {
            c = stack.peek();
            if (c.left != null && root!=c.left && root!=c.right) {
                stack.push(c.left);
            } else if (c.right != null && root!=c.right) {
                stack.push(c.right);
            }else {
                System.out.print(stack.pop().value+ " ");
                root = c;
            }

        }
        System.out.println();
    }

    /*
    * 时间复杂度为O(N) 空间复杂度为0(1)的二叉树的中序遍历
    * Morris遍历
    * 不用栈 通过底层指针指向空闲指针回上层
    * */
    public static void morrisIn(TreeNode root) {
        if(root==null) return;
        TreeNode cur1 = root;
        TreeNode cur2 = null;
        while (cur1 != null) {
            cur2 = cur1.left;
            if (cur2 != null) {
                //判断子树的左子树的最右子树是否为空 是否指向本节点
                //找到最右子节点
                while (cur2.right != null && cur2.right != cur1) {
                    cur2 = cur2.right;
                }
                if (cur2.right == null) {
                    cur2.right = cur1;
                    cur1 = cur1.left;
                    continue;
                } else {
                    cur2.right = null;
                }
            }
            System.out.print(cur1.value + " ");
            cur1 = cur1.right;
            System.out.println();
        }
    }

    static class TreeNode{
        public int value;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
    }
}
