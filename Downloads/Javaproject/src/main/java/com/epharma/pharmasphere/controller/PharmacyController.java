package com.epharma.pharmasphere.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epharma.pharmasphere.model.Pharmainfo;
import com.epharma.pharmasphere.service.PharmacyService;

import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/pharmacies")
public class PharmacyController {

    @Autowired
    private PharmacyService pharmacyService;

    @GetMapping
    public ResponseEntity<List<Pharmainfo>> getAllPharmacies() {
        List<Pharmainfo> pharmacies = pharmacyService.getAllPharmacies();
        return ResponseEntity.ok(pharmacies);
    }
}
