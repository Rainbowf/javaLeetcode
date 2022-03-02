package offer2;

import java.util.Arrays;

class Solution103 {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount+1);
        dp[0] = 0;

        for(int coin: coins){
            for(int j = amount; j>=1; j--){
                for(int k = 1; k*coin <= j;k++){
                    dp[j] = Math.min(dp[j], dp[j - k*coin]+k);
                }
            }
        }
        return dp[amount] > amount ? -1: dp[amount];
    }

    public int coinChange2(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        for(int i = 1; i <= amount; ++i){
            dp[i] = amount+1;
            for(int coin: coins){
                if(i >= coin){
                    dp[i] = Math.min(dp[i - coin] + 1,dp[i]);
                }
            }
        }
        return dp[amount] > amount ? -1: dp[amount];
    }
}