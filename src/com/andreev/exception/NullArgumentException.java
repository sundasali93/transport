package com.andreev.exception;

public class NullArgumentException extends IllegalArgumentException {

	private static final long serialVersionUID = -4732434632127730662L;

	public NullArgumentException(){
		super();
	}

	public NullArgumentException(Throwable cause){
		super(cause);
	}

	public NullArgumentException(String message){
		super(message);
	}

	public NullArgumentException(String message, Throwable cause){
		super(message, cause);
	}

}
