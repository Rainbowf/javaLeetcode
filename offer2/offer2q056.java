package offer2;

import java.util.*;

class BSTIteratorReversed {

    TreeNode curr;
    Stack<TreeNode> stack;

    public BSTIteratorReversed(TreeNode root) {
        curr = root;
        stack = new Stack<>();
    }

    public int prev() {
        while (curr != null) {
            stack.push(curr);
            curr = curr.right;
        }
        curr = stack.pop();
        int val = curr.val;
        curr = curr.left;

        return val;
    }

    public boolean hasPrev() {
        return curr != null || !stack.isEmpty();
    }
}

class Solution056 {
    //哈希表解法,O(n)
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();

        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            //处理
            if (set.contains(k - curr.val)) {
                return true;
            }
            set.add(curr.val);

            curr = curr.right;
        }
        return false;
    }

    //双指针解法
    public boolean findTarget2(TreeNode root, int k) {
        if (root == null) return false;
        BSTIterator iterNext = new BSTIterator(root);
        BSTIteratorReversed iterPrev = new BSTIteratorReversed(root);

        int next = iterNext.next();
        int prev = iterPrev.prev();
        while (next != prev) {
            if (next + prev == k) {
                return true;
            } else if (next + prev < k) {
                next = iterNext.next();
            } else {
                prev = iterPrev.prev();
            }
        }
        return false;
    }
}