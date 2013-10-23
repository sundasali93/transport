package com.andreev.exeption;

public class OutOfRangeExeption extends IllegalArgumentException {

	private static final long serialVersionUID = 1L;
	
	public OutOfRangeExeption(){
		super();
	}
	
	public OutOfRangeExeption(String string){
		super(string);
	}
	
	public OutOfRangeExeption(int value, int a, int b) {
		super("Value is out of range [" + a + ", " + b + "]");
	}

}
