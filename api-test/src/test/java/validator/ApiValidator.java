package validator;

import io.restassured.response.Response;
import org.apache.log4j.Logger;
import org.example.config.Config;
import org.example.utils.LoggerUtil;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.testng.Assert.*;

public class ApiValidator {

    private static final Logger log = LoggerUtil.getLogger(ApiValidator.class);
    private static final String schemaPath = Config.get("schemaPath");

    public static void validateStatusCode(Response response){
        log.info("Validating status code   Actual:"+response.getStatusCode()+" Expected:200");
        assertEquals(response.getStatusCode(),200);
    }

    public static void validateResponseCode(Response response){
        log.info("Validating response code   Actual:"+response.jsonPath().getInt("responseCode")+" Expected:200");
        int code = response.jsonPath().getInt("responseCode");
        assertEquals(code,200);
    }

    public static void validateResponseCode(Response response, int code){
        log.info("Validating response code   Actual:"+response.jsonPath().getInt("responseCode")+" Expected:"+code);
        int responseCode = response.jsonPath().getInt("responseCode");
        assertEquals(responseCode,code);
    }

    public static void validateResponseMessage(Response response, String message){
        log.info("Validating response message");
        String responseMessage = response.jsonPath().getString("message");
        assertEquals(responseMessage,message);
    }

    public static void validateSchema(Response response){
        log.info("Validating response schema");
        response.then().assertThat().body(matchesJsonSchemaInClasspath(schemaPath));
    }
}