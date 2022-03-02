package offer1;

import java.util.*;

class Solution67 {
    public int strToInt(String str) {
        //去除str首尾的多余空格
        char[] c = str.trim().toCharArray();
        //如果array的长度为0 返回0
        if (c.length == 0) return 0;
        //sign表示标志位  1为正  -1 为负  i代表array从何处开始遍历
        int res = 0, i = 1, sign = 1;
        //设置限制值，因为在遍历中先判断res是否越界，再向res赋值，因而对limit的要求/10
        int bndry = Integer.MAX_VALUE / 10;
        //如果array[0]=- 表明该数是负数  sign =-1
        if (c[0] == '-') sign = -1;//i=1
        else if (c[0] != '+') i = 0;//sign = 1;
        //others: i = 1, sign = 1;
        for (int j = i; j < c.length; j++) {
            //判断当前字符是否为数字  不是直接退出
            if (c[j] < '0' || c[j] > '9') break;
            //判断遍历到j-1的位置后  res是否大于limit 如果当前res已经大于limit  加上array[j]一定越界
            //当res等于limit时，我们需要判断array[j]是否大于Integer.MAX_VALUE的末位数7
            if (res > bndry || res == bndry & c[j] > '7') {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            res = res * 10 + (c[j] - '0');
        }
        return sign * res;
    }
}

