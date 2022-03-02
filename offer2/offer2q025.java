package offer2;

import java.util.*;

class Solution025 {
    //迭代法
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //翻转
        ListNode node1 = reverseList(l1);
        ListNode node2 = reverseList(l2);

        //结果
        ListNode dummy = new ListNode(0);
        ListNode sumNode = dummy;
        int carry = 0;

        //相加
        while (node1 != null || node2 != null) {
            int num1 = (node1 == null) ? 0 : node1.val;
            int num2 = (node2 == null) ? 0 : node2.val;
            int sum = num1 + num2 + carry;
            carry = sum > 9 ? 1 : 0;
            sum = sum > 9 ? sum - 10 : sum;

            ListNode node = new ListNode(sum);
            sumNode.next = node;
            sumNode = node;

            node1 = node1 == null ? null : node1.next;
            node2 = node2 == null ? null : node2.next;
        }

        if (carry > 0) {
            sumNode.next = new ListNode(1);
        }

        ListNode head = reverseList(dummy.next);
        //再翻转
//        dummy.next = null;
        return head;
    }

    //栈
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        Deque<Integer> stack1 = new LinkedList<Integer>();
        Deque<Integer> stack2 = new LinkedList<Integer>();

        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }

        int carry = 0;
        ListNode ans = null;
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {
            int a = stack1.isEmpty() ? 0 : stack1.pop();
            int b = stack2.isEmpty() ? 0 : stack2.pop();
            int cur = a + b + carry;

            carry = cur / 10;
            cur %= 10;

            ListNode curnode = new ListNode(cur);
            curnode.next = ans;
            ans = curnode;
        }
        return ans;
    }
}