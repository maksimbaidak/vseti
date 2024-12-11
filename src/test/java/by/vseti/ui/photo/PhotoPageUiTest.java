package by.vseti.ui.photo;

import by.vseti.service.UserService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PhotoPageUiTest {

    @Autowired private UserService userService;
    @Autowired private PhotoPage photoPage;
    @Autowired private PhotoPageStep photoPageStep;
}
