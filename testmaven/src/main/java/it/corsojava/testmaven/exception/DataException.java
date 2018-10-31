package it.corsojava.testmaven.exception;

public class DataException extends ApplicationException {
	/***
	 * errore lanciata in caso di errore di validazione dei
	 * campi di input nella UI
	 */

	public DataException() {
	}

	public DataException(String message, String errorCode) {
		super(message, errorCode);
		}

	public DataException(Throwable cause, String errorCode) {
		super(cause, errorCode);
		}

	public DataException(String message, Throwable cause, String errorCode) {
		super(message, cause, errorCode);
		
	}

	public DataException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String errorCode) {
		super(message, cause, enableSuppression, writableStackTrace, errorCode);
	}

}

