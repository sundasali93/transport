package com.andreev.transport.controller;

import com.andreev.transport.train.SimpleTrain;
import com.andreev.transport.train.generator.SimpleTrainGenerator;
import com.andreev.transport.train.utils.SimpleTrainSorter;


public class Main {

	public static void main(String[] args) {
		SimpleTrain train = SimpleTrainGenerator.getTrain();
		System.out.println(train);
		SimpleTrainSorter.sort(train, SimpleTrainSorter.TypeComparator);
		System.out.println(train);
	}

}
