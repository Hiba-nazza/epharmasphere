package com.epharma.pharmasphere.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epharma.pharmasphere.model.Pharmainfo;

import com.epharma.pharmasphere.repository.PharmainfoRepository;

@Service
public class PharmainfoService {

    @Autowired
    private PharmainfoRepository pharmainfoRepository;

    public Pharmainfo login(String email, String password) {
        return PharmainfoRepository.findByEmailAndPassword(email, password);
    }
}
