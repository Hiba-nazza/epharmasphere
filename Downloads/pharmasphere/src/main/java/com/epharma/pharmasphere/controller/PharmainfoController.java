/*package com.epharma.pharmasphere.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.epharma.pharmasphere.model.Pharmainfo;
import com.epharma.pharmasphere.service.PharmainfoService;

@RestController
public class PharmainfoController {

    @Autowired
    private PharmainfoService pharmainfoService;
    
    @Controller
    
    public class LoginController {

       @GetMapping("/login")
       public String showLoginPage() {
          return "login";
    }
        @GetMapping("/Signup")
        public String showSignUpPage() {
            return "Signup";
    }
}
    
    @PostMapping("/Login")
    public Pharmainfo login(@RequestBody LoginRequest loginRequest) {
        return pharmainfoService.login(loginRequest.getEmail(), loginRequest.getPassword());
    }

        
}

*/
