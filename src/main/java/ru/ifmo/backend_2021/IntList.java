package ru.ifmo.backend_2021;

import java.util.Iterator;

public class IntList implements Iterable<Integer> {

    private int length;
    private int[] list;

    public IntList(int[] list) {
        this.list = list;
        this.length = list.length;
    }

    public void add(int element) {
        this.length++;
        int[] new_list = new int[this.length];
        for(int i = 0; i< this.length-1; i++){
            new_list[i] = this.list[i];
        }
        new_list[this.length-1] = element;
        this.list = new_list;
    }

    public int get(int index) {
        return this.list[index];
    }

    public void set(int number, int index) {
        this.list[index] = number;
    }


    public String toString(){
        String result = "";
        for(int i = 0; i< this.length; i++){
            result += this.list[i] + " ";
        }
        return result.trim();
    }

    @Override
    public Iterator<Integer> iterator() {
        return new IntListIterator();
    }

    private class IntListIterator implements Iterator<Integer> {
        private int position = 0;

        @Override
        public boolean hasNext() {
            return position < IntList.this.length;
        }

        @Override
        public Integer next() {
            int el = IntList.this.list[position];
            position++;
            return el;
        }
    }
}

