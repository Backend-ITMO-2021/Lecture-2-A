package ru.ifmo.backend_2021;

import java.util.Iterator;

public class IntList implements Iterable<Integer> {
    private final int initialCapacity = 16;
    private final float maxOccupancy = 0.75f;
    private final float increaseFactor = 1.5f;
    private int capacity = initialCapacity;
    private int lastIndex = 0;
    private Integer[] list = new Integer[initialCapacity];
    private int size = 0;

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<>() {
            private int index = 0;
            @Override
            public boolean hasNext() {
                return index != lastIndex;
            }

            @Override
            public Integer next() {
                return list[++index];
            }
        };
    }

    public int size() {
        return size;
    }

    public void add(int value){
        if (size >= capacity * maxOccupancy){
            capacity *= increaseFactor;
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
