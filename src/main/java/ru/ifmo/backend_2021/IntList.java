package ru.ifmo.backend_2021;

import java.util.Iterator;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class IntList implements Iterable<Integer> {

    Node head = new Node();
    Node tail = new Node();

    static class Node {

        int data;
        Node next;
        Node prev;

        Node(int d) {
            data = d;
            next = null;
            prev = null;
        }

        Node() {
            data = 0;
            next = null;
            prev = null;
        }
    }

    public IntList() {
        head.next = tail;
        tail.prev = head;
        insert(-1);
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<>() {

            private Node current = head;

            @Override
            public boolean hasNext() {
                return current.next != null;
            }

            @Override
            public Integer next() throws IndexOutOfBoundsException {
                if (!hasNext()) throw new IndexOutOfBoundsException("End of list.");
                current = current.next;
                return current.data;
            }
        };
    }

    public void insert(int data) {
        var newNode = new Node(data);

        if (tail.prev == head) {
            tail.prev = newNode;
            head.next = newNode;
        } else {
            var current = tail.prev;
            current.next = newNode;
            newNode.prev = current;
            tail.prev = newNode;
        }

        head.next.data++;
    }

    @Override
    public String toString() {
        return StreamSupport.stream(spliterator(), false).map(Object::toString)
                .collect(Collectors.joining(" "));
    }
}