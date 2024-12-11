package by.vseti.api.login;

import by.vseti.api.AbstractApi;
import by.vseti.domain.User;
import io.restassured.builder.RequestSpecBuilder;
import org.springframework.stereotype.Component;

@Component
public class LoginApi extends AbstractApi{

    public LoginResponse login(User user){
        return (LoginResponse)
                makeRequest(
                        "username=" + user.getUsername() +
                              "&password=" + user.getPassword(),
                        new RequestSpecBuilder()

                                .setBaseUri(LoginRequestParameters.URL)
                                .addQueryParams(parseQueryParams(LoginRequestParameters.RAW_QUERY_PARAMETERS))
                                .addHeaders(parseHeaders(LoginRequestParameters.RAW_HEADERS))
                                .build(),
                        LoginResponse.class);
    }
}
