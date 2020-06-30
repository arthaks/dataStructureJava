package org.arthaks.link;

public class IntLinkList {

    private Node head;

    private Node last;

    private int size;

    public Node remove(int index) {
        if (index < 0 || index >= size) {
            throw new RuntimeException("索引超限了老铁");
        }

        Node removeNode = null;
        if (index == 0) {
            // 头节点指向next即可, 删除头节点
            removeNode = head;
            head = head.next;
        } else if (index == size - 1) {
            // 删除末尾节点
            removeNode = last;
            Node preNode = get(index - 1);
            preNode.next = null;
            last = preNode;
        } else {
            // 删除中间节点
            Node preNode = get(index - 1);
            removeNode = preNode.next;
            preNode.next = preNode.next.next;
        }

        size--;
        return removeNode;
    }


    public void insert(int index, int data) {

        if (index < 0 || index > size) {
            throw new RuntimeException("索引超限了老铁");
        }

        Node newNode = new Node(data);
        if (size == 0) {
            // 链表为null, 设置为头节点、尾节点
            head = newNode;
            last = newNode;
        } else if (index == 0) {
            // 链表不为null， 且在头插入
            newNode.next = head;
            head = newNode;
        } else if (index == size) {
            // 链表不为null， 且在尾插入
            last.next = newNode;
            last = newNode;
        } else {
            // 链表不为null， 且在中间插入
            Node preNode = get(index - 1);
            newNode.next = preNode.next;
            preNode.next = newNode;
        }
        size++;
    }


    public Node get(int index) {

        if (index < 0 || index >= size) {
            throw new RuntimeException("索引超限了老铁");
        }

        Node tempNode = head;
        for (int i = 0; i < index; i++) {
            tempNode = tempNode.next;
        }
        return tempNode;
    }

    public void printAllNode(){
        Node tempNode = head;
        int index = 0;
        while (tempNode != null){
            System.out.println("链表索引 = " + index + " 链表data = " + tempNode.data);
            tempNode = tempNode.next;
            index++;
        }
    }


    public static void main(String[] args) {
        IntLinkList intLinkList = new IntLinkList();

        intLinkList.insert(0, 0);
        intLinkList.insert(1, 100);
        intLinkList.insert(2, 200);
        intLinkList.insert(3, 300);
        intLinkList.insert(4, 400);
        intLinkList.insert(5, 500);
        intLinkList.insert(6, 600);

        intLinkList.printAllNode();
//        链表索引 = 0 链表data = 0
//        链表索引 = 1 链表data = 100
//        链表索引 = 2 链表data = 200
//        链表索引 = 3 链表data = 300
//        链表索引 = 4 链表data = 400
//        链表索引 = 5 链表data = 500
//        链表索引 = 6 链表data = 600

        System.out.println(intLinkList.size);
//        7

        System.out.println(intLinkList.get(3).data);
//        300

        intLinkList.remove(3);

        intLinkList.printAllNode();
//        链表索引 = 0 链表data = 0
//        链表索引 = 1 链表data = 100
//        链表索引 = 2 链表data = 200
//        链表索引 = 3 链表data = 400
//        链表索引 = 4 链表data = 500
//        链表索引 = 5 链表data = 600

        System.out.println(intLinkList.get(3).data);
//        400

    }


}
