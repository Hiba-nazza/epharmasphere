package com.epharma.pharmasphere.controller;
import java.util.Optional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.epharma.pharmasphere.repository.InfoRepository;
import com.epharma.pharmasphere.model.Pharmainfo;
import com.epharma.pharmasphere.service.InfoService;
@Controller
public class InfoController {

    @Autowired
    private InfoRepository infoRepository;

    @Autowired
	private InfoService infoService;

    @GetMapping("/pharmadashboard/edit")
    public String showEdit(Model model) {
        List<Pharmainfo> info = infoService.getAllinfo();
        model.addAttribute("info", info);
        return "edit_info_pharma";
    }
    

    @PostMapping("/pharmadashboard/edit")
    public String updateInfo(@RequestParam("email") String email,
                             @RequestParam("pharmacy_name") String pharmacyName,
                             @RequestParam("phone_number") String phoneNumber,
                             @RequestParam("address") String address) {

        // Find the Pharmainfo entity by email
        Optional<Pharmainfo> optionalPharmainfo = infoRepository.findByEmail(email);

        if (optionalPharmainfo.isPresent()) {
            Pharmainfo pharmainfo = optionalPharmainfo.get();

            // Update the specified fields
            pharmainfo.setPharmacy_name(pharmacyName);
            pharmainfo.setPhoneNumber(phoneNumber);
            pharmainfo.setAddress(address);

            // Save the updated entity
            infoRepository.save(pharmainfo);

            return "redirect:/pharmadashboard"; // Redirect to the dashboard or another page after successful update
        } else {
            // Handle the case when the Pharmainfo entity is not found
            return "error"; // You might want to redirect to an error page or handle it differently
        }
    }
}

