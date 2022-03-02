package offer2;

import java.util.*;

class Solution94 {
    public int minCut(String s) {
        int n = s.length();
        boolean[][] isPal = new boolean[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j <= i; j++){
                char ch1 = s.charAt(i);
                char ch2 = s.charAt(j);
                // 回文子串方法，会越界吗，不会，因为或前面先满足所以必须是i>=1才会有后面的判断
                if(ch1 == ch2 && (i <= j + 1 || isPal[j+1][i-1])){
                    isPal[j][i] = true;
                }
            }
        }

        int[] dp = new int[n];
        for(int i = 0; i < n; i++){
            //如果整个是回文子串
            if(isPal[0][i]){
                dp[i] = 0;
            } else{
                dp[i] = i;
                for(int j = 1; j <= i; j++){
                    if(isPal[j][i]){
                        dp[i] = Math.min(dp[i], dp[j-1] + 1);
                    }
                }
            }
        }
        return dp[n-1];
    }
}