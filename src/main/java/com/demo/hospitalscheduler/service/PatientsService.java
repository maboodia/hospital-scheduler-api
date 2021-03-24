package com.demo.hospitalscheduler.service;

import com.demo.hospitalscheduler.model.Schedule;
import org.springframework.http.ResponseEntity;

public interface PatientsService {

    ResponseEntity getPatients();

    ResponseEntity addSchedule(Long patientId, Schedule schedule);

    ResponseEntity removeSchedule(Long patientId, Long scheduleId);

}
