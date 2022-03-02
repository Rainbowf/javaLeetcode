package offer2;

import java.util.*;

class Solution004 {
    public int singleNumber(int[] nums) {
        int[] bitCnt = new int[32];

        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                bitCnt[i] += (num >> (31 - i)) & 1;
            }
        }
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res = ((res << 1) + bitCnt[i] % 3);
        }
        return res;
    }
}