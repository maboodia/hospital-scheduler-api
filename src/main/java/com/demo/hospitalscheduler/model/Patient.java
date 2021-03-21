package com.demo.hospitalscheduler.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Patient {

    private long id;

    private String name;

    private List<PatientSchedule> schedules;

}
