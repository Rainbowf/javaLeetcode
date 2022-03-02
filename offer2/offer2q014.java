package offer2;

import java.util.*;

class Solution014 {
    //滑动窗口+数组哈希
    public boolean checkInclusion(String s1, String s2) {
        int[] cnts = new int[26];
        int len1 = s1.length();
        int len2 = s2.length();
        if (len1 > len2) return false;
        //初始化
        for (int i = 0; i < len1; i++) {
            cnts[s1.charAt(i) - 'a']++;
            cnts[s2.charAt(i) - 'a']--;
        }
        if (areAllZero(cnts)) {
            return true;
        }

        for (int i = len1; i < len2; i++) {
            cnts[s2.charAt(i) - 'a']--;
            cnts[s2.charAt(i - len1) - 'a']++;
            if (areAllZero(cnts)){
                return true;
            }
        }
        return false;
    }

    private boolean areAllZero(int[] cnts) {
        for (int cnt : cnts) {
            if (cnt != 0) return false;
        }
        return true;
    }
}