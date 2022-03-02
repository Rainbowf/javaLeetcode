package offer2;
import java.util.*;

class Solution116 {
    //法一：图搜索（广度、深度均可）
    public int findCircleNum(int[][] isConnected) {
        boolean[] visited = new boolean[isConnected.length];
        int result = 0;
        for (int i = 0; i < isConnected.length; i++) {
            //用visited进行限制
            if (!visited[i]) {
                //核心代码：把该节点所有相连的节点给标记为visited
                findCircle(isConnected, visited, i);
                //那么下一次找的新节点一定不在前面的子图中
                result++;
            }
        }
        return result;
    }

    //广度搜索
    private void findCircle(int[][] isCon, boolean[] vi, int i) {
        Queue<Integer> queue = new LinkedList<>();
        //add与visited 捆绑
        queue.add(i);
        vi[i] = true;
        while (!queue.isEmpty()) {
            int num = queue.remove();
            for (int friend = 0; friend < isCon.length; friend++) {
                if (isCon[num][friend] == 1 & !vi[friend]) {
                    queue.add(friend);
                    vi[friend] = true;
                }
            }
        }
    }
    //法二：并查集
    public int findCircleNum2(int[][] isConnected) {
        int size = isConnected.length;//节点个数
        int[] fathers = new int[size];//存储每个节点指向的根节点，可换为HashMap
        //初始化根节点为自己
        for(int i = 0; i < size; i++){
            fathers[i] = i;
        }

        int cnt = size;//子集个数记录下来
        //遍历，更新,两两比较对角线比较
        for(int i = 0;  i< size; i++){
            for(int j = i+1; j < size; j++){
                //相连接的判断语句 + 能否合并的语句
                if(isConnected[i][j] == 1 && union(fathers, i, j)){
                    cnt--;//合并进一个，子图数就少一个
                }
            }
        }
        return cnt;
    }
    //下面都可以不用变，直接背
    //找到i位置的根节点，递归，终止条件为根节点的根节点必定是自己
    private int findFather(int[] fathers, int i){
        if(fathers[i] != i){
            fathers[i] = findFather(fathers, fathers[i]);
        }
        return fathers[i];
    }
    //判断两个节点能否合并，然后 合并两个节点
    private boolean union(int[] fathers, int i, int j){
        int faOfI = findFather(fathers, i);
        int faOfJ = findFather(fathers, j);
        if(faOfI != faOfJ){
            fathers[faOfI] = faOfJ;
            return true;
        }
        return false;
    }
}