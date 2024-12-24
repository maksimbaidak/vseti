package by.vseti.ui.login;

import by.vseti.service.UserService;
import by.vseti.ui.AbstractUiTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@Transactional
@SpringBootTest
public class LoginPageUiTest extends AbstractUiTest{

    @Autowired private LoginPageStep loginPageStep;
    @Autowired private UserService userService;

    @Test
    @DisplayName("check if registered user is able to login")
    void login() {
        assertEquals(
                LoginPageMessages.GREETING,
                loginPageStep
                        .fillFormAndSubmit(userService.getRegisteredUser("maksimbaidak"))
                        .getGreeting());
    }

    @Test
    @DisplayName("check empty values of login form")
    void emptyLogin()  {
        assertNotEquals(
                LoginPageMessages.GREETING,
                loginPageStep
                        .fillFormAndSubmit(userService.getEmptyValueUser())
                        .getGreeting());
    }

    @Test
    @DisplayName("chek error message of name or password of login form")
    void wrongNameOrPassword() {
        assertEquals(
                LoginPageMessages.WRONG_NAME_OR_PASSWORD_ERROR,
                loginPageStep
                        .fillFormAndSubmit(userService.getUserWithBadPassword())
                        .getErrorMessage());
    }
}
