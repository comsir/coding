package JobFinding;

import java.util.LinkedList;
import java.util.Queue;

/*
* 需要打印的效果
* 第一层 1
* 第二层 2 ，3
* 第三层 4，5，6
* .....
* */
public class tree_PrintByLevel {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);

        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;

        printByLevel(node1);

    }

    public static void printByLevel(TreeNode head) {
        if(head==null)return;
        TreeNode last = head;
        TreeNode nlast = null;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(head);
        TreeNode temp = null;
        int level = 1;
//        System.out.print("level"+(level++)+":");

        while (!queue.isEmpty()) {
            temp = queue.poll();
            System.out.print(temp.value+" ");

            if (temp.left != null) {
                queue.offer(temp.left);
                nlast = temp.left;
            }

            if (temp.right != null) {
                queue.offer(temp.right);
                nlast = temp.right;
            }

            if(last==temp){
                System.out.print("\nLevel"+(level++)+":");
                last = nlast;
            }
        }

    }
   static class TreeNode{
        public int value;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int data) {
            this.value = data;
        }

    }
}
