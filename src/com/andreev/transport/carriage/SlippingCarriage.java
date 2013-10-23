package com.andreev.transport.carriage;

import java.util.Date;

import com.andreev.exeption.OutOfRangeExeption;

public class SlippingCarriage extends BasePassengerCarriage {

	public SlippingCarriage(int id, String carriageNumber, Date productionDate,
			int carriageWeight, int comfortType, int passengerMaxCount,
			int baggageMaxWeight) throws OutOfRangeExeption {
		setId(id);
		setCarriageNumber(carriageNumber);
		setProductionDate(productionDate);
		setCarriageWeight(carriageWeight);
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
		sb.append("ComfortType = " + getComfortType() + ", ");
		sb.append("PassengerCount = " + getPassengerCurCount() 
				+ "/" + getPassengerMaxCount() + ", ");
		sb.append("BaggageWeight = " + getBaggageCurWeight() 
				+ "/" + getBaggageMaxWeight());
		sb.append("];");
		return sb.toString();
	}

}
