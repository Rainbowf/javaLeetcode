package offer1;

import java.util.*;

class Solution17 {
    //小数解法
    public int[] printNumbers0(int n) {
        int end = (int) Math.pow(10, n) - 1;
        int[] res = new int[end];
        for (int i = 0; i < end; i++) {
            res[i] = i + 1;
        }
        return res;
    }


    //大数解法

    StringBuilder res;
    int count = 0, N;
    int start, nine = 0;

    char[] num, loop = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    public String printNumbers(int n) {
        N = n;
        res = new StringBuilder();
        num = new char[N];

        start = n - 1;

        dfs(0);
        res.deleteCharAt(res.length() - 1);
        return res.toString();
    }

    private void dfs(int x) {
        if (x == N) {
            String s = String.valueOf(num).substring(start);
            if (!s.equals("0")) res.append(s + ",");//跳过0
            if (N - start == nine) start--;
            return;
        }

        for (char i : loop) {
            if (i == '9') nine++;
            num[x] = i;
            dfs(x + 1);
        }
        nine--;
    }
}


class Solution172 {
    //大数解法

    int[] res;//
    int count = 0, N;
    int start, nine = 0;

    char[] num, loop = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    public int[] printNumbers(int n) {
        N = n;
        res = new int[(int) Math.pow(10, n) - 1];//
        num = new char[N];

        start = n - 1;

        dfs(0);

        return res;//
    }

    private void dfs(int x) {
        if (x == N) {
            String s = String.valueOf(num).substring(start);
            if (!s.equals("0")) res[count++] = Integer.parseInt(s);//跳过0
            if (N - start == nine) start--;
            return;
        }

        for (char i : loop) {
            if (i == '9') nine++;
            num[x] = i;
            dfs(x + 1);
        }
        nine--;
    }
}