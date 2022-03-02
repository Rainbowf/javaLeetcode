package offer2;

import java.util.*;

class Solution119 {
    public int longestConsecutive(int[] nums) {
        //法二：并查集
        int size = nums.length;//节点个数
        Map<Integer, Integer> fathers = new HashMap<>();//存储每个节点指向的根节点
        Map<Integer, Integer> counts = new HashMap<>();//记录每个子集（根节点为key）的个数
        Set<Integer> all = new HashSet<>();//存放所有数，用于判断前后1位的数是否存在其中
        //初始化根节点为自己,每个子集数量为1,时间：O(n)，空间：O(n)
        for (int num : nums) {
            fathers.put(num, num);
            counts.put(num, 1);
            all.add(num);
        }

        //遍历，更新,两两比较对角线比较
        for (int num : nums) {
            if (all.contains(num - 1)) {
                union(fathers, counts, num, num - 1);
            }
            if (all.contains(num + 1)) {
                union(fathers, counts, num, num + 1);
            }
        }
        int longest = 0;
        for (int length : counts.values()) {
            longest = Math.max(length, longest);
        }
        return longest;
    }

    //下面都可以不用变，直接背
    //找到i位置的根节点，递归，终止条件为根节点的根节点必定是自己
    private int findFather(Map<Integer, Integer> fathers, int i) {
        if (fathers.get(i) != i) {
            fathers.put(i, findFather(fathers, fathers.get(i)));
        }
        return fathers.get(i);
    }

    //判断两个节点能否合并，然后 合并两个节点
    private void union(Map<Integer, Integer> fathers, Map<Integer, Integer> counts, int i, int j) {
        int faOfI = findFather(fathers, i);
        int faOfJ = findFather(fathers, j);
        if (faOfI != faOfJ) {
            fathers.put(faOfI, faOfJ);
            counts.put(faOfJ, counts.get(faOfI) + counts.get(faOfJ));
        }
    }
}