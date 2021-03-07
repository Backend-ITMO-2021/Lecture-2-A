package ru.ifmo.backend_2021;

import java.util.*;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class IntList implements Iterable<Integer> {
    private Integer[] elements;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public IntList() {
        this.elements = new Integer[DEFAULT_CAPACITY];
    }

    public boolean add(Integer integer) {
        if (this.size == this.elements.length) {
            this.elements = this.grow();
        }

        elements[this.size] = integer;
        this.size++;
        return true;
    }

    public Integer get(int index) {
        Objects.checkIndex(index, this.size);
        return this.elements[index];
    }

    private Integer[] grow() {
        return Arrays.copyOf(this.elements, this.newCapacity(this.size + 1));
    }

    private int newCapacity(int minCapacity) {
        return minCapacity * 2;
    }

    public int size(){
        return this.size;
    }

    public Spliterator<Integer> spliterator() {
        return Spliterators.spliterator(iterator(), this.size, 0);
    }

    public Stream<Integer> stream() {
        return StreamSupport.stream(this.spliterator(), false);
    }


    @Override
    public Iterator<Integer> iterator() {
        return new IntIterator();
    }

    private class IntIterator implements Iterator<Integer> {

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
    }

}
