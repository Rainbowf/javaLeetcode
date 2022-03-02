package offer1;

import java.util.*;

class Solution62 {
    public int lastRemaining(int n, int m) {
        //最后的一个的索引值是0
        int x = 0;
        //从2开始
        for (int i = 2; i <= n; i++) {
            x = (x + m) % i;
        }
        return x;
    }
}
