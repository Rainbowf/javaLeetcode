package offer2;

import java.util.*;

class Solution005 {
    public int maxProduct(String[] words) {
        //存到数组中
        int[] bitnum = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            for (char ch : words[i].toCharArray()) {
                bitnum[i] |= (1 << (ch - 'a'));
            }
        }
        //筛选，两两比较，记录最大值
        int max = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if ((bitnum[i] & bitnum[j]) == 0) {
                    max = Math.max(max, words[i].length() * words[j].length());
                }
            }
        }
        //返回最大值
        return max;
    }
}