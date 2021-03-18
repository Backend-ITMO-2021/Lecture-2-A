package ru.ifmo.backend_2021;

import java.util.Iterator;

public class IntList implements Iterable<Integer> {
    private final int iCapacity = 16;
    private final float maxO = 0.75f;
    private final float iFactor = 1.5f;
    private int capacity = iCapacity;
    private int lastIndex = 0;
    private Integer[] list = new Integer[iCapacity];
    private int size = 0;

    public Iterator<Integer> iterator() {
        return new Iterator<>() {
            private int index = 0;
            public boolean hasNext() {

                return index != lastIndex;
            }

            public Integer next() {

                return list[++index];
            }
        };
    }

    public int size() {

        return size;
    }

    public void add(int value){
        if (size >= capacity * maxO){
            capacity *= iFactor;
            Integer[] oldList = list;
            list = new Integer[capacity];
            System.arraycopy(oldList, 0, list, 0, oldList.length);
        }
        list[++lastIndex] = value;
        size++;
    }

    public Integer getLast(){
        return list[lastIndex];
    }
}