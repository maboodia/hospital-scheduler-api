package com.demo.hospitalscheduler.service;

import com.demo.hospitalscheduler.model.Schedule;
import com.demo.hospitalscheduler.persistence.entity.ScheduleEntity;
import com.demo.hospitalscheduler.persistence.repository.PatientRepository;
import com.demo.hospitalscheduler.persistence.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;

@Service
public class PatientsService {

    private PatientRepository patientRepository;

    private ScheduleRepository scheduleRepository;

    @Autowired
    public PatientsService(PatientRepository patientRepository, ScheduleRepository scheduleRepository) {
        this.patientRepository = patientRepository;
        this.scheduleRepository = scheduleRepository;
    }

    /*
       Get patients data
    */
    public ResponseEntity getPatients() {
        return new ResponseEntity<>(this.patientRepository.findAll(), HttpStatus.OK);
    }

    /*
       Add a schedule
    */
    public ResponseEntity addSchedule(Long patientId, Schedule schedule) {

        if(!this.patientRepository.existsById(patientId)) {
            return new ResponseEntity<>("No Patient Found for Id: " + patientId, HttpStatus.NOT_FOUND);
        }

        if(schedule.getDate().compareTo(ZonedDateTime.now()) < 0) {
            return new ResponseEntity<>("Input Date is in the Past !", HttpStatus.BAD_REQUEST);
        }

        // Check if schedule was already set for same patient and time
        if (this.scheduleRepository.findByPatientIdAndStartDate(patientId, schedule.getDate()).isEmpty()) {
            ScheduleEntity s = new ScheduleEntity();
            s.setStartDate(schedule.getDate());
            s.setRequestedOn(schedule.getRequestedOn());
            s.setPatient(this.patientRepository.findById(patientId).get());
            this.scheduleRepository.save(s);
        }

        return new ResponseEntity<>("Schedule Created for Patient Id: " + patientId, HttpStatus.CREATED);
    }

    /*
        Remove a schedule
     */
    public ResponseEntity removeSchedule(Long patientId, Long scheuleId) {

        if(!this.patientRepository.existsById(patientId)) {
            return new ResponseEntity<>("No Patient Found for Id: " + patientId, HttpStatus.NOT_FOUND);
        }

        if(!this.scheduleRepository.findByIdAndPatientId(scheuleId, patientId).isEmpty()) {
            this.scheduleRepository.deleteById(scheuleId);
        }

        return ResponseEntity.ok().body("Deleted Schedule for Patient Id: " + patientId);
    }
}
