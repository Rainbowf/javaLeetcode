package offer1;

import java.util.*;


class Solution06 {
    // 辅助栈，先入后出
    public int[] reversePrint(ListNode head) {
        if (head == null) return new int[0];
        ListNode cur = head;
        Stack<Integer> stack = new Stack<>();

        while (cur != null) {
            stack.push(cur.val);
            cur = cur.next;
        }
        int len = stack.size();
        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            ans[i] = stack.pop();
        }
        return ans;
    }

    //递归
    ArrayList<Integer> ans = new ArrayList<>();

    public int[] reversePrint2(ListNode head) {
        helper(head);
        int res[] = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }
        return res;
    }

    private void helper(ListNode head) {
        if (head == null) return;
        helper(head.next);
        ans.add(head.val);
    }
}