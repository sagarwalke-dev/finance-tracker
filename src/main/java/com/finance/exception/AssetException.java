package com.finance.exception;

public class AssetException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AssetException() {
		super();
	}

	public AssetException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public AssetException(String message, Throwable cause) {
		super(message, cause);
	}

	public AssetException(String message) {
		super(message);
	}

	public AssetException(Throwable cause) {
		super(cause);
	}

}
