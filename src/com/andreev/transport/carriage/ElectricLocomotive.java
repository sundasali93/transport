package com.andreev.transport.carriage;

import com.andreev.exception.OutOfRangeException;

public class ElectricLocomotive extends AbstractLocomotive {

	public ElectricLocomotive(int id, String carriageNumber, int maxSpeed)
			throws OutOfRangeException {
		super(id);
		setCarriageNumber(carriageNumber);
		setMaxSpeed(maxSpeed);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("ElectricLocomotive [");
		sb.append("ID = " + getId() + ", ");
		sb.append("Number = " + getCarriageNumber() + ", ");
		sb.append("MaxSpeed = " + getMaxSpeed());
		sb.append("];");
		return sb.toString();
	}

}
