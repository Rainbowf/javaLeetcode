package offer2;

import java.util.*;


// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};


class Solution029 {
    public Node insert(Node head, int insertVal) {
        //创建新节点
        Node node = new Node(insertVal);
        //case1
        if (head == null) {
            head = node;
            node.next = node;
        } else if (head.next == null) {
            //case2
            head.next = node;
            node.next = head;
        } else {
            insertCore(head, node);
        }
        return head;
    }

    private void insertCore(Node head, Node node) {
        Node cur = head;
        Node next = cur.next;
        Node biggest = head;
        //只转一圈
        while (!(cur.val <= node.val && next.val >= node.val) && next != head) {
            cur = next;
            next = next.next;
            if(cur.val >= biggest.val){
                biggest = cur;
            }
        }
        if (cur.val <= node.val && next.val >= node.val){
            cur.next = node;
            node.next = next;
        }else {
            node.next = biggest.next;
            biggest.next = node;
        }
    }
}