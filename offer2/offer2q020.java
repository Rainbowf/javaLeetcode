package offer2;

import java.util.*;

class Solution020 {

    //中心扩展法
    public int countSubstrings(String s) {
        //base case
        if (s == null && s.length() == 0) {
            return 0;
        }
        //result
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            count += countPalindrome(s, i, i);        //奇数
            count += countPalindrome(s, i, i + 1);//偶数
        }
        return count;
    }

    private int countPalindrome(String s, int left, int right) {
        int count = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
            count++;
        }
        return count;
    }
}

//马拉车算法 Manacher 算法
class Solution0202 {
    public int countSubstrings(String s) {
        int n = s.length();
        StringBuffer t = new StringBuffer("$#");
        for (int i = 0; i < n; ++i) {
            t.append(s.charAt(i));
            t.append('#');
        }
        n = t.length();
        t.append('!');

        int[] f = new int[n];
        int iMax = 0, rMax = 0, ans = 0;
        for (int i = 1; i < n; ++i) {
            // 初始化 f[i]
            f[i] = i <= rMax ? Math.min(rMax - i + 1, f[2 * iMax - i]) : 1;
            // 中心拓展
            while (t.charAt(i + f[i]) == t.charAt(i - f[i])) {
                ++f[i];
            }
            // 动态维护 iMax 和 rMax
            if (i + f[i] - 1 > rMax) {
                iMax = i;
                rMax = i + f[i] - 1;
            }
            // 统计答案, 当前贡献为 (f[i] - 1) / 2 上取整
            ans += f[i] / 2;
        }

        return ans;
    }
}

//作者：LeetCode-Solution
//链接：https://leetcode-cn.com/problems/a7VOhD/solution/hui-wen-zi-zi-fu-chuan-de-ge-shu-by-leet-ejfv/
//来源：力扣（LeetCode）
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。