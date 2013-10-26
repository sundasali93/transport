package com.andreev.transport.train;

import java.util.ArrayList;

import com.andreev.exception.OutOfRangeException;
import com.andreev.transport.carriage.AbstractCarriage;

public class SimpleTrain extends ArrayList<AbstractCarriage> {

	private static final long serialVersionUID = 7530921635186056886L;
	private final int id;
	private int number;

	public SimpleTrain(int id, int number) throws OutOfRangeException {
		if(id > 0) {
			this.id = id;
		} else {
			throw new OutOfRangeException("Id is under zero");
		}
		setNumber(number);
	}
	
	public SimpleTrain(int id) throws OutOfRangeException {
		this(id, 0);
	}

	public int getId() {
		return id;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) throws OutOfRangeException {
		if(number > 0) {
			this.number = number;
		} else {
			throw new OutOfRangeException("Id is under zero");
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("SimpleTrain [ID = " + getId() +
					", Number = " + getNumber() + "]: {\n");
		for(AbstractCarriage ac : this){
			sb.append("  " + ac + "\n");
		}
		sb.append("}\n");
		return sb.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + id;
		result = prime * result + number;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof SimpleTrain))
			return false;
		SimpleTrain other = (SimpleTrain) obj;
		if (id != other.id)
			return false;
		if (number != other.number)
			return false;
		return true;
	}

}
