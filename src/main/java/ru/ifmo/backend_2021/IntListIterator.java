package ru.ifmo.backend_2021;

import java.util.Iterator;

class IntListIterator implements Iterator {
    private Node node;

    public IntListIterator(Node h) {
        node = h;
    }

    public IntListIterator(IntList l) {
        this(l.getHead());
    }

    public boolean hasNext() {
        if (node == null) {
            return false;
        } else {
            return true;
        }
    }

    public Object next() {
        Integer data = node.data;
        node = node.next;
        return data;
    }

}
