package offer2;

import java.util.*;

class Solution075 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        //遍历arr1
        int[] counts = new int[1001];
        for (int num : arr1) {
            counts[num]++;
        }

        //遍历arr2
        int i = 0;
        for (int num : arr2) {
            while (counts[num] > 0) {
                arr1[i++] = num;
                counts[num]--;
            }
        }
        //遍历counts
        for (int num = 0; num < counts.length; num++) {
            while (counts[num] > 0) {
                arr1[i++] = num;
                counts[num]--;
            }
        }
        return arr1;
    }
}