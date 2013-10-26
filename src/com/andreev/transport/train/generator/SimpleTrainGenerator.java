package com.andreev.transport.train.generator;

import java.util.Random;

import org.apache.log4j.Logger;

import com.andreev.exception.OutOfRangeException;
import com.andreev.transport.carriage.generator.CarriageGenerator;
import com.andreev.transport.train.SimpleTrain;

public class SimpleTrainGenerator {

	private static final Logger log = Logger.getLogger(SimpleTrainGenerator.class);

	private static final int DEFAULT_LOCOMOTIVE_COUNT = 2;
	private static final int DEFAULT_PASSENGER_COUNT = 10;
	private static final int DEFAULT_FREIGHT_COUNT = 4;

	private static int idCount = 0;

	public static SimpleTrain getTrain(int locomotiveCount, int passengerCount,
			int freightCount){
		SimpleTrain train = null;
		try {
			train = new SimpleTrain(getId(), generateNumber() );
		} catch (OutOfRangeException e1) {
			log.error("Can't create new SimpleTrain", e1);
			throw new RuntimeException(e1);
		}
		try {
			for(int i = 0; i < locomotiveCount; i++){
					train.add(CarriageGenerator.getLocomotive());
			}
			for(int i = 0; i < passengerCount; i++){
				train.add(CarriageGenerator.getPassengerCarriage());
			}
			for(int i = 0; i < freightCount; i++){
				train.add(CarriageGenerator.getFreightCarriage());
			}
		} catch (OutOfRangeException e) {
			log.error("Can't generate carrieges", e);
		}
		log.debug("New SimpleTrain was generated");
		return train;
	}

	public static SimpleTrain getTrain(){
		return getTrain(DEFAULT_LOCOMOTIVE_COUNT, DEFAULT_PASSENGER_COUNT,
				DEFAULT_FREIGHT_COUNT);
	}

	private static int getId() {
		return ++idCount;
	}

	private static int generateNumber(){
		return (new Random().nextInt(999)) + 1;
	}

}
