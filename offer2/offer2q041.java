package offer2;

import java.util.*;

class MovingAverage {

    /** Initialize your data structure here. */
    private Queue<Integer> nums;
    private int capacity;
    private int sum;

    public MovingAverage(int size) {
        nums = new LinkedList<>();
        capacity = size;
    }

    public double next(int val) {
        nums.offer(val);

        sum+=val;

        if (nums.size()>capacity){
            sum -= nums.poll();
        }
        return (double) sum / nums.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */