package offer2;

import java.util.*;

class Solution112 {

    public int longestIncreasingPath(int[][] matrix) {

        int row = matrix.length;
        int col = matrix[0].length;

        int[][] len = new int[row][col];
        int longest = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int length = dfs(matrix, len, i, j);
                longest = Math.max(length, longest);
            }
        }
        return longest;
    }

    //遍历查找dfs
    private int dfs(int[][] matrix, int[][] len, int i, int j) {
        if (len[i][j] != 0) {
            return len[i][j];
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] dirs = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        int length = 1;//只包含自己一个节点

        for (int[] dir : dirs) {
            int r = dir[0] + i;
            int c = dir[1] + j;

            if (r >= 0 && r < rows && c >= 0 && c < cols && matrix[r][c] > matrix[i][j]) {
                int temp = dfs(matrix, len, r, c);
                length = Math.max(temp + 1, length);
            }
        }

        len[i][j] = length;
        return length;
    }
}