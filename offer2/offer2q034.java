package offer2;

import java.util.*;

class Solution034 {
    public boolean isAlienSorted(String[] words, String order) {
        //构建顺序表 哈希映射
        int[] dict = new int[26];
        for (int i = 0; i < order.length(); i++) {
            char ch = order.charAt(i);
            dict[ch - 'a'] = i;
        }

        //遍历，前后比较
        for (int i = 0; i < words.length - 1; i++) {
            if (!isSorted(words[i], words[i + 1], dict)) {
                return false;
            }
        }
        return true;
    }

    private boolean isSorted(String word1, String word2, int[] dict) {
        int i = 0;
        for (; i < word1.length() && i < word2.length(); ++i) {
            char ch1 = word1.charAt(i);
            char ch2 = word2.charAt(i);

            if (dict[ch1 - 'a'] < dict[ch2 - 'a']) {
                return true;
            } else if (dict[ch1 - 'a'] > dict[ch2 - 'a']) {
                return false;
            }
        }
        return i == word1.length();//!!!!!妙啊
    }
}