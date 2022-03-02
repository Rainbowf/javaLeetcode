package leetcode;

import java.util.LinkedList;
import java.util.Queue;

class SolutionLC200 {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int num = 0;
        boolean[][] visited = new boolean[m][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1' && !visited[i][j]){
                    getArea(grid, visited, i, j, m, n);
                    num++;
                }
            }
        }
        return num;
    }

    //基于 广度优先搜索
    private void getArea(char[][] grid, boolean[][] visited, int i, int j, int m, int n){
        //队列
        Queue<int[]> queue = new LinkedList<>();
        //插入头结点
        queue.add(new int[]{i , j});
        visited[i][j] = true;

        //定义方向
        int[][] dirs = {{-1,0}, {1, 0}, {0, -1}, {0, 1}};

        while(!queue.isEmpty()){
            int[] pos = queue.remove();

            for(int[] dir: dirs){
                int r = pos[0] + dir[0];
                int c = pos[1] + dir[1];
                if(r >= 0 && r < m && c >= 0 && c < n && grid[r][c] == '1' && !visited[r][c]){
                    queue.add(new int[]{r, c});
                    visited[r][c] = true;
                }
            }
        }
    }
}