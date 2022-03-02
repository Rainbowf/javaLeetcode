package leetcode;

import java.util.*;

class SolutionLC107 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int inLen = inorder.length;
        int postLen = postorder.length;

        if (inLen != postLen) {
            throw new RuntimeException("Incorrect imput data.");
        }

        Map<Integer, Integer> map = new HashMap<>(inLen);
        for (int i = 0; i < inLen; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(inorder, postorder, 0, inLen - 1, map, 0, postLen - 1);
    }

    private TreeNode buildTree(int[] inorder, int[] postorder, int inLeft, int inRight, Map<Integer, Integer> map, int postLeft, int postRight) {
        if (inLeft > inRight || postLeft > postRight) {
            return null;
        }
        int rootVal = postorder[postRight];
        TreeNode root = new TreeNode(rootVal);
        int pIndex = map.get(rootVal);

        root.left = buildTree(inorder, postorder, inLeft, pIndex - 1, map, postLeft, postRight - inRight + pIndex - 1);
        root.right = buildTree(inorder, postorder, pIndex + 1, inRight, map, postRight - inRight + pIndex, postRight - 1);
        return root;
    }
}