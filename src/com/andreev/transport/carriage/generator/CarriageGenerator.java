package com.andreev.transport.carriage.generator;

import java.util.Random;

import org.apache.log4j.Logger;

import com.andreev.exception.OutOfRangeException;
import com.andreev.transport.carriage.AbstractCarriage;
import com.andreev.transport.carriage.AbstractFreightCarriage;
import com.andreev.transport.carriage.AbstractPassengerCarriage;
import com.andreev.transport.carriage.AbstractPassengerCarriage.ComfortType;
import com.andreev.transport.carriage.factory.FreightCarriageFactory;
import com.andreev.transport.carriage.factory.FreightCarriageFactory.FreightCarType;
import com.andreev.transport.carriage.factory.LocomotiveFactory;
import com.andreev.transport.carriage.factory.LocomotiveFactory.LocomotiveType;
import com.andreev.transport.carriage.factory.PassengerCarriageFactory;
import com.andreev.transport.carriage.factory.PassengerCarriageFactory.PassengerCarType;

public class CarriageGenerator {

	private static Random random = new Random();
	private static int idCount = 0;

	private static final Logger log = Logger
			.getLogger(CarriageGenerator.class);

	public static AbstractCarriage generateLocomotive() {
		try {
			AbstractCarriage carriage = LocomotiveFactory.newCarriage(
					new RandomEnum<LocomotiveType>(LocomotiveType.class).random(),
					generateId(),
					generateNumber(),
					random.nextInt(150) + 30);
			log.debug("New Locomotive was generaed: " + carriage);
			return carriage;
		} catch (OutOfRangeException e) {
			log.error("Cant't generete new Locomotive", e);
			throw new RuntimeException(e);
		}
	}

	public static AbstractCarriage generateFreightCarriage() {
		try {
			AbstractCarriage carriage = FreightCarriageFactory.newCarriage(
					new RandomEnum<FreightCarType>(FreightCarType.class).random(),
					generateId(),
					generateNumber(),
					(random.nextInt(20) + 1) * 1000);
			((AbstractFreightCarriage) carriage).setCurCapacity(random
					.nextInt(((AbstractFreightCarriage) carriage).getMaxCapacity()));
			log.debug("New FreightCarriage was generaed: " + carriage);
			return carriage;
		} catch (OutOfRangeException e) {
			log.error("Cant't generete new FreightCarriage", e);
			throw new RuntimeException(e);
		}
	}

	public static AbstractCarriage generatePassengerCarriage() {
		try {
			AbstractCarriage carriage = PassengerCarriageFactory.newCarriage(
					new RandomEnum<PassengerCarType>(PassengerCarType.class).random(),
					generateId(),
					generateNumber(),
					new RandomEnum<ComfortType>(ComfortType.class).random(),
					random.nextInt(100) + 10,
					random.nextInt(1000) + 500);
			((AbstractPassengerCarriage) carriage).setPassengerCurCount(random
					.nextInt(((AbstractPassengerCarriage) carriage).getPassengerMaxCount()+ 1));
			((AbstractPassengerCarriage) carriage).setBaggageCurWeight(random
					.nextInt(((AbstractPassengerCarriage) carriage).getBaggageMaxWeight() + 1));
			log.debug("New PassengerCarriage was generaed: " + carriage);
			return carriage;
		} catch (OutOfRangeException e) {
			log.error("Cant't generete new PassengerCarriage", e);
			throw new RuntimeException(e);
		}
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

	private static String generateNumber() {
		return String.valueOf((random.nextInt(9) + 1) * 1000
				+ random.nextInt(999));
	}

}
