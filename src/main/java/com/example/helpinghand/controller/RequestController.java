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

    @CrossOrigin(origins = "*")
    @PutMapping(value = "/setStatus/{userId}",consumes = {"application/json"})
    public Optional<Request> setStatus(@PathVariable String userId)
    {
        Optional<Request> request = requestRepo.findById(Long.parseLong(userId));
        if(request.isPresent())
        {
            Request newRequest= request.get();
            newRequest.setStatus("Accepted");
            requestRepo.save(newRequest);
        }

        return requestRepo.findById(Long.parseLong(userId));
    }

    @CrossOrigin(origins = "*")
    @PutMapping(value = "/unsetStatus/{userId}",consumes = {"application/json"})
    public Optional<Request> unsetStatus(@PathVariable String userId)
    {
        Optional<Request> request = requestRepo.findById(Long.parseLong(userId));
        if(request.isPresent())
        {
            Request newRequest= request.get();
            newRequest.setStatus("Declined");
            requestRepo.save(newRequest);
        }

        return requestRepo.findById(Long.parseLong(userId));
    }
}
