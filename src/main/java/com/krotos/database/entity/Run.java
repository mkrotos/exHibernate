package com.krotos.database.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Entity
public class Run {

    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String place;
    @Column(name = "start_date")
    private LocalDate startDate;
    private LocalTime startTime;
    private int membersLimit;
}
