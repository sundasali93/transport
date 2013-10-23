package com.andreev.transport.carriage;

import java.util.Date;

import com.andreev.exeption.OutOfRangeExeption;

public class DiningCarriage extends BasePassengerCarriage {
	
	public DiningCarriage(int id, String carriageNumber, Date productionDate,
			int carriageWeight, ComfortType comfortType, int passengerMaxCount) throws OutOfRangeExeption {
		setId(id);
		setCarriageNumber(carriageNumber);
		setProductionDate(productionDate);
		setCarriageWeight(carriageWeight);
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
		sb.append("PassengerCount = " + getPassengerCurCount() 
				+ "/" + getPassengerMaxCount());
		sb.append("];");
		return sb.toString();
	}

}
