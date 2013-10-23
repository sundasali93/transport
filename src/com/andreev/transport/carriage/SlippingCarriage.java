package com.andreev.transport.carriage;

import java.util.Date;

import com.andreev.exception.OutOfRangeException;

public class SlippingCarriage extends AbstractPassengerCarriage {

	public SlippingCarriage(int id, String carriageNumber, Date productionDate,
			int carriageWeight, ComfortType comfortType, int passengerMaxCount,
			int baggageMaxWeight) throws OutOfRangeException {
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
		sb.append("SlippingCarriage [");
		sb.append("ID = " + getId() + ", ");
		sb.append("Number = " + getCarriageNumber() + ", ");
		sb.append("ComfortType = " + getComfortType().name() + ", ");
		sb.append("PassengerCount = " + getPassengerCurCount() 
				+ "/" + getPassengerMaxCount() + ", ");
		sb.append("BaggageWeight = " + getBaggageCurWeight() 
				+ "/" + getBaggageMaxWeight());
		sb.append("];");
		return sb.toString();
	}

}
