package com.andreev.transport.train.factory;

import org.apache.log4j.Logger;

import com.andreev.exception.OutOfRangeException;
import com.andreev.transport.train.SimpleTrain;

public class SimpleTrainFactory {
	
	private static final Logger log = Logger
			.getLogger(SimpleTrainFactory.class);
	
	public static SimpleTrain newSimpleTrain(int id, int number)
			throws OutOfRangeException {
		SimpleTrain st = new SimpleTrain(id, number);
		log.debug("New SimpleTrain created");
		return st;
	}

}
