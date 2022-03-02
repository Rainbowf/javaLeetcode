package offer2;

import java.util.*;

class Solution038 {
    public static void main(String[] args) {
        int[] asteroids = {73,74,75,71,69,72,76,73};
        System.out.println(Arrays.toString(dailyTemperatures(asteroids)));
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prev = stack.pop();
                ans[prev] = i - prev;
            }
            stack.push(i);
        }
        return ans;
    }
}