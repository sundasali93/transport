package com.andreev.transport.carriage.factory;

import org.apache.log4j.Logger;

import com.andreev.exception.OutOfRangeException;
import com.andreev.transport.carriage.AbstractCarriage;
import com.andreev.transport.carriage.BaggageCarriage;

public class FreightCarriageFactory {

	public enum FreightCarType {
		BAGGAGE(0);
		private final int id;

		private FreightCarType(int id) {
			this.id = id;
		}

		public int getId() {
			return id;
		}
	}

	private static final Logger log = Logger
			.getLogger(FreightCarriageFactory.class);

	public static AbstractCarriage getCarriage(FreightCarType type, int id,
			String carriageNumber, int maxCapacity) throws OutOfRangeException {
		AbstractCarriage carriage;
		if (type == FreightCarType.BAGGAGE) {
			carriage = new BaggageCarriage(id, carriageNumber, maxCapacity);
		} else
			throw new OutOfRangeException("Carriage type is incorrect");
		log.debug("New FreightCarriage: " + carriage);
		return carriage;
	}

}
