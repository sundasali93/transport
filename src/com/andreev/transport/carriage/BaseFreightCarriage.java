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

}
