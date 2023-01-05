package com.capeelectric.exception;

public class UpdateHistoryException {

	private static final long serialVersionUID = 1L;
	private String message;

	public UpdateHistoryException() {

	}
	public UpdateHistoryException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
