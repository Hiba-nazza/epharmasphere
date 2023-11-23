package com.epharma.pharmasphere.controller;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import com.epharma.pharmasphere.model.*;
import com.epharma.pharmasphere.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import java.util.List;
@Controller
public class MessageController {
    
	@Autowired
	private MessageService messageService;

	@GetMapping("/pharmadashboard")
	public String showDashboard(Model model) {
	    List<Message> messages = messageService.getAllMessages();
	    model.addAttribute("messages", messages);
	    return "pharmadashboard";
	}


}