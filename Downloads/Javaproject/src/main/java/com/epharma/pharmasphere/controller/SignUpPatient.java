package com.epharma.pharmasphere.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.stereotype.Controller;
import com.epharma.pharmasphere.model.*;
import com.epharma.pharmasphere.service.*;
@Controller
public class SignUpPatient {
    @Autowired
    private PatientService patientService;
  
    @GetMapping("/signupPatient")
    public String showSignUpForm(Model model) {
        model.addAttribute("patient", new Patient());
        
        return "signupPatient";
    }

    @PostMapping("/signupPatient")
    public String processSignUp(Patient patient) {
        System.out.println("Processing sign-up...");
    try {
        patientService.savePatient(patient);
        return "redirect:/Signin";
    } catch (Exception e) {
        // Log the exception for debugging
        e.printStackTrace();
        return "error-page"; // Redirect to an error page or handle accordingly
    }
}
    
}
