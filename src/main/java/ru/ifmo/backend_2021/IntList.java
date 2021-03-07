package ru.ifmo.backend_2021;

import java.util.*;

public class IntList implements List<Integer> {
    List<Integer> innerList;

    public IntList(){
        innerList = new ArrayList<>();
    }

    @Override
    public int size() {
        return innerList.size();
    }

    @Override
    public boolean isEmpty() {
        return innerList.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return innerList.contains(o);
    }

    @Override
    public Iterator<Integer> iterator() {
        return innerList.iterator();
    }

    @Override
    public Object[] toArray() {
        return innerList.toArray();
    }

    @Override
    public <T> T[] toArray(T[] ts) {
        return innerList.toArray(ts);
    }

    @Override
    public boolean add(Integer integer) {
        return innerList.add(integer);
    }

    @Override
    public boolean remove(Object o) {
        return innerList.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        return innerList.containsAll(collection);
    }

    @Override
    public boolean addAll(Collection<? extends Integer> collection) {
        return innerList.addAll(collection);
    }

    @Override
    public boolean addAll(int i, Collection<? extends Integer> collection) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        return innerList.removeAll(collection);
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        return innerList.retainAll(collection);
    }

    @Override
    public void clear() {
        innerList.clear();
    }

    @Override
    public Integer get(int i) {
        return innerList.get(i);
    }

    @Override
    public Integer set(int i, Integer integer) {
        return innerList.set(i, integer);
    }

    @Override
    public void add(int i, Integer integer) {
        innerList.add(i, integer);
    }

    @Override
    public Integer remove(int i) {
        return innerList.remove(i);
    }

    @Override
    public int indexOf(Object o) {
        return innerList.indexOf(o);
    }

    @Override
    public int lastIndexOf(Object o) {
        return innerList.lastIndexOf(o);
    }

    @Override
    public ListIterator<Integer> listIterator() {
        return innerList.listIterator();
    }

    @Override
    public ListIterator<Integer> listIterator(int i) {
        return innerList.listIterator(i);
    }

    @Override
    public List<Integer> subList(int i, int i1) {
        return innerList.subList(i, i1);
    }
}
