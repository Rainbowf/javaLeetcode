package offer2;

import java.util.*;


class Solution002 {
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        //从右往左写
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        //两个索引值在变的写法，注意！
        while ((i >= 0 || j >= 0)) {
            //因为是或关系，所以i和j都要进行边界检查
            int digitA = i >= 0 ? a.charAt(i--) - '0' : 0;
            int digitB = j >= 0 ? b.charAt(j--) - '0' : 0;
            int sum = digitA + digitB + carry;
            if (sum > 1) {
                carry = 1;
                sum -= 2;
            } else {
                carry = 0;
            }
            result.append(sum);
        }
        //最后一位进位
        if (carry == 1) {
            result.append(1);
        }
        //先翻转再转成String
        return result.reverse().toString();
    }
}
