package offer1;

import java.util.*;

class Solution14 {
    //数学 基本不等式 求导
    public int cuttingRope(int n) {
        if (n <= 3) return n - 1;
        int a = n / 3, b = n % 3;
        if (b == 0) return (int) Math.pow(3, a);
        if (b == 1) return (int) Math.pow(3, a - 1) * 4;
        return (int) Math.pow(3, a) * 2;
    }

    //优化动态规划
    //dp[i]=max(2×(i−2),2×dp[i−2],3×(i−3),3×dp[i−3])
    public int cuttingRope2(int n) {
        if (n < 4) return n - 1;

        int[] dp = new int[n + 1];
        dp[2] = 1;//必须分成两份
        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(2 * Math.max(i - 2, dp[i - 2]), 3 * Math.max(i - 3, dp[i - 3]));
        }
        return dp[n];
    }
    //大数求余解法：
}