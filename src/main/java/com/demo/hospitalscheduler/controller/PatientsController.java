package com.demo.hospitalscheduler.controller;

import com.demo.hospitalscheduler.model.Schedule;
import com.demo.hospitalscheduler.service.PatientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class PatientsController {

    private PatientsService patientsService;

    @Autowired
    public PatientsController(PatientsService patientsService) {
        this.patientsService = patientsService;
    }

    @GetMapping("/patients")
    public ResponseEntity getPatients() {
        return this.patientsService.getPatients();
    }

    @PostMapping(path = "/patients/{patientId}/schedules")
    public ResponseEntity addSchedule(@PathVariable("patientId") @NotNull Long patientId, @RequestBody @Valid Schedule schedule) {
        return this.patientsService.addSchedule(patientId, schedule);
    }

    @DeleteMapping(path = "/patients/{patientId}/schedules/{scheduleId}")
    public ResponseEntity removeSchedule(@PathVariable("patientId") @NotNull Long patientId, @PathVariable("scheduleId") @NotNull Long scheduleId) {
        return this.patientsService.removeSchedule(patientId, scheduleId);
    }

}
