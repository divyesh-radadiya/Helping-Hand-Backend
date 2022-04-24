package com.example.helpinghand.controller;

import com.example.helpinghand.entity.Ngo;
import com.example.helpinghand.entity.Request;
import com.example.helpinghand.repository.NgoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ngo")
@CrossOrigin("*")
public class NgoController {
    @Autowired
    private NgoRepo ngoRepo;

    @RequestMapping("/getNgo")
    @ResponseBody
    public Ngo getNgo()
    {
        return ngoRepo.findNgoByEmailId("dradadiya990@gmail.com");
    }

    @RequestMapping("/hello")
    @ResponseBody
    public String hello()
    {
        return ("dradadiya990@gmail.com");
    }
}
