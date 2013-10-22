package com.andreev.transport.carriage;

import java.util.Date;

public class DieselLocomotive extends BaseLocomotive {
	
	public DieselLocomotive(int id, String carriageNumber, Date productionDate,
			int carriageWeight, int maxSpeed) {
		setId(id);
		setCarriageNumber(carriageNumber);
		setProductionDate(productionDate);
		setCarriageWeight(carriageWeight);
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
