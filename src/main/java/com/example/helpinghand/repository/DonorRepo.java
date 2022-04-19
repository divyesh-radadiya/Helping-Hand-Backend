package com.example.helpinghand.repository;

import com.example.helpinghand.entity.Donor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface DonorRepo extends JpaRepository<Donor, Serializable> {

}
