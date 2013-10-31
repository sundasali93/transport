package com.andreev.transport.carriage.exception;

public class CarriageException extends Exception {

	private static final long serialVersionUID = -8041911351665908741L;

	public CarriageException() {
		super();
	}

	public CarriageException(String message) {
		super(message);
	}

	public CarriageException(Throwable cause) {
		super(cause);
	}

	public CarriageException(String message, Throwable cause) {
		super(message, cause);
	}

	public CarriageException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
