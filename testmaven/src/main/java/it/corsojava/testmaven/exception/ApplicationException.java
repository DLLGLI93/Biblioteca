package it.corsojava.testmaven.exception;

public class ApplicationException extends Exception {

	private String errorCode;
	
	public ApplicationException() {
	}

	public ApplicationException(String message, String errorCode) {
		super(message);
		this.errorCode = errorCode;
	}

	public ApplicationException(Throwable cause, String errorCode) {
		super(cause);
		this.errorCode = errorCode;
	}

	public ApplicationException(String message, Throwable cause, String errorCode) {
		super(message, cause);
		this.errorCode = errorCode;
	}

	public ApplicationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String errorCode) {
		super(message, cause, enableSuppression, writableStackTrace);
		this.errorCode = errorCode;
	}

}
