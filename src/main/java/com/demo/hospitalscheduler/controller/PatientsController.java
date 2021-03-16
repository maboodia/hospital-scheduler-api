package com.demo.hospitalscheduler.controller;

import com.demo.hospitalscheduler.model.Schedule;
import com.demo.hospitalscheduler.persistence.repository.PatientRepository;
import com.demo.hospitalscheduler.persistence.entity.PatientEntity;
import com.demo.hospitalscheduler.persistence.entity.ScheduleEntity;
import com.demo.hospitalscheduler.persistence.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class PatientsController {

    private PatientRepository patientRepository;

    private ScheduleRepository scheduleRepository;

    @Autowired
    public PatientsController(PatientRepository patientRepository, ScheduleRepository scheduleRepository) {
        this.patientRepository = patientRepository;
        this.scheduleRepository = scheduleRepository;
    }

    @GetMapping("/patients")
    public ResponseEntity getPatients() {
        return new ResponseEntity<List<PatientEntity>>(this.patientRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping(path = "/patients/{patientId}/schedules")
    public ResponseEntity addSchedule(@PathVariable("patientId") @NotNull Long patientId, @RequestBody @Valid Schedule schedule) {

        if(!this.patientRepository.existsById(patientId)) {
            return new ResponseEntity<String>("No Patient Found for Id: " + patientId, HttpStatus.NOT_FOUND);
        }

        // Check if schedule was already set for same patient and time
        if (this.scheduleRepository.findByPatientIdAndStartDate(patientId, schedule.getDate()).isEmpty()) {
            ScheduleEntity s = new ScheduleEntity();
            s.setStartDate(schedule.getDate());
            s.setRequestedOn(schedule.getRequestedOn());
            s.setPatient(this.patientRepository.findById(patientId).get());
            this.scheduleRepository.save(s);
        }

        return new ResponseEntity<String>("Schedule Created for Patient Id: " + patientId, HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/patients/{patientId}/schedules/{scheuleId}")
    public ResponseEntity removeSchedule(@PathVariable("patientId") @NotNull Long patientId, @PathVariable("scheuleId") @NotNull Long scheuleId) {

        if(!this.scheduleRepository.findByIdAndPatientId(scheuleId, patientId).isEmpty()) {
            this.scheduleRepository.deleteById(scheuleId);
        }

        return ResponseEntity.ok().body("Schedule Deleted Schedule for Patient Id: " + patientId);
    }

}
