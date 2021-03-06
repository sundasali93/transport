package com.andreev.transport.carriage.factory;

import org.apache.log4j.Logger;

import com.andreev.transport.carriage.AbstractCarriage;
import com.andreev.transport.carriage.AbstractPassengerCarriage.ComfortType;
import com.andreev.transport.carriage.CoachCarriage;
import com.andreev.transport.carriage.DiningCarriage;
import com.andreev.transport.carriage.SlippingCarriage;
import com.andreev.transport.carriage.exception.CarriageException;

public class PassengerCarriageFactory {

	public enum PassengerCarType {
		COACH(0), SLIPPING(1), DINING(2);
		private final int id;

		private PassengerCarType(int id) {
			this.id = id;
		}

		public int getId() {
			return id;
		}
	}

	private static final Logger LOG = Logger
			.getLogger(PassengerCarriageFactory.class);

	public static AbstractCarriage newCarriage(PassengerCarType type, int id,
			String carriageNumber, ComfortType comfortType,
			int passengerMaxCount, int baggageMaxWeight)
			throws CarriageException {
		AbstractCarriage carriage;
		if (type == PassengerCarType.COACH) {
			carriage = new CoachCarriage(id, carriageNumber, comfortType,
					passengerMaxCount, baggageMaxWeight);
		} else if (type == PassengerCarType.SLIPPING) {
			carriage = new SlippingCarriage(id, carriageNumber, comfortType,
					passengerMaxCount, baggageMaxWeight);
		} else if (type == PassengerCarType.DINING) {
			carriage = new DiningCarriage(id, carriageNumber, comfortType,
					passengerMaxCount);
		} else {
			LOG.error("FreightCarType is incorrect");
			throw new CarriageException("Carriage type is incorrect");
		}
		LOG.debug("New PassengerCarriage: " + carriage);
		return carriage;
	}

	public static AbstractCarriage newCarriage(PassengerCarType type, int id)
			throws CarriageException {
		return newCarriage(type, id, "", ComfortType.PUBLIC, 0, 0);
	}

}
