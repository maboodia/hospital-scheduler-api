package com.demo.hospitalscheduler.helper;

import com.demo.hospitalscheduler.model.Schedule;
import com.demo.hospitalscheduler.persistence.entity.PatientEntity;
import com.demo.hospitalscheduler.persistence.entity.ScheduleEntity;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class TestDataHelper {

    public static Optional<PatientEntity> generatePatientEntityWithId(long id) {

        PatientEntity patient = new PatientEntity(id, "Test Name", new ArrayList<>());

        return Optional.of(patient);

    }

    public static List<PatientEntity> generatePatientEntityList(int size) {

        List<PatientEntity> patientsList = new ArrayList<>();

        for (int i=0; i<size; i++) {

            PatientEntity patient = new PatientEntity(1, "Test Name", new ArrayList<>());

            patientsList.add(patient);

        }

        return patientsList;

    }

    public static Schedule generateSchedule() {

        Schedule schedule = new Schedule();

        schedule.setDate(ZonedDateTime.of(2050, 11, 30, 23, 45, 59, 1234, ZoneId.of("UTC+1")));
        schedule.setRequestedOn(ZonedDateTime.of(2050, 11, 30, 23, 45, 59, 1234, ZoneId.of("UTC+1")));

        return schedule;
    }

    public static Schedule generatePastSchedule() {

        Schedule schedule = new Schedule();

        schedule.setDate(ZonedDateTime.of(2015, 11, 30, 23, 45, 59, 1234, ZoneId.of("UTC+1")));
        schedule.setRequestedOn(ZonedDateTime.of(2015, 11, 30, 23, 45, 59, 1234, ZoneId.of("UTC+1")));

        return schedule;
    }

    public static List<ScheduleEntity> generateScheduleEntityList() {

        ScheduleEntity schedule = new ScheduleEntity();
        PatientEntity patient = new PatientEntity();
        List<ScheduleEntity> schedulesList = new ArrayList<>();

        patient.setId(1);
        patient.setName("Test Name");

        schedule.setId(1);
        schedule.setStartDate(ZonedDateTime.now());
        schedule.setRequestedOn(ZonedDateTime.now());
        schedule.setPatient(patient);

        patient.setSchedules(new ArrayList<ScheduleEntity>(Arrays.asList(schedule)));

        schedulesList.add(schedule);

        return schedulesList;
    }
}
