package com.example.helpinghand.repository;

import com.example.helpinghand.entity.Donor;
import com.example.helpinghand.entity.Volunteer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface VolunteerRepo extends JpaRepository<Volunteer, Serializable> {

}
