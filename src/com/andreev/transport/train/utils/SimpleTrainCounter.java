package com.andreev.transport.train.utils;

import com.andreev.transport.carriage.AbstractCarriage;
import com.andreev.transport.carriage.AbstractFreightCarriage;
import com.andreev.transport.carriage.AbstractPassengerCarriage;
import com.andreev.transport.train.SimpleTrain;

public class SimpleTrainCounter {

	public static int getPassengerCount(SimpleTrain train) {
		int count = 0;
		for (AbstractCarriage ac : train) {
			if (ac instanceof AbstractPassengerCarriage) {
				count += ((AbstractPassengerCarriage) ac).getPassengerCurCount();
			}
		}
		return count;
	}

	public static int getBaggageCount(SimpleTrain train) {
		int count = 0;
		for (AbstractCarriage ac : train) {
			if (ac instanceof AbstractPassengerCarriage) {
				count += ((AbstractPassengerCarriage) ac).getBaggageCurWeight();
			}else if (ac instanceof AbstractFreightCarriage){
				count +=((AbstractFreightCarriage)ac).getCurCapacity();
			}
		}
		return count;
	}

}
