package com.andreev.transport.carriage.factory;

import java.util.Date;

import com.andreev.transport.carriage.BaseCarriage;
import com.andreev.transport.carriage.DieselLocomotive;
import com.andreev.transport.carriage.ElectricLocomotive;

public class LocomotiveFactory extends BaseCarriageFactory {

	public final static int TYPE_COUNT = 2;
	public final static int TYPE_IDLE = 0;
	public final static int TYPE_ELECTRIC = 1;
	public final static int TYPE_DIESEL = 2;

	public static BaseCarriage getCarriage(int type, String carriageNumber,
			Date productionDate, int carriageWeight, int maxSpeed) {
		BaseCarriage carriage;
		if (type == TYPE_ELECTRIC) {
			carriage = new ElectricLocomotive(getId(), carriageNumber,
					productionDate, carriageWeight, maxSpeed);
		} else if (type == TYPE_DIESEL) {
			carriage = new DieselLocomotive(getId(), carriageNumber,
					productionDate, carriageWeight, maxSpeed);
		} else
			throw new IllegalArgumentException("Carriage type is incorrect");
		return carriage;
	}

}
