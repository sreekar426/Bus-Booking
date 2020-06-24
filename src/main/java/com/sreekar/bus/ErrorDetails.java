package com.sreekar.bus;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class ErrorDetails {
	private Date timestamp;
	private String message;
	private String details;
	private List<String> errors;

	public ErrorDetails(Date timestamp, String message, String details) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}
	
	public ErrorDetails(Date timestamp, String message, String details, List<String> error) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
		this.errors=error;
	}
}