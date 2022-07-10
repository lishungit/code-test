package com.local.test;

public class LinkedList {

    public static class Node {
        private int id;
        private Node next;

        public Node(int id, Node next){
            this.id = id;
            this.next = next;
        }
    }

    public static Node reverse(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node pre = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return pre;
    }

    public static void print(Node node){
        while (node != null) {
            System.out.print(node.id);
            node = node.next;
            if (node != null) {
                System.out.print("->");
            } else {
                System.out.println();
            }
        }
    }

}
