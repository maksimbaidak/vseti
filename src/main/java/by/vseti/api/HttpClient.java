package by.vseti.api;

import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public interface HttpClient {

    public abstract ValidatableResponse makeRequest(RequestSpecification specs, String body);

}
