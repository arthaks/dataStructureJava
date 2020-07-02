package org.arthaks.link;

public class Node {

    int data;
    Node next;

    public Node(int data) {
        this.data = data;
    }




    // 判断链表中是否有环，两个指针，同时开始， 一个快， 一个慢，如果相遇则有环，否则没有环
    public static boolean hasCycle(Node head){

        Node slowerPoint = head;
        Node fasterPoint = head;

        while (fasterPoint != null && fasterPoint.next != null){
            slowerPoint = slowerPoint.next;
            fasterPoint = fasterPoint.next.next;
            if(slowerPoint == fasterPoint){
                return true;
            }
        }

        return false;
    }


    public static void main(String[] args) {
        Node node1 = new Node(3);
        Node node2 = new Node(2);
        Node node3 = new Node(0);
        Node node4 = new Node(-4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;

        boolean b = hasCycle(node1);
        System.out.println(b);
    }

}


