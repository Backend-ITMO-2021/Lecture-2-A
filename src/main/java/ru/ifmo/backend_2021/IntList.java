package ru.ifmo.backend_2021;

import java.util.*;

class IntList implements Iterable<Integer> {
    private Integer[] list;
    private int size;
    public static int capacity = 20;


    public IntList() {
        this(capacity);
    }

    public IntList(int capacity) {
        this.list = new Integer[capacity];
        this.size = 0;
    }

    public boolean add(int value) {
        if (this.size == this.list.length) {
            this.list = Arrays.copyOf(this.list, this.list.length * 2);
        }
        list[this.size] = value;
        this.size += 1;
        return true;
    }

    public int get(int index) {
        return this.list[index];
    }


    public int size() {
        return this.size;
    }


    @Override
    public Iterator<Integer> iterator() {
        return new IntListIterator();
    }

    private class IntListIterator implements Iterator<Integer> {

        private int current = 0;

        @Override
        public boolean hasNext() {
            return current < IntList.this.size;
        }

        @Override
        public Integer next() {
            current++;
            return IntList.this.get(current-1);
        }
    }

}
