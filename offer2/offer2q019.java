package offer2;

import java.util.*;

class Solution019 {
    public static void main(String[] args) {
        String s = "abcdfcba";

        System.out.println(validPalindrome(s));
    }

    public static boolean validPalindrome(String s) {
        int start = 0, end = s.length() - 1;
        //找到第一次出现不同的地方
        for (; start < s.length() / 2; ++start, --end) {
            if (s.charAt(start) != s.charAt(end)) {
                break;
            }
        }
        return start == s.length() / 2 || isPalindrome(s, start, end - 1) || isPalindrome(s, start + 1, end);
    }

    private static boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}