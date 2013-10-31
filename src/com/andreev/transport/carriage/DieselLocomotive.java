package com.andreev.transport.carriage;

import com.andreev.transport.carriage.exception.CarriageException;

public class DieselLocomotive extends AbstractLocomotive {

	private int tankVolume;

	public DieselLocomotive(int id, String carriageNumber, int maxSpeed)
			throws CarriageException {
		super(id);
		setCarriageNumber(carriageNumber);
		setMaxSpeed(maxSpeed);
	}

	public int getTankVolume() {
		return tankVolume;
	}

	public void setTankVolume(int tankVolume) throws CarriageException {
		if (tankVolume < 0) {
			throw new CarriageException("Volume of the tank is under zero");
		}
		this.tankVolume = tankVolume;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("DieselLocomotive [");
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
		result = prime * result + tankVolume;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof DieselLocomotive))
			return false;
		DieselLocomotive other = (DieselLocomotive) obj;
		if (tankVolume != other.tankVolume)
			return false;
		return true;
	}
}
