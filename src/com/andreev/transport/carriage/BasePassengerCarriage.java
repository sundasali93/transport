package com.andreev.transport.carriage;

import com.andreev.exeption.OutOfRangeExeption;

public abstract class BasePassengerCarriage extends BaseCarriage {

	public final static int COMFORT_TYPE_COUNT = 3;
	public final static int COMFORT_TYPE_IDLE = 0;
	public final static int COMFORT_TYPE_PUBLIC = 1;
	public final static int COMFORT_TYPE_ECONOM = 2;
	public final static int COMFORT_TYPE_BUSINESS = 3;

	private int comfortType;
	private int passengerCurCount;
	private int passengerMaxCount;
	private int baggageCurWeight;
	private int baggageMaxWeight;

	public int getComfortType() {
		return comfortType;
	}

	public void setComfortType(int comfortType) {
		if ((comfortType >= 0) && (comfortType <= COMFORT_TYPE_COUNT)) {
			this.comfortType = comfortType;
		} else
			throw new OutOfRangeExeption(
					"Comfort type is out of range [0, "
							+ COMFORT_TYPE_COUNT + "]");
	}

	public int getPassengerCurCount() {
		return passengerCurCount;
	}

	public void setPassengerCurCount(int passengerCount) {
		if ((passengerCount >= 0) && (passengerCount <= this.passengerMaxCount)) {
			this.passengerCurCount = passengerCount;
		} else
			throw new OutOfRangeExeption(
					"Current passenger count is out of range [0,"
							+ this.passengerMaxCount + "]");
	}

	public int getPassengerMaxCount() {
		return passengerMaxCount;
	}

	public void setPassengerMaxCount(int passengerMaxCount) {
		if (passengerMaxCount >= 0) {
			this.passengerMaxCount = passengerMaxCount;
		} else
			throw new OutOfRangeExeption(
					"Maximum passenger count is under zero");
	}

	public int getBaggageCurWeight() {
		return baggageCurWeight;
	}

	public void setBaggageCurWeight(int baggageCurWeight) {
		if ((baggageCurWeight >= 0)
				&& (baggageCurWeight <= baggageMaxWeight)) {
			this.baggageCurWeight = baggageCurWeight;
		} else
			throw new OutOfRangeExeption(
					"Current baggage  weight is out of range [0,"
							+ this.passengerMaxCount + "]");
	}

	public int getBaggageMaxWeight() {
		return baggageMaxWeight;
	}

	public void setBaggageMaxWeight(int baggageMaxWeight) {
		if (baggageMaxWeight >= 0) {
			this.baggageMaxWeight = baggageMaxWeight;
		} else
			throw new OutOfRangeExeption(
					"Maximum baggage weight is under zero");
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + baggageCurWeight;
		result = prime * result + baggageMaxWeight;
		result = prime * result + comfortType;
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
		if (!(obj instanceof BasePassengerCarriage))
			return false;
		BasePassengerCarriage other = (BasePassengerCarriage) obj;
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