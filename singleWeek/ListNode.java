package singleWeek;

//Definition for singly-linked list.
public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    //判断null法
    public ListNode append0(ListNode head, int value) {
        ListNode newNode = new ListNode(value);
        if (head == null) return newNode;

        ListNode node = head;
        while (node.next != null) {
            node = node.next;
        }
        node.next = newNode;
        return head;
    }

    //哑结点法（哨兵节点）
    public ListNode append(ListNode head, int value) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode newNode = new ListNode(value);

        ListNode node = dummy;
        while (node.next != null) {
            node = node.next;
        }
        node.next = newNode;
        return head;
    }

    //删除
    public ListNode delete0(ListNode head, int value) {
        if (head == null) return head;

        if (head.val == value) {
            return head.next;
        }

        ListNode node = head;
        while (node.next != null) {
            if (node.next.val == value) {
                node.next = node.next.next;
                break;
            }
            node = node.next;//传递
        }
        return head;
    }

    //哑结点（哨兵节点）
    public ListNode delete(ListNode head, int value) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode node = dummy;
        while (node.next != null) {
            if (node.next.val == value) {
                node.next = node.next.next;
                break;
            }
            node = node.next;//传递
        }
        return dummy.next;
    }
}