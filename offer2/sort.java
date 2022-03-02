package offer2;

import java.util.Random;

//快排
public class sort {
    public int[] sortArray(int[] nums) {
        quicksort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quicksort(int[] nums, int start, int end) {
        if (end > start) {
            int pivot = partition(nums, start, end);
            quicksort(nums, start, pivot - 1);
            quicksort(nums, pivot + 1, end);
        }
    }

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
}
