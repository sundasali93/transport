package com.andreev.transport.train.generator;

import java.util.Random;

import org.apache.log4j.Logger;

import com.andreev.exception.OutOfRangeException;
import com.andreev.transport.carriage.generator.CarriageGenerator;
import com.andreev.transport.train.SimpleTrain;
import com.andreev.transport.train.factory.SimpleTrainFactory;

public class SimpleTrainGenerator {

	private static final Logger log = Logger.getLogger(SimpleTrainGenerator.class);

	private static final int MAX_TRAIN_NUMBER = 999;

	private static final int DEFAULT_LOCOMOTIVE_COUNT = 2;
	private static final int DEFAULT_PASSENGER_COUNT = 10;
	private static final int DEFAULT_FREIGHT_COUNT = 4;

	private static int idCount = 0;

	public static SimpleTrain generateTrain(int locomotiveCount, int passengerCount,
			int freightCount){
		SimpleTrain train = null;
		try {
			train = SimpleTrainFactory.newSimpleTrain(generateId(), generateNumber() );
		} catch (OutOfRangeException e) {
			log.fatal("Can't generate new SimpleTrain", e);
			throw new RuntimeException(e);
		}
		for(int i = 0; i < locomotiveCount; i++){
				train.add(CarriageGenerator.generateLocomotive());
		}
		for(int i = 0; i < passengerCount; i++){
			train.add(CarriageGenerator.generatePassengerCarriage());
		}
		for(int i = 0; i < freightCount; i++){
			train.add(CarriageGenerator.generateFreightCarriage());
		}
		log.debug("New SimpleTrain was generated");
		return train;
	}

	public static SimpleTrain generateTrain(){
		return generateTrain(DEFAULT_LOCOMOTIVE_COUNT, DEFAULT_PASSENGER_COUNT,
				DEFAULT_FREIGHT_COUNT);
	}

	private static int generateId() {
		return ++idCount;
	}

	private static int generateNumber(){
		return (new Random().nextInt(MAX_TRAIN_NUMBER)) + 1;
	}

}
