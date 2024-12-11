package by.vseti.api.registration;

import by.vseti.domain.User;
import by.vseti.service.UserService;
import by.vseti.ui.registration.RegistrationPageMessages;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class RegistrationApiTest {

    @Autowired private UserService userService;
    @Autowired private RegistrationApi registrationApi;

    @Test
    @DisplayName("a registration try with valid random user")
    void randomValidUserRegistrationTest() {
        assertEquals(
                RegistrationResponceMessages.GREETING,
                registrationApi
                        .getResponse(userService.getUserWithBadPassword())
                        .getError());
    }

    @Test
    @DisplayName("registration with bad emails")
    void badEmailsTest(){
        userService
                .getUsersWithBadEmails()
                .forEach(user ->
                        test(
                                user,
                                RegistrationResponceMessages.BAD_EMAIL));
    }

    @Test
    @DisplayName("registration try with bad passwords")
    void badPasswordsTest() {
        userService
                .getUsersWithBadPasswords()
                .forEach(user ->
                        test(
                                user,
                                RegistrationResponceMessages.BAD_PASSWORD));
    }

    @Test
    private void test(User user, String expectedError) {
        assertEquals(
                expectedError,
                registrationApi
                        .getResponse(user)
                        .getError());
    }
}
