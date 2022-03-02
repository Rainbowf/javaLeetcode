package offer1;

import java.util.*;

//快速幂运算
class Solution160 {
    //分冶算法,递归
    public double myPow(double x, int n) {
        long N = n;
        return N >= 0 ? powHelper(x, N) : 1.0 / powHelper(x, -N);
    }

    private double powHelper(double x, long N) {
        if (N == 0.0) return 1.0;
        double half = powHelper(x, N / 2);
        return N % 2 == 0 ? half * half : half * half * x;
    }
}

class Solution161 {
    //分冶算法,迭代
    public double myPow(double x, int n) {
        long N = n;
        return N >= 0 ? powHelper(x, N) : 1.0 / powHelper(x, -N);
    }

    private double powHelper(double x, long N) {
        double ans = 1.0;
        double y = x;//初始x
        while (N > 0) {
            if (N % 2 == 1) {//末尾为1
                ans *= y;
            }
            y *= y;//编成平方
            N /= 2;//向右移一位
        }
        return ans;
    }
}