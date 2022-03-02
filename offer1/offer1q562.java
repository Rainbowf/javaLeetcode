package offer1;

import java.util.*;

class Solution562 {
    public int singleNumber(int[] nums) {
        int[] bitSum = new int[32];
        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                bitSum[i] += (num >> (31 - i)) & 1;
            }
        }
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res = (res << 1) + bitSum[i] % 3;
        }
        return res;
    }
}