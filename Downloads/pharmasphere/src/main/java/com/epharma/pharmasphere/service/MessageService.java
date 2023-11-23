package com.epharma.pharmasphere.service;
import org.springframework.stereotype.Service;
import com.epharma.pharmasphere.model.Message;
import com.epharma.pharmasphere.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }
}
