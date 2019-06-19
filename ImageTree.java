import java.util.Stack;


/*
*
*
* */
public class ImageTree {

    public static void main(String[] args) {

    }
    //递归方法
    public boolean isSymmetric_recursive(TreeNode root) {
        if(root==null) return true;
        return isSymmetricHelp(root.left, root.right);
    }
    public boolean isSymmetricHelp(TreeNode left, TreeNode right) {
        if(left==null && right==null) return true;
        if((left!=null && right==null) || (left==null && right!=null)) return false;
        if(left.val!=right.val) return false;
        return isSymmetricHelp(left.left, right.right) && isSymmetricHelp(left.right, right.left);
    }

    //非递归方法
    public boolean isSymmetric_iteration(TreeNode root) {
        //1.判断root的左右子树 然后加入stack中
        //只有当root的左右子树都存在的时候才加入 其他情况return false
        if(root==null) return true;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode left,right;
        if(root.left!=null) {
            if(root.right==null) return false;
            stack.push(root.left);
            stack.push(root.right);

        }else if(root.left==null && root.right!=null) {
            return false;
        }

        while (!stack.isEmpty()) {
            if(stack.size()%2!=0)return false;
            //存在两个则提出出栈
            right = stack.pop();
            left = stack.pop();
            if(right.val!=left.val) return false;
            //出栈访问比较后 继续循环入栈
            if(left.left!=null) {
                if(right.right==null) return false;
                stack.push(left.left);
                stack.push(right.right);
            }else if(left.left==null && right.right!=null) {
                return false;
            }

            if(left.right!=null) {
                if(right.left==null) return false;
                stack.push(left.right);
                stack.push(right.left);
            } else if (left.right == null && right.left != null) {
                return false;
            }
        }
        return true;

    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}

