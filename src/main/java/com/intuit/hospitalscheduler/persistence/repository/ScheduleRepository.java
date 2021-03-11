package com.intuit.hospitalscheduler.persistence.repository;


import com.intuit.hospitalscheduler.persistence.entity.ScheduleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<ScheduleEntity, Long>  {

    List<ScheduleEntity> findByPatientIdAndStartDate(long patientId, Date startDate);

}
