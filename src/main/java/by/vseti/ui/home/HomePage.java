package by.vseti.ui.home;

import by.vseti.domain.User;
import by.vseti.ui.Appendable;
import by.vseti.ui.Page;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Slf4j
@Component
public class HomePage extends Page implements Appendable<HomePage> {

    public HomePage get(User user){
        webDriver.get("https://vseti.by/" + user.getUsername());
        //webDriver.manage().deleteAllCookies();
        user.getCookiesMap().forEach((key, value) ->
                webDriver.manage().addCookie(new Cookie(key, value)));
        log.info("driver cookie: " + webDriver.manage().getCookies().toString());
        webDriver.navigate().refresh();
        return this;
    }

    HomePage clickNewPostButton(){
        findByXpath(HomePageXpath.NEW_POST_BUTTON).click();
        return this;
    }

    HomePage sendKeysNewPostWindow(String text){
        findByXpath(HomePageXpath.NEW_POST_WINDOW_TEXT_AREA).sendKeys(text);
        return this;
    }

    HomePage clickCreateNewPostButton(){
        findByXpath(HomePageXpath.NEW_POST_CREATE_BUTTON).click();
        return this;
    }

    String getPosts(){
        return findByXpath(HomePageXpath.POST_CONTAINER).getText();
    }

    HomePage clickAvatarButton(){
        findByXpath(HomePageXpath.AVATAR_BUTTON).click();
        return this;
    }
}
