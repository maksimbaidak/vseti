package by.vseti.ui.login;

import by.vseti.domain.User;
import by.vseti.ui.Actions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoginPageStep extends Actions {

    @Autowired private LoginPage loginPage;

    public LoginPage fillFormAndSubmit(User user) {
        return loginPage
                .get()
                .sendKeysNickField(user.getUsername())
                .sendKeysPasswordField(user.getPassword())
                .clickSubmit()
                .appendAction(await(1));
    }
}
