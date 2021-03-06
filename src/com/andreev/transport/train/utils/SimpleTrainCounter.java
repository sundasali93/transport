package com.andreev.transport.train.utils;

import org.apache.log4j.Logger;

import com.andreev.transport.carriage.AbstractCarriage;
import com.andreev.transport.carriage.AbstractFreightCarriage;
import com.andreev.transport.carriage.AbstractPassengerCarriage;
import com.andreev.transport.train.SimpleTrain;

public class SimpleTrainCounter {

	private static final Logger LOG = Logger
			.getLogger(SimpleTrainCounter.class);

	public static int getPassengerCount(SimpleTrain train) {
		if(train == null){
			LOG.error("Train is null");
			throw new IllegalArgumentException("Train is null");
		}
		int count = 0;
		for (AbstractCarriage ac : train) {
			if (ac instanceof AbstractPassengerCarriage) {
				count += ((AbstractPassengerCarriage) ac).getPassengerCurCount();
			}
		}
		return count;
	}

	public static int getBaggageCount(SimpleTrain train) {
		if(train == null){
			LOG.error("Train is null");
			throw new IllegalArgumentException("Train is null");
		}
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
