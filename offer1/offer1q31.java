package offer1;

import java.util.*;

class Solution31 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        for(int num : pushed){
            stack.push(num);//num入栈
            while (!stack.isEmpty() && stack.peek() == popped[i]){
                stack.pop();
                i++;
            }
        }
        return stack.isEmpty();
    }

    public boolean validateStackSequences2(int[] pushed, int[] popped) {
        int len = pushed.length;
        if (len == 0) return true;
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            map.put(pushed[i], i);
        }
        int k = 0;
        for (int i = 0; i < len; i++) {
            stack.push(pushed[k]);
            while (!stack.isEmpty() && stack.peek() != popped[i]) {
                if (k < len) {
                    stack.push(pushed[++k]);
                } else return false;

            }
            stack.pop();
            k++;
        }
        return true;
    }
}