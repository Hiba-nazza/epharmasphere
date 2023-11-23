package com.epharma.pharmasphere.repository;
import com.epharma.pharmasphere.model.Message;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
    // Add custom query methods if needed
	List<Message> findAll();
}