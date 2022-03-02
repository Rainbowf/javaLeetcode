package offer2;

import java.util.*;

class RecentCounter {
    private Queue<Integer> times;
    private int windowSize;

    public RecentCounter() {
        times = new LinkedList<>();
        windowSize = 3000;
    }

    public int ping(int t) {
        times.offer(t);
        while (times.peek() + windowSize < t){
            times.poll();
        }
        return times.size();
    }
}
