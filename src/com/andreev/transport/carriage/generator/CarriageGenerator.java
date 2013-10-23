package com.andreev.transport.carriage.generator;

import java.util.Date;
import java.util.Random;

import com.andreev.transport.carriage.BaseCarriage;
import com.andreev.transport.carriage.BaseFreightCarriage;
import com.andreev.transport.carriage.BasePassengerCarriage;
import com.andreev.transport.carriage.factory.FreightCarriageFactory;
import com.andreev.transport.carriage.factory.LocomotiveFactory;
import com.andreev.transport.carriage.factory.PassengerCarriageFactory;

public class CarriageGenerator {

	public static Random random = new Random();

	public static BaseCarriage getLocomotive() {
		BaseCarriage carriage = LocomotiveFactory.getCarriage(
				random.nextInt(LocomotiveFactory.TYPE_COUNT) + 1, 
				getNumber(),
				getDate(), 
				getWeight(), 
				random.nextInt(150) + 30);
		return carriage;
	}

	public static BaseCarriage getFreightCarriage() {
		BaseCarriage carriage = FreightCarriageFactory.getCarriage(
				random.nextInt(FreightCarriageFactory.TYPE_COUNT) + 1,
				getNumber(), 
				getDate(), 
				getWeight(),
				(random.nextInt(20) + 1) * 1000);
		((BaseFreightCarriage) carriage).setCurCapacity(random
				.nextInt(((BaseFreightCarriage) carriage).getMaxCapacity()));
		return carriage;
	}

	public static BaseCarriage getPassengerCarriage() {
		BaseCarriage carriage = PassengerCarriageFactory.getCarriage(
				random.nextInt(PassengerCarriageFactory.TYPE_COUNT) + 1,
				getNumber(), 
				getDate(), 
				getWeight(),
				random.nextInt(BasePassengerCarriage.COMFORT_TYPE_COUNT) + 1,
				random.nextInt(100) + 10, 
				random.nextInt(1000) + 500);
		((BasePassengerCarriage) carriage).setPassengerCurCount(random
				.nextInt(((BasePassengerCarriage) carriage).getPassengerMaxCount()+ 1));
		((BasePassengerCarriage) carriage).setBaggageCurWeight(random
				.nextInt(((BasePassengerCarriage) carriage).getBaggageMaxWeight() + 1));
		return carriage;
	}

	private static String getNumber() {
		return String.valueOf((random.nextInt(9) + 1) * 1000
				+ random.nextInt(999));
	}

	private static Date getDate() {
		return new Date();
	}

	private static int getWeight() {
		return random.nextInt(2000) + 3000;
	}

}
