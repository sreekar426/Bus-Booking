package com.sreekar.bus;

import lombok.Data;

@Data
public class BusResponse {

	private String busNo;
	private String operator;
	private String departureTime;
	private String arrivalTime;
	private String duration;
	private String price;
	private String resultsCount;

}
