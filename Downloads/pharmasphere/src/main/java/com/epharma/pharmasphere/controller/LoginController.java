package com.epharma.pharmasphere.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.ui.Model;
import com.epharma.pharmasphere.model.*;
import com.epharma.pharmasphere.service.*;
import java.util.Optional;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
@Controller
public class LoginController {
    @Autowired
    private InfoService pharmainfoService;

 
    @GetMapping("/Login")
    public String showSignInForm(Model model) {
        
        model.addAttribute("pharmainfo", new Pharmainfo());
       
        /*model.addAttribute("patient", new Patient());*/
        
        return "Login";
    }
      @PostMapping("/Login")
    public String processSignIn(Pharmainfo pharmainfo, RedirectAttributes redirectAttributes, HttpSession session) {
        // Check if the email and password exist in the database
        Optional<Pharmainfo> existingPharmainfo = pharmainfoService.getPharmainfoByEmailAndPassword(
                pharmainfo.getEmail(), pharmainfo.getPassword());

        if (existingPharmainfo.isPresent()) {
            // Redirect to the dashboard if credentials are valid
            session.setAttribute("userEmail", pharmainfo.getEmail());
            return "redirect:/pharmadashboard";
        } else {
            // Add an error message and redirect back to the sign-in page
            redirectAttributes.addFlashAttribute("error", "Invalid email or password");
            return "redirect:/Login";
        }
    }
    
}
