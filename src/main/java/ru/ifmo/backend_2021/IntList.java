package ru.ifmo.backend_2021;

import java.util.Arrays;
import java.util.Iterator;

class IntList implements Iterable<Integer> {

    private Integer[] list;
    private int listSize;

    public IntList() {
        this(10);
    }

    public IntList(int size) {
        this.list = new Integer[size];
        this.listSize = 0;
    }

    public int size() {
        return this.listSize;
    }

    public int get(int index) {
        if (index >= this.listSize) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        return this.list[index];
    }

    public void append(int value) {
        if (this.list.length == listSize) {
            this.list = Arrays.copyOf(this.list, this.list.length * 2);
        }
        this.list[listSize] = value;
        listSize++;
    }

    public String toString(){
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < this.listSize; i++){
            str.append(" ").append(this.list[i]);
        }
        return str.toString();
    }

    @Override
    public Iterator<Integer> iterator() {
        Iterator<Integer> it = new Iterator<Integer>() {

            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < listSize;
            }

            @Override
            public Integer next() {
                currentIndex++;
                return list[currentIndex];
            }
        };
        return it;
    }
}