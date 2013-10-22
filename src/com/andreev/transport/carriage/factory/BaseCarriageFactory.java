package com.andreev.transport.carriage.factory;

public abstract class BaseCarriageFactory {
	
	private static int idCount = 0;
	
	protected static int getId(){
		return ++idCount;
	}

}
