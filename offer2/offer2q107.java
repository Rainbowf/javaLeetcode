package offer2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Solution107 {
    public int[][] updateMatrix(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;
        int[][] res = new int[row][col];
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (mat[i][j] == 0) {
                    queue.add(new int[]{i, j});
                    res[i][j] = 0;
                } else {
                    res[i][j] = Integer.MAX_VALUE;
                }

            }
        }

        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};


        while (!queue.isEmpty()) {
            int[] pos = queue.remove();
            int dist = res[pos[0]][pos[1]];
            for (int[] dir : dirs) {
                int r = pos[0] + dir[0];
                int c = pos[1] + dir[1];
                if (r >= 0 && r < row && c >= 0 && c < col) {
                    if (res[r][c] > dist + 1) {
                        res[r][c] = dist + 1;
                        queue.add(new int[]{r, c});
                    }
                }
            }
        }
        return res;
    }
}