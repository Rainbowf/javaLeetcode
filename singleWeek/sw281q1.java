package singleWeek;

import java.util.*;

class Solutionsw281q1 {
    public static void main(String[] args) {

        System.out.println(countEven(30));
    }

    public static int countEven(int num) {
        int[] dp = new int[num < 10 ? 10 : num + 1];
        int oddNum = 0;
        int evenNum = 0;
        for (int i = 0; i < 10; i++) {
            dp[i] = i;
        }
        for (int i = 10; i <= num; i++) {
            dp[i] = dp[i / 10] + dp[i % 10];
        }

        for (int i = 1; i <= num; i++) {
            if (dp[i] % 2 == 0) evenNum++;
        }

        return evenNum;
    }
}