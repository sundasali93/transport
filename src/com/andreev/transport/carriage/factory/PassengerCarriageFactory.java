package com.andreev.transport.carriage.factory;

import java.util.Date;

import com.andreev.exeption.OutOfRangeExeption;
import com.andreev.transport.carriage.BaseCarriage;
import com.andreev.transport.carriage.BasePassengerCarriage.ComfortType;
import com.andreev.transport.carriage.CoachCarriage;
import com.andreev.transport.carriage.DiningCarriage;
import com.andreev.transport.carriage.SlippingCarriage;

public class PassengerCarriageFactory extends BaseCarriageFactory {
	
	public enum PassengerCarType{
		COACH(0), SLIPPING(1), DININIG(2);
		private final int id;
		private PassengerCarType(int id){
			this.id = id;
		}
		public int getId() { return id; }
	}

	public static BaseCarriage getCarriage(PassengerCarType type, String carriageNumber,
			Date productionDate, int carriageWeight, ComfortType comfortType,
			int passengerMaxCount, int baggageMaxWeight) throws OutOfRangeExeption {
		BaseCarriage carriage;
		if (type == PassengerCarType.COACH) {
			carriage = new CoachCarriage(getId(), carriageNumber,
					productionDate, carriageWeight, comfortType,
					passengerMaxCount, baggageMaxWeight);
		} else if (type == PassengerCarType.SLIPPING) {
			carriage = new SlippingCarriage(getId(), carriageNumber,
					productionDate, carriageWeight, comfortType,
					passengerMaxCount, baggageMaxWeight);
		} else if (type == PassengerCarType.DININIG) {
			carriage = new DiningCarriage(getId(), carriageNumber,
					productionDate, carriageWeight, comfortType,
					passengerMaxCount);
		} else
			throw new OutOfRangeExeption("Carriage type is incorrect");
		return carriage;
	}
}
