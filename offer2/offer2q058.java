package offer2;

import java.util.*;


class MyCalendar {
    private TreeMap<Integer, Integer> events;

    public MyCalendar() {
        events = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        //前面一个
        Map.Entry<Integer, Integer> event = events.floorEntry(start);
        if (event != null && event.getValue() > start) {
            return false;
        }
        //后面一个
        event = events.ceilingEntry(start);
        if (event != null && event.getKey() < end) {
            return false;
        }
        //都没有，那就存进去，并且返回
        events.put(start, end);
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */