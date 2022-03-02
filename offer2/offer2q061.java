package offer2;

import java.util.*;

class Solution061 {
    //最大堆思路，简单却耗时
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        //创建最大堆
        Queue<int[]> maxHeap = new PriorityQueue<>((p1, p2) -> p2[0] + p2[1] - p1[0] - p1[1]);
        //两层嵌套，注意只需要前k个
        for (int i = 0; i < Math.min(k, nums1.length); ++i) {
            for (int j = 0; j < Math.min(k, nums2.length); ++j) {
                //分两种情况
                if (maxHeap.size() < k) {
                    maxHeap.offer(new int[]{nums1[i], nums2[j]});
                } else {
                    int[] root = maxHeap.peek();
                    if (root[0] + root[1] > nums1[i] + nums2[j]) {
                        maxHeap.poll();
                        maxHeap.offer(new int[]{nums1[i], nums2[j]});
                    }
                }
            }
        }
        //结果输出
        List<List<Integer>> result = new LinkedList<>();
        while (!maxHeap.isEmpty()) {
            int[] vals = maxHeap.poll();
            result.add(Arrays.asList(vals[0], vals[1]));
        }
        return result;
    }

    //最小堆思路，复杂但省时间
    public List<List<Integer>> kSmallestPairs2(int[] nums1, int[] nums2, int k) {
        //创建最小堆
        Queue<int[]> minHeap = new PriorityQueue<>(
                (p1, p2) -> nums1[p1[0]] + nums2[p1[1]] - nums1[p2[0]] - nums2[p2[1]]);

        //创建k个
        if (nums2.length > 0) {
            for (int i = 0; i < Math.min(k, nums1.length); ++i) {
                minHeap.offer(new int[]{i, 0});
            }
        }

        List<List<Integer>> result = new LinkedList<>();
        //比较k次
        while (k-- > 0 && !minHeap.isEmpty()) {
            int[] ids = minHeap.poll();
            result.add(Arrays.asList(nums1[ids[0]], nums2[ids[1]]));

            if (ids[1] < nums2.length - 1) {
                minHeap.offer(new int[]{ids[0], ids[1] + 1});
            }
        }
        return result;
    }
}