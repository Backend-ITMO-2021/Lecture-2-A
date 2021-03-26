package ru.ifmo.backend_2021;

import java.util.*;


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

    String convertToString() {
        IntListIterator it = new IntListIterator();
        StringBuilder result = new StringBuilder();

        while (it.hasNext()) {
            result.append(it.next()).append(" ");
        }

        return result.substring(0, result.length() - 1);
    }

    @Override
    public Iterator<Integer> iterator() {
        return new IntListIterator();
    }

    private class IntListIterator implements Iterator<Integer> {
        private int curIndex;

        IntListIterator() {
            this.curIndex = 0;
        }

        @Override
        public boolean hasNext() {
            return this.curIndex < size;
        }

        @Override
        public Integer next() {
            this.curIndex++;
            return data[curIndex - 1];
        }
    }
}
