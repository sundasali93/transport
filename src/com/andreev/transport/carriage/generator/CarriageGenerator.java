package com.andreev.transport.carriage.generator;

import java.util.Date;
import java.util.Random;

import com.andreev.exeption.OutOfRangeExeption;
import com.andreev.transport.carriage.BaseCarriage;
import com.andreev.transport.carriage.BaseFreightCarriage;
import com.andreev.transport.carriage.BasePassengerCarriage;
import com.andreev.transport.carriage.BasePassengerCarriage.ComfortType;
import com.andreev.transport.carriage.factory.FreightCarriageFactory;
import com.andreev.transport.carriage.factory.FreightCarriageFactory.FreightType;
import com.andreev.transport.carriage.factory.LocomotiveFactory;
import com.andreev.transport.carriage.factory.LocomotiveFactory.LocomotiveType;
import com.andreev.transport.carriage.factory.PassengerCarriageFactory;
import com.andreev.transport.carriage.factory.PassengerCarriageFactory.PassengerCarType;

public class CarriageGenerator {

	public static Random random = new Random();

	public static BaseCarriage getLocomotive() throws OutOfRangeExeption {
		BaseCarriage carriage = LocomotiveFactory.getCarriage(
				new RandomEnum<LocomotiveType>(LocomotiveType.class).random(),
				generateNumber(),
				getnerateDate(), 
				generateWeight(), 
				random.nextInt(150) + 30);
		return carriage;
	}

	public static BaseCarriage getFreightCarriage() throws OutOfRangeExeption {
		BaseCarriage carriage = FreightCarriageFactory.getCarriage(
				new RandomEnum<FreightType>(FreightType.class).random(),
				generateNumber(), 
				getnerateDate(), 
				generateWeight(),
				(random.nextInt(20) + 1) * 1000);
		((BaseFreightCarriage) carriage).setCurCapacity(random
				.nextInt(((BaseFreightCarriage) carriage).getMaxCapacity()));
		return carriage;
	}

	public static BaseCarriage getPassengerCarriage() throws OutOfRangeExeption {
		BaseCarriage carriage = PassengerCarriageFactory.getCarriage(
				new RandomEnum<PassengerCarType>(PassengerCarType.class).random(),
				generateNumber(), 
				getnerateDate(), 
				generateWeight(),
				new RandomEnum<ComfortType>(ComfortType.class).random(),
				random.nextInt(100) + 10, 
				random.nextInt(1000) + 500);
		((BasePassengerCarriage) carriage).setPassengerCurCount(random
				.nextInt(((BasePassengerCarriage) carriage).getPassengerMaxCount()+ 1));
		((BasePassengerCarriage) carriage).setBaggageCurWeight(random
				.nextInt(((BasePassengerCarriage) carriage).getBaggageMaxWeight() + 1));
		return carriage;
	}

	private static String generateNumber() {
		return String.valueOf((random.nextInt(9) + 1) * 1000
				+ random.nextInt(999));
	}

	private static Date getnerateDate() {
		return new Date();
	}

	private static int generateWeight() {
		return random.nextInt(2000) + 3000;
	}
	
	private static class RandomEnum<E extends Enum<?>> {

        private final E[] values;

        public RandomEnum(Class<E> token) {
            values = token.getEnumConstants();
        }

        public E random() {
            return values[random.nextInt(values.length)];
        }
    }

}
