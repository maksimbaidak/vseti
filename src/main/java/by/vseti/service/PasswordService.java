package by.vseti.service;

import by.vseti.domain.Password;
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
public class PasswordService {

    @Value("${path.wrongPasswords}") private String path;

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
        return new String(faker.bothify("?")).toUpperCase() + faker.bothify("?????##");
    }

    public Stream<String> generateWrongPasswords()  {
        try {
            return mapper
                    .readValue(new File(path), new TypeReference<List<Password>>(){})
                    .stream()
                        .map(passJsonObj -> generateBadPassword(passJsonObj));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String generateBadPassword(Password password){
        StringBuilder genPass = new StringBuilder();
        if(password.getLength() >= 6) genPass.append(faker.bothify("??????"));
        if(password.isHasLowercase()) genPass.append(faker.bothify("?"));
        if(password.isHasUppercase()) genPass.append(new String(faker.bothify("?")).toUpperCase());
        if(password.isHasDigitOrSymbol()) genPass.append(faker.bothify("#"));
        return genPass.toString();
    }
}
