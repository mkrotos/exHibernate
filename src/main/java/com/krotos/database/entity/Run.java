package com.krotos.database.entity;

import lombok.Data;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

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

    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "run",
            cascade = CascadeType.REMOVE)
    private Set<Member> members=new HashSet<>();

    @Override
    public String toString() {
        return "Run{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", place='" + place + '\'' +
                ", startDate=" + startDate +
                ", startTime=" + startTime +
                ", membersLimit=" + membersLimit +
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

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public int getMembersLimit() {
        return membersLimit;
    }

    public void setMembersLimit(int membersLimit) {
        this.membersLimit = membersLimit;
    }

    public Set<Member> getMembers() {
        return members;
    }

    public void setMembers(Set<Member> members) {
        this.members = members;
    }
}
