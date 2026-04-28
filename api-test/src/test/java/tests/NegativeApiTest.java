package tests;

import client.ApiClient;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.apache.log4j.Logger;
import org.example.utils.LoggerUtil;
import org.testng.annotations.Test;
import validator.ApiValidator;

import java.util.HashMap;
import java.util.Map;

@Epic("API Tests")
@Feature("Negative")
public class NegativeApiTest {

    private static final Logger log = LoggerUtil.getLogger(NegativeApiTest.class);

    @Test(priority = 6)
    @Story("Negative search case")
    @Description("VEEVA-13")
    public void VEEVA_13_searchProductNegative(){
        log.info("Start of Negative test case");
        Map<String,String> body = new HashMap<>();

        Response response = ApiClient.post("/api/searchProduct",body);

        ApiValidator.validateResponseCode(response,400);
        log.info("End of Negative test case\n");
    }
}