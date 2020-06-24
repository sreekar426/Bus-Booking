package com.sreekar.bus;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class BusNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public BusNotFoundException(String exception) {
		super(exception);
	}

}