package ru.ifmo.backend_2021;

import java.util.Iterator;
import java.util.Arrays;

public class IntList implements Iterable<Integer> {
    private int size = 0;
    private int capacity = 10;
    private int lastIndex = 0;
    private Integer[] list = new Integer[capacity];

    public int size() {
        return size;
    }

    public void add(Integer num) {
        if (size == list.length) {
            list = Arrays.copyOf(list, list.length * 2);
        }
        list[size++] = num;
    }

    public Integer get(Integer index) {
        return list[index];
    }

    public Integer getLast() {
        return list[lastIndex];
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < this.size; i++)
            output.append(" ").append(this.list[i]);
        return output.toString();
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            private int index;

            @Override
            public Integer next() {
                return list[++index];
            }

            @Override
            public boolean hasNext() {
                return index != lastIndex;
            }
        };
    }
}