package com.sreekar.bus;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class BusRequest {

	@NotNull(message = "Source cannot be missing or empty")
	@Size(min = 2, message = "Source must not be less than 2 characters")
	private String source;
	@NotNull(message = "Destination cannot be missing or empty")
	@Size(min = 2, message = "Destination must not be less than 2 characters")
	private String destination;
	@NotNull(message = "From Date cannot be missing or empty")
	@Size(min = 2, message = "From Date must not be less than 2 characters")
	private String travelDate;
	private String returnDate;

}
