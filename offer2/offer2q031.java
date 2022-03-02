/**


package offer2;

import java.util.*;

class ListNode {
    public int key;
    public int value;
    public ListNode next;
    public ListNode prev;

    public ListNode(int k, int v) {
        key = k;
        value = v;
    }
}

class LRUCache {
    //初始化
    private ListNode head;
    private ListNode tail;
    private Map<Integer,ListNode> map;
    int capacity;

    public LRUCache(int cap) {
        map = new HashMap<>();
        head = new ListNode(-1,-1);
        tail = new ListNode(-1,-1);
        head.next = tail;
        tail.prev = head;

        capacity = cap;
    }

    public int get(int key) {
        //先找
        ListNode node = map.get(key);
        //没找到
        if(node == null){
            return -1;
        }
        //找到了，移到最后面，value值不变
        moveToTail(node, node.value);
        return node.value;
    }

    public void put(int key, int value) {
        //先看寻不存在
        if(map.containsKey(key)){
            //存在，移到后面，并且更新
            moveToTail(map.get(key),value);
        }else {
            //不存在，看有没有超容
            if(map.size() == capacity){
                //先把第一个删了，链表中要删除，映射表中也要删除
                ListNode toBeDeleted = head.next;//first

                deleteNode(toBeDeleted);

                map.remove(toBeDeleted.key);
            }
            ListNode node = new ListNode(key,value);
            insertToTail(node);

            map.put(key, node);
        }
    }

    private void moveToTail(ListNode node, int value) {
        //先前面的断链
        deleteNode(node);
        //后面的添加
        node.value = value;
        insertToTail(node);
    }
    private void insertToTail(ListNode node) {
        //两步连接
        tail.prev.next = node;
        node.prev = tail.prev;

        node.next = tail;
        tail.prev = node;
    }

    private void deleteNode(ListNode toBeDeleted) {
        toBeDeleted.prev.next = toBeDeleted.next;
        toBeDeleted.next.prev = toBeDeleted.prev;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

