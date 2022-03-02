//package offer2;
//
//import java.util.*;
//
//
//// Definition for a Node.
//class Node {
//    public int val;
//    public Node prev;
//    public Node next;
//    public Node child;
//};
//
//
//class Solution028 {
//    public Node flatten(Node head) {
//        //递归
//        flattenGetTail(head);
//        return head;
//    }
//
//    private Node flattenGetTail(Node head) {
//        //递归函数入口：当前节点；出口：返回当前节点的最后一个节点；
//        //并且保证next节点之前已经拉平
//        Node node= head;
//        Node tail = null;
//
//        while (node!=null){
//            //预先储存下一个节点
//            Node next = node.next;
//
//            if(node.child!=null){
//                //递归得到子节点的最后一个节点
//                Node child = node.child;
//                Node childTail = flattenGetTail(node.child);
//
//                //子节点去除
//                node.child = null;
//                //与子节点建立双向
//                node.next = child;
//                child.prev = node;
//
//                //尾节点与后面节点建立双向
//                childTail.next = next;
//                //后一节点需要判断是否为空
//                if(next!= null){
//                    next.prev = childTail;
//                }
//                tail = childTail;
//            }else {
//                tail = node;
//            }
//            //下移一个
//            node = next;
//        }
//        return tail;
//    }
//}