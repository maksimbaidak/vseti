package by.vseti.api;

import by.vseti.domain.User;
import io.restassured.specification.RequestSpecification;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
public abstract class AbstractApi<T extends Response>  {

    private static final String LIMIT_EXCEEDED = "<i class=\"fa fa-exclamation-circle\"></i> Превышен лимит, пожалуйста, повторите попытку позже.";

    @Autowired private HttpClient httpClient;

    public T getResponse(User user){
        Response response = null;
        try {
            response =
                    httpClient
                            .makeRequest(getSpecifications(), getBody(user))
                            .log().status()
                            .log().body()
                            .extract().as(getResponseType());
        }catch (Exception exception){
            log.info(exception.getMessage());
            try {
                return (T) getResponseType()
                        .getClass()
                        .getConstructor()
                        .newInstance("Response isn't valid");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        if(response.getError().equals(LIMIT_EXCEEDED)){
            try {
                log.info("Request limit lxceeded, trying to reconnect...");
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return getResponse(user);
        }
        return (T) response;
    }

    protected abstract RequestSpecification getSpecifications();

    protected abstract String getBody(User user);

    protected abstract Type getResponseType();

    protected Map<String, ?> parseQueryParams(String params){
        return split(params);
    }

    protected Map<String, String> parseHeaders(String headers){
        return split(headers);
    }

    private Map<String, String> split(String str){
        return str
                .lines()
                .map(line -> line.split(":"))
                .collect(Collectors.toMap(key -> key[0], val -> val[1]));
    }
}
