package com.andreev.exception;

public class NotNullException extends Exception {

	private static final long serialVersionUID = -4732434632127730662L;
	
	public NotNullException(){
		super();
	}
	
	public NotNullException(Throwable cause){
		super(cause);
	}
	
	public NotNullException(String message){
		super(message);
	}
	
	public NotNullException(String message, Throwable cause){
		super(message, cause);
	}

}
