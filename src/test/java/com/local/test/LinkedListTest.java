package com.local.test;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class LinkedListTest {

    @Test
    public void reverseTest() {
        LinkedList.Node node4 = new LinkedList.Node(40, null);
        LinkedList.Node node3 = new LinkedList.Node(30, node4);
        LinkedList.Node node2 = new LinkedList.Node(20, node3);
        LinkedList.Node node1 = new LinkedList.Node(10, node2);
        LinkedList.Node node = node1;

        LinkedList.Node reverseNode = LinkedList.reverse(node);

        List ids = new ArrayList<Integer>();
        while (reverseNode != null) {
            ids.add(reverseNode.getId());
            reverseNode = reverseNode.getNext();
        }
        int[] actualList = ids.stream().filter(integer -> integer != null).mapToInt(i -> (int) i).toArray();
        final int[] expectedList = {40, 30, 20, 10};
        Assert.assertArrayEquals(expectedList, actualList);
    }
}