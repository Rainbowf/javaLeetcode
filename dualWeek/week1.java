package dualWeek;

import java.util.*;


class Solutionweek1 {
    public static void main(String[] args) {
        int[] nums1 = {3, 1, 2, 2, 2, 1, 3};
        int k1 = 2;

        int[] nums2 = {1, 2, 3, 4};
        int k2 = 1;

        System.out.println(countPairs(nums2, k2));
    }

    public static int countPairs(int[] nums, int k) {
        int res = 0;
        //暴力解法100*100
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j] && (i * j) % k == 0) {
                    res++;
                }
            }
        }
        return res;
    }



}