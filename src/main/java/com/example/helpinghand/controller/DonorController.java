package com.example.helpinghand.controller;

import com.example.helpinghand.entity.Donor;
import com.example.helpinghand.entity.Ngo;
import com.example.helpinghand.repository.DonorRepo;
import com.example.helpinghand.repository.NgoRepo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/donor")
@CrossOrigin("*")
public class DonorController {
    @Autowired
    private DonorRepo donorRepo;
    private static final Logger logger = LogManager.getLogger("HHController");

    @Autowired
    private NgoRepo ngoRepo;

    @CrossOrigin(origins = "*")
    @PostMapping(value = "/add",consumes = {"application/json"})
    public Optional<Donor> addDonor(@RequestBody Donor donor)
    {
        logger.info("Donor added with mobile:" + donor.getMobile());
        Ngo ngo=ngoRepo.findNgoByPinCode(donor.getPinCode());
        donor.setNgo(ngo);
        donorRepo.save(donor);
        return donorRepo.findById(donor.getUserId());
    }
}
