package com.epharma.pharmasphere.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.ui.Model;
import com.epharma.pharmasphere.model.*;
import com.epharma.pharmasphere.service.*;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
@Controller
public class SigninController {

    @Autowired
    private PatientService patientService;

    @GetMapping("/Signin")
    public String showSignInForm(Model model) {
        model.addAttribute("patient", new Patient());
        return "Signin";
    }

    @PostMapping("/Signin")
    public String processSignIn(Patient patient,
                                RedirectAttributes redirectAttributes,
                                HttpSession session) {

        if (patientService.authenticatePatient(patient.getEmail(), patient.getPassword())) {
            session.setAttribute("userEmail", patient.getEmail());
            return "redirect:/homepagepatient";
        } else {
            redirectAttributes.addFlashAttribute("error", "Invalid email or password");
            return "redirect:/Signin";
        }
    }
}


