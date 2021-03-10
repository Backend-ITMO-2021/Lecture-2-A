package ru.ifmo.backend_2021;

import java.util.*;

public class IntList implements Iterable<Integer> {
    private Integer[] list;
    private int size;
    private int pointer;
    private static final int DEFAULT_SIZE = 10;

    public IntList(int size) {
        list = new Integer[size];
        pointer = 0;
    }

    public IntList() {
        this(DEFAULT_SIZE);
    }

    public boolean add(Integer integer) {
        if (pointer == this.list.length) {
            this.list = this.growList();
        }
        list[pointer] = integer;
        pointer++;
        size = list.length;
        return true;
    }

    public Integer get(int index) {
        Objects.checkIndex(index, this.size);
        return this.list[index];
    }

    private Integer[] growList() {
        return Arrays.copyOf(this.list, Math.round(size * 2.5f));
    }

    public int size() {
        return pointer;
    }

    public Spliterator<Integer> spliterator() {
        return Spliterators.spliterator(iterator(), this.size, 0);
    }


    @Override
    public Iterator<Integer> iterator() {
        return new IntIterator();
    }

    private class IntIterator implements Iterator<Integer> {

        private int cursor;

        @Override
        public boolean hasNext() {
            return cursor < IntList.this.size();
        }

        @Override
        public Integer next() {
            Integer value = IntList.this.get(cursor);
            cursor++;
            return value;
        }
    }

}