package offer2;

import java.util.*;

class Solution057 {
    //TreeSet O(n·logk)
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            Long lower = set.floor((long) nums[i]);
            if (lower != null && lower >= (long) nums[i] - t) {
                return true;
            }

            Long upper = set.ceiling((long) nums[i]);
            if (upper != null && upper <= (long) nums[i] + t) {
                return true;
            }

            set.add((long) nums[i]);
            if (i >= k) {
                set.remove((long) nums[i - k]);
            }
        }
        return false;
    }

    //O(n)分桶
    public boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t) {
        Map<Integer, Integer> buckets = new HashMap<>();

        int bucketSize = t + 1;//桶内可存放数据个数
        for (int i = 0; i < nums.length; i++) {
            //获取桶编号
            int num = nums[i];
            int id = getBucketID(num, bucketSize);
            //判断前后是否存在
            if (buckets.containsKey(id)
                    || (buckets.containsKey(id - 1) && buckets.get(id - 1) + t >= num)
                    || (buckets.containsKey(id + 1) && buckets.get(id + 1) - t <= num)) {
                return true;
            }
            //都不存在就创建一个
            buckets.put(id, num);
            //把没用的删了
            if (i >= k) {
                buckets.remove(getBucketID(nums[i - k], bucketSize));
            }
        }
        return false;
    }

    private int getBucketID(int num, int bucketSize) {
        return num >= 0 ? num / bucketSize : (num + 1) / bucketSize - 1;
    }
}
