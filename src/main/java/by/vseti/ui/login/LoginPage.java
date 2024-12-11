package by.vseti.ui.login;

import by.vseti.ui.Page;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class LoginPage extends Page<LoginPage> {

    LoginPage get(){
        webDriver.get("https://vseti.by/welcome");
        return this;
    }

    LoginPage sendKeysNickField(String nick){
        findByXpath(LoginPageXpath.NICK_FIELD).sendKeys(nick);
        return this;
    }

    LoginPage sendKeysPasswordField(String pass){
        findByXpath(LoginPageXpath.PASSWORD_FIELD).sendKeys(pass);
        return this;
    }

    LoginPage clickSubmit(){
        findByXpath(LoginPageXpath.SUBMITT_BUTTON).click();
        return this;
    }

    public String getGreeting(){
        return findByXpath(LoginPageXpath.GREETING_FIELD).getText();
    }

    public String getErrorMessage(){
        return findByXpath(LoginPageXpath.ERRORS_FIELD).getText();
    }

    @Override
    protected LoginPage getThisCls() {
        return this;
    }
}
