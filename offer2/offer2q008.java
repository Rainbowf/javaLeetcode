package offer2;

import java.util.*;

class Solution008 {
    //自己写的版本bug
    public int minSubArrayLen0(int target, int[] nums) {
        int i = 0, j = 0;
        int minLen = nums.length;
        int sum = nums[0];
        while (i <= j && j < nums.length) {
            if (sum < target) {
                sum += nums[++j];
            } else {
                minLen = Math.min(minLen, j - 1 + 1);
                sum -= nums[++i];
            }
        }
        return minLen;
    }

    public int minSubArrayLen(int target, int[] nums) {
        int i = 0;
        int minLen = nums.length + 1;
        int sum = 0;
        for (int j = 0; j < nums.length; j++) {
            sum += nums[j];
            while (i <= j && sum >= target) {
                minLen = Math.min(minLen, j - i + 1);
                sum -= nums[i++];
            }
        }
        return minLen == nums.length + 1 ? 0 : minLen;
    }
}

//前缀和 + 二分查找
class Solution0082 {
    public int minSubArrayLen(int s, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        int[] sums = new int[n + 1];
        // 为了方便计算，令 size = n + 1
        // sums[0] = 0 意味着前 0 个元素的前缀和为 0
        // sums[1] = A[0] 前 1 个元素的前缀和为 A[0]
        // 以此类推
        for (int i = 1; i <= n; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }
        for (int i = 1; i <= n; i++) {
            int target = s + sums[i - 1];
            int bound = Arrays.binarySearch(sums, target);
            if (bound < 0) {
                bound = -bound - 1;
            }
            if (bound <= n) {
                ans = Math.min(ans, bound - (i - 1));
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}

//作者：LeetCode-Solution
//        链接：https://leetcode-cn.com/problems/2VG8Kg/solution/he-da-yu-deng-yu-target-de-zui-duan-zi-s-ixef/
//        来源：力扣（LeetCode）
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。