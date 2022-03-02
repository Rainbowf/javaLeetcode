package offer1;

import java.util.*;

class Solution39 {

    //法一：先快排，返回中间值
    public int majorityElement1(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    //法二：哈希表
    public int majorityElement2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        Map.Entry<Integer, Integer> maxValOfEntry = null;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (maxValOfEntry == null || entry.getValue() > maxValOfEntry.getValue()) {
                maxValOfEntry = entry;
            }
        }
        return maxValOfEntry.getKey();
    }

    //法三：摩尔投票法
    public int majorityElement3(int[] nums) {
        int count = 0;
        Integer candidate = null;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (candidate == num) ? 1 : -1;
        }
        return candidate;
    }

    //分冶
    //随机化
}