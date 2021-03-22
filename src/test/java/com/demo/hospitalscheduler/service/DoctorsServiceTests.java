package com.demo.hospitalscheduler.service;

import com.demo.hospitalscheduler.helper.TestDataHelper;
import com.demo.hospitalscheduler.persistence.repository.DoctorRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
public class DoctorsServiceTests {

    @Mock
    private DoctorRepository doctorRepository;

    @InjectMocks
    private DoctorsService doctorsService;

    @Test
    @DisplayName("Get Patients - Empty List")
    public void getPatients_EmptyList_Success() {

        Mockito.when(this.doctorRepository.findAll()).thenReturn(TestDataHelper.generateDoctorEntityList(0));
        ResponseEntity response = this.doctorsService.getDoctors();

        verify(this.doctorRepository, times(1)).findAll();
        assertNotNull(response);

    }

    @Test
    @DisplayName("Get Patients - List with Single Item")
    public void getPatients_ListWithSingleItem_Success() {

        Mockito.when(this.doctorRepository.findAll()).thenReturn(TestDataHelper.generateDoctorEntityList(1));
        ResponseEntity response = this.doctorsService.getDoctors();

        verify(this.doctorRepository, times(1)).findAll();
        assertNotNull(response);

    }

    @Test
    @DisplayName("Get Patients - List with Multiple Items")
    public void getPatients_ListWithMultipleItem_Success() {

        Mockito.when(this.doctorRepository.findAll()).thenReturn(TestDataHelper.generateDoctorEntityList(3));
        ResponseEntity response = this.doctorsService.getDoctors();

        verify(this.doctorRepository, times(1)).findAll();
        assertNotNull(response);

    }

}
