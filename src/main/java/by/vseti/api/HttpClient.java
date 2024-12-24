package by.vseti.api;

import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public interface HttpClient {

    ValidatableResponse makeRequest(RequestSpecification specs, String body);

}
