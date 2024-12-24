package by.vseti.api;

import by.vseti.domain.Proxy;
import by.vseti.service.ProxyService;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.ProxySpecification;
import io.restassured.specification.RequestSpecification;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import static io.restassured.RestAssured.given;

@Slf4j
public class HttpClientWithProxy implements HttpClient {

    @Autowired private ProxyService proxyService;

    public ValidatableResponse makeRequest(RequestSpecification specs, String body){
        Response response = null;
        Proxy proxy = null;
        do{
            proxy = proxyService.getNext();
            log.info("Attempt to connect by: " + proxy.toString());
            try{response =
                            given()
                                .spec(specs)
                                .proxy(ProxySpecification
                                        .host(proxy.getAddress())
                                        .withPort(proxy.getPort())
                                        .withAuth(proxy.getLogin(),proxy.getPassword()))
                                .body(body)
                            .when()
                                .log().method()
                                .log().uri()
                                .log().body()
                            .post();
            }
            catch (Exception exception){
                log.info(exception.getMessage());
            }
        }while(response == null);
        return response.then();
    }
}
