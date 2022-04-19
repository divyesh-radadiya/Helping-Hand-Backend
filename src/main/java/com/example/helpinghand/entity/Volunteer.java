package com.example.helpinghand.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Volunteer extends User{

    @Column(nullable = false)
    private String details;

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
