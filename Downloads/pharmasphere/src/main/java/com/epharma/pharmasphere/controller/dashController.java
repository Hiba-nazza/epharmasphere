package com.epharma.pharmasphere.controller;

import java.security.Principal;
import java.util.List;
import java.util.Optional;
import java.util.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

import com.epharma.pharmasphere.model.*;
import com.epharma.pharmasphere.repository.*;
import com.epharma.pharmasphere.service.*;

import jakarta.servlet.http.HttpSession;

@Controller
public class dashController {
    private final MessageRepository messageRepository;
    private final PatientRepository patientRepository;
    @Autowired
    private MessageService messageService;
     @Autowired
    private PatientService patientService;

    @Autowired
    public dashController(MessageRepository messageRepository, PatientRepository patientRepository) {
        this.messageRepository = messageRepository;
        this.patientRepository = patientRepository;
    }

    
    @GetMapping("/dash")
    public String showDashboard(Model model, HttpSession session) {
        // Get the user's email from the session attribute
        String userEmail = (String) session.getAttribute("userEmail");

        if (userEmail != null) {
            // Retrieve messages based on the user's email as receiver
            List<Message> receivedMessages = messageService.getMessagesForReceiver(userEmail);
            
            // Retrieve messages based on the user's email as sender
            List<Message> sentMessages = messageService.getMessagesForSender(userEmail);

            model.addAttribute("receivedMessages", receivedMessages);
            model.addAttribute("sentMessages", sentMessages);

            Optional<Patient> patientOptional = patientService.getPatientByEmail(userEmail);
            if (patientOptional.isPresent()) {
                Patient patient = patientOptional.get();

                
                model.addAttribute("patient", patient);

                return "dash";
            } else {
                // Redirect to an error page or handle the case where the user info is not found
                return "error";
            }
        } else {
            // Handle the case where the user is not authenticated
            model.addAttribute("receivedMessages", Collections.emptyList());
            model.addAttribute("sentMessages", Collections.emptyList());
        }

        return "dash";
    }

    

}
