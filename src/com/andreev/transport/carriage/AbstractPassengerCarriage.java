package com.andreev.transport.carriage;

import com.andreev.exception.NotNullException;
import com.andreev.exception.OutOfRangeException;

public abstract class AbstractPassengerCarriage extends AbstractCarriage {

	public enum ComfortType {
		PUBLIC(0), ECONOM(1), BUSINESS(2);
		private final int id;

		private ComfortType(int id) {
			this.id = id;
		}

		public int getId() {
			return id;
		}
	}

	private ComfortType comfortType;
	private int passengerCurCount;
	private int passengerMaxCount;
	private int baggageCurWeight;
	private int baggageMaxWeight;

	public AbstractPassengerCarriage(int id) throws OutOfRangeException {
		super(id);
	}

	public ComfortType getComfortType() {
		return comfortType;
	}

	public void setComfortType(ComfortType comfortType) throws NotNullException {
		if (comfortType == null) {
			throw new NotNullException("Comfort type is null");
		}
		this.comfortType = comfortType;

	}

	public int getPassengerCurCount() {
		return passengerCurCount;
	}

	public void setPassengerCurCount(int passengerCount)
			throws OutOfRangeException {
		if ((passengerCount >= 0) && (passengerCount <= this.passengerMaxCount)) {
			this.passengerCurCount = passengerCount;
		} else {
			throw new OutOfRangeException(
					"Current passenger count is out of range [0,"
							+ this.passengerMaxCount + "]");
		}
	}

	public int getPassengerMaxCount() {
		return passengerMaxCount;
	}

	public void setPassengerMaxCount(int passengerMaxCount)
			throws OutOfRangeException {
		if (passengerMaxCount >= 0) {
			this.passengerMaxCount = passengerMaxCount;
		} else {
			throw new OutOfRangeException(
					"Maximum passenger count is under zero");
		}
	}

	public int getBaggageCurWeight() {
		return baggageCurWeight;
	}

	public void setBaggageCurWeight(int baggageCurWeight)
			throws OutOfRangeException {
		if ((baggageCurWeight >= 0) && (baggageCurWeight <= baggageMaxWeight)) {
			this.baggageCurWeight = baggageCurWeight;
		} else {
			throw new OutOfRangeException(
					"Current baggage  weight is out of range [0,"
							+ this.passengerMaxCount + "]");
		}
	}

	public int getBaggageMaxWeight() {
		return baggageMaxWeight;
	}

	public void setBaggageMaxWeight(int baggageMaxWeight)
			throws OutOfRangeException {
		if (baggageMaxWeight >= 0) {
			this.baggageMaxWeight = baggageMaxWeight;
		} else {
			throw new OutOfRangeException(
					"Maximum baggage weight is under zero");
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + baggageCurWeight;
		result = prime * result + baggageMaxWeight;
		result = prime * result
				+ ((comfortType == null) ? 0 : comfortType.hashCode());
		result = prime * result + passengerCurCount;
		result = prime * result + passengerMaxCount;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof AbstractPassengerCarriage))
			return false;
		AbstractPassengerCarriage other = (AbstractPassengerCarriage) obj;
		if (baggageCurWeight != other.baggageCurWeight)
			return false;
		if (baggageMaxWeight != other.baggageMaxWeight)
			return false;
		if (comfortType != other.comfortType)
			return false;
		if (passengerCurCount != other.passengerCurCount)
			return false;
		if (passengerMaxCount != other.passengerMaxCount)
			return false;
		return true;
	}

}