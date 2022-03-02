package offer2;

import java.util.*;

class Solution110 {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> path = new LinkedList<Integer>();
        dfs(0, graph, path, result);
        return result;
    }

    private void dfs(int start, int[][] graph, List<Integer> path, List<List<Integer>> result) {
        path.add(start);
        if (start == graph.length - 1) {
            result.add(new LinkedList<>(path));
        } else {
            for (int next : graph[start]) {
                dfs(next, graph, path, result);
            }
        }
        path.remove(path.size() - 1);
    }
}