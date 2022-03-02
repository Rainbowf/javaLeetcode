package offer2;

import java.util.*;

class Solution111 {
    //创建一个图Map: {key:起始节点（被除数）; value：Map｛key:终止节点（除数）;value:有向边权值（商）｝}
    private Map<String, Map<String, Double>> buildGraph(List<List<String>> equations, double[] values) {
        //开辟一块空间用于存储图
        Map<String, Map<String, Double>> graph = new HashMap<>();
        for (int i = 0; i < equations.size(); ++i) {
            String from = equations.get(i).get(0);
            String to = equations.get(i).get(1);

            graph.putIfAbsent(from, new HashMap<String, Double>());
            graph.get(from).put(to, values[i]);

            graph.putIfAbsent(to, new HashMap<String, Double>());
            graph.get(to).put(from, 1.0 / values[i]);
        }
        return graph;
    }

    //对目标字符串数组进行dfs搜索，前提: from 和 to 均在 graph 中
    private double dfs(Map<String, Map<String, Double>> graph, String from, String to, Set<String> visited) {
        if (from.equals(to)) {
            return 1.0;
        }

        visited.add(from);

        for (Map.Entry<String, Double> entry : graph.get(from).entrySet()) {
            String next = entry.getKey();
            if (!visited.contains(next)) {
                double nextValue = dfs(graph, next, to, visited);
                if (nextValue > 0) {
                    return entry.getValue() * nextValue;
                }
            }
        }

        visited.remove(from);
        return -1.0;
    }

    //主函数
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        //Step 1: 构建图，创建结果数组
        Map<String, Map<String, Double>> graph = buildGraph(equations, values);
        double[] results = new double[queries.size()];
        //Step 2: 对每一个query进行搜索
        for (int i = 0; i < queries.size(); ++i) {
            String from = queries.get(i).get(0);
            String to = queries.get(i).get(1);

            if (!graph.containsKey(from) || !graph.containsKey(to)) {
                results[i] = -1.0;
            } else {
                //对每一个query建立一个查询记录集，避免回路重复搜索
                Set<String> visited = new HashSet<>();
                results[i] = dfs(graph, from, to, visited);
            }
        }
        return results;
    }
}