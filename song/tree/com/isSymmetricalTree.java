package song.tree.com;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class isSymmetricalTree {
    public static void main(String[] args) {

    }
//递归版本
    boolean isSymmetrical(TreeNode pRoot)
    {
        if(pRoot == null){
            return true;
        }
        return comRoot(pRoot.left, pRoot.right);
    }
    private boolean comRoot(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
//        if((left==null && right!=null) && (left!=null && right==null)) return false;
        if(left==null || right==null)return false;
        if(left.value!=right.value)return false;
        return comRoot(left.left, right.right) && comRoot(left.right, right.left);
    }

    //非递归
    //DFS
    /*
    *
 1.出栈的时候也是成对成对的 ，
                1.若都为空，继续；
                2.一个为空，返回false;
                3.不为空，比较当前值，值不等，返回false；
     * 2.确定入栈顺序，每次入栈都是成对成对的，如left.left， right.right ;left.rigth,right.left
    * */
    boolean isSymmetricalDFS(TreeNode pRoot){
        if(pRoot==null) return true;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(pRoot.left);
        stack.push(pRoot.right);
        while (!stack.isEmpty()) {
            //成对取出
            TreeNode right = stack.pop();
            TreeNode left = stack.pop();

            if(left==null && right==null) continue;
            if(left==null || right==null) return false;
            if(left.value!=right.value)return false;

            //成对插入
            stack.push(left.left);
            stack.push(right.right);
            stack.push(left.right);
            stack.push(right.left);
        }
        return true;
    }

    //BFS
    /*
 BFS使用Queue来保存成对的节点，代码和上面极其相似
     * 1.出队的时候也是成对成对的
               1.若都为空，继续；
                2.一个为空，返回false;
                3.不为空，比较当前值，值不等，返回false；
     * 2.确定入队顺序，每次入队都是成对成对的，如left.left， right.right ;left.rigth,right.left
    * */
    boolean isSymmetricalBFS(TreeNode pRoot) {
        if(pRoot==null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(pRoot.left);
        queue.offer(pRoot.right);
        while (!queue.isEmpty()) {
            TreeNode right = queue.poll();
            TreeNode left = queue.poll();
            if(left==null && right==null)continue;
            if(left==null || right==null)return false;
            if(left.value !=right.value)return false;
            //成对入队
            queue.offer(left.left);
            queue.offer(right.right);
            queue.offer(left.right);
            queue.offer(right.left);
        }
            return true;
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
