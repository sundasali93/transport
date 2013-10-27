package com.andreev.transport.train.utils;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.andreev.exception.NullArgumentException;
import com.andreev.transport.carriage.AbstractCarriage;
import com.andreev.transport.carriage.AbstractPassengerCarriage;
import com.andreev.transport.train.SimpleTrain;

public class SimpleTrainFinder {

	private static final Logger log = Logger.getLogger(SimpleTrainFinder.class);

	public static List<AbstractCarriage> findCarriages(SimpleTrain train,
			int minPassengerCount, int maxPassengerCount) {
		if(train == null){
			NullArgumentException e = new NullArgumentException("Train is null");
			log.error("Can't find carriage",e);
			throw new RuntimeException(e);
		}
		List<AbstractCarriage> list = new ArrayList<AbstractCarriage>();
		for (AbstractCarriage ac : train) {
			if (ac instanceof AbstractPassengerCarriage) {
				AbstractPassengerCarriage apc = (AbstractPassengerCarriage) ac;
				if ((apc.getPassengerCurCount() >= minPassengerCount)
						&& (apc.getPassengerCurCount() <= maxPassengerCount)) {
					list.add(apc);
				}
			}
		}
		return list;
	}

}
