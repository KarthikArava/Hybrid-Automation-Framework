package client;

import io.restassured.response.Response;
import org.apache.log4j.Logger;
import org.example.config.Config;
import org.example.utils.LoggerUtil;

import java.util.Map;

import static io.restassured.RestAssured.*;

public class ApiClient {

    private static final Logger log = LoggerUtil.getLogger(ApiClient.class);
    private static final String baseUrl = Config.get("apiBaseUrl");

    public static Response get(String endpoint, Map<String,String> params) {

        log.info("Sending GET request to : "+baseUrl+endpoint);

        Response response = given().queryParams(params)
                .when().get(baseUrl+endpoint)
                .then().extract().response();

        log.info("Response body : "+response.asPrettyString());

        return response;
    }

    public static Response post(String endpoint, Map<String,String> body) {

        log.info("Sending POST request to : "+baseUrl+endpoint);

        Response response = given().contentType("application/x-www-form-urlencoded").formParams(body)
                .when().post(baseUrl+endpoint)
                .then().extract().response();

        log.info("Response body : "+response.asPrettyString());

        return response;
    }

}