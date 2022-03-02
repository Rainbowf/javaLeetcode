package offer2;

import java.util.*;

class Solution007 {
    public List<List<Integer>> threeSum(int[] nums) {
        // 用什么数据结构？动态数组
        List<List<Integer>> res = new LinkedList<>();

        //base case
        if (nums.length < 3) return res;

        //先排序 n·logn
        Arrays.sort(nums);


        //固定一个数，剩下用双指针
        for (int i = 0; i < nums.length - 2; ) {

            for (int j = i + 1, k = nums.length - 1; j < k; ) {
                if ((nums[i] + nums[j] + nums[k]) < 0) {
                    ++j;
                } else if ((nums[i] + nums[j] + nums[k]) > 0) {
                    --k;
                } else {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    //去重
                    int temp = nums[j];
                    while (nums[j] == temp && j < k) {
                        ++j;
                    }
                }
            }
            //去重,i定位至最新的不与前面相同的数
            int temp = nums[i];
            while (i < nums.length && nums[i] == temp) {
                ++i;
            }
        }
        return res;
    }
}