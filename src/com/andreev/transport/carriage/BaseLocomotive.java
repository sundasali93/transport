package com.andreev.transport.carriage;

import com.andreev.exeption.OutOfRangeExeption;

public abstract class BaseLocomotive extends BaseCarriage {

	private int maxSpeed;

	public int getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(int maxSpeed) throws OutOfRangeExeption {
		if (maxSpeed >= 0) {
			this.maxSpeed = maxSpeed;
		} else
			throw new OutOfRangeExeption("Maximum speed is under zero");
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
		if (!(obj instanceof BaseLocomotive))
			return false;
		BaseLocomotive other = (BaseLocomotive) obj;
		if (maxSpeed != other.maxSpeed)
			return false;
		return true;
	}
}
