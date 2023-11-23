
package com.epharma.pharmasphere.repository;
import com.epharma.pharmasphere.model.Pharmainfo;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface InfoRepository extends JpaRepository<Pharmainfo, Long> {
    // Add custom query methods if needed
	List<Pharmainfo> findAll();
    Optional<Pharmainfo> findByEmail(String email);
}