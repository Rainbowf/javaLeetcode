package offer2;

import java.util.*;

class Solution026 {
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

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        //对半分，快慢双指针
        ListNode slow = head;
        ListNode fast = slow.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }
        }
        //拆开
        ListNode secList = slow.next;
        slow.next = null;
        //拼接
        secList = reverseList(secList);
        ListNode firList = head;

        while (firList != null && secList!=null){
            ListNode next1 = firList.next;
            ListNode next2 = secList.next;

            firList.next = secList;
            secList.next = next1;

            firList = next1;
            secList = next2;
        }
    }
}
//转成线性表 再处理
class Solution0262 {
    public void reorderList(ListNode head) {

        if (head == null) {
            return;
        }
        //存放线性表
        List<ListNode> list = new ArrayList<ListNode>();
        ListNode node = head;
        while (node != null) {
            list.add(node);
            node = node.next;
        }
        //双指针，头尾
        int i = 0, j = list.size() - 1;
        while (i < j) {
            list.get(i).next = list.get(j);
            i++;
            //相碰
            if (i == j) {
                break;
            }
            list.get(j).next = list.get(i);
            j--;
        }
        //尾节点为null
        list.get(i).next = null;
    }
}