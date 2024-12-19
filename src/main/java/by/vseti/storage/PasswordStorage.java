package by.vseti.storage;

import by.vseti.domain.Password;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PasswordStorage extends JpaRepository<Password, Integer> {
}
