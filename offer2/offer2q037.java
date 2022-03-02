package offer2;

import java.util.*;

class Solution037 {
    public static void main(String[] args) {
        int[] asteroids = {5, 10, -5};
        System.out.println(Arrays.toString(asteroidCollision(asteroids)));
    }

    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int num : asteroids) {
            while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < -num) {
                stack.pop();
            }
            if (!stack.isEmpty() && num < 0 && stack.peek() == -num) {
                stack.pop();
            } else if (num > 0 || stack.isEmpty() || stack.peek() < 0) {
                stack.push(num);
            }
        }
        return stack.stream().
                mapToInt(i -> i).
                toArray();
    }

    public static int[] asteroidCollision1(int[] asteroids) {

        Stack<Integer> stack = new Stack<>();

        for (int num : asteroids) {
            if (num > 0) {
                stack.push(num);
                continue;
            } else if (!stack.isEmpty()) {
                int prev = stack.peek();
                if (prev + num > 0) {
                    continue;
                } else if (prev + num == 0) {
                    stack.pop();
                    continue;
                } else if (prev < 0) {
                    stack.push(num);
                    continue;
                }
                while (!stack.isEmpty()) {

                }
            } else {
                stack.push(num);
            }
        }
        return stack.stream().
                mapToInt(i -> i).
                toArray();
    }
}