package offer2;

import java.util.*;

class Solution072 {
    //二分查找
    public int mySqrt(int x) {
        int l = 1;
        int r = x;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (m <= x / m) {
                if ((m + 1) > x / (m + 1)) {
                    return m;
                }
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        //以上都不满足，刚好返回0
        return 0;
    }
    //方法一：袖珍计算器算法
    public int mySqrt2(int x) {
        if (x == 0) {
            return 0;
        }
        int ans = (int) Math.exp(0.5 * Math.log(x));
        return (long) (ans + 1) * (ans + 1) <= x ? ans + 1 : ans;
    }

    //方法三：牛顿迭代
    public int mySqrt3(int a) {
        long x = a;
        while (x * x > a) x = (x + a / x) / 2;
        return (int)x;
    }
    //https://leetcode-cn.com/problems/sqrtx/solution/x-de-ping-fang-gen-by-leetcode-solution/
}