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

    public boolean add(Integer value) {
        if (capacity <= this.size) {
            capacity *= 2;
            Integer[] copyList = new Integer[capacity];
            for (int i = 0; i < this.list.length; i++)
                copyList[i] = this.list[i];
            this.list = copyList;
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
