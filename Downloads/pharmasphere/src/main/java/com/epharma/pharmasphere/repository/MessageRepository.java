package com.epharma.pharmasphere.repository;
import com.epharma.pharmasphere.model.Message;
import com.epharma.pharmasphere.model.Patient;
import com.epharma.pharmasphere.model.Pharmainfo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
    // Add custom query methods if needed
	List<Message> findAll();
    List<Message> findByReceiver(String receiver);
    List<Message> findByReceiver(Patient patient);
    List<Message> findBySender(String sender);
    List<Message> findBySender(Patient patient);
    List<Message> findBySender(Pharmainfo pharmainfo);
}