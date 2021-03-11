package com.intuit.hospitalscheduler.controller;

import com.intuit.hospitalscheduler.persistence.repository.PatientRepository;
import com.intuit.hospitalscheduler.persistence.repository.ScheduleRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PatientControllerTests {

    @Mock
    private PatientRepository patientRepository;

    @Mock
    private ScheduleRepository scheduleRepository;

    @InjectMocks
    private PatientController patientController;

    @Test
    public void getPatients_EmptyList_Success() {
        Mockito.when(this.patientRepository.findAll()).thenReturn(new ArrayList<>());
        //when(this.patientRepository.findAll()).thenReturn(new ArrayList<>());
        ResponseEntity response = this.patientController.getPatients();

        verify(this.patientRepository, times(1)).findAll();
        assertNotNull(response);
    }

}
