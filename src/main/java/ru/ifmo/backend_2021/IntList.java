package ru.ifmo.backend_2021;

import java.util.Iterator;

public class IntList implements Iterable<Integer> {

    private int[] values = new int[1];
    private int size = 0;

    public void add(int value) {
        if (size == values.length) {
            int[] newValues = new int[values.length * 2];

            System.arraycopy(values, 0, newValues, 0, size);
            values = newValues;
        }

        values[size] = value;
        size++;
    }

    public int size() {
        return size;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<>() {

            int i = 0;

            @Override
            public boolean hasNext() {
                return i < size;
            }

            @Override
            public Integer next() {
                i++;

                return values[i - 1];
            }
        };
    }
}
