package com.epharma.pharmasphere.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@Controller // This means that this class is a Controller
public class PatientController {

	@Autowired

  @RequestMapping("/")
	public String hello(){
		return "index";
	}
	
	@RequestMapping("/dash")
	public String dash(){
		return "dash";
	}

}
