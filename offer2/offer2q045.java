package offer2;

import java.util.*;

class Solution045 {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();

        List<Integer> result = new LinkedList<>();

        if (root != null) {
            queue1.offer(root);
        }
        int bottomLeft = root.val;

        while (!queue1.isEmpty()) {
            TreeNode node = queue1.poll();

            if (node.left != null) {
                queue2.offer(node.left);
            }
            if (node.right != null) {
                queue2.offer(node.right);
            }

            if (queue1.isEmpty()) {
                queue1 = queue2;
                queue2 = new LinkedList<>();
                if(!queue1.isEmpty()){
                    bottomLeft = queue1.peek().val;
                }
            }
        }
        return bottomLeft;
    }
}