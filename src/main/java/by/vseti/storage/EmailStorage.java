package by.vseti.storage;

import by.vseti.domain.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailStorage extends JpaRepository<Email, Integer> {
}
