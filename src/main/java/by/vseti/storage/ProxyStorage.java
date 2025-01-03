package by.vseti.storage;

import by.vseti.domain.Proxy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProxyStorage extends JpaRepository<Proxy, Integer> {
}
