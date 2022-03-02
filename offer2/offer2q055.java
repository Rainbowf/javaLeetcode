package offer2;

import java.util.*;

class BSTIterator {

    TreeNode curr;
    Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        curr = root;
        stack = new Stack<>();
    }

    public int next() {
        while (curr != null) {
            stack.push(curr);
            curr = curr.left;
        }
        curr = stack.pop();
        int val = curr.val;
        curr = curr.right;

        return val;
    }

    public boolean hasNext() {
        return curr != null || !stack.isEmpty();
    }
}