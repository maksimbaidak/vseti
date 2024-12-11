package by.vseti.ui.home;

import by.vseti.service.UserService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
//@TestMethodOrder(MethodOrderer.Random.class)
public class HomePageUiTest {

    @Autowired private UserService userService;
    @Autowired private HomePageStep homePageStep;

    @Test
    @DisplayName("create new post on user wall")
    void newPostTest(){
        String text = "привет world";
        assertTrue(
                homePageStep
                        .get(userService.getRegisteredUser())
                        .addNewPost(text)
                        .getPosts()
                        .contains(text));
    }

    @Test
    @DisplayName("change avatar")
    void changeAvatar() {
        homePageStep
                .get(userService.getRegisteredUser())
                .changeAvatar();
    }
}
