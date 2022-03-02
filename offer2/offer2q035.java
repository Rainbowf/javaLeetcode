package offer2;

import java.util.*;

class Solution035 {
    public int findMinDifference(List<String> timePoints) {
        if (timePoints.size() > 1440) {
            return 0;
        }

        boolean[] minFlags = new boolean[1440];
        for (String time : timePoints) {
            String t[] = time.split(":");
            int min = Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);

            if (minFlags[min]) {
                return 0;
            }

            minFlags[min] = true;
        }

        return helper(minFlags);
    }

    private int helper(boolean[] minFlags) {
        int minDiff = minFlags.length - 1;
        int prev = -1;

        int first = minFlags.length - 1;
        int last = -1;

        for (int i = 0; i < minFlags.length; ++i) {
            if (minFlags[i]) {
                if (prev >= 0) {
                    minDiff = Math.min(i - prev, minDiff);
                }
                prev = i;
                first = Math.min(i, first);
                last = Math.max(i, last);
            }
        }

        minDiff = Math.min(first + minFlags.length - last, minDiff);
        return minDiff;
    }
}