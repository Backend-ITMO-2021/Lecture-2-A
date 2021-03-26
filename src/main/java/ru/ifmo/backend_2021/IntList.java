package ru.ifmo.backend_2021;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;


class IntList implements Iterable<Integer> {
    private int[] data;
    private int size;

    IntList() {
        this.data = new int[0];
        this.size = 0;
    }

    int getSize() {
      return this.size;
    }

    void push(int value) {
        this.data = Arrays.copyOf(data, size + 1);
        this.data[size] = value;
        this.size++;
    }

    protected String convertToString() {
        String result = Arrays.toString(this.data).replaceAll(",", "");
        return result.substring(1, result.length() - 1);
    }

    @Override
    public Iterator<Integer> iterator() {
        return new IntListIterator(0);
    }

    private class IntListIterator implements Iterator<Integer> {
        private int curIndex;

        IntListIterator(int index) {
            this.curIndex = index;
        }

        @Override
        public boolean hasNext() {
        return this.curIndex < size;
        }

        @Override
        public Integer next() {
            if(!this.hasNext()) {
                throw new NoSuchElementException();
            }
            return curIndex++;
        }
    }
}
