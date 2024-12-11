package by.vseti.service;

import by.vseti.domain.Password;
import by.vseti.domain.User;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

@Component
public class UserStorage {

    @Value("${path.registeredUsers}") private String path;

    @Autowired private ObjectMapper mapper;

    private User user;

    public User getUser(){
        return this.user;
    }

    @PostConstruct
    void setUp(){
        try {
            this.user =
                    mapper.readValue(new File(path), new TypeReference<User>(){});
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @PreDestroy
    void tearDown(){
        try {
            mapper
                    .writeValue(new File(path), this.user);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
