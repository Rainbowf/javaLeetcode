package offer2;


import java.util.*;

class Solution001 {
    public int divide(int dividend, int divisor) {
        //转成负数除以负数时，只有这一种会溢出
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        //转成负数 除以 负数，保存最后 商 的符号 ，偶数+，奇数-
        int negative = 2;
        if (dividend > 0) {
            negative--;
            dividend = -dividend;
        }
        if (divisor > 0) {
            negative--;
            divisor = -divisor;
        }

//        boolean flag_dividend = false;
//        boolean flag_divisor = false;
//        if (dividend > 0) {
//            flag_dividend = true;
//            dividend = -dividend;
//        }
//        if(divisor > 0) {
//            flag_divisor = true;
//            divisor = -divisor;
//        }
//
//        boolean flag_result = flag_dividend ^ flag_divisor;

//        boolean flag_result = true;
//        if (dividend > 0) {
//            flag_result = !flag_result;
//            dividend = -dividend;
//        }
//        if (divisor > 0) {
//            flag_result = !flag_result;
//            divisor = -divisor;
//        }


        //标准化后的除法
        int result = divideCore(dividend, divisor);
        return negative % 2 == 1 ? -result : result;

    }

    private int divideCore(int dividend, int divisor) {
        int res = 0;
        while (dividend <= divisor){
            int value = divisor;
            int quotient =1;
            while(value >= Integer.MIN_VALUE>>1 && dividend <= value<<1){
                quotient += quotient;
                value += value;
            }

            res += quotient;
            dividend -=value;
        }
        return res;
    }
}
