package by.vseti.api.posts;

import by.vseti.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Transactional
@SpringBootTest
public class PostsApiTest {

    @Autowired private UserService userService;
    @Autowired private PostsApi postsApi;

    @Test
    @DisplayName("add new text post")
    void createPost(){
        assertEquals(
                200,
                postsApi
                        .createTextPostWithColor(
                                userService.getRegisteredUser(),
                                "наконец")
                        .getStatus());
    }
}
