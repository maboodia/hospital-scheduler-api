package com.demo.hospitalscheduler.persistence.repository;

import com.demo.hospitalscheduler.persistence.entity.DoctortEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<DoctortEntity, Long> {
}
