package song.tree.com;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class four_traverseTree {
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
        four_traverseTree demo = new four_traverseTree();
//        demo.preOrder(node1);
//        demo.midOrder(node1);
//        demo.sufOrder(node1);
        demo.levelOrder(node1);
    }

    public void preOrder(TreeNode head) {
        //根左右
        if(head==null) return;
        Stack<TreeNode> stack = new Stack();
        stack.push(head);
        TreeNode cur;
        while(!stack.isEmpty()) {
           cur = stack.pop();
            System.out.println(cur.val);
            if(cur.right!=null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
    }
    //思路就是不停的把左节点压入栈，一旦没了左节点，弹出一个 输出，这样一个子树的左根都访问，需要右，所以再指向右压入栈
    public void midOrder(TreeNode head) {
        //左根右
        if(head==null) return;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while(!stack.isEmpty() || head!=null) {
            if (head != null) {
                stack.push(head);
                head = head.left;
            } else {
                head = stack.pop();
                System.out.println(head.val);
                head = head.right;
            }
        }

    }
    public void sufOrder(TreeNode head) {
        //后序使用的是两个stack 利用反序的 巧妙的弹出
        if(head==null) return;
        Stack<TreeNode> stack1 = new Stack<TreeNode>();
        Stack<TreeNode> stack2 = new Stack<TreeNode>();
        stack1.push(head);
        TreeNode curr;
        while (!stack1.isEmpty()) {
            curr = stack1.pop();
            stack2.push(curr);
            if (curr.left != null) {
                stack1.push(curr.left);
            }
            if (curr.right != null) {
                stack1.push(curr.right);
            }
        }
        while (!stack2.isEmpty()) {
            System.out.println(stack2.pop().val);
        }
    }
    public void levelOrder(TreeNode head) {
        if(head==null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(head);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            System.out.println(cur.val);
            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }
    }


static class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }
}
