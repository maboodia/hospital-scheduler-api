package com.demo.hospitalscheduler.model;

import org.junit.jupiter.api.Test;

import java.time.ZonedDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScheduleTests {

    @Test
    public void setSchedule_DateValues_Success() {

        ZonedDateTime startDate = ZonedDateTime.now();
        ZonedDateTime requestedOn = ZonedDateTime.now();

        Schedule schedule = new Schedule(startDate, requestedOn);

        assertEquals(schedule.getDate(), startDate);
        assertEquals(schedule.getRequestedOn(), requestedOn);
    }

}
