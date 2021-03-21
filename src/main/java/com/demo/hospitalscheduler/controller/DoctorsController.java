package com.demo.hospitalscheduler.controller;

import com.demo.hospitalscheduler.service.DoctorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class DoctorsController {

    private DoctorsService doctorsService;

    @Autowired
    public DoctorsController(DoctorsService doctorsService) {
        this.doctorsService = doctorsService;
    }

    @GetMapping("/doctors")
    public ResponseEntity getPatients() {
        return this.doctorsService.getDoctors();
    }

}
