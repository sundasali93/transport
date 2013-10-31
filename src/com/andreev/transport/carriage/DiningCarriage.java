package com.andreev.transport.carriage;

import com.andreev.transport.carriage.exception.CarriageException;

public class DiningCarriage extends AbstractPassengerCarriage {

	private int tableCount;

	public DiningCarriage(int id, String carriageNumber,
			ComfortType comfortType, int passengerMaxCount)
			throws CarriageException {
		super(id);
		setCarriageNumber(carriageNumber);
		setComfortType(comfortType);
		setPassengerMaxCount(passengerMaxCount);
		setBaggageMaxWeight(0);
	}

	public int getTableCount() {
		return tableCount;
	}

	public void setTableCount(int tableCount) throws CarriageException {
		if (tableCount < 0) {
			throw new CarriageException("Waiter count is under zero");
		}
		this.tableCount = tableCount;
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
		sb.append("]");
		return sb.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + tableCount;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof DiningCarriage))
			return false;
		DiningCarriage other = (DiningCarriage) obj;
		if (tableCount != other.tableCount)
			return false;
		return true;
	}
}
