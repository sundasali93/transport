package com.andreev.transport.carriage;

public abstract class BaseLocomotive extends BaseCarriage {

	private int maxSpeed;

	public int getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(int maxSpeed) {
		if (maxSpeed < 0) {
			this.maxSpeed = maxSpeed;
		} else
			throw new IllegalArgumentException("Maximum speed is under zero");
	}

}
