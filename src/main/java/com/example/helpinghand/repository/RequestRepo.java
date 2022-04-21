package com.example.helpinghand.repository;

import com.example.helpinghand.entity.Donor;
import com.example.helpinghand.entity.Ngo;
import com.example.helpinghand.entity.Request;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import java.util.List;

public interface RequestRepo extends JpaRepository<Request, Serializable> {
    public List<Request> findAllByMobile(String mobile) ;
}
