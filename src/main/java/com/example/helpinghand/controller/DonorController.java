package com.example.helpinghand.controller;

import com.example.helpinghand.entity.Donor;
import com.example.helpinghand.entity.Ngo;
import com.example.helpinghand.repository.DonorRepo;
import com.example.helpinghand.repository.NgoRepo;
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

    @Autowired
    private NgoRepo ngoRepo;

    @CrossOrigin(origins = "*")
    @PostMapping(value = "/add",consumes = {"application/json"})
    public Optional<Donor> addDonor(@RequestBody Donor donor)
    {
        Ngo ngo=ngoRepo.findNgoByPinCode(donor.getPinCode());
        donor.setNgo(ngo);
        donorRepo.save(donor);
        return donorRepo.findById(donor.getUserId());
    }
}
