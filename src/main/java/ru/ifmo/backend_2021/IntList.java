package ru.ifmo.backend_2021;
import java.util.Iterator;

public class IntList implements Iterable<Integer> {
    private int size = 0;
    private int capacity = 20;
    private Integer[] arr = new Integer[capacity];
    private int index = 0;

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {

            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public Integer next() {
                Integer item = arr[index];
                index += 1;
                return item;
            }
        };
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }

    public int get(int i) {
        if (i > size) {
            throw new ArrayIndexOutOfBoundsException(i);
        } else if (i == -1) {
            return arr[size-1];
        }
        return arr[i];
    }

    public void add(Integer elem) {
        if (size >= capacity) {
            capacity = arr.length + capacity;
            Integer[] prevArr = arr;
            arr = new Integer[capacity];
            System.arraycopy(prevArr, 0, arr, 0, prevArr.length);
        }
        arr[size] = elem;
        size += 1;
    }

    public String print() {
        StringBuilder string = new StringBuilder();
        for (Integer item : arr) {
            if (item != null) {
                string.append(item).append(" ");
            }        }
        return string.toString().trim();
    }

}
