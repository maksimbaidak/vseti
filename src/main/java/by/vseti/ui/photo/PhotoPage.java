package by.vseti.ui.photo;

import by.vseti.domain.User;
import by.vseti.ui.Page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PhotoPage {

    PhotoPage get(User user){
        //webDriver.get("https://vseti.by/" + user.getUsername() + "/photos");
        return this;
    }
}
