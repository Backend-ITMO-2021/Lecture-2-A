package ru.ifmo.backend_2021;

import java.util.*;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;


public class IntList implements Iterable<Integer>{
    private Integer[] elements;
    private int quantity;
    private static final int DEFAULT_CAPACITY = 10;


    public IntList(){
        this.elements = new Integer[DEFAULT_CAPACITY];
    }

    public void add (Integer integer){
        if(this.quantity == this.elements.length)
            this.elements = Arrays.copyOf(this.elements, (this.quantity)*2);

        this.elements[this.quantity] = integer;
        this.quantity++;
    }

    public Integer getEl (int index){
        return this.elements[index];
    }

    public int size(){
        return this.quantity;
    }

    public Spliterator<Integer> spliterator(){
        return Spliterators.spliterator(iterator(), this.size(), 0);
    }

    public Stream<Integer> stream() {
        return StreamSupport.stream(this.spliterator(), false);
    }


    @Override
    public Iterator<Integer> iterator() {
        return new IntIterator();
    }

    private class IntIterator implements Iterator<Integer>{
        private int cursor;

        @Override
        public boolean hasNext(){
            return cursor < IntList.this.quantity;
        }

        @Override
        public Integer next() {
            Integer value = IntList.this.getEl(cursor);
            cursor++;
            return value;
        }
    }

}
