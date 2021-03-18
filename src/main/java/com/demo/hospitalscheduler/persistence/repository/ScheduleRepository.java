package com.demo.hospitalscheduler.persistence.repository;

import com.demo.hospitalscheduler.persistence.entity.ScheduleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.ZonedDateTime;
import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<ScheduleEntity, Long>  {

    List<ScheduleEntity> findByPatientIdAndStartDate(long patientId, ZonedDateTime startDate);

    List<ScheduleEntity> findByIdAndPatientId(long id, long patientId);
}
