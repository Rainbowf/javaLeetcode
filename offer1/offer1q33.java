package offer1;

import java.util.*;
//方法一：递归分治
//从右往左找小
class Solution330 {
    public boolean verifyPostorder(int[] postorder) {
        int len = postorder.length;
        return verifyPostorder(postorder, 0, len - 1);
    }

    private boolean verifyPostorder(int[] postorder, int left, int right) {
        if (left >= right) return true;
        int mini = right - 1;

        while (left <= mini && postorder[mini] > postorder[right]) {
            mini--;
        }

        int j = mini;
        while (left <= j && postorder[j] < postorder[right]) {
            j--;
        }
        return j == left - 1 && verifyPostorder(postorder, left, mini) && verifyPostorder(postorder, mini + 1, right - 1);
    }
}

//从左往右找大
class Solution331 {
    public boolean verifyPostorder(int[] postorder) {
        int len = postorder.length;
        return verifyPostorder(postorder, 0, len - 1);
    }

    private boolean verifyPostorder(int[] postorder, int left, int right) {
        if (left >= right) return true;
        int maxi = 0;

        while (postorder[maxi] < postorder[right]) {
            maxi++;
        }
        int j = maxi;
        while (postorder[j] > postorder[right]) {
            j++;
        }
        return j == right && verifyPostorder(postorder, left, maxi - 1) && verifyPostorder(postorder, maxi, right - 1);
    }
}
//方法二：辅助单调栈
//https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/solution/mian-shi-ti-33-er-cha-sou-suo-shu-de-hou-xu-bian-6/