package leetcode;
import java.util.*;

class Solution0230 {
    //递归写法
    private int res = 0;
    private int rank = 0;
    public int kthSmallest(TreeNode root, int k) {
        dfs(root,k);
        return res;
    }
    private void dfs(TreeNode root,int k) {
        if (root != null) {
            dfs(root.left,k);
            rank++;
            if(rank == k){
                res = root.val;
            }
            dfs(root.right,k);
        }
    }

    public int kthSmallest2(TreeNode root, int k) {
        //中序遍历-入栈法
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        int rank = 0;
        int res = 0;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            rank++;
            if(rank == k){
                res = curr.val;
            }

            curr = curr.right;
        }
        return res;
    }
}