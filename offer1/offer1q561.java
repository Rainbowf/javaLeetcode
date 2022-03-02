package offer1;

import java.util.*;

class Solution561 {
    public int[] singleNumbers(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            ans ^= num;
        }
        //找到ans中为1的那一位
        int div = 1;
        while ((div & ans) == 0) {
            div <<= 1;
        }
        //分组计算
        int a = 0, b = 0;
        for (int num : nums) {
            if ((div & num) != 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }
        return new int[]{a, b};
    }
}