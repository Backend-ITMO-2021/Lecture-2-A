package ru.ifmo.backend_2021;

import java.util.Iterator;

public class IntList implements Iterable<Integer> {
    private Node head;

    public IntList() {
        head = null;
    }

    public IntList(Node n) {
        head = n;
    }

    public void add(Node n) {
        if (head == null) {
            head = n;
        } else {
            Node node = head;
            while (node.next != null) {
                node = node.next;
            }
            node.next = n;
        }
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node n) {
        n.next = head.next;
        head = n;
    }

    public Iterator iterator() {
        return new IntListIterator(head);
    }

}
