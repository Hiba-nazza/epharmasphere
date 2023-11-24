package com.epharma.pharmasphere.service;

import com.epharma.pharmasphere.model.Patient;
// import com.epharma.pharmasphere.model.HomepageFormData;
import com.epharma.pharmasphere.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List; // Add this import statement

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

    // public void handleHomepageForm(HomepageFormData formData) {
    //     // Implement the logic to handle homepage form data
    //     // This may include saving data to the database or performing other actions

    //     // Example: Save a new patient to the database
    //     Patient newPatient = new Patient();
    //     newPatient.setUsername(formData.getUsername());
    //     newPatient.setPhoneNumber(formData.getPhoneNumber());
    //     newPatient.setAddress(formData.getAddress());
    //     newPatient.setEmail(formData.getEmail());
    //     newPatient.setPassword(formData.getPassword());

    //     patientRepository.save(newPatient);
    // }

    // Add other service methods for business logic, if needed

    // For example:
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    // Add more methods as per your business requirements
}
