package com.epharma.pharmasphere.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import com.epharma.pharmasphere.model.Pharmainfo;
import com.epharma.pharmasphere.service.InfoService;
@Controller
public class SignUpPharmaController {
    @Autowired
    private InfoService infoService;
    @GetMapping("/Signup_pharma")
    public String showSignUpForm(Model model) {
        model.addAttribute("pharmainfo", new Pharmainfo());
        model.addAttribute("type", "pharmacist");
        return "Signup_pharma";
    }

    @PostMapping("/Signup_pharma")
    public String processSignUp(Pharmainfo pharmainfo) {
        infoService.savePharmainfo(pharmainfo);
        return "redirect:/Login";
    }
    
}
