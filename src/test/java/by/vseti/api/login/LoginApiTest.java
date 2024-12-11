package by.vseti.api.login;

import by.vseti.service.UserService;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class LoginApiTest {

    @Autowired private UserService userService;
    @Autowired private LoginApi loginApi;

    @Test
    @DisplayName("login with registrated user")
    void positiveLogin(){
        assertEquals(
                200,
                loginApi
                        .login(userService.getRegisteredUser())
                        .getStatus());
    }

    @Test
    @DisplayName("login with unregistered user")
    void negative(){
        assertEquals(
                LoginResponceMessages.BAD_CREDENTIALS,
                loginApi
                        .login(userService.getValidRandomUser())
                        .getError().get());
    }
}
