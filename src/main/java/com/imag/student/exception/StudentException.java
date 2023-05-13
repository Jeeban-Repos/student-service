package com.imag.student.exception;

import java.util.Map;

public class StudentException {

	private Map<String, String> exceptionData;
	private String statusCode;
	private String exceptionMessage;
	
	public StudentException(Map<String, String> exceptionData, String statusCode) {
		this.exceptionData = exceptionData;
		this.statusCode = statusCode;
	}
	

	public StudentException(String statusCode, String exceptionMessage) {
		super();
		this.statusCode = statusCode;
		this.exceptionMessage = exceptionMessage;
	}



	public Map<String, String> getExceptionData() {
		return exceptionData;
	}

	public void setExceptionData(Map<String, String> exceptionData) {
		this.exceptionData = exceptionData;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}


	public String getExceptionMessage() {
		return exceptionMessage;
	}


	public void setExceptionMessage(String exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}
	
	
}
