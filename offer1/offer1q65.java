package offer1;

import java.util.*;
//位运算，迭代
class Solution65 {
    public int add(int a, int b) {
        while (b != 0) {       //当进位为0时跳出
            int c = (a & b) << 1; //c计算进位和
            a ^= b;         //a计算无进位和
            b = c;          //b表示进位和
        }
        return a;
    }
}
//位运算，递归，更清楚
class Solution652 {
    public int add(int a, int b) {
        if (b == 0) {
            return a;
        }
        return add(a ^ b, (a & b) << 1);
    }
}