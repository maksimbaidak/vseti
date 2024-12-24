package by.vseti.storage;

import by.vseti.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserStorage extends JpaRepository<User, Integer> {

    @Query(value = "SELECT * FROM users WHERE username=?",nativeQuery = true)
    public User findByUsername(String username);
}
