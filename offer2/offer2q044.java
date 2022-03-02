package offer2;

import java.util.*;

//Definition for a binary tree node.
/*class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    //bfs算法
    public List<Integer> bfs(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) queue.offer(root);

        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            result.add(node.val);

            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return result;
    }
}*/


class Solution044 {
    //方法一：计数法
    public List<Integer> largestValues(TreeNode root) {
        int curr = 0;
        int next = 0;

        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> result = new LinkedList<>();

        if (root != null) {
            queue.offer(root);
            curr++;
        }

        int max = Integer.MIN_VALUE;

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            curr--;
            max = Math.max(max, node.val);

            if (node.left != null) {
                queue.offer(node.left);
                next++;
            }
            if (node.right != null) {
                queue.offer(node.right);
                next++;
            }

            if (curr == 0) {
                result.add(max);
                curr = next;
                max = Integer.MIN_VALUE;
                next = 0;
            }
        }
        return result;
    }
    //方法二：双队列交替
    public List<Integer> largestValues2(TreeNode root) {
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();

        List<Integer> result = new LinkedList<>();

        if(root!=null){
            queue1.offer(root);
        }

        int max = Integer.MIN_VALUE;

        while (!queue1.isEmpty()){
            TreeNode node = queue1.poll();
            max = Math.max(max,node.val);

            if (node.left != null) {
                queue2.offer(node.left);
            }
            if (node.right != null) {
                queue2.offer(node.right);
            }

            if (queue1.isEmpty()){
                queue1 = queue2;
                queue2 = new LinkedList<>();

                result.add(max);
                max = Integer.MIN_VALUE;
            }
        }
        return result;
    }


}