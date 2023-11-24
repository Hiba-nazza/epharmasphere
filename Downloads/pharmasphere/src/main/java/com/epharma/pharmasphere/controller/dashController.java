package com.epharma.pharmasphere.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

import com.epharma.pharmasphere.model.Message;
import com.epharma.pharmasphere.model.Patient;
import com.epharma.pharmasphere.repository.MessageRepository;
import com.epharma.pharmasphere.repository.PatientRepository;

@Controller
public class dashController {
    private final MessageRepository messageRepository;
    private final PatientRepository patientRepository;

    @Autowired
    public dashController(MessageRepository messageRepository, PatientRepository patientRepository) {
        this.messageRepository = messageRepository;
        this.patientRepository = patientRepository;
    }

    @GetMapping("/dash")
    public String dashboard(Model model, Principal principal) {
        // String username = principal.getName();

        // // Retrieve the user based on the username
        // Patient patient = patientRepository.findByUsername(username);

        // // Retrieve messages for the authenticated user
        // List<Message> messages = messageRepository.findByReceiver(patient);

        // model.addAttribute("messages", messages);
        return "dash";
    }
    

}
