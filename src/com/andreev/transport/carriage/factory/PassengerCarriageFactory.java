package com.andreev.transport.carriage.factory;

import java.util.Date;

import com.andreev.transport.carriage.BaseCarriage;
import com.andreev.transport.carriage.CoachCarriage;
import com.andreev.transport.carriage.DiningCarriage;
import com.andreev.transport.carriage.SlippingCarriage;

public class PassengerCarriageFactory extends BaseCarriageFactory {

	public final static int TYPE_COUNT = 3;
	public final static int TYPE_IDLE = 0;
	public final static int TYPE_COACH = 1;
	public final static int TYPE_SLIPPING = 2;
	public final static int TYPE_DININIG = 3;

	public static BaseCarriage getCarriage(int type, String carriageNumber,
			Date productionDate, int carriageWeight, int comfortType,
			int passengerMaxCount, int baggageMaxWeight) {
		BaseCarriage carriage;
		if (type == TYPE_COACH) {
			carriage = new CoachCarriage(getId(), carriageNumber,
					productionDate, carriageWeight, comfortType,
					passengerMaxCount, baggageMaxWeight);
		} else if (type == TYPE_SLIPPING) {
			carriage = new SlippingCarriage(getId(), carriageNumber,
					productionDate, carriageWeight, comfortType,
					passengerMaxCount, baggageMaxWeight);
		} else if (type == TYPE_DININIG) {
			carriage = new DiningCarriage(getId(), carriageNumber,
					productionDate, carriageWeight, comfortType,
					passengerMaxCount);
		} else
			throw new IllegalArgumentException("Carriage type is incorrect");
		return carriage;
	}
}
