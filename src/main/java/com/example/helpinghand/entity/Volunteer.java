package com.example.helpinghand.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Volunteer extends User{

    @Column(nullable = false)
    private String details;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="ngoId", nullable=false)
    private Ngo ngo;

    public Ngo getNgo() {
        return ngo;
    }

    public void setNgo(Ngo ngo) {
        this.ngo = ngo;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
