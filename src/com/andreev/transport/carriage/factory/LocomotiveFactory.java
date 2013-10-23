package com.andreev.transport.carriage.factory;

import java.util.Date;

import org.apache.log4j.Logger;

import com.andreev.exception.OutOfRangeException;
import com.andreev.transport.carriage.AbstractCarriage;
import com.andreev.transport.carriage.DieselLocomotive;
import com.andreev.transport.carriage.ElectricLocomotive;

public class LocomotiveFactory{

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

	public static AbstractCarriage getCarriage(LocomotiveType type, int id,
			String carriageNumber, Date productionDate, int carriageWeight,
			int maxSpeed) throws OutOfRangeException {
		AbstractCarriage carriage;
		if (type == LocomotiveType.ELECTRIC) {
			carriage = new ElectricLocomotive(id, carriageNumber,
					productionDate, carriageWeight, maxSpeed);
		} else if (type == LocomotiveType.DIESEL) {
			carriage = new DieselLocomotive(id, carriageNumber,
					productionDate, carriageWeight, maxSpeed);
		} else
			throw new OutOfRangeException("Carriage type is incorrect");
		log.debug("New Locomotive: " + carriage);
		return carriage;
	}

}
