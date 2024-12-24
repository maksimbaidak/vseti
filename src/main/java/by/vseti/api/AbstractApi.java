package by.vseti.api;

import io.restassured.specification.RequestSpecification;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
public abstract class AbstractApi<T extends Response>  {

    private static final String LIMIT_EXCEEDED = "<i class=\"fa fa-exclamation-circle\"></i> Превышен лимит, пожалуйста, повторите попытку позже.";

    @Autowired private HttpClient httpClient;

    protected T makeRequest(
            String body,
            RequestSpecification specifications,
            Class<T> responseClass){
        Response response = null;
        try {
            response =
                    httpClient
                            .makeRequest(specifications, body)
                            .log().status()
                            .log().body()
                            .extract().as(responseClass);
        }catch (Exception exception){
            log.error(exception.getMessage());
            try {
                response =
                        responseClass
                                .getConstructor()
                                .newInstance();
                response.setError("Response isn't valid");
                return (T) response;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        if(response.getError().isPresent() &&
                response.getError().get().equals(LIMIT_EXCEEDED)){
            try {
                log.info("Request limit exceeded, trying to reconnect...");
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return makeRequest(body, specifications, responseClass);
        }
        return (T) response;
    }

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
