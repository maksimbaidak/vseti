package by.vseti.storage;

import by.vseti.domain.Password;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

@Repository
public class PasswordStorage {

    @Value("${path.password}") private String path;

    @Autowired private ObjectMapper mapper;

    public Stream<Password> getAll(){
        try {
            return mapper
                    .readValue(new File(path), new TypeReference<List<Password>>(){})
                    .stream();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
