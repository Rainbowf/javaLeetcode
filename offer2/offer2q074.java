package offer2;

import java.util.*;

class Solution074 {
    public int[][] merge(int[][] intervals) {
        //先按照起始位置排序
        Arrays.sort(intervals, (i1, i2) -> i1[0] - i2[0]);

        List<int[]> merged = new LinkedList<>();
        //合并
        int i = 0;
        while (i < intervals.length){
            int[] temp = new int[]{intervals[i][0],intervals[i][1]};
            int j = i + 1;
            while ( j < intervals.length && intervals[j][0] <= temp[1]){
                temp[1] = Math.max(temp[1],intervals[j][1]);
                j++;
            }
            //添加
            merged.add(temp);
            //i 断裂处新开始
            i = j;
        }
        //List<> 转成 int[]
        int[][] res = new int[merged.size()][];
        return merged.toArray(res);
    }
}