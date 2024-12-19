package by.vseti.ui;
import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

public class AbstractUiTest {

    @Autowired WebDriver webDriver;

    @AfterEach
    public void closeDriver(){
        this.webDriver.manage().deleteAllCookies();
    }
}
