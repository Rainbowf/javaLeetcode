package offer2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Solution106 {
    public boolean isBipartite(int[][] graph) {
        int len = graph.length;
        //创建每个节点的颜色表,0、1、-1:没有染色
        int[] colors = new int[len];
        Arrays.fill(colors, -1);
        //对每个节点进行 涂色
        for (int i = 0; i < len; i++) {
            //只对还未染色的节点进行搜索，前面已经涂色的节点均为其他子图搜索完毕，因此可设置现在的节点颜色为0
            if (colors[i] == -1) {
                if (!setColor(graph, colors, i, 0)) {
                    return false;
                }
            }
        }
        return true;
    }

    //  广度优先搜索
    private boolean setColor(int[][] graph, int[] colors, int i, int color) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);
        colors[i] = color;

        while (!queue.isEmpty()) {
            int v = queue.remove();
            for (int neighbor : graph[v]) {
                //在这一轮中已经涂色的节点需要排除掉
                if (colors[neighbor] >= 0) {
                    if (colors[neighbor] == colors[v]) {
                        return false;
                    }
                } else {
                    queue.add(neighbor);
                    colors[neighbor] = 1 - colors[v];
                }
            }
        }
        return true;
    }

    //  深度优先搜索，递归
    private boolean setColor2(int[][] graph, int[] colors, int i, int color) {
        //在这一轮中，可能会碰到重复涂色，即 闭环
        if (colors[i] >= 0) {
            return color == colors[i];
        }

        colors[i] = color;
        //对每一个邻居进行检查
        for (int neighbor : graph[i]) {
            if (!setColor(graph, colors, neighbor, 1 - color)) {
                return false;
            }
        }
        return true;
    }
}