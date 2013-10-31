package com.andreev.transport.carriage.factory;

import org.apache.log4j.Logger;

import com.andreev.transport.carriage.AbstractCarriage;
import com.andreev.transport.carriage.BaggageCarriage;
import com.andreev.transport.carriage.exception.CarriageException;

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

	private static final Logger LOG = Logger
			.getLogger(FreightCarriageFactory.class);

	public static AbstractCarriage newCarriage(FreightCarType type, int id,
			String carriageNumber, int maxCapacity) throws CarriageException {
		AbstractCarriage carriage = null;
		if (type == FreightCarType.BAGGAGE) {
			carriage = new BaggageCarriage(id, carriageNumber, maxCapacity);
		} else {
			LOG.error("FreightCarType is incorrect");
			throw new CarriageException("Carriage type is incorrect");
		}
		LOG.debug("New FreightCarriage: " + carriage);
		return carriage;
	}

	public static AbstractCarriage newCarriage(FreightCarType type, int id)
			throws CarriageException {
		return newCarriage(type, id, "", 0);
	}

}
