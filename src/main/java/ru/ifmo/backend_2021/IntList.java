package ru.ifmo.backend_2021;

import java.util.*;

class IntList implements Iterable<Integer> {
    private Integer[] list;
    private int size;

    public IntList(int size) {
        this.list = new Integer[size];
        this.size = size;
    }

    public IntList() {
        this.list = new Integer[50];
    }

    public boolean add(Integer value) {
        if (this.list.length == this.size) {
            Integer[] copyList;
            copyList = this.list;
            this.list = new Integer[this.size*2];
            this.list = copyList;
        }
        list[this.size] = value;
        this.size++;
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
