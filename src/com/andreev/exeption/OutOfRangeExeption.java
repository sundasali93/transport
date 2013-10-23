package com.andreev.exeption;

public class OutOfRangeExeption extends Exception {
	
	private static final long serialVersionUID = 6970843594463494496L;

	public OutOfRangeExeption(){
		super();
	}
	
	public OutOfRangeExeption(Throwable cause){
		super(cause);
	}
	
	public OutOfRangeExeption(String message){
		super(message);
	}
	
	public OutOfRangeExeption(String message, Throwable cause){
		super(message, cause);
	}
}
