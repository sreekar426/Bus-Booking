package com.sreekar.bus;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value="Online Booking", description="Online Ticket Booking")
public class BookingController {

	@ApiOperation(value = "search for buses", response = BusResponse.class)
	@PostMapping("/search")
	ResponseEntity<List<BusResponse>> getBusDetails(@Valid @RequestBody BusRequest busRequest)
			throws JsonMappingException, JsonProcessingException, IOException {

		return ResponseEntity.ok(DefaultCompare(getSearchBuses(busRequest)));
	}

	@ApiOperation(value = "search buses orderd by operator",response = ResponseEntity.class)
	@PostMapping("/byOperatorName")
	ResponseEntity<List<BusResponse>> sortOperator(@Valid @RequestBody BusRequest busRequest)
			throws JsonMappingException, JsonProcessingException, IOException {

		return ResponseEntity.ok(operatorSort(getSearchBuses(busRequest)));

	}

	@ApiOperation(value = "search buses orderd by Departue",response = BusResponse.class)
	@PostMapping("/byDepTime")
	ResponseEntity<List<BusResponse>> sortDepTime(@Valid @RequestBody BusRequest busRequest)
			throws JsonMappingException, JsonProcessingException, IOException {
		return ResponseEntity.ok(depSort(getSearchBuses(busRequest)));

	}

	@ApiOperation(value = "search buses orderd by Arrival",response = BusResponse.class)
	@PostMapping("/byArrTime")
	ResponseEntity<List<BusResponse>> sortArrTime(@Valid @RequestBody BusRequest busRequest)
			throws JsonMappingException, JsonProcessingException, IOException {
		return ResponseEntity.ok(arrSort(getSearchBuses(busRequest)));

	}

	@ApiOperation(value = "search buses orderd by Journey Duration",response = BusResponse.class)
	@PostMapping("/byDuration")
	ResponseEntity<List<BusResponse>> sortDuration(@Valid @RequestBody BusRequest busRequest)
			throws JsonMappingException, JsonProcessingException, IOException {
		return ResponseEntity.ok(durationSort(getSearchBuses(busRequest)));

	}

	private List<BusResponse> getSearchBuses(BusRequest busRequest)
			throws JsonMappingException, JsonProcessingException, IOException {

		ObjectMapper oB = new ObjectMapper();
		oB.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);

		try {
			return Arrays.asList(oB.readValue(
					new String(Files.readAllBytes(Paths.get(System.getProperty("user.dir") + "/src/main/resources/data/"
							+ busRequest.getSource() + "-" + busRequest.getDestination() + ".txt"))),
					BusResponse[].class));
		} catch (NoSuchFileException ex) {
			throw new RouteNotFoundException("At this time we are not providing service in the selcted route");
		}

	}

	private List<BusResponse> DefaultCompare(List<BusResponse> busResp) {
		Comparator<BusResponse> compareById = (BusResponse o1, BusResponse o2) -> o1.getPrice()
				.compareTo(o2.getPrice());

		Collections.sort(busResp, compareById);
		return busResp;
	}

	private List<BusResponse> operatorSort(List<BusResponse> busResp) {
		Comparator<BusResponse> compareById = (BusResponse o1, BusResponse o2) -> o1.getOperator()
				.compareTo(o2.getOperator());

		Collections.sort(busResp, compareById);
		return busResp;
	}

	private List<BusResponse> arrSort(List<BusResponse> busResp) {
		Comparator<BusResponse> compareById = (BusResponse o1, BusResponse o2) -> o1.getArrivalTime()
				.compareTo(o2.getArrivalTime());

		Collections.sort(busResp, compareById);
		return busResp;
	}

	private List<BusResponse> depSort(List<BusResponse> busResp) {
		Comparator<BusResponse> compareById = (BusResponse o1, BusResponse o2) -> o1.getDepartureTime()
				.compareTo(o2.getDepartureTime());

		Collections.sort(busResp, compareById);
		return busResp;
	}

	private List<BusResponse> durationSort(List<BusResponse> busResp) {
		Comparator<BusResponse> compareById = (BusResponse o1, BusResponse o2) -> o1.getDuration()
				.compareTo(o2.getDuration());

		Collections.sort(busResp, compareById);
		return busResp;
	}

}
