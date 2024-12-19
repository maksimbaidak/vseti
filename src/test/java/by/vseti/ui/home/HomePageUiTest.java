package by.vseti.ui.home;

import by.vseti.service.UserService;
import by.vseti.ui.AbstractUiTest;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Transactional
@SpringBootTest
public class HomePageUiTest extends AbstractUiTest {

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
}
