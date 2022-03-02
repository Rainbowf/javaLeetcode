package offer1;

import java.util.*;

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */

//不同步法
class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x);
        }
    }

    public void pop() {
        if (stack.pop().equals(minStack.peek())) {//?为什么不能用==
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}

//同步法
class MinStack2 {
    Deque<Integer> xStack;
    Deque<Integer> minStack;

    public MinStack2() {
        xStack = new LinkedList<Integer>();
        minStack = new LinkedList<Integer>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int x) {
        xStack.push(x);
        minStack.push(Math.min(minStack.peek(), x));
    }

    public void pop() {
        xStack.pop();
        minStack.pop();
    }

    public int top() {
        return xStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}

//存差值法
class MinStack3 {
    Deque<Integer> stack;
    int minv;

    public MinStack3() {
        stack = new LinkedList<Integer>();
        minv = Integer.MAX_VALUE;
    }

    public void push(int x) {
        if (stack.isEmpty()) {
            stack.push(0);
            minv = x;
        } else {
            stack.push(x - minv);
            minv = Math.min(minv, x);
        }
    }

    public void pop() {
        int top = stack.pop();
        if (top < 0) {
            minv = minv - top;
        }
    }

    public int top() {
        int top = stack.peek();
        return top >= 0 ? minv + top : minv;
    }

    public int getMin() {
        return minv;
    }
}



