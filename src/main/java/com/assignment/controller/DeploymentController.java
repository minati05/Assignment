package com.assignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.assignment.model.ServiceRequest;
import com.assignment.service.DeploymentService;

@RestController
@RequestMapping("/api/deploy")
public class DeploymentController {

    @Autowired
    private DeploymentService service;

    @PostMapping
    public String deploy(@RequestBody ServiceRequest request) {
    	 System.out.println("API HIT");
        service.process(request);
        return "Deployment files generated successfully!";
    }
}