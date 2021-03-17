package ru.ifmo.backend_2021;

import java.util.Arrays;
import java.util.Iterator;

public class IntList implements Iterable<Integer> {
	private Integer[] elements;
	public int size = 0;

	public IntList() {
		elements = new Integer[0];
	}

	public IntList(Integer[] initialElements) {
		this.elements = initialElements;
		this.size = initialElements.length;

	}

	public int size() {
		return size; //
	}

	public Boolean isEmpty() {
		return size == 0;
	}

	public Integer[] extendArray() {
		return Arrays.copyOf(this.elements, this.size + 1);
	}

	public void add(Integer elementValue) {
		if (this.size == this.elements.length) this.elements = this.extendArray();
		this.elements[this.size++] = elementValue;
	}

	public Integer get(Integer index) {
		if (index >= size) {
			throw new ArrayIndexOutOfBoundsException();
		}

		return elements[index];
	}

	public Integer getLast() {
		if (this.size == 0) throw new ArrayIndexOutOfBoundsException();

		return elements[size - 1];
	}

	@Override
	public Iterator<Integer> iterator() {
		return new Iterator<Integer>(){
			private Integer index = 0;


			@Override
			public boolean hasNext() {
				return index < size;
			}

			@Override
			public Integer next() {
				return elements[index++];
			}
		};
	}

	
}
