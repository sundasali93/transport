package com.andreev.transport.train.exception;

import com.andreev.transport.carriage.exception.CarriageException;

public class TrainException extends CarriageException {

	private static final long serialVersionUID = -2916567425383013688L;

	public TrainException() {
		super();
	}

	public TrainException(String message) {
		super(message);
	}

	public TrainException(Throwable cause) {
		super(cause);
	}

	public TrainException(String message, Throwable cause) {
		super(message, cause);
	}

	public TrainException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
