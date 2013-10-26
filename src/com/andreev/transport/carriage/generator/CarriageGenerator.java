package com.andreev.transport.carriage.generator;

import java.util.Random;

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

	public static AbstractCarriage getLocomotive() throws OutOfRangeException {
		AbstractCarriage carriage = LocomotiveFactory.createCarriage(
				new RandomEnum<LocomotiveType>(LocomotiveType.class).random(),
				generateId(),
				generateNumber(),
				random.nextInt(150) + 30);
		return carriage;
	}

	public static AbstractCarriage getFreightCarriage() throws OutOfRangeException {
		AbstractCarriage carriage = FreightCarriageFactory.createCarriage(
				new RandomEnum<FreightCarType>(FreightCarType.class).random(),
				generateId(),
				generateNumber(), 
				(random.nextInt(20) + 1) * 1000);
		((AbstractFreightCarriage) carriage).setCurCapacity(random
				.nextInt(((AbstractFreightCarriage) carriage).getMaxCapacity()));
		return carriage;
	}

	public static AbstractCarriage getPassengerCarriage() throws OutOfRangeException {
		AbstractCarriage carriage = PassengerCarriageFactory.createCarriage(
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

	private static String generateNumber() {
		return String.valueOf((random.nextInt(9) + 1) * 1000
				+ random.nextInt(999));
	}

}
