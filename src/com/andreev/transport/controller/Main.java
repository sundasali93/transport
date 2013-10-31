package com.andreev.transport.controller;

import org.apache.log4j.Logger;

import com.andreev.transport.train.SimpleTrain;
import com.andreev.transport.train.generator.SimpleTrainGenerator;
import com.andreev.transport.train.utils.SimpleTrainCounter;
import com.andreev.transport.train.utils.SimpleTrainFinder;
import com.andreev.transport.train.utils.SimpleTrainSorter;

public class Main {

	private static final Logger LOG = Logger.getLogger(Main.class);

	public static void main(String[] args) {
		LOG.info("Application start");

		SimpleTrain train = SimpleTrainGenerator.generateTrain();

		System.out.println(train);

		SimpleTrainSorter.sort(train, SimpleTrainSorter.TypeComparator);
		System.out.println(train);

		System.out.println("Total Passengers: "
				+ SimpleTrainCounter.getPassengerCount(train));
		System.out.println("Total Baggage Weight: "
				+ SimpleTrainCounter.getBaggageCount(train));

		int min = 5;
		int max = 20;
		System.out.println("\nCarriages with the Count of Passengers between "
				+ min + " and " + max + ":");
		System.out.println(SimpleTrainFinder.findCarriages(train, min, max));
		LOG.info("Application stop");
	}

}
