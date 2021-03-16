package com.demo.hospitalscheduler.persistence.entity;

import com.demo.hospitalscheduler.model.Schedule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PatientEntityTests {

    @Test
    @DisplayName("PatientEntity Setters and Getters")
    public void setEntity_ValidValues_Success() {

        PatientEntity entity = new PatientEntity();

        entity.setId(1);
        entity.setName("Test Name");
        entity.setSchedules(new ArrayList<>());

        assertEquals(entity.getId(), 1);
        assertEquals(entity.getName(), "Test Name");
        assertNotNull(entity.getSchedules());
    }

}
