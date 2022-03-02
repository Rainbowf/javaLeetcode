package offer2;

import java.util.*;


class Solution047 {
    //中序遍历-递归
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> nodes = new LinkedList<>();
        dfs(root, nodes);
        return nodes;
    }

    private void dfs(TreeNode root, List<Integer> nodes) {
        if (root != null) {
            dfs(root.left, nodes);
            nodes.add(root.val);
            dfs(root.right, nodes);
        }
    }

    //中序遍历-栈
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> nodes = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            nodes.add(curr.val);
            curr = curr.right;
        }
        return nodes;
    }

    //前序遍历-栈
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> nodes = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                //注意差别
                nodes.add(curr.val);//!!!!!!!!!!!!!!!!!!!!!!!!
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
//            nodes.add(curr.val);
            curr = curr.right;
        }
        return nodes;
    }

    //后序遍历-栈???????????????????????????????????
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> nodes = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode curr = root;
        //////////注意/////
        TreeNode prev = null;

        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.peek();
            if (curr.right != null && curr.right != prev) {
                curr = curr.right;
            } else {
                stack.pop();
                nodes.add(curr.val);
                prev = curr;
                curr = null;
            }
        }
        return nodes;
    }


    public TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        //后序遍历
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        if (root.left == null && root.right == null && root.val == 0) {
            return null;
        }
        return root;
    }
}