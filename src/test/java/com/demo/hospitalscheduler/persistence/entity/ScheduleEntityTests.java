package com.demo.hospitalscheduler.persistence.entity;

import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ScheduleEntityTests {

    @Test
    public void setEntity_ValidValues_Success() {

        PatientEntity patient = new PatientEntity();

        patient.setId(1);
        patient.setName("Test Name");
        patient.setSchedules(new ArrayList<>());

        Date startDate = new Date(System.currentTimeMillis());
        Date requestedOn = new Date(System.currentTimeMillis());

        ScheduleEntity schedule = new ScheduleEntity(1, patient, startDate, requestedOn);

        assertEquals(schedule.getId(), 1);
        assertEquals(schedule.getPatient(), patient);
        assertEquals(schedule.getStartDate(), startDate);
        assertEquals(schedule.getRequestedOn(), requestedOn);

    }

}
