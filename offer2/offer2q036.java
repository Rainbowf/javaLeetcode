package offer2;

import java.util.*;

class Solution036 {
    public int evalRPN(String[] tokens) {
        //创建栈
        Stack<Integer> stack = new Stack<Integer>();
        //依次入栈
        for (String token : tokens) {
            switch (token) {
                case "+":
                case "-":
                case "*":
                case "/":
                    int num1 = stack.pop();
                    int num2 = stack.pop();
                    stack.push(calculate(num1, num2, token));
                    break;
                default:
                    stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    private int calculate(int num1, int num2, String operater) {
        switch (operater) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                return num2 / num1;
            default:
                return 0;
        }
    }
}