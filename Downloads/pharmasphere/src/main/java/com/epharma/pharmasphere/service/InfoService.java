package com.epharma.pharmasphere.service;
import org.springframework.stereotype.Service;
import com.epharma.pharmasphere.model.Pharmainfo;
import com.epharma.pharmasphere.repository.InfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Service
public class InfoService {

    @Autowired
    private InfoRepository infoRepository;

    public List<Pharmainfo> getAllinfo() {
        return infoRepository.findAll();
    }
}