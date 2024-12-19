package by.vseti.api.login;

import by.vseti.api.AbstractApi;
import by.vseti.domain.User;
import io.restassured.builder.RequestSpecBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
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
