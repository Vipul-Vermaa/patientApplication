package com.example.patientApp;


import com.example.patientApp.model.Patient;
import com.example.patientApp.repository.PatientRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class PatientAppApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private PatientRepository patientRepository;

	@BeforeEach
	public void setup() {
		// Clear the patient collection before each test.
		patientRepository.deleteAll();
	}
	@Test
	public void testHomePage() throws Exception {
		mockMvc.perform(get("/"))
				.andExpect(status().isOk())
				.andExpect(view().name("index"));
	}
	@Test
	public void testShowRegistrationForm() throws Exception {
		mockMvc.perform(get("/register"))
				.andExpect(status().isOk())
				.andExpect(view().name("registration"))
				.andExpect(model().attributeExists("patient"));
	}

	@Test
	public void testRegisterPatient() throws Exception {
		mockMvc.perform(post("/register")
						.param("name", "John Doe")
						.param("email", "john@example.com")
						.param("phone", "1234567890")
						.param("medicalHistory", "No known issues"))
				.andExpect(status().isOk())
				.andExpect(model().attributeExists("message"))
				.andExpect(model().attribute("message", equalTo("Patient registered successfully!")));
	}

	@Test
	public void testBookAppointment() throws Exception {
		// First, create a patient so that we have a valid patientId.
		Patient patient = new Patient();
		patient.setName("Jane Doe");
		patient.setEmail("jane@example.com");
		patient.setPhone("0987654321");
		patient.setMedicalHistory("Allergic to penicillin");
		Patient savedPatient = patientRepository.save(patient);

		// Use a valid ISO date-time string (for example: 2025-02-04T10:00:00)
		String dateTime = "2025-02-04T10:00:00";

		mockMvc.perform(post("/appointments/book")
						.param("patientId", savedPatient.getId())
						.param("doctorName", "Dr. Smith")
						.param("dateTime", dateTime))
				.andExpect(status().isOk())
				.andExpect(view().name("appointments"))
				.andExpect(model().attributeExists("message"))
				.andExpect(model().attribute("message", equalTo("Appointment booked successfully!")));
	}
	@Test
	public void testAddMedication() throws Exception {
		// First, create a patient so that we have a valid patientId.
		Patient patient = new Patient();
		patient.setName("Alice");
		patient.setEmail("alice@example.com");
		patient.setPhone("5555555555");
		patient.setMedicalHistory("Diabetic");
		Patient savedPatient = patientRepository.save(patient);

		mockMvc.perform(post("/medications/add")
						.param("patientId", savedPatient.getId())
						.param("name", "Insulin")
						.param("dosage", "5 units")
						.param("instructions", "Before meals"))
				.andExpect(status().isOk())
				.andExpect(view().name("medications"))
				.andExpect(model().attributeExists("message"))
				.andExpect(model().attribute("message", equalTo("Medication added successfully!")));
	}

}
