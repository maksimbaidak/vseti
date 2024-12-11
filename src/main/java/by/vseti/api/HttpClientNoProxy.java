package by.vseti.api;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import lombok.extern.slf4j.Slf4j;

import static io.restassured.RestAssured.given;


@Slf4j
public class HttpClientNoProxy implements HttpClient {

    public ValidatableResponse makeRequest(RequestSpecification specs, String body){
        return given()
                        .spec(specs)
                        .body(body)
                .when()
                        .log().method()
                        .log().uri()
                        .log().body()
                        .post()
                .then();
    }
}
