package com.andreev.transport.carriage.factory;

import org.apache.log4j.Logger;

import com.andreev.transport.carriage.AbstractCarriage;
import com.andreev.transport.carriage.DieselLocomotive;
import com.andreev.transport.carriage.ElectricLocomotive;
import com.andreev.transport.carriage.exception.CarriageException;

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

	private static final Logger LOG = Logger.getLogger(LocomotiveFactory.class);

	public static AbstractCarriage newCarriage(LocomotiveType type, int id,
			String carriageNumber, int maxSpeed) throws CarriageException {
		AbstractCarriage carriage = null;
		if (type == LocomotiveType.ELECTRIC) {
			carriage = new ElectricLocomotive(id, carriageNumber, maxSpeed);
		} else if (type == LocomotiveType.DIESEL) {
			carriage = new DieselLocomotive(id, carriageNumber, maxSpeed);
		} else {
			LOG.error("FreightCarType is incorrect");
			throw new CarriageException("Carriage type is incorrect");
		}
		LOG.debug("New Locomotive: " + carriage);
		return carriage;
	}

	public static AbstractCarriage newCarriage(LocomotiveType type, int id)
			throws CarriageException {
		return newCarriage(type, id, "", 0);
	}

}
