package com.andreev.transport.carriage.factory;

import org.apache.log4j.Logger;

import com.andreev.exception.NullArgumentException;
import com.andreev.exception.OutOfRangeException;
import com.andreev.transport.carriage.AbstractCarriage;
import com.andreev.transport.carriage.DieselLocomotive;
import com.andreev.transport.carriage.ElectricLocomotive;

public class LocomotiveFactory {

	public enum LocomotiveType {
		ELECTRIC(0), DIESEL(1);
		private final int id;

		private LocomotiveType(int id) {
			this.id = id;
		}

		public int getId() {
			return id;
		}
	}

	private static final Logger log = Logger.getLogger(LocomotiveFactory.class);

	public static AbstractCarriage newCarriage(LocomotiveType type, int id,
			String carriageNumber, int maxSpeed) throws OutOfRangeException {
		AbstractCarriage carriage = null;
		try {
			if (type == LocomotiveType.ELECTRIC) {
				carriage = new ElectricLocomotive(id, carriageNumber, maxSpeed);
			} else if (type == LocomotiveType.DIESEL) {
				carriage = new DieselLocomotive(id, carriageNumber, maxSpeed);
			} else {
				NullArgumentException e = new NullArgumentException(
						"Carriage type is incorrect");
				log.error("FreightCarType is incorrect", e);
				throw e;
			}
		} catch (NullArgumentException e) {
			log.fatal("Can't create new Locomotive", e);
			throw new RuntimeException(e);
		}
		log.debug("New Locomotive: " + carriage);
		return carriage;
	}

	public static AbstractCarriage newCarriage(LocomotiveType type, int id)
			throws OutOfRangeException {
		return newCarriage(type, id, "", 0);
	}

}
