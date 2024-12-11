package by.vseti.api.login;

import by.vseti.api.AbstractApi;
import by.vseti.domain.User;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;

@Component
public class LoginApi extends AbstractApi<LoginResponce>{

    @Override
    protected String getBody(User user) {
        return  "username=" + user.getUsername() +
                "&password=" + user.getPassword();
    }

    @Override
    protected Type getResponseType() {
        return LoginResponce.class;
    }

    @Override
    protected RequestSpecification getSpecifications(){
        return new RequestSpecBuilder()
                    .setBaseUri(LoginRequestParameters.URL)
                    .addQueryParams(parseQueryParams(LoginRequestParameters.RAW_QUERY_PARAMETERS))
                    .addHeaders(parseHeaders(LoginRequestParameters.RAW_HEADERS))
                    .build();
    }
}
