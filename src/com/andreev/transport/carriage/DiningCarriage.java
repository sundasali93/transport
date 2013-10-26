package com.andreev.transport.carriage;

import com.andreev.exception.NotNullException;
import com.andreev.exception.OutOfRangeException;

public class DiningCarriage extends AbstractPassengerCarriage {

	public DiningCarriage(int id, String carriageNumber,
			ComfortType comfortType, int passengerMaxCount)
			throws OutOfRangeException, NotNullException {
		super(id);
		setCarriageNumber(carriageNumber);
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
		sb.append("ComfortType = " + getComfortType().name() + ", ");
		sb.append("PassengerCount = " + getPassengerCurCount() + "/"
				+ getPassengerMaxCount());
		sb.append("];");
		return sb.toString();
	}

}
