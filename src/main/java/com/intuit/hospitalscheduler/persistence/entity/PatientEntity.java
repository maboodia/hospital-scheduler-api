package com.intuit.hospitalscheduler.persistence.entity;

import javax.persistence.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

@Entity
@Table(name="patient")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PatientEntity {

    @Id
    @Column(name="PATIENT_ID")
    private long id;

    @Column(name="PATIENT_NAME")
    private String name;

    @JsonManagedReference
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "patient")
    private List<ScheduleEntity> schedules;

}
