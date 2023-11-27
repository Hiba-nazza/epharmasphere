package com.epharma.pharmasphere.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epharma.pharmasphere.model.Pharmainfo;
import com.epharma.pharmasphere.repository.PharmacyRepository;

@Service
public class PharmacyService {

    @Autowired
    private PharmacyRepository pharmacyRepository;

    public List<Pharmainfo> getAllPharmacies() {
        return pharmacyRepository.findAll();
    }
}
