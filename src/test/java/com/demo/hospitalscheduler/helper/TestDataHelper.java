package com.demo.hospitalscheduler.helper;

import com.demo.hospitalscheduler.model.Schedule;
import com.demo.hospitalscheduler.persistence.entity.DoctorEntity;
import com.demo.hospitalscheduler.persistence.entity.PatientEntity;
import com.demo.hospitalscheduler.persistence.entity.ScheduleEntity;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class TestDataHelper {

    public static Optional<DoctorEntity> generateDoctorEntityWithId(long id) {

        DoctorEntity doctorEntity = new DoctorEntity(id, "Test Name", new ArrayList<>());
        return Optional.of(doctorEntity);

    }

    public static List<DoctorEntity> generateDoctorEntityList(int size) {

        List<DoctorEntity> doctortEntities = new ArrayList<>();

        for (int i=0; i<size; i++) {

            DoctorEntity doctortEntity = new DoctorEntity(1, "Test Name", new ArrayList<>());
            doctortEntities.add(doctortEntity);

        }

        return doctortEntities;

    }

    public static Optional<PatientEntity> generatePatientEntityWithId(long id) {

        PatientEntity patientEntity = new PatientEntity(id, "Test Name", new ArrayList<>());
        return Optional.of(patientEntity);

    }

    public static List<PatientEntity> generatePatientEntityList(int size) {

        List<PatientEntity> patientEntities = new ArrayList<>();

        for (int i=0; i<size; i++) {

            PatientEntity patientEntity = new PatientEntity(1, "Test Name", new ArrayList<>());
            patientEntities.add(patientEntity);

        }

        return patientEntities;

    }

    public static Schedule generateSchedule() {

        Schedule schedule = new Schedule();

        schedule.setDoctorId(1);
        schedule.setDate(ZonedDateTime.of(2050, 11, 30, 23, 45, 59, 1234, ZoneId.of("UTC+1")));
        schedule.setRequestedOn(ZonedDateTime.of(2050, 11, 30, 23, 45, 59, 1234, ZoneId.of("UTC+1")));

        return schedule;

    }

    public static Schedule generateScheduleInvalidDoctor() {

        Schedule schedule = new Schedule();

        schedule.setDoctorId(9999);
        schedule.setDate(ZonedDateTime.of(2050, 11, 30, 23, 45, 59, 1234, ZoneId.of("UTC+1")));
        schedule.setRequestedOn(ZonedDateTime.of(2050, 11, 30, 23, 45, 59, 1234, ZoneId.of("UTC+1")));

        return schedule;

    }

    public static Schedule generatePastSchedule() {

        Schedule schedule = new Schedule();

        schedule.setDoctorId(1);
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

        patient.setSchedules(new ArrayList<>(Arrays.asList(schedule)));

        schedulesList.add(schedule);

        return schedulesList;

    }
}
