package com.demo.hospitalscheduler.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.ZonedDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DoctorSchedule {

    private long id;

    @JsonFormat(pattern="MM/dd/yyyy HH:mm:ss")
    private ZonedDateTime startDate;

    @JsonFormat(pattern="MM/dd/yyyy HH:mm:ss")
    private ZonedDateTime requestedOn;

    private long patientId;

}
