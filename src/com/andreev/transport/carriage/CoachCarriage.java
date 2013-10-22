package com.andreev.transport.carriage;

import java.util.Date;

public class CoachCarriage extends BasePassengerCarriage {

	public CoachCarriage(int id, String carriageNumber, Date productionDate,
			int carriageWeight, int comfortType, int passengerMaxCount,
			int baggageMaxWeight) {
		setId(id);
		setCarriageNumber(carriageNumber);
		setProductionDate(productionDate);
		setCarriageWeight(carriageWeight);
		setComfortType(comfortType);
		setPassengerMaxCount(passengerMaxCount);
		setBaggageMaxWeight(baggageMaxWeight);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("CoachCarriage [");
		sb.append("ID = " + getId() + ", ");
		sb.append("Number = " + getCarriageNumber() + ", ");
		sb.append("ComfortType = " + getComfortType() + ", ");
		sb.append("PassengerCount = " + getPassengerCurCount() 
				+ "/" + getPassengerMaxCount() + ", ");
		sb.append("BaggageWeight = " + getBaggageCurWeight() 
				+ "/" + getBaggageMaxWeight());
		sb.append("];");
		return sb.toString();
	}
}
