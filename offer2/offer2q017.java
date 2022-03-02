package offer2;

import java.util.*;


class Solution017 {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";

        System.out.println(minWindow(s, t));
    }

    public static String minWindow0(String s, String t) {
        int len1 = s.length();
        int len2 = t.length();
        if (len1 < len2) return "";

        int validSum = len2;
        int allSum = 0;


        Set<Character> set = new HashSet<>();
        int[] map = new int[256];

        for (int i = 0; i < len2; i++) {
            map[t.charAt(i)]++;
            if (!set.contains(t.charAt(i))) {
                set.add(t.charAt(i));
            }
        }
        int kindNum = set.size();

        int maxI = 0;
        int minJ = len1;
        int minLen = Integer.MAX_VALUE;

        for (int i = 0, j = 0; j < len1 || kindNum == 0; i++) {
            while (i <= j && j < len1 && kindNum > 0) {
                if (set.contains(s.charAt(j))) {
                    map[s.charAt(j)]--;
                    if (map[s.charAt(j)] == 0) {
                        kindNum--;
                    }
                }
                j++;
            }

            if (set.contains(s.charAt(i))) {
                map[s.charAt(i)]++;
                if (map[s.charAt(i)] == 1) {
                    if ((j - i) <= (minJ - maxI)) {
                        maxI = i;
                        minJ = j;
                    }
                    kindNum++;
                }
            }
        }

        return minJ - maxI == len1 ? "" : s.substring(maxI, minJ);
    }

    public static String minWindow(String s, String t) {
        int len1 = s.length();
        int len2 = t.length();
        if (len1 < len2) return "";

        Set<Character> set = new HashSet<>();
        int[] map = new int[256];
        Arrays.fill(map, 0);

        for (int i = 0; i < len2; i++) {
            map[t.charAt(i)]++;
            if (!set.contains(t.charAt(i))) {
                set.add(t.charAt(i));
            }
        }
        int kindNum = set.size();

        int maxI = 0;
        int minJ = 0;
        int i = 0, j = 0;
        int minLen = Integer.MAX_VALUE;

        while (j < len1 || (kindNum == 0 && j == len1)) {
            if (kindNum > 0) {
                if (set.contains(s.charAt(j))) {
                    map[s.charAt(j)]--;
                    if (map[s.charAt(j)] == 0) {
                        kindNum--;
                    }
                }
                j++;
            } else {
                if (j - i < minLen) {
                    minLen = j - i;
                    maxI = i;
                    minJ = j;
                }

                if (set.contains(s.charAt(i))) {
                    map[s.charAt(i)]++;
                    if (map[s.charAt(i)] == 1) {
                        kindNum++;
                    }
                }
                i++;
            }
        }

        return minLen < Integer.MAX_VALUE ? s.substring(maxI, minJ) : "";
    }
}