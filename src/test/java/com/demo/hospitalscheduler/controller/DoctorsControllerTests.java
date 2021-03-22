package com.demo.hospitalscheduler.controller;

import com.demo.hospitalscheduler.service.DoctorsService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
public class DoctorsControllerTests {

    @Mock
    private DoctorsService doctorsService;

    @InjectMocks
    private DoctorsController doctorsController;

    @Test
    @DisplayName("Get Doctors")
    public void getDoctors_CallService_Success() {

        this.doctorsController.getPatients();
        verify(this.doctorsService, times(1)).getDoctors();

    }

}
