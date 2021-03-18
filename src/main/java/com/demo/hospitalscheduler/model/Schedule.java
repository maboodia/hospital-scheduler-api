package com.demo.hospitalscheduler.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.ZonedDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Schedule {

    @NotNull
    private ZonedDateTime date;

    @NotNull
    private ZonedDateTime requestedOn;
}
