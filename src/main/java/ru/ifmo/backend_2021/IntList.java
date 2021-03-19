package ru.ifmo.backend_2021;

import java.util.Iterator;

public class IntList implements Iterable<Integer> {

    private final int initialCapacity = 10;
    private Integer[] list;
    private int capacity = initialCapacity;
    private int size;
    private int lastIndex = 0;


    public IntList(){
        this.list = new Integer[initialCapacity];
    }

    public void add(int value){
        if (this.size >= this.list.length*0.9f){
            Integer[] oldList = list;
            list = new Integer[capacity*= 1.2f];
            System.arraycopy(oldList, 0, list, 0, oldList.length);
        }
        this.list[++lastIndex] = value;
        this.size++;
    }

    public int size() {
        return this.size;
    }

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
}