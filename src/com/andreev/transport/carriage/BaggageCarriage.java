package com.andreev.transport.carriage;

import com.andreev.exception.NotNullException;
import com.andreev.exception.OutOfRangeException;

public class BaggageCarriage extends AbstractFreightCarriage {

	public BaggageCarriage(int id, String carriageNumber, int maxCapacity)
			throws OutOfRangeException, NotNullException {
		super(id);
		setCarriageNumber(carriageNumber);
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