package by.vseti.service;

import by.vseti.domain.User;
import by.vseti.storage.UserStorage;
import com.github.javafaker.service.FakeValuesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class UserService {

    @Autowired private UserStorage userStorage;
    @Autowired private EmailService emailService;
    @Autowired private PasswordService passwordService;
    @Autowired private FakeValuesService faker;

    public User getEmptyValueUser(){
        return User
                .builder()
                .username("")
                .email("")
                .password("")
                .build();
    }

    public User getRegisteredUser(String username){
        return userStorage.findByUsername(username);
    }

    public User getValidRandomUser(){
        return validRandomUser().build();
    }

    public User getUserWithPasswordMisMatch(){
        return validRandomUser()
                .passwordConfirmation(faker.bothify("???????"))
                .build();
    }

    public User getUserWithBadPassword()  {
        return getUsersWithBadPasswords().findAny().get();
    }

    public Stream<User> getUsersWithBadPasswords()  {
        return passwordService
                .generateWrongPasswords()
                .map(pass -> validRandomUser().password(pass).build());
    }

    public User getUserWithBadEmail(){
        return getUsersWithBadEmails().findAny().get();
    }

    public Stream<User> getUsersWithBadEmails(){
        return emailService
                .generateWrongEmails()
                .map(email -> validRandomUser().email(email).build());
    }

    private User.UserBuilder validRandomUser(){
        String password = passwordService.generateValid();
        return User
                .builder()
                .username(faker.bothify("???????????"))
                .email(emailService.generateValid())
                .password(password)
                .passwordConfirmation(password);
    }
}
