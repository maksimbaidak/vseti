package by.vseti.service;

import by.vseti.domain.Email;
import by.vseti.storage.EmailStorage;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.service.FakeValuesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

@Service
public class EmailService {

    @Autowired private EmailStorage emailStorage;
    @Autowired private FakeValuesService faker;
    @Autowired private ObjectMapper mapper;

    public String generateValid(){
        return faker.bothify("?????@???.???");
    }

    public Stream<String> generateWrongEmails()  {
        return emailStorage
                .findAll()
                .stream()
                .map(this::generateBadEmail);
    }

    private String generateBadEmail(Email badEmailSpecs) {
        StringBuilder genEmail = new StringBuilder();
        if(badEmailSpecs.isHasUserName()) genEmail.append(faker.bothify("???"));
        if(badEmailSpecs.isHasAtSymbol()) genEmail.append("@");
        if(badEmailSpecs.isHasDomain()) genEmail.append(faker.bothify("??.??"));
        return genEmail.toString();
    }
}
