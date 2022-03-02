package offer2;

import javax.swing.plaf.nimbus.AbstractRegionPainter;
import java.util.*;


class Solution053 {
    //复杂度O(n)解法
    public TreeNode inorderSuccessor1(TreeNode root, TreeNode p) {
        if (root == null) return null;
        boolean found = false;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr!=null || !stack.isEmpty()){
            while (curr!=null){
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();

            if(found){
                break;
            }else if(p==curr){
                found = true;
            }
            curr = curr.right;
        }
        return curr;
    }
    //复杂度O(h = logn)解法
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode cur = root;
        TreeNode res = null;

        while (cur!=null){
            if(cur.val <= p.val){
                cur = cur.right;
            }else {
                res = cur;
                cur = cur.left;
            }
        }
        return res;
    }
}