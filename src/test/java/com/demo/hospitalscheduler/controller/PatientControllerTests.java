package com.demo.hospitalscheduler.controller;

import com.demo.hospitalscheduler.helper.TestDataHelper;
import com.demo.hospitalscheduler.persistence.repository.PatientRepository;
import com.demo.hospitalscheduler.persistence.repository.ScheduleRepository;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
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
        Mockito.when(this.patientRepository.findAll()).thenReturn(TestDataHelper.generatePatientEntityList(0));
        ResponseEntity response = this.patientController.getPatients();

        verify(this.patientRepository, times(1)).findAll();
        assertNotNull(response);
    }

    @Test
    public void getPatients_ListWithSingleItem_Success() {
        Mockito.when(this.patientRepository.findAll()).thenReturn(TestDataHelper.generatePatientEntityList(1));
        ResponseEntity response = this.patientController.getPatients();

        verify(this.patientRepository, times(1)).findAll();
        assertNotNull(response);
    }

    @Test
    public void getPatients_ListWithMultipleItem_Success() {
        Mockito.when(this.patientRepository.findAll()).thenReturn(TestDataHelper.generatePatientEntityList(3));
        ResponseEntity response = this.patientController.getPatients();

        verify(this.patientRepository, times(1)).findAll();
        assertNotNull(response);
    }

    @Test
    public void addSchedule_SingleItem_NotFound() {

        long patientId = 1;

        Mockito.when(this.patientRepository.existsById(any())).thenReturn(false);
        ResponseEntity response = this.patientController.addSchedule(Long.valueOf(patientId), TestDataHelper.generateSchedule());

        assertNotNull(response);
        assertEquals(response.getStatusCode(), HttpStatus.NOT_FOUND);
    }

    @Test
    public void addSchedule_SingleItem_Success() {

        long patientId = 1;

        Mockito.when(this.patientRepository.existsById(any())).thenReturn(true);
        Mockito.when(this.patientRepository.findById(any())).thenReturn(TestDataHelper.generatePatientEntityWithId(patientId));
        ResponseEntity response = this.patientController.addSchedule(Long.valueOf(patientId), TestDataHelper.generateSchedule());

        verify(this.scheduleRepository, times(1)).save(any());
        assertNotNull(response);
        assertEquals(response.getStatusCode(), HttpStatus.CREATED);
    }

    @Test
    public void addSchedule_MultipleSavesOfSameSchedule_Success() {

        long patientId = 1;

        Mockito.when(this.patientRepository.existsById(any())).thenReturn(true);
        Mockito.when(this.scheduleRepository.findByPatientIdAndStartDate(anyLong(), any())).thenReturn(TestDataHelper.generateScheduleEntityList());

        ResponseEntity response = this.patientController.addSchedule(Long.valueOf(patientId), TestDataHelper.generateSchedule());

        verify(this.scheduleRepository, times(0)).save(any());
        assertNotNull(response);
        assertEquals(response.getStatusCode(), HttpStatus.CREATED);
    }

    @Test
    public void remmoveSchedule_SingleItem_NotFound() {

        long scheduleId = 1;

        Mockito.when(this.scheduleRepository.existsById(any())).thenReturn(false);
        ResponseEntity response = this.patientController.removeSchedule(Long.valueOf(scheduleId));

        assertNotNull(response);
        assertEquals(response.getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void remmoveSchedule_SingleItem_ItemFound() {

        long scheduleId = 1;

        Mockito.when(this.scheduleRepository.existsById(any())).thenReturn(true);
        ResponseEntity response = this.patientController.removeSchedule(Long.valueOf(scheduleId));

        assertNotNull(response);
        assertEquals(response.getStatusCode(), HttpStatus.OK);
    }

}
