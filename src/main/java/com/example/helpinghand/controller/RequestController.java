package com.example.helpinghand.controller;

import com.example.helpinghand.entity.Donor;
import com.example.helpinghand.entity.Ngo;
import com.example.helpinghand.entity.Request;
import com.example.helpinghand.repository.DonorRepo;
import com.example.helpinghand.repository.NgoRepo;
import com.example.helpinghand.repository.RequestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/request")
@CrossOrigin("*")
public class RequestController {
    @Autowired
    private RequestRepo requestRepo;

    @CrossOrigin(origins = "*")
    @PostMapping(value = "/add",consumes = {"application/json"})
    public Optional<Request> addDonor(@RequestBody Request request)
    {
        requestRepo.save(request);

        return requestRepo.findById(request.getUserId());
    }
}
