package com.andreev.transport.carriage;

import com.andreev.transport.carriage.exception.CarriageException;


public abstract class AbstractFreightCarriage extends AbstractCarriage {

	private int maxCapacity;
	private int curCapacity;

	public AbstractFreightCarriage(int id) throws CarriageException {
		super(id);
	}

	public int getMaxCapacity() {
		return maxCapacity;
	}

	public void setMaxCapacity(int maxCapacity) throws CarriageException {
		if (maxCapacity >= 0) {
			this.maxCapacity = maxCapacity;
		} else {
			throw new CarriageException("Maximum capacity is under zero");
		}
	}

	public int getCurCapacity() {
		return curCapacity;
	}

	public void setCurCapacity(int curCapacity) throws CarriageException {
		if ((curCapacity <= this.maxCapacity) && (curCapacity >= 0)) {
			this.curCapacity = curCapacity;
		} else {
			throw new CarriageException(
					"Current capacity is out of range [0, " + this.maxCapacity
							+ "]");
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + curCapacity;
		result = prime * result + maxCapacity;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof AbstractFreightCarriage))
			return false;
		AbstractFreightCarriage other = (AbstractFreightCarriage) obj;
		if (curCapacity != other.curCapacity)
			return false;
		if (maxCapacity != other.maxCapacity)
			return false;
		return true;
	}

}