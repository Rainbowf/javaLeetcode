package leetcode;

import java.util.*;

//判断两数互质
class SolutionLC1447 {
    //法一：gcd
    public List<String> simplifiedFractions(int n) {
        List<String> res = new ArrayList<>();
        //i/j
        for(int i = 1; i < n; i++){
            for(int j = i+ 1; j <= n; j++){
                if(gcd1(i,j)==1){
                    res.add(i+"/"+j);//注意这里要用双引号，String类型
                }
            }
        }
        return res;
    }

    //gcd算法：1.欧几里得算法
    private int gcd1(int a, int b) {
        return b == 0 ? a : gcd1(b, a % b);
    }

    //gcd算法：2.辗转相除法
    private int gcd2(int a, int b) {
        while (true) {
            if (a > b) {
                a -= b;
            } else if (b > a) {
                b -= a;
            } else {
                return a;
            }
        }
    }

}