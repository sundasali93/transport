package com.andreev.transport.carriage.factory;

import java.util.Date;

import org.apache.log4j.Logger;

import com.andreev.exception.OutOfRangeException;
import com.andreev.transport.carriage.AbstractCarriage;
import com.andreev.transport.carriage.AbstractPassengerCarriage.ComfortType;
import com.andreev.transport.carriage.CoachCarriage;
import com.andreev.transport.carriage.DiningCarriage;
import com.andreev.transport.carriage.SlippingCarriage;

public class PassengerCarriageFactory{

	public enum PassengerCarType {
		COACH(0), SLIPPING(1), DININIG(2);
		private final int id;

		private PassengerCarType(int id) {
			this.id = id;
		}

		public int getId() {
			return id;
		}
	}
	
	private static final Logger log = Logger.getLogger(PassengerCarriageFactory.class);

	public static AbstractCarriage getCarriage(PassengerCarType type, int id,
			String carriageNumber, Date productionDate, int carriageWeight,
			ComfortType comfortType, int passengerMaxCount, int baggageMaxWeight)
			throws OutOfRangeException {
		AbstractCarriage carriage;
		if (type == PassengerCarType.COACH) {
			carriage = new CoachCarriage(id, carriageNumber,
					productionDate, carriageWeight, comfortType,
					passengerMaxCount, baggageMaxWeight);
		} else if (type == PassengerCarType.SLIPPING) {
			carriage = new SlippingCarriage(id, carriageNumber,
					productionDate, carriageWeight, comfortType,
					passengerMaxCount, baggageMaxWeight);
		} else if (type == PassengerCarType.DININIG) {
			carriage = new DiningCarriage(id, carriageNumber,
					productionDate, carriageWeight, comfortType,
					passengerMaxCount);
		} else
			throw new OutOfRangeException("Carriage type is incorrect");
		log.debug("New PassengerCarriage: " + carriage);
		return carriage;
	}
}
