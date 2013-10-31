package com.andreev.transport.carriage;

import com.andreev.transport.carriage.exception.CarriageException;

public class SlippingCarriage extends AbstractPassengerCarriage {

	private int bedCount;

	public SlippingCarriage(int id, String carriageNumber,
			ComfortType comfortType, int passengerMaxCount, int baggageMaxWeight)
			throws CarriageException {
		super(id);
		setCarriageNumber(carriageNumber);
		setComfortType(comfortType);
		setPassengerMaxCount(passengerMaxCount);
		setBaggageMaxWeight(baggageMaxWeight);
	}

	public int getBedCount() {
		return bedCount;
	}

	public void setBedCount(int bedCount) throws CarriageException {
		if (bedCount < 0) {
			throw new CarriageException("Bed count is under zero");
		}
		this.bedCount = bedCount;
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
		sb.append("]");
		return sb.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + bedCount;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof SlippingCarriage))
			return false;
		SlippingCarriage other = (SlippingCarriage) obj;
		if (bedCount != other.bedCount)
			return false;
		return true;
	}

}
