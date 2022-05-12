package com.example.helpinghand.controller;

import com.example.helpinghand.entity.Ngo;
import com.example.helpinghand.entity.Request;
import com.example.helpinghand.repository.NgoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

@RestController
@RequestMapping("/ngo")
@CrossOrigin("*")
public class NgoController {
    private static final Logger logger = LogManager.getLogger("HHController");

    @Autowired
    private NgoRepo ngoRepo;

    @RequestMapping("/getNgo/{email}")
    @ResponseBody
    public Ngo getNgo(@PathVariable String email)
    {
        logger.info("[NgoGetDetails] - ["+email+"]" );

        return ngoRepo.findNgoByEmailId(email);
    }

    @PostMapping(value = "/add",consumes = {"application/json"})
    @ResponseBody
    public Ngo addNgo(@RequestBody Ngo ngo)
    {
       logger.info("[Add Ngo] - ["+ngo.getMobile()+"]" );
        return ngoRepo.save(ngo);
    }
}
