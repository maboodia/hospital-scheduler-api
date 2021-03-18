package com.demo.hospitalscheduler;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HospitalSchedulerApiApplicationTests {

	static final String URL_PREFIX = "http://localhost:";
	static final String PATIENTS_CONTEXT_ROOT = "/v1/demo/hospital-scheduling/patients";
	static final String INVALID_PATIENTS_CONTEXT_ROOT = "/v1/demo/hospital-scheduling/patients-not-valid";
	static final String SCHEDULES_URL_PATH = "/schedules";

	@LocalServerPort
	private int port;

	private TestRestTemplate restTemplate;

	@Autowired
	public HospitalSchedulerApiApplicationTests(TestRestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@Test
	void contextLoads() {
	}

	@Test
	@DisplayName("Get All Patients")
	public void Integration_getAllPatients_Success() throws Exception {

		String response = this.restTemplate.getForObject(URL_PREFIX + this.port + PATIENTS_CONTEXT_ROOT,
				String.class);

		assertEquals(new JSONArray(response).length(),10);

	}

	@Test
	@DisplayName("Get All Patients - Invalid URL")
	public void Integration_getAllPatients2_Success() throws Exception {

		assertThat(this.restTemplate.getForObject(URL_PREFIX + this.port + PATIENTS_CONTEXT_ROOT,
				String.class)).contains("Muhamad Aboodia");

		JSONObject response = new JSONObject(this.restTemplate.getForObject(URL_PREFIX + this.port + INVALID_PATIENTS_CONTEXT_ROOT,
				String.class));

		assertEquals(Integer.valueOf(response.get("status").toString()), HttpStatus.NOT_FOUND.value());

	}

}
