package by.vseti.ui.home;

import by.vseti.domain.User;
import by.vseti.ui.Actions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HomePageStep {

    @Autowired private HomePage homePage;

    public HomePageStep get(User user){
        homePage
                .get(user)
                .appendAction(Actions.await(10));
        return this;
    }

    public HomePage addNewPost(String text){
        return homePage
                .clickNewPostButton()
                .sendKeysNewPostWindow(text)
                .clickCreateNewPostButton()
                .appendAction(Actions.await(2));
    }
}
