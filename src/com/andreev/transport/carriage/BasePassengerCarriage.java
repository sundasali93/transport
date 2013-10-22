package com.andreev.transport.carriage;

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
			throw new IllegalArgumentException(
					"Comfort type is out of range [0, "
							+ COMFORT_TYPE_COUNT + "]");
	}

	public int getPassengerCurCount() {
		return passengerCurCount;
	}

	public void setPassengerCurCount(int passengerCount) {
		if ((passengerCount >= 0) && (passengerCount >= this.passengerMaxCount)) {
			this.passengerCurCount = passengerCount;
		} else
			throw new IllegalArgumentException(
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
			throw new IllegalArgumentException(
					"Maximum passenger count is under zero");
	}

	public int getBaggageCurWeight() {
		return baggageCurWeight;
	}

	public void setBaggageCurWeight(int baggageCurWeight) {
		if ((baggageCurWeight >= 0)
				&& (baggageCurWeight >= this.baggageMaxWeight)) {
			this.baggageCurWeight = baggageCurWeight;
		} else
			throw new IllegalArgumentException(
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
			throw new IllegalArgumentException(
					"Maximum baggage weight is under zero");
	}

}
