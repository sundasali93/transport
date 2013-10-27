package com.andreev.transport.carriage;

import com.andreev.exception.NullArgumentException;
import com.andreev.exception.OutOfRangeException;

public class DieselLocomotive extends AbstractLocomotive {

	public DieselLocomotive(int id, String carriageNumber, int maxSpeed)
			throws OutOfRangeException, NullArgumentException {
		super(id);
		setCarriageNumber(carriageNumber);
		setMaxSpeed(maxSpeed);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("DieselLocomotive [");
		sb.append("ID = " + getId() + ", ");
		sb.append("Number = " + getCarriageNumber() + ", ");
		sb.append("MaxSpeed = " + getMaxSpeed());
		sb.append("];");
		return sb.toString();
	}

}
