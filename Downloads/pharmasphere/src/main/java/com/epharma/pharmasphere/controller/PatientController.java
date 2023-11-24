package com.epharma.pharmasphere.controller;

import com.epharma.pharmasphere.service.PatientService;
import com.epharma.pharmasphere.service.PharmacyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/patient")  // Define a base mapping for patient-related endpoints
public class PatientController {

     final PatientService patientService;
     final PharmacyService pharmacyService;

    @Autowired
    public PatientController(PatientService patientService, PharmacyService pharmacyService) {
        this.patientService = patientService;
        this.pharmacyService = pharmacyService;
    }

    @GetMapping("/dashboard")
    public String showDashboard(Model model) {
        // Logic for displaying the patient dashboard
        return "homepagepatient";
    }

    @GetMapping("/signup")
    public String showSignupForm(Model model) {
        // Logic for displaying the patient signup form
        return "signupPatient";
    }

    @PostMapping("/signup")
    public String handleSignupForm(@RequestParam String username,
                                   @RequestParam String phoneNumber,
                                   @RequestParam String address,
                                   @RequestParam String email,
                                   @RequestParam String password) {
        // Logic for handling the patient signup form
        return "redirect:/patient/dashboard";
    }

    // Other methods related to patient actions

}

