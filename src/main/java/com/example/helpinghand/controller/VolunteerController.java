package com.example.helpinghand.controller;

import com.example.helpinghand.entity.Donor;
import com.example.helpinghand.entity.Volunteer;
import com.example.helpinghand.repository.DonorRepo;
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

    @CrossOrigin(origins = "*")
    @PostMapping(value = "/add",consumes = {"application/json"})
    public Optional<Volunteer> addDonor(@RequestBody Volunteer volunteer)
    {
        volunteerRepo.save(volunteer);
        return volunteerRepo.findById(volunteer.getUserId());
    }
}
