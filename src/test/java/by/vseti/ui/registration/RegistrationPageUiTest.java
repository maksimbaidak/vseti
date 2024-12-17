package by.vseti.ui.registration;

import by.vseti.domain.User;
import by.vseti.service.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;


@Transactional
@SpringBootTest
public class RegistrationPageUiTest {

    @Autowired private RegistrationPageStep registrationPageStep;
    @Autowired private UserService userService;

    @Test
    @DisplayName("test valid random user")
    void randomValidUserTest(){
        testWithCaptcha(
                userService.getValidRandomUser(),
                RegistrationPageMessages.GREETING);
    }

    @Test
    @DisplayName(("test valid random user with password not match"))
    void passwordMisMatchTest(){
        testWithCaptcha(
                userService.getUserWithPasswordMisMatch(),
                RegistrationPageMessages.PASSWORD_MISMATCH);
    }

    @Test
    @DisplayName("check registration form with bad emails")
    void badEmailTest(){
        userService
                .getUsersWithBadEmails()
                .forEach(user ->
                        testWithoutCaptcha(
                                user,
                                RegistrationPageMessages.BAD_EMAIL_FORM_ERROR));
    }

    @Test
    @DisplayName("check registration form with bad passwords")
    void badPasswordsTest()  {
        userService
                .getUsersWithBadPasswords()
                .forEach(user ->
                        testWithoutCaptcha(
                                user,
                                RegistrationPageMessages.BAD_PASSWORD_FORM_ERROR));
    }

    @Test
    private void testWithCaptcha(User user, String expectedError){
        assertEquals(
                expectedError,
                registrationPageStep
                        .fillFormAndSolveCaptchaAndSubmit(user)
                        .getErrorMessage());

    }

    @Test
    private void testWithoutCaptcha(User user, String expectedError) {
        assertEquals(
                expectedError,
                registrationPageStep
                        .fillFormAndSubmit(user)
                        .getErrorMessage());
    }
}
