package com.epharma.pharmasphere.controller;

// import com.epharma.pharmasphere.model.Pharmainfo;
// import com.epharma.pharmasphere.service.PharmacyService;
// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
 import org.springframework.ui.Model;
 import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

// import java.util.List;

@Controller
@RequestMapping("/homepagepatient")
public class HomepagePatientController {

    // private final PharmacyService pharmacyService;

    // @Autowired
    // public HomepagePatientController(PharmacyService pharmacyService) {
    //     this.pharmacyService = pharmacyService;
    // }

    // @GetMapping
    // public String showHomepage(Model model) {
    //     List<Pharmainfo> pharmacies = pharmacyService.getAllPharmacies();
    //     model.addAttribute("pharmacies", pharmacies);
    //     return "homepagepatient";
    // }
    @GetMapping
     public String showHomepage(Model model) {
    //     List<Pharmainfo> pharmacies = pharmacyService.getAllPharmacies();
    //     model.addAttribute("pharmacies", pharmacies);
         return "homepagepatient";
     }
    
    @PostMapping
    public String handleHomepageForm(@RequestParam String selectedPharmacy,
                                     @RequestParam String message,
                                     @RequestParam MultipartFile file) {
        // Logic for handling the homepage form
        return "redirect:/patient/dashboard";
    }

    // Other methods related to homepage actions

}
