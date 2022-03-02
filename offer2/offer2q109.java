package offer2;

import java.util.*;

class Solution109 {
    //单向广度搜索
    public int openLock(String[] deadends, String target) {
        Set<String> dead = new HashSet<>(Arrays.asList(deadends));
        Set<String> visited = new HashSet<>();
        String init = "0000";
        //base case
        if (dead.contains(init) || dead.contains(target)) {
            return -1;
        }

        Queue<String> queue1 = new LinkedList<>();
        Queue<String> queue2 = new LinkedList<>();
        int steps = 0;
        queue1.offer(init);
        visited.add(init);
        while (!queue1.isEmpty()) {
            String cur = queue1.remove();

            if (cur.equals(target)) {
                return steps;
            }
            List<String> nexts = getNeighbors(cur);
            for (String next : nexts) {
                if (!dead.contains(next) && !visited.contains(next)) {
                    queue2.add(next);
                    visited.add(next);
                }
            }

            if (queue1.isEmpty()) {
                steps++;
                queue1 = queue2;
                queue2 = new LinkedList<>();
            }
        }
        return -1;
    }

    private List<String> getNeighbors(String word) {
        List<String> neighbors = new LinkedList<>();
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char old = chars[i];
            //减1，遇0转9
            chars[i] = old == '0' ? '9' : (char) (old - 1);
            neighbors.add(new String(chars));
            //加1，遇9转0
            chars[i] = old == '9' ? '0' : (char) (old + 1);
            neighbors.add(new String(chars));
            //恢复
            chars[i] = old;
        }
        return neighbors;
    }

    //双向广度优先搜索
    public int openLock2(String[] deadends, String target) {
        Set<String> dead = new HashSet<>(Arrays.asList(deadends));
        Set<String> visited = new HashSet<>();
        String init = "0000";
        //base case
        if (dead.contains(init) || dead.contains(target)) {
            return -1;
        }
        if (init.equals(target)) {
            return 0;
        }
        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();
        int length = 1;
        set1.add(init);
        set2.add(target);

        visited.add(target);
        while (!set1.isEmpty() && !set2.isEmpty()) {
            if (set2.size() < set1.size()) {
                Set<String> temp = set1;
                set1 = set2;
                set2 = temp;
            }

            Set<String> set3 = new HashSet<>();
            for (String word : set1) {
                List<String> neighbors = getNeighbors(word);
                for (String neighbor : neighbors) {
                    if (!dead.contains(neighbor)  && set2.contains(neighbor)) {
                        return length;
                    }
                    if (!dead.contains(neighbor) &&!visited.contains(neighbor)) {
                        set3.add(neighbor);
                        visited.add(neighbor);
                    }
                }
            }
            length++;
            set1 = set3;
        }
        return -1;
    }
}