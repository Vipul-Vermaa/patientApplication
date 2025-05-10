package com.example.patientApp.repository;

import com.example.patientApp.model.Appointment;
import com.example.patientApp.model.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;


@Repository
public interface AppointmentRepository extends MongoRepository<Appointment, String> {

    boolean existsByPatientAndDoctorNameAndAppointmentDateTime(Patient patient, String doctorName, LocalDateTime appointmentDateTime);
}
