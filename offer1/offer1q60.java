package offer1;

import java.util.*;

class Solution60 {
    //动态规划，正向推导 时间复杂度 O(n2) 空间复杂度 O(n)
    // f(n−1,x)仅与f(n,x+1),f(n,x+2),...,f(n,x+6)相关
    public double[] dicesProbability(int n) {
        double[] dp = new double[6];
        Arrays.fill(dp, 1.0 / 6.0);
        //n个骰子
        for (int i = 2; i <= n; i++) {
            double[] tmp = new double[5 * i + 1];
            for (int j = 0; j < dp.length; j++) {
                for (int k = 0; k < 6; k++) {
                    tmp[j + k] += dp[j] / 6.0;
                }
            }
            dp = tmp;
        }
        return dp;
    }
}