import java.util.List;

class Solution100 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.size();

        int[][] dp = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = triangle.get(i).get(j);
                if (i > 0 && j == 0) {
                    dp[i][j] += dp[i - 1][j];
                } else if (i > 0 && j == i) {
                    dp[i][j] += dp[i - 1][j - 1];
                } else if (i > 0) {
                    dp[i][j] += Math.min(dp[i - 1][j], dp[i - 1][j - 1]);
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int num : dp[size - 1]) {
            min = Math.min(num, min);
        }
        return min;
    }
}