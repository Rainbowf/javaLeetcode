package offer2;

import java.util.*;

class Solution011 {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        int maxLen = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i] == 0 ? -1 : 1;
            map.putIfAbsent(sum,i);
            maxLen = Math.max(maxLen, i - map.get(sum));
        }
        return maxLen;
    }
}