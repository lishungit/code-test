package com.local.test;

public class LinkedListTest {

    public static void main(String[] args) {
        LinkedList.Node node4 = new LinkedList.Node(40, null);
        LinkedList.Node node3 = new LinkedList.Node(30, node4);
        LinkedList.Node node2 = new LinkedList.Node(20, node3);
        LinkedList.Node node1 = new LinkedList.Node(10, node2);

        LinkedList.Node node = node1;

        System.out.println("Reverse before:");
        LinkedList.print(node);
        LinkedList.Node reverseNode = LinkedList.reverse(node);
        System.out.println("Reverse after:");
        LinkedList.print(reverseNode);
    }

}

