package com.epharma.pharmasphere.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.epharma.pharmasphere.model.Pharmainfo;
import com.epharma.pharmasphere.service.PharmainfoService;

@RestController
public class PharmainfoController {

    @Autowired
    private PharmainfoService pharmainfoService;

    @PostMapping("/Login")
    public Pharmainfo login(@RequestBody LoginRequest loginRequest) {
        return pharmainfoService.login(loginRequest.getEmail(), loginRequest.getPassword());
    }
}




