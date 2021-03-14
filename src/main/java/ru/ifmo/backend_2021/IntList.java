package ru.ifmo.backend_2021;

import java.util.Arrays;
import java.util.Iterator;

public class IntList implements Iterable<Integer> {
    private Integer[] values;
    private int size = 0;

    public IntList() {
        this.values = new Integer[0];
    }

    public boolean add(Integer integer) {
        if (this.size == this.values.length) {
            this.values = this.increase();
        }

        this.values[this.size] = integer;
        this.size++;
        return true;
    }

    public Integer get(int index) {
        if (index > this.size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return this.values[index];
    }

    private Integer[] increase() {
        return Arrays.copyOf(this.values, this.size + 1);
    }

    public int size(){
        return this.size;
    }

    @Override
    public String toString() {
        return Arrays.toString(values);
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<>() {
            private int cursor;

            @Override
            public boolean hasNext() {
                return cursor < IntList.this.size;
            }

            @Override

            public Integer next() {
                Integer value = IntList.this.get(cursor);
                cursor++;
                return value;
            }
        };
    }
}
