package com.demo.hospitalscheduler.service;

import com.demo.hospitalscheduler.model.Doctor;
import com.demo.hospitalscheduler.model.DoctorSchedule;
import com.demo.hospitalscheduler.persistence.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DoctorsServiceImpl implements DoctorsService {

    private DoctorRepository doctorRepository;

    @Autowired
    public DoctorsServiceImpl(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    /*
       Get patients data
    */
    public ResponseEntity getDoctors() {

        List<Doctor> doctors = this.doctorRepository.findAll().stream()
                .map(d -> new Doctor(
                        d.getId(),
                        d.getName(),
                        d.getSchedules().stream()
                                .map(s -> new DoctorSchedule(
                                        s.getId(),
                                        s.getStartDate(),
                                        s.getRequestedOn(),
                                        s.getPatient_Id()
                                )).collect(Collectors.toList()
                        )
                )).collect(Collectors.toList());

        return new ResponseEntity<>(doctors, HttpStatus.OK);
    }

}
