package com.demo.hospitalscheduler;

import com.demo.hospitalscheduler.helper.TestDataHelper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HospitalSchedulerApiIntegrationTests {

	static final String URL_PREFIX = "http://localhost:";
	static final String PATIENTS_CONTEXT_ROOT = "/v1/demo/hospital-scheduling/patients";
	static final String INVALID_PATIENTS_CONTEXT_ROOT = "/v1/demo/hospital-scheduling/patients-not-valid";
	static final String DOCTORS_CONTEXT_ROOT = "/v1/demo/hospital-scheduling/doctors";
	static final String INVALID_DOCTORS_CONTEXT_ROOT = "/v1/demo/hospital-scheduling/doctors-not-valid";
	static final String SCHEDULES_URL_PATH = "/schedules/";

	@LocalServerPort
	private int port;

	private TestRestTemplate restTemplate;

	@Autowired
	public HospitalSchedulerApiIntegrationTests(TestRestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@Test
	@DisplayName("Get All Doctors")
	public void getAllDoctors_ValidRequest_Success() {

		ResponseEntity<String> response = this.restTemplate.getForEntity(URL_PREFIX + this.port + DOCTORS_CONTEXT_ROOT,
				String.class);

		assertEquals(HttpStatus.OK.value(), response.getStatusCode().value());
		assertTrue(response.getBody().contains("Purvi Shangvi"));

	}

	@Test
	@DisplayName("Get All Doctors - Invalid URL")
	public void getAllDoctors_InvalidPath_NotFound() {

		ResponseEntity<String> response = this.restTemplate.getForEntity(URL_PREFIX + this.port + INVALID_DOCTORS_CONTEXT_ROOT,
				String.class);

		assertEquals(HttpStatus.NOT_FOUND.value(), response.getStatusCode().value());

	}

	@Test
	@DisplayName("Get All Patients")
	public void getAllPatients_ValidRequest_Success() {

		ResponseEntity<String> response = this.restTemplate.getForEntity(URL_PREFIX + this.port + PATIENTS_CONTEXT_ROOT,
				String.class);

		assertEquals(HttpStatus.OK.value(), response.getStatusCode().value());
		assertTrue(response.getBody().contains("Muhamad Aboodia"));

	}

	@Test
	@DisplayName("Get All Patients - Invalid URL")
	public void getAllPatients_InvalidPath_NotFound() {

		ResponseEntity<String> response = this.restTemplate.getForEntity(URL_PREFIX + this.port + INVALID_PATIENTS_CONTEXT_ROOT,
				String.class);

		assertEquals(HttpStatus.NOT_FOUND.value(), response.getStatusCode().value());

	}

	@Test
	@DisplayName("Add Schedule - Patient Id Not Found")
	public void addSchedule_InvalidPatient_NotFound() {

		long invalidPatientId = 9999;

		ResponseEntity<String> response = this.restTemplate.postForEntity(URL_PREFIX + this.port + PATIENTS_CONTEXT_ROOT + "/" + invalidPatientId + SCHEDULES_URL_PATH,
				TestDataHelper.generateSchedule(),
				String.class);

		assertEquals(HttpStatus.NOT_FOUND.value(), response.getStatusCode().value());
		assertTrue(response.getBody().contains("No Patient Found for Id"));

	}

	@Test
	@DisplayName("Add Schedule - Past Schedule")
	public void addSchedule_PastSchedule_BadRequest() {

		long patientId = 1;

		ResponseEntity<String> response = this.restTemplate.postForEntity(URL_PREFIX + this.port + PATIENTS_CONTEXT_ROOT + "/" + patientId + SCHEDULES_URL_PATH,
				TestDataHelper.generatePastSchedule(),
				String.class);

		System.out.println(response.toString());

		assertEquals(HttpStatus.BAD_REQUEST.value(), response.getStatusCode().value());
		assertTrue(response.getBody().contains("Input Date is in the Past"));

	}

	@Test
	@DisplayName("Add Schedule - Valid Input")
	public void addSchedule_validPatient_Success() {

		long patientId = 1;

		ResponseEntity<String> response = this.restTemplate.postForEntity(URL_PREFIX + this.port + PATIENTS_CONTEXT_ROOT + "/" + patientId + SCHEDULES_URL_PATH,
				TestDataHelper.generateSchedule(),
				String.class);

		assertEquals(HttpStatus.CREATED.value(), response.getStatusCode().value());
		assertTrue(response.getBody().contains("Schedule Created for Patient Id"));

	}

	@Test
	@DisplayName("Remove Schedule - Patient Id Not Found")
	public void removeSchedule_InvalidPatient_NotFound() {

		long invalidPatientId = 9999;
		long scheduleId = 1;

		ResponseEntity<String> response = this.restTemplate.exchange(URL_PREFIX + this.port + PATIENTS_CONTEXT_ROOT + "/" + invalidPatientId + SCHEDULES_URL_PATH + scheduleId,
				HttpMethod.DELETE,
				null,
				String.class);

		assertEquals(HttpStatus.NOT_FOUND.value(), response.getStatusCode().value());
		assertTrue(response.getBody().contains("No Patient Found for Id"));

	}

	@Test
	@DisplayName("Remove Schedule - Schedule Not Found")
	public void removeSchedule_ScheduleNotFound_Success() {

		long patientId = 1;
		long scheduleId = 9999;

		ResponseEntity<String> response = this.restTemplate.exchange(URL_PREFIX + this.port + PATIENTS_CONTEXT_ROOT + "/" + patientId + SCHEDULES_URL_PATH + scheduleId,
				HttpMethod.DELETE,
				null,
				String.class);

		assertEquals(HttpStatus.OK.value(), response.getStatusCode().value());
		assertTrue(response.getBody().contains("Deleted Schedule for Patient Id"));

	}

	@Test
	@DisplayName("Remove Schedule - Valid Request")
	public void removeSchedule_ValidRequest_Success() {

		long patientId = 1;
		long scheduleId = 1;

		ResponseEntity<String> response = this.restTemplate.exchange(URL_PREFIX + this.port + PATIENTS_CONTEXT_ROOT + "/" + patientId + SCHEDULES_URL_PATH + scheduleId,
				HttpMethod.DELETE,
				null,
				String.class);

		assertEquals(HttpStatus.OK.value(), response.getStatusCode().value());
		assertTrue(response.getBody().contains("Deleted Schedule for Patient Id"));

	}

}
