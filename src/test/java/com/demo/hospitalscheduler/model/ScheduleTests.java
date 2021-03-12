package com.demo.hospitalscheduler.model;

import org.junit.jupiter.api.Test;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScheduleTests {

    @Test
    public void setSchedule_DateValues_Success() {

        Date startDate = new Date(System.currentTimeMillis());
        Date requestedOn = new Date(System.currentTimeMillis());

        Schedule schedule = new Schedule(startDate, requestedOn);

        assertEquals(schedule.getDate(), startDate);
        assertEquals(schedule.getRequestedOn(), requestedOn);
    }

}
