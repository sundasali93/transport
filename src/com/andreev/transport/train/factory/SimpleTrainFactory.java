package com.andreev.transport.train.factory;

import org.apache.log4j.Logger;

import com.andreev.transport.train.SimpleTrain;
import com.andreev.transport.train.exception.TrainException;

public class SimpleTrainFactory {

	private static final Logger LOG = Logger
			.getLogger(SimpleTrainFactory.class);

	public static SimpleTrain newSimpleTrain(int id, int number)
			throws TrainException {
		SimpleTrain st = new SimpleTrain(id, number);
		LOG.debug("New SimpleTrain created");
		return st;
	}

	public static SimpleTrain newSimpleTrain(int id)
			throws TrainException {
		return newSimpleTrain(id, 0);
	}

}
