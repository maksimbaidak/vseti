package by.vseti.ui;
import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

public class AbstractUiTest {

    @Autowired private WebDriver webDriver;

    @AfterEach
    public void refreshDriver(){
        this.webDriver.manage().deleteAllCookies();
    }
}
