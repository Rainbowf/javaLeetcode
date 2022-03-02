package offer1;

import java.util.*;

class Solution57 {
    //数学解法，求根公式
    public int[][] findContinuousSequence(int target) {
        List<int[]> vec = new ArrayList<int[]>();
        int maxStart = (target - 1) / 2;
        for (int i = 1; i <= maxStart; i++) {
            long start = i;
            int maxEnd = (int) (Math.sqrt(2.0 * target + Math.pow(start - 0.5, 2)) - 0.5);
            if ((maxEnd - i + 1) * (i + maxEnd) == 2 * target) {
                int[] res = new int[maxEnd - i + 1];
                for (int k = i; k <= maxEnd; ++k) {
                    res[k - i] = k;
                }
                vec.add(res);
            }
        }
        return vec.toArray(new int[vec.size()][]);
    }

    //双指针
    public int[][] findContinuousSequence2(int target) {
        List<int[]> vec = new ArrayList<int[]>();
        int sum = 3;
        for (int l = 1, r = 2; l < r; ) {
            if (sum == target)
            {
                int[] res = new int[r - l + 1];
                for (int i = l; i <= r; i++) {
                    res[i - l] = i;
                }
                vec.add(res);
                sum -= l++;
            }else if(sum < target){
                sum += ++r;
            }else {
                sum -= l++;
            }
        }
        return vec.toArray(new int[vec.size()][]);
    }
}
