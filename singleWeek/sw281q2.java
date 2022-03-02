package singleWeek;

import java.util.*;

class Solutionsw281q2 {
    public static void main(String[] args) {

//        System.out.println(mergeNodes());
    }

    public static ListNode mergeNodes(ListNode head) {
        ListNode newHead = null;
        ListNode prev = null;
        ListNode cur = head;

        boolean first = true;
        boolean newFlag = true;
        int sum = 0;
        while (cur != null) {
            if (cur.val != 0) {
                sum += cur.val;
            } else if (!first) {
                ListNode newNode = new ListNode(sum);
                sum = 0;
                if (newFlag) {
                    newHead = newNode;
                    prev = newNode;
                    newFlag = false;
                } else {
                    prev.next = newNode;
                    prev = newNode;
                }
            }

            cur = cur.next;
            first = false;
        }
        return newHead;
    }
}