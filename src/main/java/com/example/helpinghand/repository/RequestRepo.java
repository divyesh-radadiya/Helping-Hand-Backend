package com.example.helpinghand.repository;

import com.example.helpinghand.entity.Donor;
import com.example.helpinghand.entity.Request;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface RequestRepo extends JpaRepository<Request, Serializable> {

}
