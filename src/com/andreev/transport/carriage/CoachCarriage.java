package com.andreev.transport.carriage;

import com.andreev.transport.carriage.exception.CarriageException;

public class CoachCarriage extends AbstractPassengerCarriage {

	private int coachNumber;

	public CoachCarriage(int id, String carriageNumber,
			ComfortType comfortType, int passengerMaxCount, int baggageMaxWeight)
			throws CarriageException {
		super(id);
		setCarriageNumber(carriageNumber);
		setComfortType(comfortType);
		setPassengerMaxCount(passengerMaxCount);
		setBaggageMaxWeight(baggageMaxWeight);
	}

	public int getCoachNumber() {
		return coachNumber;
	}

	public void setCoachNumber(int coachNumber) throws CarriageException {
		if (coachNumber < 0) {
			throw new CarriageException("Coach number is under zero");
		}
		this.coachNumber = coachNumber;
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
		sb.append("]");
		return sb.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + coachNumber;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof CoachCarriage))
			return false;
		CoachCarriage other = (CoachCarriage) obj;
		if (coachNumber != other.coachNumber)
			return false;
		return true;
	}
}
