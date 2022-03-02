package offer2;

import java.util.*;

class Solution039 {
    //暴力法
    public int largestRectangleArea1(int[] heights) {
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            int min = heights[i];
            for (int j = i; j < heights.length; j++) {
                min = Math.min(min, heights[j]);
                int area = min * (j - i + 1);
                maxArea = Math.max(area, maxArea);
            }
        }
        return maxArea;
    }

    //递归，分冶
    public int largestRectangleArea2(int[] heights) {
        return helper(heights, 0, heights.length);
    }

    // 左闭右开
    private int helper(int[] heights, int left, int right) {
        if (left == right) return 0;

        if (left + 1 == right) {
            return heights[left];
        }
        //找最小值
        int minIndex = left;
        for (int i = left + 1; i < right; i++) {
            if (heights[i] < heights[minIndex]) {
                minIndex = i;
            }
        }
        //三个面积比较
        int midArea = (right - left) * heights[minIndex];
        int leftArea = helper(heights, left, minIndex);
        int rightArea = helper(heights, minIndex + 1, right);

        midArea = Math.max(midArea, leftArea);
        return Math.max(midArea, rightArea);
    }

    public int largestRectangleArea(int[] heights) {
        //栈
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i]) {
                int height = heights[stack.pop()];
                int width = i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }

        while (stack.peek() != -1) {
            int height = heights[stack.peek()];
            int width = heights.length - stack.peek() - 1;
            maxArea = Math.max(maxArea, height * width);
        }
        return maxArea;
    }
}