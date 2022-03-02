package offer2;

class Solution102 {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum + target) % 2 == 1 || sum < target) {
            return 0;
        }
        return subsetSum(nums, (sum + target) / 2);


    }

    private int subsetSum(int[] nums, int target) {
        int l = nums.length;
        int[] dp = new int[target + 1];
        dp[0] = 1;

        for (int num: nums) {
            for (int j = target; j >= num; --j) {
                dp[j] += dp[j - num];
            }
        }
        return dp[target];
    }
}