package com.andreev.transport.carriage;

import com.andreev.exception.NullArgumentException;
import com.andreev.exception.OutOfRangeException;

public abstract class AbstractCarriage {

	private final int id;
	private String carriageNumber;

	public AbstractCarriage(int id) throws OutOfRangeException {
		if (id >= 0)
			this.id = id;
		else
			throw new OutOfRangeException("Id is under zero");
	}

	public int getId() {
		return id;
	}

	public String getCarriageNumber() {
		return carriageNumber;
	}

	public void setCarriageNumber(String carriageNumber) {
		if (carriageNumber != null) {
			this.carriageNumber = carriageNumber;
		} else
			throw new NullArgumentException("Carriage number is null");
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((carriageNumber == null) ? 0 : carriageNumber.hashCode());
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof AbstractCarriage))
			return false;
		AbstractCarriage other = (AbstractCarriage) obj;
		if (carriageNumber == null) {
			if (other.carriageNumber != null)
				return false;
		} else if (!carriageNumber.equals(other.carriageNumber))
			return false;
		if (id != other.id)
			return false;
		return true;
	}

}
