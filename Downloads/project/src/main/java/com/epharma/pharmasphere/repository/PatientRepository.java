package com.epharma.pharmasphere.repository;

import com.epharma.pharmasphere.model.Patient;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    Patient findByUsername(String username);
    // You can add custom query methods if needed
    List<Patient> findAll();
    Optional<Patient> findByEmailAndPassword(String email, String password);
    Optional<Patient> findByEmail(String email) ;
        
}
