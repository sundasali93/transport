package com.andreev.transport.train.utils;

import java.util.ArrayList;
import java.util.List;

import com.andreev.transport.carriage.AbstractCarriage;
import com.andreev.transport.carriage.AbstractPassengerCarriage;
import com.andreev.transport.train.SimpleTrain;

public class SimpleTrainFinder {

	public static List<AbstractCarriage> findCarriages(SimpleTrain train,
			int minPassengerCount, int maxPassengerCount) {
		List<AbstractCarriage> list = new ArrayList<>();
		for (AbstractCarriage ac : train.getTrainList()) {
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
