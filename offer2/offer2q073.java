package offer2;

import java.util.*;

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        //获取右边界
        int maxPile = Integer.MIN_VALUE;
        for (int pile : piles) {
            maxPile = Math.max(maxPile, pile);
        }

        //二分查找
        int l = 1;
        int r = maxPile;

        while (l <= r) {
            int m = l + (r - l) / 2;
            if (getHours(piles, m) <= h) {
                if (m == 1 || getHours(piles, m - 1) > h) {
                    return m;
                }
                r = m -1;
            }else {
                l = m + 1;
            }
        }
        return -1;
    }

    private int getHours(int[] piles, int speed) {
        int hours = 0;
        for (int pile : piles) {
//            while (pile > 0) {
//                hours++;
//                pile -= speed;
//            }
            hours += ((pile - 1) / speed + 1);
        }
        return hours;
    }
}