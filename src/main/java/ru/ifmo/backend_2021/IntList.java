package ru.ifmo.backend_2021;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class IntList  implements Iterable<Integer> {
    private Integer[] values;

    public IntList() {
        values = new Integer[0];
    }

    public boolean add(Integer newValue) {
        Integer[] temp = values;
        values = new Integer[temp.length + 1];
        System.arraycopy(temp, 0, values, 0, temp.length);
        values[temp.length] = newValue;
        return true;
    }

    public int size() {
        return values.length;
    }

    public StringBuilder toSB() {
        StringBuilder result = new StringBuilder();
        for (int val: values) {
            result.append(" ").append(val);
        }
        return result;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < values.length;
            }

            @Override
            public Integer next() throws NoSuchElementException {
                if (index == values.length) throw new NoSuchElementException("There are no more items in the list!");
                return values[index++];
            }
        };
    }
}
