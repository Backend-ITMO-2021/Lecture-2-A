package ru.ifmo.backend_2021;

import java.util.*;

public class IntList implements Iterable<Integer> {
    private Integer[] list;
    private int lastElemIndex;
    private static final int DEFAULT_MAX_SIZE = 1;

    public IntList(int maxSize) {
        list = new Integer[maxSize];
        lastElemIndex = 0;
    }

    public IntList() {
        this(DEFAULT_MAX_SIZE);
    }

    public int size() {
        return lastElemIndex;
    }

    public void add(int value) {
        if (lastElemIndex == this.list.length) {
            this.list = Arrays.copyOf(this.list, this.list.length * 2);
        }
        list[lastElemIndex] = value;
        lastElemIndex++;
    }

    public Integer get(int index) {
        if (index >= this.list.length) throw new ArrayIndexOutOfBoundsException();
        return this.list[index];
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < IntList.this.size();
            }

            @Override
            public Integer next() {
                Integer value = IntList.this.get(index);
                index++;
                return value;
            }
        };
    }
}