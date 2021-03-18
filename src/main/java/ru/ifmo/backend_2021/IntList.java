package ru.ifmo.backend_2021;
import java.util.*;

public class IntList implements Iterable<Integer> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Integer[] items;

    public IntList() {
        items = new Integer[DEFAULT_CAPACITY];
    }

    public void add(Integer num) {
        if (size == items.length) {
            enlargeCapacity();
        }
        items[size++] = num;
    }

    public Integer get(Integer index) {
        if (index >= size || index < 0) {
            throw  new IndexOutOfBoundsException("You're trying to get element with index" + index + "but size of list is" + size);
        }
        return this.items[index];
    }

    public int size() {
        return size;
    }

    public void remove(Integer index) {
        if (index >= size || index < 0) {
            throw  new IndexOutOfBoundsException("You're trying to get element with index" + index + "but size of list is" + size);
        }
        int numOfElem = items.length - (index + 1);
        System.arraycopy(items, index + 1, items, index, numOfElem);
        size--;
    }

    private void enlargeCapacity() {
        int newSize = items.length*2;
        items = Arrays.copyOf(items, newSize);
    }

    @Override
    public String toString() 
    {
         StringBuilder sb = new StringBuilder();
         sb.append(" ");
         for(int i = 0; i < size ;i++) {
             sb.append(items[i].toString());
             if(i<size-1){
                 sb.append(" ");
             }
         }
         return sb.toString();
    }

    @Override
    public  Iterator<Integer> iterator() {
        return new IntIterator();
    }


    private class IntIterator implements Iterator<Integer> {

        private int pointer;
        @Override
        public Integer next() {
            Integer value = IntList.this.get(pointer);
            pointer++;
            return value;
        }
        @Override
        public boolean hasNext() {
            return pointer < IntList.this.size;
        }
    }
}