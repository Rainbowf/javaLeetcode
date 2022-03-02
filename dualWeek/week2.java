package dualWeek;

import java.util.*;

class Solutionweek2 {
    public static void main(String[] args) {
        System.out.println(sumOfThree(33));
    }

    public static long[] sumOfThree(long num) {
        long n = (num / 3) - 1;
        if (3 * (n + 1) == num) {
            return new long[]{n, n + 1, n + 2};
        }
        return new long[]{};
    }
}