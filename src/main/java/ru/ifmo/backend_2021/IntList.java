package ru.ifmo.backend_2021;

import java.util.*;

class IntList implements Iterable<Integer> {
    private Integer[] list;
    private int size;
    public static final int DEFAULT_CAPACITY = 100;

    public IntList() {
        this(DEFAULT_CAPACITY);
    }

    public IntList(int capacity) {
        if (capacity < 0)
            throw new IllegalArgumentException("negative capacity");
        list = new Integer[capacity];
        size = 0;
    }

    public void add(Integer value) {
        ensureCapacity(this.size + 1);
        list[this.size] = value;
        this.size++;
    }


    public int getSize() {
        return size;
    }

    public String getPos() {
        String result = "";
        for (Integer integer: list) {
            if (integer != null) {
                result += " " + integer;
            }
        }
        return result;
    }

    public void ensureCapacity(int capacity) {
        if (capacity > list.length) {
            int newCapacity = list.length * 2 + 1;
            if (capacity > newCapacity)
                newCapacity = capacity;
            Integer[] newListCap = new Integer[newCapacity];
            for (int i = 0; i < size; i++)
                newListCap[i] = list[i];
            list = newListCap;
        }
    }


    @Override
    public Iterator<Integer> iterator() {
        return new IntListIterator();
    }

    private class IntListIterator implements Iterator<Integer> {

        private int current = 0;

        @Override
        public boolean hasNext() {
            return current != size;
        }

        @Override
        public Integer next() {
            return list[++current];
        }
    }

}
