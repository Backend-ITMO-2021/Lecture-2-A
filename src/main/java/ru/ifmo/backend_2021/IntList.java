package ru.ifmo.backend_2021;

import java.util.*;

public class IntList implements Iterable<Integer> {

    private Integer[] list;
    private int size;

    public IntList() {
        this.list = new Integer[0];
    }

    public void add(int number) {
        if (this.size == this.list.length)
            this.list = Arrays.copyOf(this.list, this.size + 1);
        list[this.size] = number;
        this.size++;
    }

    public int get(int index) {
        return this.list[index];
    }

    public int size() {
        return this.size;
    }

    public String toString() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < this.size; i++)
            str.append(" ").append(this.list[i]);
        return str.toString();
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {

            private int iterationIndex = 0;

            @Override
            public boolean hasNext() {
                return iterationIndex < size;
            }

            @Override
            public Integer next() {
                return list[++iterationIndex];
            }
        };
    }
}
