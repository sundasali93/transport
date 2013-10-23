package com.andreev.transport.train.generator;

import com.andreev.transport.carriage.generator.CarriageGenerator;
import com.andreev.transport.train.SimpleTrain;

public class SimpleTrainGenerator {
	
	private static final int DEFAULT_LOCOMOTIVE_COUNT = 2;
	private static final int DEFAULT_PASSENGER_COUNT = 10;
	private static final int DEFAULT_FREIGHT_COUNT = 4;
	
	public static SimpleTrain getTrain(int locomotiveCount, int passengerCount, int freightCount){
		SimpleTrain train = new SimpleTrain();
		for(int i = 0; i < locomotiveCount; i++){
			train.getTrain().add(CarriageGenerator.getLocomotive());
		}
		for(int i = 0; i < passengerCount; i++){
			train.getTrain().add(CarriageGenerator.getPassengerCarriage());
		}
		for(int i = 0; i < freightCount; i++){
			train.getTrain().add(CarriageGenerator.getFreightCarriage());
		}
		return train;
	}
	
	public static SimpleTrain getTrain(){
		return getTrain(DEFAULT_LOCOMOTIVE_COUNT, DEFAULT_PASSENGER_COUNT, DEFAULT_FREIGHT_COUNT);		
	}

}
