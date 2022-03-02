package offer1;

import java.util.*;
//类似全排列题，但是需要去重
//去重方案：1.一开始遍历，用哈希集合 2.先排序，然后用visited布尔数组
class Solution28 {

    List<String> res = new LinkedList<>();
    char[] c;

    public String[] permutation(String s) {
        c = s.toCharArray();
        helper(0);
        return res.toArray(new String[res.size()]);
    }

    private void helper(int i) {
        //若到了尾部，则添加到res中
        if (i == c.length - 1) {
            //注意语法！！！！！！！！！！！
            res.add(String.valueOf(c));
            return;
        } else {
            HashSet<Character> set = new HashSet<>();
            for (int j = i; j < c.length; j++) {
                if(set.contains(c[j])) continue;//重复，剪纸
                set.add(c[j]);
                swap(i, j);
                helper(i + 1);
                swap(i, j);
            }
        }
    }

    private void swap(int a, int b) {
        if (a != b) {
            char t = c[a];
            c[a] = c[b];
            c[b] = t;
        }
    }
}