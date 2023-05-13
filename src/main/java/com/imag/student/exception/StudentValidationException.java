package com.imag.student.exception;

public class StudentValidationException extends RuntimeException {

	private static final long serialVersionUID = 7442533167160776081L;

	private String exceptionMessage;

	public StudentValidationException() {
	}

	public StudentValidationException(String exception) {
		super(exception);
		this.exceptionMessage = exception;
	}
	

	public String getExceptionMessage() {
		return exceptionMessage;
	}

	public void setExceptionMessage(String exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}

}
