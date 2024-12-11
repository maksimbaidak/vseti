package by.vseti.ui.registration;

import by.vseti.domain.User;
import by.vseti.ui.Step;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class RegistrationPageStep extends Step {

    @Autowired private RegistrationPage registrationPage;

    public RegistrationPage fillFormAndSubmit(User user) {
        return registrationPage.get()
                .sendKeysLoginField(user.getUsername())
                .sendKeysEmailField(user.getEmail())
                .sendKeysPasswordField(user.getPassword())
                .sendKeysConfirmPasswordField(user.getPassword())
                .appendAction(logInfo("Current user: " + user.toString()))
                .clickAgreementCheckbox()
                .clickSubmitButton()
                .appendAction(logDebug("submit button was clicked"))
                .appendAction(await(5));
    }

    public RegistrationPage fillFormAndSolveCaptchaAndSubmit(User user){
        return registrationPage.get()
                .sendKeysLoginField(user.getUsername())
                .sendKeysEmailField(user.getEmail())
                .sendKeysPasswordField(user.getPassword())
                .sendKeysConfirmPasswordField(user.getPasswordConfirmation())
                .appendAction(logInfo("Current user: " + user.toString()))
                .clickReCaptcha()
                .appendAction(logInfo("recaptcha solved"))
                .appendAction(await(5))
                .clickAgreementCheckbox()
                .clickSubmitButton()
                .appendAction(logDebug("submit button was clicked"))
                .appendAction(await(5));
    }
}
