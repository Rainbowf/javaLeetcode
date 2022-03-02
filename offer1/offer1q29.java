package offer1;

import java.util.*;

class Solution29 {
    public int[] spiralOrder(int[][] matrix) {
        if(matrix.length == 0) return new int[0];
        int l = 0, r = matrix[0].length - 1;
        int t = 0, b = matrix.length - 1;

        int k = 0;
        int[] ans = new int[matrix[0].length * matrix.length];

        while (true) {
            //left to right
            for (int j = l; j <= r; j++) ans[k++] = matrix[t][j];

            if (++t > b) break;
            //top to bottom
            for (int i = t; i <= b; i++) ans[k++] = matrix[i][r];

            if (--r < l) break;
            //right to left
            for (int j = r; j >= l; j--) ans[k++] = matrix[b][j];

            if (--b < t) break;
            //bottom to top
            for (int i = b; i >= t; i--) ans[k++] = matrix[i][l];

            if (++l > r) break;
        }
        return ans;
    }
}