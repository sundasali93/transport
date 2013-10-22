package com.andreev.transport.console;

import java.util.Iterator;

import com.andreev.transport.carriage.BaseCarriage;
import com.andreev.transport.train.SimpleTrain;
import com.andreev.transport.train.generator.SimpleTrainGenerator;


public class Main {

	public static void main(String[] args) {
		SimpleTrain train = SimpleTrainGenerator.getTrain();
		Iterator<BaseCarriage> iterator = train.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
	}

}
