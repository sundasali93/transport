package com.andreev.transport.carriage.factory;

import java.util.Date;

import com.andreev.exeption.OutOfRangeExeption;
import com.andreev.transport.carriage.BaggageCarriage;
import com.andreev.transport.carriage.BaseCarriage;

public class FreightCarriageFactory extends BaseCarriageFactory {

	public enum FreightType{
		BAGGAGE(0);
		private final int id;
		private FreightType(int id){
			this.id = id;
		}
		public int getId() { return id; }
	}

	public static BaseCarriage getCarriage(FreightType type, String carriageNumber,
			Date productionDate, int carriageWeight, int maxCapacity) throws OutOfRangeExeption {
		BaseCarriage carriage;
		if (type == FreightType.BAGGAGE) {
			carriage = new BaggageCarriage(getId(), carriageNumber,
					productionDate, carriageWeight, maxCapacity);
		} else
			throw new OutOfRangeExeption("Carriage type is incorrect");
		return carriage;
	}

}
