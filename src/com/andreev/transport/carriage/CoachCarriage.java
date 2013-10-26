package com.andreev.transport.carriage;

import com.andreev.exception.NotNullException;
import com.andreev.exception.OutOfRangeException;

public class CoachCarriage extends AbstractPassengerCarriage {

	public CoachCarriage(int id, String carriageNumber,
			ComfortType comfortType, int passengerMaxCount, int baggageMaxWeight)
			throws OutOfRangeException, NotNullException {
		super(id);
		setCarriageNumber(carriageNumber);
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
		sb.append("ComfortType = " + getComfortType().name() + ", ");
		sb.append("PassengerCount = " + getPassengerCurCount() + "/"
				+ getPassengerMaxCount() + ", ");
		sb.append("BaggageWeight = " + getBaggageCurWeight() + "/"
				+ getBaggageMaxWeight());
		sb.append("];");
		return sb.toString();
	}
}
