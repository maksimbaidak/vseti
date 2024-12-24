package by.vseti.service;

import by.vseti.domain.Password;
import by.vseti.storage.PasswordStorage;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.service.FakeValuesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class PasswordService {

    @Autowired private PasswordStorage passwordStorage;
    @Autowired private FakeValuesService faker;
    @Autowired private ObjectMapper mapper;

    /**
     *
     * @return password, generated according to password specification:
     * -Must be at least 6 characters long.
     * -Must contain a lowercase letter.
     * -Must contain an uppercase letter.
     * -Must contain a number or special character.
     */

    public String generateValid(){
        return new String(
                faker.bothify("?")).toUpperCase() +
                faker.bothify("?????##");
    }

    public Stream<String> generateWrongPasswords()  {
        return passwordStorage
                .getAll()
                .map(this::generateBadPassword);
    }

    private String generateBadPassword(Password badPasswordSpecs){
        StringBuilder genPass = new StringBuilder();
        if(badPasswordSpecs.getLength() >= 6) {
            genPass.append(faker.bothify("??????"));
        }
        if(badPasswordSpecs.isHasLowercase()) {
            genPass.append(faker.bothify("?"));
        }
        if(badPasswordSpecs.isHasUppercase()) {
            genPass.append(new String(faker.bothify("?")).toUpperCase());
        }
        if(badPasswordSpecs.isHasDigitOrSymbol()) {
            genPass.append(faker.bothify("#"));
        }
        return genPass.toString();
    }
}
