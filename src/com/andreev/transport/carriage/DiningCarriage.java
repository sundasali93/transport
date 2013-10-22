package com.andreev.transport.carriage;

import java.util.Date;

public class DiningCarriage extends BasePassengerCarriage {
	
	public DiningCarriage(int id, String carriageNumber, Date productionDate,
			int carriageWeight, int comfortType, int passengerMaxCount) {
		setId(id);
		setCarriageNumber(carriageNumber);
		setProductionDate(productionDate);
		setCarriageWeight(carriageWeight);
		setComfortType(comfortType);
		setPassengerMaxCount(passengerMaxCount);
		setBaggageMaxWeight(0);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("DiningCarriage [");
		sb.append("ID = " + getId() + ", ");
		sb.append("Number = " + getCarriageNumber() + ", ");
		sb.append("ComfortType = " + getComfortType() + ", ");
		sb.append("PassengerCount = " + getPassengerCurCount() 
				+ "/" + getPassengerMaxCount());
		sb.append("];");
		return sb.toString();
	}

}
