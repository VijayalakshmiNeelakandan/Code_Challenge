package steps;

import io.restassured.RestAssured;
import responseDto.NetworkResponse;
import shared.WebserviceEndpoints;

public class RestAPI {

    public int getResponseCode(){
        return RestAssured.get(WebserviceEndpoints.getUrl()).getStatusCode();

    }

    public NetworkResponse getResponse(){
        return RestAssured.given().queryParam("fields","location").when().get(WebserviceEndpoints.getUrl()).then().extract().as(NetworkResponse.class);

    }
}
