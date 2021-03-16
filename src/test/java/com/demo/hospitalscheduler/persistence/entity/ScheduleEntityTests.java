package com.demo.hospitalscheduler.persistence.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.time.ZonedDateTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ScheduleEntityTests {

    @Test
    @DisplayName("ScheduleEntity Setters, Getters and Constructor")
    public void setEntity_ValidValues_Success() {

        PatientEntity patient = new PatientEntity();

        patient.setId(1);
        patient.setName("Test Name");
        patient.setSchedules(new ArrayList<>());

        ZonedDateTime startDate = ZonedDateTime.now();
        ZonedDateTime requestedOn = ZonedDateTime.now();

        ScheduleEntity schedule = new ScheduleEntity(1, patient, startDate, requestedOn);

        assertEquals(schedule.getId(), 1);
        assertEquals(schedule.getPatient(), patient);
        assertEquals(schedule.getStartDate(), startDate);
        assertEquals(schedule.getRequestedOn(), requestedOn);

    }

}
