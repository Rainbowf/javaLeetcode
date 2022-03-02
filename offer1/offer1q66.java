package offer1;

import java.util.*;

class Solution66 {
    //暴力法，超时
    public int[] constructArr(int[] a) {
        int size = a.length;
        int[] res = new int[size];
        for (int i = 0; i < size; i++) {
            int mul = 1;
            for (int j = i + 1; j < i + size; j++) {
                mul *= a[j % size];
            }
            res[i] = mul;
        }
        return res;
    }

    //
    public int[] constructArr2(int[] a) {
        int size = a.length;
        if (size == 0) return new int[0];
        int[] res = new int[size];
        res[0] = 1;
        int temp = 1;
        for (int i = 1; i < size; i++) {
            res[i] = res[i - 1] * a[i - 1];
        }
        for (int i = size - 2; i >= 0; i--) {
            temp *= a[i + 1];
            res[i] *= temp;
        }
        return res;
    }

    public int[] constructArr3(int[] a) {
        int size = a.length;
        if (size == 0) return new int[0];
        int[] res = new int[size];

        Arrays.fill(res, 1);

        int left = 1;
        int right = 1;

        for (int i = 0; i < size; i++) {
            res[i] *= left;
            left *= a[i];               // 持有左边的所有数的乘积

            res[size - i - 1] *= right;
            right *= a[size - i - 1];     // 持有右边的所有数的乘积
        }
        return res;
    }
}