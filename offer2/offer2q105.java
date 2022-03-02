package offer2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Solution105 {
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int maxArea = 0;
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    int area = getArea(grid, visited, i, j, m, n);
                    maxArea = Math.max(area, maxArea);

                }
            }
        }
        return maxArea;
    }

    //基于 广度优先搜索
    private int getArea(int[][] grid, boolean[][] visited, int i, int j, int m, int n) {
        //队列
        Queue<int[]> queue = new LinkedList<>();
        //插入头结点
        queue.add(new int[]{i, j});
        visited[i][j] = true;

        //定义方向
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        //面积
        int area = 0;

        while (!queue.isEmpty()) {
            int[] pos = queue.remove();
            area++;

            for (int[] dir : dirs) {
                int r = pos[0] + dir[0];
                int c = pos[1] + dir[1];
                if (r >= 0 && r < m && c >= 0 && c < n && grid[r][c] == 1 && !visited[r][c]) {
                    queue.add(new int[]{r, c});
                    visited[r][c] = true;
                }
            }
        }
        return area;
    }

    //基于 栈 深度优先搜索
    private int getArea2(int[][] grid, boolean[][] visited, int i, int j, int m, int n) {
        //栈
        Stack<int[]> stack = new Stack<>();

        //插入头结点
        stack.push(new int[]{i, j});
        visited[i][j] = true;

        //定义方向
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        //面积
        int area = 0;

        while (!stack.isEmpty()) {
            int[] pos = stack.pop();
            area++;

            for (int[] dir : dirs) {
                int r = pos[0] + dir[0];
                int c = pos[1] + dir[1];
                if (r >= 0 && r < m && c >= 0 && c < n && grid[r][c] == 1 && !visited[r][c]) {
                    stack.push(new int[]{r, c});
                    visited[r][c] = true;
                }
            }
        }
        return area;
    }

    //基于 递归 深度优先搜索
    private int getArea3(int[][] grid, boolean[][] visited, int i, int j, int m, int n) {
        //面积
        int area = 1;
        visited[i][j] = true;
        //定义方向
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for (int[] dir : dirs) {
            int r = i + dir[0];
            int c = j + dir[1];
            if (r >= 0 && r < m && c >= 0 && c < n && grid[r][c] == 1 && !visited[r][c]) {
                area += getArea(grid, visited, r, c, m, n);
            }
        }
        return area;
    }

}

//1254. 统计封闭岛屿的数目
// https://leetcode-cn.com/problems/number-of-closed-islands/
class SolutionLC1254 {
    public int closedIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int num = 0;
        boolean[][] visited = new boolean[m][n];

        for (int j = 0; j < n; j++) {
            getArea(grid, visited, 0, j);// 把靠上边的岛屿淹掉
            getArea(grid, visited, m - 1, j);// 把靠下边的岛屿淹掉
        }
        for (int i = 0; i < m; i++) {
            getArea(grid, visited, i, 0);// 把靠左边的岛屿淹掉
            getArea(grid, visited, i, n - 1);// 把靠右边的岛屿淹掉
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0 && !visited[i][j]) {
                    getArea(grid, visited, i, j);
                    num++;
                }
            }
        }
        return num;
    }

    //基于 广度优先搜索
    private void getArea1(int[][] grid, boolean[][] visited, int i, int j) {

        int m = grid.length;
        int n = grid[0].length;
        //队列
        Queue<int[]> queue = new LinkedList<>();
        //插入头结点
        queue.add(new int[]{i, j});
        if(grid[i][j] == 0 && !visited[i][j]){
            visited[i][j] = true;
        }

        //定义方向
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!queue.isEmpty()) {
            int[] pos = queue.remove();

            for (int[] dir : dirs) {
                int r = pos[0] + dir[0];
                int c = pos[1] + dir[1];
                if (r >= 0 && r < m && c >= 0 && c < n && grid[r][c] == 0 && !visited[r][c]) {
                    queue.add(new int[]{r, c});
                    visited[r][c] = true;
                }
            }
        }
    }

    //基于 栈 深度优先搜索
    private void getArea(int[][] grid, boolean[][] visited, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;
        //栈
        Stack<int[]> stack = new Stack<>();
        //插入头结点
        stack.push(new int[]{i, j});
        visited[i][j] = true;
        //定义方向
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!stack.isEmpty()) {
            int[] pos = stack.pop();

            for (int[] dir : dirs) {
                int r = pos[0] + dir[0];
                int c = pos[1] + dir[1];
                if (r >= 0 && r < m && c >= 0 && c < n && grid[r][c] == 0 && !visited[r][c]) {
                    stack.push(new int[]{r, c});
                    visited[r][c] = true;
                }
            }
        }
    }

    //基于 递归 深度优先搜索
    private void getArea3(int[][] grid, boolean[][] visited, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;

        visited[i][j] = true;
        //定义方向
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for (int[] dir : dirs) {
            int r = i + dir[0];
            int c = j + dir[1];
            if (r >= 0 && r < m && c >= 0 && c < n && grid[r][c] == 0 && !visited[r][c]) {
                getArea(grid, visited, r, c);
            }
        }
    }

}