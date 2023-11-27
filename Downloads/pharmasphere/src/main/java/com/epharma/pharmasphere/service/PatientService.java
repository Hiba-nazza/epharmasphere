package com.epharma.pharmasphere.service;

import com.epharma.pharmasphere.model.Patient;
//import com.epharma.pharmasphere.model.Pharmainfo;
//import com.epharma.pharmasphere.model.Pharmainfo;
//import com.epharma.pharmasphere.model.Pharmainfo;
// import com.epharma.pharmasphere.model.HomepageFormData;
import com.epharma.pharmasphere.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List; // Add this import statement
import java.util.Optional;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    @Autowired
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public Patient createPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    // Add more methods as per your business requirements
    
    public Optional<Patient> getPatientInfoByEmailAndPassword(String email, String password) {
        return patientRepository.findByEmailAndPassword(email, password);
    }
    public void savePatient(Patient patient) {
         patientRepository.save(patient);
    }
    public Optional<Patient> getPatientByEmail(String email) {
        return patientRepository.findByEmail(email);
    }
    
    
    
    public boolean authenticatePatient(String email, String password) {
        Optional<Patient> patientOptional = patientRepository.findByEmail(email);
        if (patientOptional.isPresent()) {
            Patient patient = patientOptional.get();
            if (patient.getPassword().equals(password)) {
                return true; // Authentication successful
            }
        }
        return false; // Authentication failed
    }
}
