package com.andreev.transport.carriage;

import com.andreev.transport.carriage.exception.CarriageException;

public class BaggageCarriage extends AbstractFreightCarriage {

	private int shelfCount;

	public BaggageCarriage(int id, String carriageNumber, int maxCapacity)
			throws CarriageException {
		super(id);
		setCarriageNumber(carriageNumber);
		setMaxCapacity(maxCapacity);
		setCurCapacity(0);
	}

	public int getShelfCount() {
		return shelfCount;
	}

	public void setShelfCount(int shelfCount) throws CarriageException {
		if (shelfCount < 0) {
			throw new CarriageException("Shelf count is under zero");
		}
		this.shelfCount = shelfCount;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("BaggageCarriage [");
		sb.append("ID = " + getId() + ", ");
		sb.append("Number = " + getCarriageNumber() + ", ");
		sb.append("Capacity = " + getCurCapacity() + "/" + getMaxCapacity());
		sb.append("]");
		return sb.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + shelfCount;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof BaggageCarriage))
			return false;
		BaggageCarriage other = (BaggageCarriage) obj;
		if (shelfCount != other.shelfCount)
			return false;
		return true;
	}

}