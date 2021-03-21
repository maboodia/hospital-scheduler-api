package com.demo.hospitalscheduler.persistence.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
@Table(name="schedule")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleEntity {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "schedule_id_seq"
    )
    @SequenceGenerator(
            name = "schedule_id_seq",
            allocationSize = 1
    )
    @Column(name="schedule_id")
    private long id;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id")
    private DoctortEntity doctor;

    public Long getDoctor_Id(){
        return this.doctor.getId();
    }

    public String getDoctor_Name(){
        return this.doctor.getName();
    }

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id")
    private PatientEntity patient;

    public Long getPatient_Id(){
        return this.patient.getId();
    }

    public String getPatient_Name(){
        return this.patient.getName();
    }

    @Column(name="start_date")
    @JsonFormat(pattern="MM/dd/yyyy HH:mm:ss")
    private ZonedDateTime startDate;

    @Column(name="requested_on")
    @JsonFormat(pattern="MM/dd/yyyy HH:mm:ss")
    private ZonedDateTime requestedOn;

}
