package JobFinding;

import java.util.Deque;
import java.util.LinkedList;

public class BalancedBST {

    public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }
    public static void main(String[] args) {

    }

    //递归操作
    public TreeNode sortedArrayToBST_recursion(int[] nums) {
        if(nums.length==0) return null;
        return sortedArray(nums, 0, nums.length-1);
    }
    public TreeNode sortedArray(int[] nums, int start, int end) {
        if(start>end) return null;
        int length = start + (end-start)/2;
        TreeNode node = new TreeNode(nums[length]);
        node.left = sortedArray(nums, start, length-1);
        node.right = sortedArray(nums, length+1, end);
        return node;
    }

    //非递归操作
    public TreeNode sortedArrayToBST_iterative(int[] nums) {
        if ( nums.length == 0)  return null;

        TreeNode head = new TreeNode(0);
        Deque<TreeNode> nodeStack       = new LinkedList<TreeNode>() {{ push(head);  }};
        Deque<Integer>  leftIndexStack  = new LinkedList<Integer>()  {{ push(0);     }};
        Deque<Integer>  rightIndexStack = new LinkedList<Integer>()  {{ push(nums.length-1); }};

        //其实就是把原本递归的存的数组边界值 用自己的容器装
        //递归转非递归 就是要抓住 那些值是变化的 然后把变化的值自己存起来
        while (!nodeStack.isEmpty()) {
            TreeNode currnode = nodeStack.pop();
            int left = leftIndexStack.pop();
            int right = rightIndexStack.pop();
            int mid = left + (right-left)/2;//avoid overflow
            currnode.val = nums[mid];
            if(left<=mid-1) {
                currnode.left = new TreeNode(0);
                nodeStack.push(currnode.left);
                leftIndexStack.push(left);
                rightIndexStack.push(mid-1);
            }
            if(mid+1<=right) {
                currnode.right = new TreeNode(0);
                nodeStack.push(currnode.right);
                leftIndexStack.push(mid+1);
                rightIndexStack.push(right);
            }
        }
        return head;
    }

    }
