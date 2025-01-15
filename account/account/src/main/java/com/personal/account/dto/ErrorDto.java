package com.personal.account.dto;

import java.time.LocalDateTime;

public class ErrorDto {

	int statusCode;
	String message;
	LocalDateTime timeOfException;
	
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public LocalDateTime getTimeOfException() {
		return timeOfException;
	}
	public void setTimeOfException(LocalDateTime timeOfException) {
		this.timeOfException = timeOfException;
	}
	
	public ErrorDto(int statusCode, String message, LocalDateTime timeOfException) {
		super();
		this.statusCode = statusCode;
		this.message = message;
		this.timeOfException = timeOfException;
	}	
}
