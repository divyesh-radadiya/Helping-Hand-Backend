package com.example.helpinghand.repository;

import com.example.helpinghand.entity.Ngo;
import com.example.helpinghand.entity.Request;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import java.util.List;

public interface NgoRepo extends JpaRepository<Ngo, Serializable> {
    public Ngo findNgoByEmailId(String emailId) ;

}
