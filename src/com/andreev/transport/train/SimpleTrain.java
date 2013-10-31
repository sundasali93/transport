package com.andreev.transport.train;

import java.util.ArrayList;

import com.andreev.transport.carriage.AbstractCarriage;
import com.andreev.transport.train.exception.TrainException;

public class SimpleTrain extends ArrayList<AbstractCarriage> {

	private static final long serialVersionUID = 7530921635186056886L;
	private final int ID;
	private int number;

	public SimpleTrain(int id, int number) throws TrainException {
		if (id > 0) {
			this.ID = id;
		} else {
			throw new TrainException("Id is under zero");
		}
		setNumber(number);
	}

	public SimpleTrain(int id) throws TrainException {
		this(id, 0);
	}

	public int getId() {
		return ID;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) throws TrainException {
		if (number > 0) {
			this.number = number;
		} else {
			throw new TrainException("Id is under zero");
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("SimpleTrain [ID = " + getId() + ", Number = " + getNumber()
				+ "]: {\n");
		for (AbstractCarriage ac : this) {
			sb.append("  " + ac + "\n");
		}
		sb.append("}\n");
		return sb.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ID;
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
		if (ID != other.ID)
			return false;
		if (number != other.number)
			return false;
		return true;
	}

}
