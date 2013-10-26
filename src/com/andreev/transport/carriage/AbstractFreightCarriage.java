package com.andreev.transport.carriage;

import com.andreev.exception.OutOfRangeException;

public abstract class AbstractFreightCarriage extends AbstractCarriage {

	private int maxCapacity;
	private int curCapacity;

	public AbstractFreightCarriage(int id) throws OutOfRangeException {
		super(id);
	}

	public int getMaxCapacity() {
		return maxCapacity;
	}

	public void setMaxCapacity(int maxCapacity) throws OutOfRangeException {
		if (maxCapacity >= 0) {
			this.maxCapacity = maxCapacity;
		} else {
			throw new OutOfRangeException("Maximum capacity is under zero");
		}
	}

	public int getCurCapacity() {
		return curCapacity;
	}

	public void setCurCapacity(int curCapacity) throws OutOfRangeException {
		if ((curCapacity <= this.maxCapacity) && (curCapacity >= 0)) {
			this.curCapacity = curCapacity;
		} else {
			throw new OutOfRangeException(
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