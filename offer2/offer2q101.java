package offer2;

class Solution101 {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) {
            return false;
        }

        return subsetSum(nums, sum / 2);
    }

    //方法一：递归
    private boolean subsetSum(int[] nums, int target) {
        int l = nums.length;
        Boolean[][] dp = new Boolean[l + 1][target + 1];
        return helper(nums, dp, l, target);
    }

    private boolean helper(int[] nums, Boolean[][] dp, int i, int j) {
        if (dp[i][j] == null) {
            if (j == 0) {
                dp[i][j] = true;
            } else if (i == 0) {
                dp[i][j] = false;
            } else {
                //不选择
                dp[i][j] = helper(nums, dp, i - 1, j);
                //选择
                if (!dp[i][j] && j >= nums[i - 1]) {
                    dp[i][j] = helper(nums, dp, i - 1, j - nums[i - 1]);
                }
            }

        }
        return dp[i][j];
    }

    //方法二：迭代计算
    private boolean subsetSum2(int[] nums, int target) {
        int l = nums.length;
        boolean[][] dp = new boolean[l + 1][target + 1];
        for (int i = 0; i <= l; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= l; i++) {
            for (int j = 1; j <= target; j++) {
                dp[i][j] = dp[i - 1][j];
                if (!dp[i][j] && j >= nums[i - 1]) {
                    dp[i][j] = dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[l][target];
    }

    //方法三：迭代计算,改成一维数组
    private boolean subsetSum3(int[] nums, int target) {
        int l = nums.length;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        for (int i = 1; i <= l; i++) {
            for (int j = target; j >0; --j) {

                if (!dp[j] && j >= nums[i - 1]) {
                    dp[j] = dp[j - nums[i - 1]];
                }
            }
        }
        return dp[target];
    }
}