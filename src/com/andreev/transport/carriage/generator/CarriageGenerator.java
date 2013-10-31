package com.andreev.transport.carriage.generator;

import java.util.Random;

import org.apache.log4j.Logger;

import com.andreev.transport.carriage.AbstractCarriage;
import com.andreev.transport.carriage.AbstractFreightCarriage;
import com.andreev.transport.carriage.AbstractPassengerCarriage;
import com.andreev.transport.carriage.AbstractPassengerCarriage.ComfortType;
import com.andreev.transport.carriage.exception.CarriageException;
import com.andreev.transport.carriage.factory.FreightCarriageFactory;
import com.andreev.transport.carriage.factory.FreightCarriageFactory.FreightCarType;
import com.andreev.transport.carriage.factory.LocomotiveFactory;
import com.andreev.transport.carriage.factory.LocomotiveFactory.LocomotiveType;
import com.andreev.transport.carriage.factory.PassengerCarriageFactory;
import com.andreev.transport.carriage.factory.PassengerCarriageFactory.PassengerCarType;

public class CarriageGenerator {

	private static final Logger LOG = Logger.getLogger(CarriageGenerator.class);

	private static Random random = new Random();
	private static int idCount = 0;

	public static AbstractCarriage generateLocomotive() {
		AbstractCarriage carriage = null;
		try {
			carriage = LocomotiveFactory.newCarriage(
					new RandomEnum<LocomotiveType>(LocomotiveType.class).random(),
					generateId(),
					generateNumber(),
					generateMaxSpeed());
		} catch (CarriageException e) {
			LOG.fatal("Cant't generete new Locomotive", e);
			System.exit(1);
		}
		LOG.debug("New Locomotive was generaed: " + carriage);
		return carriage;
	}

	public static AbstractCarriage generateFreightCarriage() {
		AbstractCarriage carriage = null;
		try {
			carriage = FreightCarriageFactory.newCarriage(
					new RandomEnum<FreightCarType>(FreightCarType.class).random(),
					generateId(),
					generateNumber(),
					generateMaxCapacity());
			((AbstractFreightCarriage) carriage).setCurCapacity(random
					.nextInt(((AbstractFreightCarriage) carriage).getMaxCapacity()));
		} catch (CarriageException e) {
			LOG.fatal("Cant't generete new FreightCarriage", e);
			System.exit(1);
		}
		LOG.debug("New FreightCarriage was generaed: " + carriage);
		return carriage;
	}

	public static AbstractCarriage generatePassengerCarriage() {
		AbstractCarriage carriage = null;
		try {
			carriage = PassengerCarriageFactory.newCarriage(
					new RandomEnum<PassengerCarType>(PassengerCarType.class).random(),
					generateId(),
					generateNumber(),
					new RandomEnum<ComfortType>(ComfortType.class).random(),
					generatePessangerMaxCount(),
					generateBaggageMaxWeight());
			((AbstractPassengerCarriage) carriage).setPassengerCurCount(random
					.nextInt(((AbstractPassengerCarriage) carriage).getPassengerMaxCount()+ 1));
			((AbstractPassengerCarriage) carriage).setBaggageCurWeight(random
					.nextInt(((AbstractPassengerCarriage) carriage).getBaggageMaxWeight() + 1));
		} catch (CarriageException e) {
			LOG.fatal("Cant't generete new PassengerCarriage", e);
			System.exit(1);
		}
		LOG.debug("New PassengerCarriage was generaed: " + carriage);
		return carriage;
	}

	private static class RandomEnum<E extends Enum<E>> {

        private final E[] values;

        public RandomEnum(Class<E> token) {
            values = token.getEnumConstants();
        }

        public E random() {
            return values[random.nextInt(values.length)];
        }
    }

	private static int generateId(){
		return ++idCount;
	}

	private static int generateMaxSpeed() {
		return random.nextInt(150) + 30;
	}

	private static int generateMaxCapacity(){
		return (random.nextInt(20) + 1) * 1000;
	}

	private static int generatePessangerMaxCount(){
		return random.nextInt(100) + 10;
	}

	private static int generateBaggageMaxWeight(){
		return random.nextInt(1000) + 500;
	}

	private static String generateNumber() {
		return String.valueOf((random.nextInt(9) + 1) * 1000
				+ random.nextInt(999));
	}

}
