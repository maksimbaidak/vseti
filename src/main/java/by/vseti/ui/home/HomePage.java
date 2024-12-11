package by.vseti.ui.home;

import by.vseti.domain.MyCookie;
import by.vseti.domain.User;
import by.vseti.ui.Page;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Slf4j
@Component
public class HomePage extends Page<HomePage> {

    public HomePage get(User user){
        webDriver.get("https://vseti.by/" + user.getUsername());
        for (MyCookie myCookie : user.getCookies()){
            webDriver.manage().addCookie(
                    new Cookie(myCookie.getKey(), myCookie.getValue()));
        }
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

    HomePage loadAvatar(){
        findByXpath(HomePageXpath.LOAD_AVATAR_INPUT)
                .sendKeys("C:\\Users\\baidakm\\Desktop\\photo.png");
        new WebDriverWait(webDriver, Duration.ofSeconds(20))
                .until(x -> findByXpath(HomePageXpath.SAVE_NEW_AVATAR_BUTTON).isDisplayed());
        return this;
    }

    @Override
    protected HomePage getThisCls() {
        return this;
    }
}
