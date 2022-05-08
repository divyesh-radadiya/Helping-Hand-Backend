package com.example.helpinghand.controller;

import com.example.helpinghand.entity.Donor;
import com.example.helpinghand.entity.Ngo;
import com.example.helpinghand.entity.Request;
import com.example.helpinghand.repository.DonorRepo;
import com.example.helpinghand.repository.NgoRepo;
import com.example.helpinghand.repository.RequestRepo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/request")
@CrossOrigin("*")
public class RequestController {
    @Autowired
    private RequestRepo requestRepo;

    @Autowired
    private NgoRepo ngoRepo;
    private static final Logger logger = LogManager.getLogger("HHController");


    @CrossOrigin(origins = "*")
    @PostMapping(value = "/add",consumes = {"application/json"})
    public Optional<Request> addRequest(@RequestBody Request request)
    {
        logger.info("Add request :" + request.getMobile());
        Ngo ngo=ngoRepo.findNgoByPinCode(request.getPinCode());
        request.setNgo(ngo);
        requestRepo.save(request);

        return requestRepo.findById(request.getUserId());
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/setStatus/{userId}")
    public Optional<Request> setStatus(@PathVariable String userId)
    {
        Optional<Request> request = requestRepo.findById(Long.parseLong(userId));
        logger.info("Set status:" + userId);
        if(request.isPresent())
        {
            Request newRequest= request.get();
            newRequest.setStatus("Accepted");
            requestRepo.save(newRequest);
        }

        return requestRepo.findById(Long.parseLong(userId));
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/unsetStatus/{userId}")
    public Optional<Request> unsetStatus(@PathVariable String userId)
    {
        Optional<Request> request = requestRepo.findById(Long.parseLong(userId));
        logger.info("Unset status:" + userId);
        if(request.isPresent())
        {
            Request newRequest= request.get();
            newRequest.setStatus("Declined");
            requestRepo.save(newRequest);
        }

        return requestRepo.findById(Long.parseLong(userId));
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/delete/{userId}")
    public void deleteStatus(@PathVariable String userId)
    {
        logger.info("delete status:" + userId);
        requestRepo.deleteById(Long.parseLong(userId));
    }

    @RequestMapping("/getRequests/{number}")
    @ResponseBody
    public List<Request> getRequests(@PathVariable String number)
    {
        logger.info("get request :" + number);
        return requestRepo.findAllByMobile(number);
    }
}
