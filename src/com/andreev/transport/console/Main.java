package com.andreev.transport.console;

import com.andreev.transport.carriage.BaseCarriage;
import com.andreev.transport.train.SimpleTrain;
import com.andreev.transport.train.generator.SimpleTrainGenerator;
import com.andreev.transport.train.utils.TrainSorter;


public class Main {

	public static void main(String[] args) {
		SimpleTrain train = SimpleTrainGenerator.getTrain();
		showTrain(train);
		TrainSorter.sort(train, TrainSorter.TypeComparator);
		showTrain(train);
	}
	
	public static void showTrain(SimpleTrain train){
		System.out.println("----------------------------------");
		for(BaseCarriage bc : train.getTrain()){
			System.out.println(bc);
		}
		System.out.println("----------------------------------");
	}

}
