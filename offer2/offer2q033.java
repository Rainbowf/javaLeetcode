package offer2;

import java.util.*;


class Solution033 {
    //质数相乘法
    public List<List<String>> groupAnagrams1(String[] strs) {
        int[] hash = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};
        Map<Long, List<String>> groups = new HashMap<>();
        for (String str : strs) {
            long wordHash = 1;
            for (char ch : str.toCharArray()) {
                wordHash *= hash[ch - 'a'];
            }
            groups.putIfAbsent(wordHash, new LinkedList<String>());
            groups.get(wordHash).add(str);
        }
        return new LinkedList<>(groups.values());
    }

    //先排序后分组
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();
        for (String str : strs) {
            char[] strToArray = str.toCharArray();
            Arrays.sort(strToArray);
            String sorted = new String(strToArray);

            groups.putIfAbsent(sorted, new LinkedList<String>());
            groups.get(sorted).add(str);
        }
        return new LinkedList<>(groups.values());
    }
}