package offer2;

import java.util.*;

class Solution118 {
    //法二：并查集
    public int[] findRedundantConnection(int[][] edges) {
        //节点个数，需要自己计算
        int size = 0;
        for (int[] edge:edges){
            size = Math.max(size, edge[1]);
        }
        //注意这里是n+1
        int[] fathers = new int[size+1];//存储每个节点指向的根节点，可换为HashMap
        //初始化根节点为自己
        for (int i = 1; i <= size; i++) {
            fathers[i] = i;
        }

        // int cnt = size;//子集个数记录下来
        //遍历，更新,两两比较对角线比较
        for (int[] edge: edges) {

            //相连接的判断语句 + 能否合并的语句
            if (!union(fathers, edge[0], edge[1])) {
                //cnt--;//合并进一个，子图数就少一个
                return edge;
            }
        }
        //return cnt;
        return new int[2];
    }
    //判断相似性
//    private boolean isSimilar(String str1, String str2) {
//        int diffCnt = 0;
//        for (int i = 0; i < str1.length(); i++) {
//            if (str1.charAt(i) != str2.charAt(i)) {
//                diffCnt++;
//            }
//        }
//        return diffCnt <= 2;
//    }

    //下面都可以不用变，直接背
    //找到i位置的根节点，递归，终止条件为根节点的根节点必定是自己
    private int findFather(int[] fathers, int i) {
        if (fathers[i] != i) {
            fathers[i] = findFather(fathers, fathers[i]);
        }
        return fathers[i];
    }

    //判断两个节点能否合并，然后 合并两个节点
    private boolean union(int[] fathers, int i, int j) {
        int faOfI = findFather(fathers, i);
        int faOfJ = findFather(fathers, j);
        if (faOfI != faOfJ) {
            fathers[faOfI] = faOfJ;
            return true;
        }
        return false;
    }

}