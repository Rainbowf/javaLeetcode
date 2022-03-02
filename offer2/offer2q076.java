package offer2;

import java.util.*;


class Solution076 {
    private int partition(int[] nums, int start, int end) {
        //产生随机数
        int random = new Random().nextInt(end - start + 1) + start;
        //和末尾进行交换
        swap(nums, random, end);

        int small = start - 1;
        for (int i = start; i < end; ++i) {
            if (nums[i] < nums[end]) {
                small++;
                swap(nums, i, small);
            }
        }
        //small前面都是小于随机数end的数
        small++;
        //把end换回来
        swap(nums, small, end);
        return small;
    }

    private void swap(int[] nums, int i1, int i2) {
        if (i1 != i2) {
            int temp = nums[i1];
            nums[i1] = nums[i2];
            nums[i2] = temp;
        }
    }

    public int findKthLargest(int[] nums, int k) {
        int target = nums.length - k;
        int start = 0;
        int end = nums.length - 1;
        int index = partition(nums, start, end);

        while (index != target) {
            //更新index
            if (index > target) {
                end = index - 1;
            } else if (index < target) {
                start = index + 1;
            }
            //再次查找
            index = partition(nums, start, end);
        }
        return nums[index];
    }
}