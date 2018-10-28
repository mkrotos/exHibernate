package com.krotos.database.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Member {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String lastName;
    private int startNumber;
    private long runId;
}

