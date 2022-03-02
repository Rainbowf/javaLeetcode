package dualWeek;

import java.util.*;
//lc5999
class Solutionweek3 {
    public static void main(String[] args) {
        List<Integer> res = new LinkedList<>();
        res.add(1);
        res.add(2);
        System.out.println(res);
    }

    public static List<Long> maximumEvenSplit(long finalSum) {
        List<Long> ans = new ArrayList<>();

        if (finalSum % 2 == 1) return ans;
        long temp = finalSum;

        for (long i = 2; i < temp; i += 2) {
            finalSum -= i;
            if (finalSum <= i) {
                finalSum += i;
                ans.add(finalSum);
                return ans;
            }
            ans.add(i);
        }
        return ans;
    }
}