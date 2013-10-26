package com.andreev.transport.carriage;

import com.andreev.exception.OutOfRangeException;

public abstract class AbstractLocomotive extends AbstractCarriage {

	private int maxSpeed;

	public AbstractLocomotive(int id) throws OutOfRangeException {
		super(id);
	}

	public int getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(int maxSpeed) throws OutOfRangeException {
		if (maxSpeed >= 0) {
			this.maxSpeed = maxSpeed;
		} else {
			throw new OutOfRangeException("Maximum speed is under zero");
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + maxSpeed;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof AbstractLocomotive))
			return false;
		AbstractLocomotive other = (AbstractLocomotive) obj;
		if (maxSpeed != other.maxSpeed)
			return false;
		return true;
	}
}
