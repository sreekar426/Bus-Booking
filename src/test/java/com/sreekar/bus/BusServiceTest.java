package com.sreekar.bus;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class BusServiceTest {

	@LocalServerPort
	private int randomServerPort;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void getBuses() throws JsonMappingException, JsonProcessingException, IOException, URISyntaxException {
		final String baseUrl = "http://localhost:" + randomServerPort + "/search";
		URI uri = new URI(baseUrl);

		BusRequest bus = new BusRequest();
		bus.setDestination("Chennai");
		bus.setSource("Bangalore");
		bus.setReturnDate("");
		bus.setTravelDate("24-06-2020");

		HttpHeaders headers = new HttpHeaders();
		headers.set("X-COM-PERSIST", "true");

		HttpEntity<?> request = new HttpEntity<>(bus, headers);

		ResponseEntity<Object> result = this.restTemplate.postForEntity(uri, request, Object.class);

		// Verify request succeed
		Assert.assertEquals(200, result.getStatusCodeValue());

	}

	@Test
	public void sortByOperator() throws JsonMappingException, JsonProcessingException, IOException, URISyntaxException {
		final String baseUrl = "http://localhost:" + randomServerPort + "/byOperatorName";
		URI uri = new URI(baseUrl);

		BusRequest bus = new BusRequest();
		bus.setDestination("Chennai");
		bus.setSource("Bangalore");
		bus.setReturnDate("");
		bus.setTravelDate("24-06-2020");

		HttpHeaders headers = new HttpHeaders();
		headers.set("X-COM-PERSIST", "true");

		HttpEntity<?> request = new HttpEntity<>(bus, headers);

		ResponseEntity<Object> result = this.restTemplate.postForEntity(uri, request, Object.class);

		// Verify request succeed
		Assert.assertEquals(200, result.getStatusCodeValue());

	}

	@Test
	public void sortByArrival() throws JsonMappingException, JsonProcessingException, IOException, URISyntaxException {
		final String baseUrl = "http://localhost:" + randomServerPort + "/byArrTime";
		URI uri = new URI(baseUrl);

		BusRequest bus = new BusRequest();
		bus.setDestination("Chennai");
		bus.setSource("Bangalore");
		bus.setReturnDate("");
		bus.setTravelDate("24-06-2020");

		HttpHeaders headers = new HttpHeaders();
		headers.set("X-COM-PERSIST", "true");

		HttpEntity<?> request = new HttpEntity<>(bus, headers);

		ResponseEntity<Object> result = this.restTemplate.postForEntity(uri, request, Object.class);

		// Verify request succeed
		Assert.assertEquals(200, result.getStatusCodeValue());

	}

	@Test
	public void sortByDepartue() throws JsonMappingException, JsonProcessingException, IOException, URISyntaxException {
		final String baseUrl = "http://localhost:" + randomServerPort + "/byDepTime";
		URI uri = new URI(baseUrl);

		BusRequest bus = new BusRequest();
		bus.setDestination("Chennai");
		bus.setSource("Bangalore");
		bus.setReturnDate("");
		bus.setTravelDate("24-06-2020");

		HttpHeaders headers = new HttpHeaders();
		headers.set("X-COM-PERSIST", "true");

		HttpEntity<?> request = new HttpEntity<>(bus, headers);

		ResponseEntity<Object> result = this.restTemplate.postForEntity(uri, request, Object.class);

		// Verify request succeed
		Assert.assertEquals(200, result.getStatusCodeValue());

	}

	@Test
	public void sortByDuration() throws JsonMappingException, JsonProcessingException, IOException, URISyntaxException {
		final String baseUrl = "http://localhost:" + randomServerPort + "/byDuration";
		URI uri = new URI(baseUrl);

		BusRequest bus = new BusRequest();
		bus.setDestination("Chennai");
		bus.setSource("Bangalore");
		bus.setReturnDate("");
		bus.setTravelDate("24-06-2020");

		HttpHeaders headers = new HttpHeaders();
		headers.set("X-COM-PERSIST", "true");

		HttpEntity<?> request = new HttpEntity<>(bus, headers);

		ResponseEntity<Object> result = this.restTemplate.postForEntity(uri, request, Object.class);

		// Verify request succeed
		Assert.assertEquals(200, result.getStatusCodeValue());

	}

	@Test
	public void routeNotFound() throws JsonMappingException, JsonProcessingException, IOException, URISyntaxException {
		final String baseUrl = "http://localhost:" + randomServerPort + "/search";
		URI uri = new URI(baseUrl);

		BusRequest bus = new BusRequest();
		bus.setDestination("Delhi");
		bus.setSource("Bangalore");
		bus.setReturnDate("");
		bus.setTravelDate("24-06-2020");

		HttpHeaders headers = new HttpHeaders();
		headers.set("X-COM-PERSIST", "true");

		HttpEntity<?> request = new HttpEntity<>(bus, headers);

		ResponseEntity<Object> result = this.restTemplate.postForEntity(uri, request, Object.class);

		// Verify request succeed
		Assert.assertEquals(404, result.getStatusCodeValue());
	}

	@Test
	public void fieldsRequires() throws JsonMappingException, JsonProcessingException, IOException, URISyntaxException {
		final String baseUrl = "http://localhost:" + randomServerPort + "/search";
		URI uri = new URI(baseUrl);

		BusRequest bus = new BusRequest();
		bus.setDestination("");
		bus.setSource("Bangalore");
		bus.setReturnDate("");
		bus.setTravelDate("24-06-2020");

		HttpHeaders headers = new HttpHeaders();
		headers.set("X-COM-PERSIST", "true");

		HttpEntity<?> request = new HttpEntity<>(bus, headers);

		ResponseEntity<Object> result = this.restTemplate.postForEntity(uri, request, Object.class);

		// Verify request succeed
		Assert.assertEquals(400, result.getStatusCodeValue());
	}

}
