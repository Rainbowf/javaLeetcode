package offer2;

import java.util.*;

class Solution052 {
    public TreeNode increasingBST(TreeNode root) {
        if (root == null) return null;
        Stack<TreeNode> stack = new Stack<>();

        TreeNode curr = root;

        TreeNode prev = null;
        TreeNode first = null;

        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            //增加的部分
            if (prev == null) {
                first = curr;
            } else {
                prev.right = curr;
            }
            prev = curr;
            curr.left = null;

            curr = curr.right;
        }
        return first;
    }
}