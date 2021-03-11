package com.intuit.hospitalscheduler.persistence.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

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
    @JoinColumn(name = "patient_id")
    private PatientEntity patient;

    @Column(name="start_date")
    private Date startDate;

    @Column(name="requested_on")
    private Date requestedOn;

}
