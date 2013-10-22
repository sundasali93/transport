package com.andreev.transport.carriage;

import java.util.Date;

public class ElectricLocomotive extends BaseLocomotive {
	
	public ElectricLocomotive(int id, String carriageNumber, Date productionDate,
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
		sb.append("ElectricLocomotive [");
		sb.append("ID = " + getId() + ", ");
		sb.append("Number = " + getCarriageNumber() + ", ");
		sb.append("MaxSpeed = " + getMaxSpeed());
		sb.append("];");
		return sb.toString();
	}

}
