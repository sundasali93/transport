package com.andreev.transport.carriage;

import com.andreev.transport.carriage.exception.CarriageException;

public class ElectricLocomotive extends AbstractLocomotive {

	private int batteryVolume;

	public ElectricLocomotive(int id, String carriageNumber, int maxSpeed)
			throws CarriageException {
		super(id);
		setCarriageNumber(carriageNumber);
		setMaxSpeed(maxSpeed);
	}

	public int getBatteryVolume() {
		return batteryVolume;
	}

	public void setBatteryVolume(int batteryVolume) throws CarriageException {
		if (batteryVolume < 0) {
			throw new CarriageException("Battery volume is under zero");
		}
		this.batteryVolume = batteryVolume;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("ElectricLocomotive [");
		sb.append("ID = " + getId() + ", ");
		sb.append("Number = " + getCarriageNumber() + ", ");
		sb.append("MaxSpeed = " + getMaxSpeed());
		sb.append("]");
		return sb.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + batteryVolume;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof ElectricLocomotive))
			return false;
		ElectricLocomotive other = (ElectricLocomotive) obj;
		if (batteryVolume != other.batteryVolume)
			return false;
		return true;
	}
}
