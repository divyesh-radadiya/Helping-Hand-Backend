package com.example.helpinghand.controller;

import com.example.helpinghand.entity.Ngo;
import com.example.helpinghand.entity.Request;
import com.example.helpinghand.repository.NgoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ngo")
@CrossOrigin("*")
public class NgoController {
    @Autowired
    private NgoRepo ngoRepo;

    @RequestMapping("/getNgo/{email}")
    @ResponseBody
    public Ngo getNgo(@PathVariable String email)
    {
        return ngoRepo.findNgoByEmailId(email);
    }
}
