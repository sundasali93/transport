package com.andreev.transport.carriage;

import java.util.Date;

public class BaggageCarriage extends BaseFreightCarriage {

	public BaggageCarriage(int id, String carriageNumber, Date productionDate,
			int carriageWeight, int maxCapacity) {
		setId(id);
		setCarriageNumber(carriageNumber);
		setProductionDate(productionDate);
		setCarriageWeight(carriageWeight);
		setMaxCapacity(maxCapacity);
		setCurCapacity(0);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("BaggageCarriage [");
		sb.append("ID = " + getId() + ", ");
		sb.append("Number = " + getCarriageNumber() + ", ");
		sb.append("Capacity = " + getCurCapacity() + "/" + getMaxCapacity());
		sb.append("];");
		return sb.toString();
	}

}