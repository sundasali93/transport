package com.andreev.exception;

public class OutOfRangeException extends Exception {
	
	private static final long serialVersionUID = 6970843594463494496L;

	public OutOfRangeException(){
		super();
	}
	
	public OutOfRangeException(Throwable cause){
		super(cause);
	}
	
	public OutOfRangeException(String message){
		super(message);
	}
	
	public OutOfRangeException(String message, Throwable cause){
		super(message, cause);
	}
}
