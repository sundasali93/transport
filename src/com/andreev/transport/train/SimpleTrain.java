package com.andreev.transport.train;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.andreev.transport.carriage.BaseCarriage;

public class SimpleTrain {

	private List<BaseCarriage> train;
	
	public SimpleTrain() {
		train = new LinkedList<>();
	}

	public boolean add(BaseCarriage e) {
		return train.add(e);
	}

	public void add(int index, BaseCarriage element) {
		train.add(index, element);
	}

	public boolean contains(Object o) {
		return train.contains(o);
	}

	public boolean equals(Object o) {
		return train.equals(o);
	}

	public BaseCarriage get(int index) {
		return train.get(index);
	}

	public int hashCode() {
		return train.hashCode();
	}

	public int indexOf(Object o) {
		return train.indexOf(o);
	}

	public boolean isEmpty() {
		return train.isEmpty();
	}

	public Iterator<BaseCarriage> iterator() {
		return train.iterator();
	}

	public BaseCarriage remove(int index) {
		return train.remove(index);
	}

	public boolean remove(Object o) {
		return train.remove(o);
	}

	public BaseCarriage set(int index, BaseCarriage element) {
		return train.set(index, element);
	}

	public int size() {
		return train.size();
	}

}
