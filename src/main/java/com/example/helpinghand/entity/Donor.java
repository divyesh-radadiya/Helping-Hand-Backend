package com.example.helpinghand.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
@Entity
public class Donor extends User{

    @Column(nullable = false)
    private String transactionId;

    @Column(nullable = false)
    private String details;

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }




}
