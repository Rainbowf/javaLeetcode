package offer2;

import java.util.*;

class Solution070 {
    public static void main(String[] args) {
        int[] nums1 = {1};
        int[] nums2 = {1, 2, 2, 3, 3};
        int[] nums3 = {2, 2, 3, 3, 4};
        System.out.println(singleNonDuplicate(nums2));
    }

    public static int singleNonDuplicate(int[] nums) {
        if (nums.length == 1) return nums[0];
        int i = 0;
        int j = nums.length / 2;
        while (i <= j) {
            int m = i + (j - i) / 2;
            int k = 2 * m;
            if (k < nums.length - 1 && nums[k] != nums[k + 1]) {
                if (m == 0 || nums[k - 2] == nums[k - 1]) {
                    return nums[k];
                }
                j = m - 1;

            } else {
                i = m + 1;
            }
        }
        return nums[nums.length - 1];
    }
}