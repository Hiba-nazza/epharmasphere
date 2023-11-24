package com.epharma.pharmasphere.repository;

import com.epharma.pharmasphere.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    // You can add custom query methods if needed
}
