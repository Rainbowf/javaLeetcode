import java.util.*;

class Solution96 {
    public boolean isInterleave(String s1, String s2, String s3) {
        int l1 = s1.length();
        int l2 = s2.length();
        int l3 = s3.length();
        //边界条件
        if(l1 + l2 != l3){
            return false;
        }

        int i1 = 0;
        int i2 = 0;
        //创建dp表，注意s1、s2预留一位首元素
        boolean[][] dp = new boolean[l1 + 1][l2 + 1];

        //两个空字符串必定可以交织出一个空字符串，true
        dp[0][0] = true;

        //i2 = -1时，即s2不参与交织
        for(i1 = 0; i1 < l1; i1++){
            dp[i1+1][0] = s1.charAt(i1) == s3.charAt(i1) && dp[i1][0];
        }
        //i1 = -1时，即s1不参与交织
        for(i2 = 0; i2 < l2; i2++){
            dp[0][i2+1] = s2.charAt(i2) == s3.charAt(i2) && dp[0][i2];
        }
        //两者交织情形
        for (i1 = 0; i1 < l1; i1++) {
            for (i2 = 0; i2 < l2; i2++) {
                char ch1 = s1.charAt(i1);
                char ch2 = s2.charAt(i2);
                char ch3 = s3.charAt(i1+i2+1);

                dp[i1+1][i2+1] = (ch1 == ch3 && dp[i1][i2+1]) || (ch2 == ch3 && dp[i1+1][i2]);
            }
        }
        return dp[l1][l2];
    }

    public boolean isInterleave2(String s1, String s2, String s3) {
        int l1 = s1.length();
        int l2 = s2.length();
        int l3 = s3.length();
        //边界条件
        if(l1 + l2 != l3){
            return false;
        }

        int i1 = 0;
        int i2 = 0;
        //创建dp表，注意s1、s2预留一位首元素
        boolean[][] dp = new boolean[2][l2 + 1];

        //两个空字符串必定可以交织出一个空字符串，true
        dp[0][0] = true;

        //i2 = -1时，即s2不参与交织
        for(i1 = 0; i1 < l1; i1++){
            dp[i1+1][0] = s1.charAt(i1) == s3.charAt(i1) && dp[i1][0];
        }
        //i1 = -1时，即s1不参与交织
        for(i2 = 0; i2 < l2; i2++){
            dp[0][i2+1] = s2.charAt(i2) == s3.charAt(i2) && dp[0][i2];
        }
        //两者交织情形
        for (i1 = 0; i1 < l1; i1++) {
            for (i2 = 0; i2 < l2; i2++) {
                char ch1 = s1.charAt(i1);
                char ch2 = s2.charAt(i2);
                char ch3 = s3.charAt(i1+i2+1);

                dp[i1+1][i2+1] = (ch1 == ch3 && dp[i1][i2+1]) || (ch2 == ch3 && dp[i1+1][i2]);
            }
        }
        return dp[l1][l2];
    }
}