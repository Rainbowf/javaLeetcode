package offer1;

class Solution682 {
    //labuladong
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //base case
        if (root == null) return null;
        if (root == p || root == q) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        //case 1
        if (left != null && right != null) {
            return root;
        }
        //case 2
        if (left == null && right == null) {
            return null;
        }
        //case 3
        return left == null ? right : left;
    }
}