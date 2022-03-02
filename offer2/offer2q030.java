package offer2;

import com.sun.xml.internal.bind.v2.runtime.reflect.Lister;

import java.util.*;

class RandomizedSet {

    /**
     * Initialize your data structure here.
     */
    HashMap<Integer, Integer> numToIndex;   //存储数据所在位置
    ArrayList<Integer> nums;                //存储数据

    public RandomizedSet() {
        numToIndex = new HashMap<>();
        nums = new ArrayList<>();           //动态数组，用i索引
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (numToIndex.containsKey(val)) {
            return false;
        }

        numToIndex.put(val, nums.size());   //存到最后一个位置
        nums.add(val);
        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (!numToIndex.containsKey(val)) {
            return false;
        }

        int loc = numToIndex.get(val);
        int lastNum = nums.get(nums.size() - 1);

        nums.set(loc, lastNum);
        nums.remove(nums.size() - 1);

        numToIndex.put(lastNum, loc);
        numToIndex.remove(val);
        return true;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        Random random = new Random();
        int r = random.nextInt(nums.size());
        return nums.get(r);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */