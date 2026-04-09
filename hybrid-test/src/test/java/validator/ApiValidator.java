package validator;

import io.restassured.response.Response;
import org.apache.log4j.Logger;
import org.example.utils.LoggerUtil;

import static org.testng.Assert.*;

public class ApiValidator {

    private static final Logger log = LoggerUtil.getLogger(ApiValidator.class);

    public static void validateStatusCode(Response response){
        log.info("Validating status code   Actual:"+response.getStatusCode()+" Expected:200");
        assertEquals(response.getStatusCode(),200);
    }

    public static void validateResponseCode(Response response, int code){
        log.info("Validating response code   Actual:"+response.jsonPath().getInt("responseCode")+" Expected:"+code);
        int responseCode = response.jsonPath().getInt("responseCode");
        assertEquals(responseCode,code);
    }

    public static void validateResponseMessage(Response response, String message){
        log.info("Validating response message");
        String responseMessage = response.jsonPath().getString("message");
        assertTrue(responseMessage.contains(message));
    }

}