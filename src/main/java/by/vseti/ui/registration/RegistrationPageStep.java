package by.vseti.ui.registration;

import by.vseti.domain.User;
import by.vseti.ui.Actions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class RegistrationPageStep {

    @Autowired private RegistrationPage registrationPage;

    public RegistrationPage fillFormAndSubmit(User user) {
        return registrationPage.get()
                .sendKeysLoginField(user.getUsername())
                .sendKeysEmailField(user.getEmail())
                .sendKeysPasswordField(user.getPassword())
                .sendKeysConfirmPasswordField(user.getPassword())
                .appendAction(Actions.logInfo("Current user: " + user.toString()))
                .clickAgreementCheckbox()
                .clickSubmitButton()
                .appendAction(Actions.logDebug("submit button was clicked"))
                .appendAction(Actions.await(5));
    }

    public RegistrationPage fillFormAndSolveCaptchaAndSubmit(User user){
        return registrationPage.get()
                .sendKeysLoginField(user.getUsername())
                .sendKeysEmailField(user.getEmail())
                .sendKeysPasswordField(user.getPassword())
                .sendKeysConfirmPasswordField(user.getPasswordConfirmation())
                .appendAction(Actions.logInfo("Current user: " + user.toString()))
                .clickReCaptcha()
                .appendAction(Actions.logInfo("recaptcha solved"))
                .appendAction(Actions.await(5))
                .clickAgreementCheckbox()
                .clickSubmitButton()
                .appendAction(Actions.logDebug("submit button was clicked"))
                .appendAction(Actions.await(5));
    }
}
