package leetcode;

import java.util.*;
//https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/solution/cong-qian-xu-yu-zhong-xu-bian-li-xu-lie-gou-zao-9/
class SolutionLC105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int preLen = preorder.length;
        int inLen = inorder.length;

        if (preLen != inLen) {
            throw new RuntimeException("Incorrect imput data.");
        }
        Map<Integer, Integer> map = new HashMap<>(preLen);
        for (int i = 0; i < inLen; i++) {
            map.put(inorder[i], i);
        }

        return buildTree(preorder, 0, preLen - 1, map, 0, inLen - 1);
    }

    /**
     *@param preorder   前序追历序列
     *@param preLeft    前序遍历序列子区间的左边界，可以取到
     *@param preRight   前序遍历序列子区间的右边界，可以取到
     *@param map        在中序遍历序列里，数值与下标的对应关系
     *@param inLeft     中序追历序列子区间的左边界，可以取到
     *@param inRight    前序追历序列子区间的右边界，可以取到
     *@return
     */
    private TreeNode buildTree(int[] preorder, int preLeft, int preRight, Map<Integer, Integer> map, int inLeft, int inRight) {
        if (preLeft > preRight || inLeft > inRight) {
            return null;
        }
        int rootVal = preorder[preLeft];
        TreeNode root = new TreeNode(rootVal);
        int pIndex = map.get(rootVal);

        root.left = buildTree(preorder, preLeft + 1, pIndex - inLeft + preLeft, map, inLeft, pIndex - 1);
        root.right = buildTree(preorder, pIndex - inLeft + preLeft + 1, preRight, map, pIndex + 1, inRight);
        return root;
    }
}