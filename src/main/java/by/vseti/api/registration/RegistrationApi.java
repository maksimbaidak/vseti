package by.vseti.api.registration;

import by.vseti.api.AbstractApi;
import by.vseti.domain.User;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;

@Component
public class RegistrationApi extends AbstractApi{

    public RegistrationResponse register(User user){
        return (RegistrationResponse)
                makeRequest(
                        "username=" + user.getUsername() +
                                "&email=" + user.getEmail() +
                                "&password=" + user.getPassword() +
                                "&confirm_password=" + user.getPassword() +
                                "&gender=" + user.getGender() +
                                "&g-recaptcha-response=" + null +
                                "&accept_terms=on",
                        new RequestSpecBuilder()
                                .setBaseUri(RegistrationRequestParameters.URL)
                                .addQueryParams(parseQueryParams(RegistrationRequestParameters.RAW_QUERY_PARAMETERS))
                                .addHeaders(parseHeaders(RegistrationRequestParameters.RAW_HEADERS))
                                .build(),
                        RegistrationResponse.class);
    }
}
