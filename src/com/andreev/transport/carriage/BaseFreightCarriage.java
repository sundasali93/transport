package com.andreev.transport.carriage;

public abstract class BaseFreightCarriage extends BaseCarriage {

	private int maxCapacity;
	private int curCapacity;

	public int getMaxCapacity() {
		return maxCapacity;
	}

	protected void setMaxCapacity(int maxCapacity) {
		if (maxCapacity >= 0) {
			this.maxCapacity = maxCapacity;
		} else
			throw new IllegalArgumentException("Maximum capacity is under zero");
	}

	public int getCurCapacity() {
		return curCapacity;
	}

	public void setCurCapacity(int curCapacity) {
		if ((curCapacity <= this.maxCapacity) && (curCapacity >= 0)) {
			this.curCapacity = curCapacity;
		} else
			throw new IllegalArgumentException(
					"Current capacity is out of range [0, " 
							+ this.maxCapacity + "]");
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
		if (!(obj instanceof BaseFreightCarriage))
			return false;
		BaseFreightCarriage other = (BaseFreightCarriage) obj;
		if (curCapacity != other.curCapacity)
			return false;
		if (maxCapacity != other.maxCapacity)
			return false;
		return true;
	}	

}
