package com.demo.hospitalscheduler.controller;

import com.demo.hospitalscheduler.helper.TestDataHelper;
import com.demo.hospitalscheduler.persistence.repository.PatientRepository;
import com.demo.hospitalscheduler.persistence.repository.ScheduleRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;

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
    private PatientsController patientController;

    @Test
    @DisplayName("Get Patients - Empty List")
    public void getPatients_EmptyList_Success() {
        Mockito.when(this.patientRepository.findAll()).thenReturn(TestDataHelper.generatePatientEntityList(0));
        ResponseEntity response = this.patientController.getPatients();

        verify(this.patientRepository, times(1)).findAll();
        assertNotNull(response);
    }

    @Test
    @DisplayName("Get Patients - List with Single Item")
    public void getPatients_ListWithSingleItem_Success() {
        Mockito.when(this.patientRepository.findAll()).thenReturn(TestDataHelper.generatePatientEntityList(1));
        ResponseEntity response = this.patientController.getPatients();

        verify(this.patientRepository, times(1)).findAll();
        assertNotNull(response);
    }

    @Test
    @DisplayName("Get Patients - List with Multiple Items")
    public void getPatients_ListWithMultipleItem_Success() {
        Mockito.when(this.patientRepository.findAll()).thenReturn(TestDataHelper.generatePatientEntityList(3));
        ResponseEntity response = this.patientController.getPatients();

        verify(this.patientRepository, times(1)).findAll();
        assertNotNull(response);
    }

    @Test
    @DisplayName("Add a Schedule - Patient Not Found")
    public void addSchedule_InvalidPatient_NotFound() {

        long patientId = 1;

        Mockito.when(this.patientRepository.existsById(any())).thenReturn(false);
        ResponseEntity response = this.patientController.addSchedule(Long.valueOf(patientId), TestDataHelper.generateSchedule());

        assertNotNull(response);
        assertEquals(response.getStatusCode(), HttpStatus.NOT_FOUND);
    }

    @Test
    @DisplayName("Add a Schedule")
    public void addSchedule_ValidInput_Success() {

        long patientId = 1;

        Mockito.when(this.patientRepository.existsById(any())).thenReturn(true);
        Mockito.when(this.patientRepository.findById(any())).thenReturn(TestDataHelper.generatePatientEntityWithId(patientId));
        ResponseEntity response = this.patientController.addSchedule(Long.valueOf(patientId), TestDataHelper.generateSchedule());

        verify(this.scheduleRepository, times(1)).save(any());
        assertNotNull(response);
        assertEquals(response.getStatusCode(), HttpStatus.CREATED);
    }

    @Test
    @DisplayName("Add a Past Date Schedule")
    public void addSchedule_PastDate_Failure() {

        long patientId = 1;

        Mockito.when(this.patientRepository.existsById(any())).thenReturn(true);
        ResponseEntity response = this.patientController.addSchedule(Long.valueOf(patientId), TestDataHelper.generatePastSchedule());

        verify(this.scheduleRepository, times(0)).save(any());
        assertNotNull(response);
        assertEquals(response.getStatusCode(), HttpStatus.BAD_REQUEST);
    }

    @Test
    @DisplayName("Add a Schedule - Not Saved if Already Exists")
    public void addSchedule_MultipleSavesOfSameSchedule_NotSaving() {

        long patientId = 1;

        Mockito.when(this.patientRepository.existsById(any())).thenReturn(true);
        Mockito.when(this.scheduleRepository.findByPatientIdAndStartDate(anyLong(), any())).thenReturn(TestDataHelper.generateScheduleEntityList());

        ResponseEntity response = this.patientController.addSchedule(Long.valueOf(patientId), TestDataHelper.generateSchedule());

        verify(this.scheduleRepository, times(0)).save(any());
        assertNotNull(response);
        assertEquals(response.getStatusCode(), HttpStatus.CREATED);
    }

    @Test
    @DisplayName("Remove Schedule - Patient Not Found")
    public void removeSchedule_InvalidPatient_NotFound() {

        long patientId = 1;
        long scheduleId = 1;

        Mockito.when(this.patientRepository.existsById(any())).thenReturn(false);
        ResponseEntity response = this.patientController.removeSchedule(Long.valueOf(patientId), Long.valueOf(scheduleId));

        assertNotNull(response);
        assertEquals(response.getStatusCode(), HttpStatus.NOT_FOUND);
    }

    @Test
    @DisplayName("Remove a Schedule that does not Exist")
    public void removeSchedule_NotFound_NoDeletion() {

        long patientId = 1;
        long scheduleId = 1;

        Mockito.when(this.patientRepository.existsById(any())).thenReturn(true);
        Mockito.when(this.scheduleRepository.findByIdAndPatientId(anyLong(), anyLong())).thenReturn(new ArrayList<>());
        ResponseEntity response = this.patientController.removeSchedule(Long.valueOf(patientId), Long.valueOf(scheduleId));

        verify(this.scheduleRepository, times(0)).deleteById(any());
        assertNotNull(response);
        assertEquals(response.getStatusCode(), HttpStatus.OK);
    }

    @Test
    @DisplayName("Remove a Schedule that Exists")
    public void removeSchedule_ItemFound_Delete() {

        long patientId = 1;
        long scheduleId = 1;

        Mockito.when(this.patientRepository.existsById(any())).thenReturn(true);
        Mockito.when(this.scheduleRepository.findByIdAndPatientId(anyLong(), anyLong())).thenReturn(TestDataHelper.generateScheduleEntityList());
        ResponseEntity response = this.patientController.removeSchedule(Long.valueOf(patientId), Long.valueOf(scheduleId));

        verify(this.scheduleRepository, times(1)).deleteById(any());
        assertNotNull(response);
        assertEquals(response.getStatusCode(), HttpStatus.OK);
    }

}
