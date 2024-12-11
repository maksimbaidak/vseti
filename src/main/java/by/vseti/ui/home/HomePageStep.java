package by.vseti.ui.home;

import by.vseti.domain.User;
import by.vseti.ui.Actions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HomePageStep extends Actions {

    @Autowired private HomePage homePage;

    public HomePageStep get(User user){
        homePage
                .get(user)
                .appendAction(await(10));
        return this;
    }

    public HomePage addNewPost(String text){
        return homePage
                .clickNewPostButton()
                .sendKeysNewPostWindow(text)
                .clickCreateNewPostButton()
                .appendAction(await(2));
    }

    public HomePage changeAvatar(){
        return homePage
                .clickAvatarButton()
                .loadAvatar();
    }
}
