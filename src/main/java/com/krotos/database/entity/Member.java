package com.krotos.database.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
public class Member {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String lastName;
    private int startNumber;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "runId")
    private Run run;

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", startNumber=" + startNumber +
                ", run=" + run +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getStartNumber() {
        return startNumber;
    }

    public void setStartNumber(int startNumber) {
        this.startNumber = startNumber;
    }

    public Run getRun() {
        return run;
    }

    public void setRun(Run run) {
        this.run = run;
    }
}

