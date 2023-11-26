package com.epharma.pharmasphere.repository;

import com.epharma.pharmasphere.model.Pharmainfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PharmacyRepository extends JpaRepository<Pharmainfo, Long> {
    // You can add custom query methods here if needed
    List<Pharmainfo> findAll();
}
