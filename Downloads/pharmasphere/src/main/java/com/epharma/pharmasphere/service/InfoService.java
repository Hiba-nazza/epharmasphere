package com.epharma.pharmasphere.service;
import org.springframework.stereotype.Service;
import com.epharma.pharmasphere.model.Pharmainfo;
import com.epharma.pharmasphere.repository.InfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;
@Service
public class InfoService {

    @Autowired
    private InfoRepository infoRepository;

    public List<Pharmainfo> getAllinfo() {
        return infoRepository.findAll();
    }
    public Optional<Pharmainfo> getPharmaInfoByEmail(String email) {
        return infoRepository.findByEmail(email);
    }
    public void savePharmainfo(Pharmainfo pharmainfo) {
        infoRepository.save(pharmainfo);
    }
    public Optional<Pharmainfo> getPharmainfoByEmailAndPassword(String email, String password) {
        return infoRepository.findByEmailAndPassword(email, password);
    }
    
    
    
}