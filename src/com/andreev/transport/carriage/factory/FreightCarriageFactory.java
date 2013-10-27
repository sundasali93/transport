package com.andreev.transport.carriage.factory;

import org.apache.log4j.Logger;

import com.andreev.exception.NullArgumentException;
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

	public static AbstractCarriage newCarriage(FreightCarType type, int id,
			String carriageNumber, int maxCapacity) throws OutOfRangeException {
		AbstractCarriage carriage = null;
		try {
			if (type == FreightCarType.BAGGAGE) {
				carriage = new BaggageCarriage(id, carriageNumber, maxCapacity);
			} else {
				NullArgumentException e = new NullArgumentException(
						"Carriage type is incorrect");
				log.error("FreightCarType is incorrect", e);
				throw new RuntimeException(e);
			}
		} catch (NullArgumentException e) {
			log.error("Can't create new Freight Carriage", e);
			throw new RuntimeException(e);
		}
		log.debug("New FreightCarriage: " + carriage);
		return carriage;
	}

	public static AbstractCarriage newCarriage(FreightCarType type, int id)
			throws OutOfRangeException {
		return newCarriage(type, id, "", 0);
	}

}
