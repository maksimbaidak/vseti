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
        System.out.println("111111111111111111111111111111111111111");
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
        System.out.println("@222222222222222222222222222222222222222222222222");
        homePageStep
                .get(userService.getRegisteredUser())
                .changeAvatar();
    }
}
