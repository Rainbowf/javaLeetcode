package offer2;

import java.util.*;

class Solution071 {
    //
    private int[] sums;
    private int total;

    public void Solution(int[] w) {
        sums = new int[w.length];
        for (int i = 0; i < w.length; i++) {
            total += w[i];
            sums[i] = total;
        }
    }

    public int pickIndex() {
        //产生随机数
        Random random = new Random();
        int p = random.nextInt(total);
        //二分查找
        int l = 0;
        int r = sums.length;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (sums[m] > p) {
                if (m == 0 || sums[m - 1] <= p) {
                    return m;
                }
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return -1;
    }
}