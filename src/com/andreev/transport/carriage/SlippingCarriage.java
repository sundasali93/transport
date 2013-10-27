package com.andreev.transport.carriage;

import com.andreev.exception.OutOfRangeException;

public class SlippingCarriage extends AbstractPassengerCarriage {

	public SlippingCarriage(int id, String carriageNumber,
			ComfortType comfortType, int passengerMaxCount, int baggageMaxWeight)
			throws OutOfRangeException {
		super(id);
		setCarriageNumber(carriageNumber);
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
		sb.append("PassengerCount = " + getPassengerCurCount() + "/"
				+ getPassengerMaxCount() + ", ");
		sb.append("BaggageWeight = " + getBaggageCurWeight() + "/"
				+ getBaggageMaxWeight());
		sb.append("];");
		return sb.toString();
	}

}
