package offer2;

import java.util.*;

class Solution069 {
    public static void main(String[] args) {
        int[] nums1 = {24,69,100,99,79,78,67,36,26,19};
        int k1 = 2;

        int[] nums2 = {1, 2, 3, 4};
        int k2 = 1;

        System.out.println(peakIndexInMountainArray(nums1));
    }
    public static int peakIndexInMountainArray(int[] arr) {
        //注意，要留出头和尾
        int i = 1;//i=0 X!
        int j = arr.length - 2;//j=arr.length-1 X!
        while (i <= j) {
            int m = i + (j - i) / 2;
            if (arr[m] > arr[m - 1] && arr[m] < arr[m + 1]) {
                i = m + 1;
            } else if (arr[m] < arr[m - 1] && arr[m] > arr[m + 1]) {
                j = m - 1;
            }else {
                return m;
            }
        }
        return -1;//找不到就随意返回
    }
}