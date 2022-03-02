package offer2;

import java.util.*;

class Solution016 {
    //暴力解法,超时
    public int lengthOfLongestSubstring0(String s) {
        int len = s.length();
        int maxLen = 0;
        for (int i = 0; i < len; i++) {
            Map<Character, Integer> map = new HashMap<>();
            int j = i;
            while (j < len) {
                if (map.containsKey(s.charAt(j))) {
                    maxLen = Math.max(maxLen, j - i);
                } else {
                    map.put(s.charAt(j), 1);
                }
            }
        }
        return maxLen;
    }
    public int lengthOfLongestSubstring00(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int len = s.length();
        if(len == 0) return 0;
        for (int i = 0; i < len; i++) {
            map.putIfAbsent(s.charAt(i), 0);
        }

        int maxLen = 0;
        for (int i = 0, j = 0; i < len; i++) {
            while (i <= j && j < len && (map.get(s.charAt(j)) == 0)) {
                map.put(s.charAt(j), map.get(s.charAt(j) + 1));
                maxLen = Math.max(maxLen, j - i + 1);
                j++;
            }
            // map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
        }
        return maxLen;
    }
    //双指针
    public int lengthOfLongestSubstring(String s) {
        int[] map = new int[256];
        int len = s.length();
        if (len == 0) return 0;

        int maxLen = 0;
        for (int i = 0, j = 0; i < len; i++) {
            while (i <= j && j < len && map[s.charAt(j)] < 1) {
                map[s.charAt(j)] += 1;
                maxLen = Math.max(maxLen, j - i + 1);
                j++;
            }
            map[s.charAt(i)] -= 1;
        }
        return maxLen;
    }
}