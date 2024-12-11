package by.vseti.ui.registration;

import by.vseti.ui.Appendable;
import by.vseti.ui.Page;
import by.vseti.ui.util.CaptchaSolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RegistrationPage extends Page implements Appendable<RegistrationPage> {

    @Autowired private CaptchaSolver captchaSolver;

    RegistrationPage get(){
        webDriver.get("https://vseti.by/register");
        return this;
    }

    RegistrationPage sendKeysLoginField(String login){
        findByXpath(RegistrationPageXpath.LOGIN_FIELD).sendKeys(login);
        return this;
    }

    RegistrationPage sendKeysEmailField(String email){
        findByXpath(RegistrationPageXpath.EMAIL_FIELD).sendKeys(email);
        return this;
    }

    RegistrationPage sendKeysPasswordField(String pass){
        findByXpath(RegistrationPageXpath.PASSWORD_FIELD).sendKeys(pass);
        return this;
    }

    RegistrationPage sendKeysConfirmPasswordField(String pass){
        findByXpath(RegistrationPageXpath.CONFIRM_PASSWORD_FIELD).sendKeys(pass);
        return this;
    }

    RegistrationPage clickGenderSelect(){
        findByXpath(RegistrationPageXpath.GENDER_SELECT).click();
        return this;
    }

    RegistrationPage clickReCaptcha(){
        captchaSolver.solveGCaptcha();
        return this;
    }

    RegistrationPage clickAgreementCheckbox(){
        findByXpath(RegistrationPageXpath.AGREEMENT_CHECKBOX).click();
        return this;
    }

    public RegistrationPage clickSubmitButton(){
        findByXpath(RegistrationPageXpath.SUBMIT_BUTTON).click();
        return this;
    }

    public String getErrorMessage(){
        return findByXpath(RegistrationPageXpath.FORM_ERROR).getText();
    }
}
