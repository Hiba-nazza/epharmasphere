package com.epharma.pharmasphere.service;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.epharma.pharmasphere.model.Message;
import com.epharma.pharmasphere.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@Service
public class MessageService {
    @Value("${file.upload-dir}")
    private String uploadDirectory;

    @Autowired
    private MessageRepository messageRepository;

    public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }
    public List<Message> getMessagesForReceiver(String receiver) {
        return messageRepository.findByReceiver(receiver);
    }
 
    public void saveMessage(Message message) {
        messageRepository.save(message);
    }
    public Message getMessageById(Long id) {
        return messageRepository.findById(id).orElse(null);
    }
    
    public List<Message> getMessagesForSender(String sender) {
        return messageRepository.findBySender(sender);
    }
    
    public String saveFile(MultipartFile file) throws IOException {
        // Save the file to a location on the server
        String filePath = uploadDirectory + File.separator + file.getOriginalFilename();
        Files.copy(file.getInputStream(), Paths.get(filePath), StandardCopyOption.REPLACE_EXISTING);
        return filePath;
    }
}



