package com.andreev.transport.carriage.factory;

import java.util.Date;

import com.andreev.exeption.OutOfRangeExeption;
import com.andreev.transport.carriage.BaggageCarriage;
import com.andreev.transport.carriage.BaseCarriage;

public class FreightCarriageFactory extends BaseCarriageFactory {

	public final static int TYPE_COUNT = 1;
	public final static int TYPE_IDLE = 0;
	public final static int TYPE_BAGGAGE = 1;

	public static BaseCarriage getCarriage(int type, String carriageNumber,
			Date productionDate, int carriageWeight, int maxCapacity) throws OutOfRangeExeption {
		BaseCarriage carriage;
		if (type == TYPE_BAGGAGE) {
			carriage = new BaggageCarriage(getId(), carriageNumber,
					productionDate, carriageWeight, maxCapacity);
		} else
			throw new OutOfRangeExeption("Carriage type is incorrect");
		return carriage;
	}

}
