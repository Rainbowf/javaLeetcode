package offer1;

import java.util.*;


class Solution591 {
    //法一：暴力解法 O((n−k+1)·k)≈O(n·k)
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0) return new int[0];
        int[] res = new int[nums.length - k + 1];

        for (int i = 0; i < nums.length - k + 1; i++) {
            int max1 = Integer.MIN_VALUE;
            for (int j = i; j < i + k && j < nums.length; j++) {
                max1 = Math.max(max1, nums[j]);
            }
            res[i] = max1;
        }
        return res;
    }

    //优先队列 时间复杂度：O(n·logn)
    public int[] maxSlidingWindow2(int[] nums, int k) {
        if (nums.length == 0 || k == 0) return new int[0];
        int n = nums.length;
        //最大堆
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] != o2[0] ? o2[0] - o1[0] : o2[1] - o1[1];
            }
        });

        for (int i = 0; i < k; i++) {
            pq.offer(new int[]{nums[i], i});
        }

        int[] ans = new int[n - k + 1];//存放结果数据
        ans[0] = pq.peek()[0];
        for (int i = k; i < n; i++) {
            pq.offer(new int[]{nums[i], i});
            while (pq.peek()[1] <= i - k) {
                pq.poll();
            }
            ans[i - k + 1] = pq.peek()[0];
        }
        return ans;
    }

    // 法二：官方：单调队列
    public int[] maxSlidingWindow3(int[] nums, int k) {
        if (nums.length == 0 || k == 0) return new int[0];
        int n = nums.length;
        //窗口个数
        int[] res = new int[n - k + 1];
        //双端队列，单调队列,整理多种写法！！！
        LinkedList<Integer> queue = new LinkedList<>();
        //Deque<Integer> queue = new ArrayDeque<>();
        //Deque<Integer> deque = new LinkedList<Integer>();


        //遍历数组元素，r表示滑动窗右边界
        //以下合并写法 or 分段写法也可
        for (int r = 0; r < n; r++) {
            while (!queue.isEmpty() && nums[r] >= queue.peekLast()) {
                queue.removeLast();
            }
            queue.addLast(r);//存储下标

            int l = r - k + 1;//左边界
            if(queue.peekFirst() < l){
                queue.removeFirst();
            }
            if(r + 1 >= k){
                res[l] = nums[queue.peekFirst()];
            }
        }
        return res;
    }
    // 法三：官方：分块 + 预处理（稀疏表（Sparse Table））
}