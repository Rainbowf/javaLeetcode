package offer2;

class Solution97 {
    public int numDistinct(String s, String t) {
        int len1 = s.length();
        int len2 = t.length();

        if (len1 < len2) return 0;
        //创建dp表
        int[][] dp = new int[len1 + 1][len2 + 1];
        //s、t均为空，返回1；
        dp[0][0] = 1;
        for (int i = 0; i < len1; i++) {
            //包含空字符，定为 1
            dp[i + 1][0] = 1;
            //注意i、j范围
            for (int j = 0; j <= i && j < len2; j++) {
                if(s.charAt(i) == t.charAt(j)){
                    dp[i+1][j+1] = dp[i][j] + dp[i][j+1];
                }else {
                    dp[i+1][j+1] = dp[i][j+1];
                }
            }

        }
        return dp[len1][len2];
    }
}