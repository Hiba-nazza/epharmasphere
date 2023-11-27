package com.epharma.pharmasphere.controller;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.io.UrlResource;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
//import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.epharma.pharmasphere.model.*;
//import com.epharma.pharmasphere.repository.*;
import com.epharma.pharmasphere.service.*;

import java.io.IOException;
//import java.net.MalformedURLException;
import java.nio.file.Paths;
//import java.io.IOException;
import java.util.Collections;
import jakarta.servlet.http.HttpSession;
/* 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;*/
import java.util.List;
import java.util.Optional;

import org.springframework.core.io.ClassPathResource;
//import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import java.nio.file.Files;
import java.nio.file.Path;

@Controller
public class MessageController {
    
	@Autowired
	private MessageService messageService;
	@Autowired
    private InfoService infoService;

        
    

	@GetMapping("/pharmadashboard")
    public String showDashboard(Model model, HttpSession session) {
        // Get the user's email from the session attribute
        String userEmail = (String) session.getAttribute("userEmail");

        if (userEmail != null) {
            // Retrieve messages based on the user's email
            List<Message> messages = messageService.getMessagesForReceiver(userEmail);

            model.addAttribute("messages", messages);
            Optional<Pharmainfo> pharmaInfoOptional = infoService.getPharmaInfoByEmail(userEmail);
            if (pharmaInfoOptional.isPresent()) {
                Pharmainfo pharmaInfo = pharmaInfoOptional.get();
                
                // Add Pharmainfo to the model
                model.addAttribute("info", pharmaInfo);
                
                return "pharmadashboard";
            } else {
                // Redirect to an error page or handle the case where the user info is not found
                return "error";
            }
        } else {
            // Handle the case where the user is not authenticated
            model.addAttribute("messages", Collections.emptyList());
        }

        return "pharmadashboard";
    }
    @PostMapping("/pharmadashboard")
    public String processForm(@ModelAttribute("message") Message message) {
        messageService.saveMessage(message);
        return "redirect:/pharmadashboard";
    }
    
    @PostMapping("/sendMessage")
    public String sendMessage(@ModelAttribute("message") Message message,
                            @RequestParam("receiverEmail") String receiverEmail,
                            HttpSession session) {
        // Retrieve the sender's email from the session
        String senderEmail = (String) session.getAttribute("userEmail");

        // Set additional fields in the Message object
        message.setSender(senderEmail);
        message.setReceiver(receiverEmail);

        // Save the message
        messageService.saveMessage(message);

        // Redirect to the dashboard or another appropriate page
        return "redirect:/dash";
    }
    
    @GetMapping("/pharmadashboard/form")
    public String showForm(Model model) {
        model.addAttribute("message", new Message());
        return "pharmadashboard";
    }

    @PostMapping("/upload")
    public String handleFileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload.");
            return "redirect:/homepagepatient"; // Redirect to inbox or any other page
        }

        try {
            // Save the file to the server
            String filePath = messageService.saveFile(file);

            // Create a new message with the file path
            Message message = new Message();
            message.setFilePath(filePath);

            // Save the message to the database
            messageService.saveMessage(message);

            redirectAttributes.addFlashAttribute("message", "File uploaded successfully.");
        } catch (IOException e) {
            redirectAttributes.addFlashAttribute("message", "Failed to upload the file.");
            e.printStackTrace(); // Handle the exception appropriately
        }

        return "redirect:/homepagepatient"; // Redirect to inbox or any other page
    }
 
    
    @GetMapping("/displayPdf")
    public ResponseEntity<byte[]> displayPdf() throws IOException {
        // Load the PDF file from the classpath
        Resource resource = new ClassPathResource("uploads/paragraphe.pdf");
        Path pdfPath = Paths.get(resource.getURI());

        // Read the file content into a byte array
        byte[] pdfBytes = Files.readAllBytes(pdfPath);

        // Set up HTTP headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("attachment", "paragraphe.pdf");

        // Return the PDF file as a response entity
        return ResponseEntity.ok().headers(headers).body(pdfBytes);
    }
    /*@PostMapping("/sendMessage")
    public String sendMessage(@ModelAttribute("message") Message message,
                            @RequestParam("receiverEmail") String receiverEmail
                            ) {
        // Set additional fields in the Message object
        message.setReceiver(receiverEmail);
        
        // Save the message and file (if any)
        messageService.saveMessage(message);

        // Redirect to the dashboard or another appropriate page
        return "redirect:/pharmadashboard";
    }*/

    /*@GetMapping("/download/{messageId}")
public ResponseEntity<Resource> downloadFile(@PathVariable Long messageId) {
    // Retrieve the message from the database
    Message message = messageService.getMessageById(messageId);

    // Construct the file path
    String filePath = message.getFilePath();
    Path path = Paths.get(filePath);
    Resource resource;

    try {
        if (path.toFile().exists()) {
            resource = new FileSystemResource(path.toFile());

            // Extract file name from the path
            String fileName = path.getFileName().toString();

            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + fileName)
                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .body(resource);
        } else {
            return ResponseEntity.notFound().build();
        }
    } catch (Exception e) {
        e.printStackTrace(); // Handle the exception appropriately
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}*/

    


}



