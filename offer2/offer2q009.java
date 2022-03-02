package offer2;

import java.util.*;

//同步双指针
class Solution009 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        long mul = 1;
        int i = 0;
        int cnt = 0;
        for (int j = 0; j < nums.length; j++) {
            mul *= nums[j];
            while (i <= j && mul > k) {
                mul /= nums[i++];
            }
            cnt += (i <= j) ? j - i + 1 : 0;
        }
        return cnt;
    }
}