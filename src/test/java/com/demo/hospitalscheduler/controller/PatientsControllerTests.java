package com.demo.hospitalscheduler.controller;

import com.demo.hospitalscheduler.helper.TestDataHelper;
import com.demo.hospitalscheduler.model.Schedule;
import com.demo.hospitalscheduler.service.PatientsService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
public class PatientsControllerTests {

    @Mock
    private PatientsService patientsService;

    @InjectMocks
    private PatientsController patientController;

    @Test
    @DisplayName("Get Patients")
    public void getPatients_CallService_Success() {

        this.patientController.getPatients();
        verify(this.patientsService, times(1)).getPatients();

    }

    @Test
    @DisplayName("Add Patient")
    public void addSchedule_CallService_Success() {

        long patientId = 1;
        Schedule schedule = TestDataHelper.generateSchedule();

        this.patientController.addSchedule(patientId, schedule);
        verify(this.patientsService, times(1)).addSchedule(patientId, schedule);

    }

    @Test
    @DisplayName("Remove Patient")
    public void removeSchedule_CallService_Success() {

        long patientId = 1;
        long scheduleId = 1;

        this.patientController.removeSchedule(patientId, scheduleId);
        verify(this.patientsService, times(1)).removeSchedule(patientId, scheduleId);

    }

}
