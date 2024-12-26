package by.vseti.api.login;

import by.vseti.service.UserService;

import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Transactional
@SpringBootTest
public class LoginApiTest {

    @Autowired private UserService userService;
    @Autowired private LoginApi loginApi;

    @Test
    @DisplayName("login with registrated user")
    void positiveLogin(){
        assertEquals(
                HttpStatus.SC_OK,
                loginApi
                        .login(userService.getRegisteredUser("maksimbaidak"))
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
