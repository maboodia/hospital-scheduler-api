package com.intuit.hospitalscheduler.controller;

import com.intuit.hospitalscheduler.model.Schedule;
import com.intuit.hospitalscheduler.persistence.entity.PatientEntity;
import com.intuit.hospitalscheduler.persistence.entity.ScheduleEntity;
import com.intuit.hospitalscheduler.persistence.repository.PatientRepository;
import com.intuit.hospitalscheduler.persistence.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
public class PatientController {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private ScheduleRepository scheduleRepository;

    @GetMapping("/patients")
    public ResponseEntity getPatients() {
        return new ResponseEntity<List<PatientEntity>>(patientRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping(path = "/schedules/{patientId}")
    public ResponseEntity addSchedule(@PathVariable("patientId") @NotNull Long patientId, @RequestBody @Valid Schedule schedule) {

        if(!patientRepository.existsById(patientId)) {
            return new ResponseEntity<String>("No Patient Found for Id: " + patientId, HttpStatus.NOT_FOUND);
        }

        // Check if schedule was already set for same patient and time
        if (scheduleRepository.findByPatientIdAndStartDate(patientId, schedule.getDate()).isEmpty()) {
            ScheduleEntity s = new ScheduleEntity();
            s.setStartDate(schedule.getDate());
            s.setRequestedOn(schedule.getRequestedOn());
            s.setPatient(patientRepository.findById(patientId).get());
            scheduleRepository.save(s);
        }

        return new ResponseEntity<String>("Successfully Created Schedule for Patient Id: " + patientId, HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/schedules/{scheuleId}")
    public ResponseEntity removeSchedule(@PathVariable("scheuleId") @NotNull Long scheuleId) {

        if(scheduleRepository.existsById(scheuleId)) {
            scheduleRepository.deleteById(scheuleId);
        }

        return ResponseEntity.ok().body("Successfully Deleted Schedule");
    }

}
