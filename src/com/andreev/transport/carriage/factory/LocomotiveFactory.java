package com.andreev.transport.carriage.factory;

import java.util.Date;

import com.andreev.exeption.OutOfRangeExeption;
import com.andreev.transport.carriage.BaseCarriage;
import com.andreev.transport.carriage.DieselLocomotive;
import com.andreev.transport.carriage.ElectricLocomotive;

public class LocomotiveFactory extends BaseCarriageFactory {

	public enum LocomotiveType{
		ELECTRIC(0), DIESEL(1);
		private final int id;
		private LocomotiveType(int id){
			this.id = id;
		}
		public int getId() { return id; }
	}

	public static BaseCarriage getCarriage(LocomotiveType type, String carriageNumber,
			Date productionDate, int carriageWeight, int maxSpeed) throws OutOfRangeExeption {
		BaseCarriage carriage;
		if (type == LocomotiveType.ELECTRIC) {
			carriage = new ElectricLocomotive(getId(), carriageNumber,
					productionDate, carriageWeight, maxSpeed);
		} else if (type == LocomotiveType.DIESEL) {
			carriage = new DieselLocomotive(getId(), carriageNumber,
					productionDate, carriageWeight, maxSpeed);
		} else
			throw new OutOfRangeExeption("Carriage type is incorrect");
		return carriage;
	}

}
