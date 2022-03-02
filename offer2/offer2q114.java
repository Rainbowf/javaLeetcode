package offer2;

import java.util.*;

class Solution114 {

    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> graph = new HashMap<>();
        Map<Character, Integer> inDegrees = new HashMap<>();

        //初始化
        for(String word : words){
            for (char ch: word.toCharArray()){
                graph.putIfAbsent(ch, new HashSet<Character>());
                inDegrees.putIfAbsent(ch, 0);
            }
        }

        //比较两个字符串，填图
        for (int i = 0; i < words.length - 1; i++) {
            String a = words[i];
            String b = words[i+1];
            //特殊情况
            if(a.startsWith(b) && !a.equals(b)){
                return "";
            }

            int m = a.length();
            int n = b.length();

            for (int j = 0; j < Math.min(m, n); j++) {
                char ch1 = a.charAt(j);
                char ch2 = b.charAt(j);
                if (ch1 != ch2) {
                    if(!graph.get(ch1).contains(ch2)) {
                        graph.get(ch1).add(ch2);
                        inDegrees.put(ch2, inDegrees.get(ch2) + 1);
                    }
                    break;//一定要中断，后面就不比较了
                }
            }
        }

        //生成拓扑序列
        Queue<Character> queue = new LinkedList<>();
        for (char ch : graph.keySet()) {
            if (inDegrees.get(ch) == 0) {
                queue.add(ch);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            char from = queue.remove();
            sb.append(from);
            for (char next : graph.get(from)) {
                inDegrees.put(next, inDegrees.get(next) - 1);
                if (inDegrees.get(next) == 0) {
                    queue.add(next);
                }
            }
        }
        return sb.length() == inDegrees.size() ? sb.toString() : "";
    }
}