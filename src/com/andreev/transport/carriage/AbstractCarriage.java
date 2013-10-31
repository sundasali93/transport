package com.andreev.transport.carriage;

import com.andreev.transport.carriage.exception.CarriageException;

public abstract class AbstractCarriage {

	private final int ID;
	private String carriageNumber;

	public AbstractCarriage(int id) throws CarriageException {
		if (id >= 0)
			this.ID = id;
		else
			throw new CarriageException("Id is under zero");
	}

	public int getId() {
		return ID;
	}

	public String getCarriageNumber() {
		return carriageNumber;
	}

	public void setCarriageNumber(String carriageNumber)
			throws CarriageException {
		if (carriageNumber != null) {
			this.carriageNumber = carriageNumber;
		} else
			throw new CarriageException("Carriage number is null");
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((carriageNumber == null) ? 0 : carriageNumber.hashCode());
		result = prime * result + ID;
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
		if (ID != other.ID)
			return false;
		return true;
	}

}
