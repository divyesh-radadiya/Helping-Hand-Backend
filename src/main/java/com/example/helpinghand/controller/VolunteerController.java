package com.example.helpinghand.controller;

import com.example.helpinghand.entity.Donor;
import com.example.helpinghand.entity.Ngo;
import com.example.helpinghand.entity.Volunteer;
import com.example.helpinghand.repository.DonorRepo;
import com.example.helpinghand.repository.NgoRepo;
import com.example.helpinghand.repository.VolunteerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/volunteer")
@CrossOrigin("*")
public class VolunteerController {
    @Autowired
    private VolunteerRepo volunteerRepo;

    @Autowired
    private NgoRepo ngoRepo;

    @CrossOrigin(origins = "*")
    @PostMapping(value = "/add",consumes = {"application/json"})
    public Optional<Volunteer> addVolunteer(@RequestBody Volunteer volunteer)
    {
        Ngo ngo=ngoRepo.findNgoByPinCode(volunteer.getPinCode());
        volunteer.setNgo(ngo);
        volunteerRepo.save(volunteer);
        return volunteerRepo.findById(volunteer.getUserId());
    }
}
